package kr.co.mlec.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.calendar.vo.CalendarVO;
import kr.co.mlec.login.service.LoginService;
import kr.co.mlec.member.vo.MemberVO;
import kr.co.mlec.mypills.service.MypillsService;
import kr.co.mlec.mypills.vo.MypillsVO;

@Controller
@SessionAttributes({ "msg", "loginSucessVO" })
public class LoginController {

	@Autowired
	LoginService service;
	
	@Autowired
	MypillsService mservice;
	
	@Autowired
	SqlSessionTemplate ss;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String gotoSignup() {
		return "login/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String addMember(MemberVO vo, @RequestParam("profile") MultipartFile file) {
		System.out.println(vo);
		System.out.println(file);
		service.addMember(vo, file);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/checkId/{id}", method = RequestMethod.POST)
	public Map<String, Integer> checkId(@PathVariable("id") String id) {
		int num = service.searchId(id);
		Map<String, Integer> result = new HashMap<String, Integer>();
		System.out.println(num);
		result.put("cnt", num);
		return result;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String gotoLogin(SessionStatus status) {
		status.setComplete();
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginAttempt(MemberVO vo, Model model, HttpSession session) {
		MemberVO result = service.login(vo);
		if (result == null) {
			model.addAttribute("msg", "잘못된 정보입니다.");
			return "redirect:/login";
		}
		model.addAttribute("loginSucessVO", result);
		session.removeAttribute("msg");
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(SessionStatus status) {
		System.out.println("before : " + status.isComplete());
		status.setComplete();
		System.out.println("after : " + status.isComplete());
		return "redirect:/";
	}

	@RequestMapping("/mypage/{id}")
	public ModelAndView MyPageForm(@PathVariable("id") String id) {
		List<MypillsVO> mypills = mservice.selectMypillsSer(id);
		
		ModelAndView mav = new ModelAndView("login/mypage");
		mav.addObject("mypills", mypills);
		return mav;
	}

	@RequestMapping("/myinfo")
	public String MyInfoForm() {

		return "login/myinfo";
	}

	@RequestMapping(value = "/changePwd", method = RequestMethod.GET)
	public String ChangePwdForm() {

		return "login/changePwd";
	}

	@RequestMapping(value = "/changePwd/{id}", method = RequestMethod.POST)
	public String ChangePwd(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response,
			Model model, HttpSession session) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", request.getParameter("pwd"));
		map.put("npwd", request.getParameter("npwd"));
		int result = service.searchPwd(map);
		if (result == 0) {
			model.addAttribute("msg", "비밀번호를 다시 확인해주세요");
			return "redirect:/changePwd";
		}

		service.changePwd(map);

		session.removeAttribute("msg");
		System.out.println(session.getAttribute("msg"));
		return "redirect:/myinfo";
	}

	@RequestMapping(value = "/changeMyinfo")
	public String ChangeMyInfo(MemberVO vo, Model model) {
		service.changeMyinfo(vo);
		model.addAttribute("loginSucessVO", vo);
		return "redirect:/";
	}

	// 켈렌더
	@RequestMapping("/mypage2")
	public String MyPageForm2(HttpSession session, Model model) {
		List<CalendarVO> voList = ss.selectList("calendar.dao.CalendarDAO.selectAll",
				((MemberVO) session.getAttribute("loginSucessVO")).getId());
		StringBuffer calendarList = new StringBuffer();

		for (CalendarVO vo : voList) {
			calendarList.append("{ start : \"" + vo.getStart() + "\", end :\"" + vo.getEnd() + "\", title : \""
					+ vo.getTitle() + "\"},");
		}
		model.addAttribute("calendarList", calendarList);
		return "login/mypage2";
	}
}
