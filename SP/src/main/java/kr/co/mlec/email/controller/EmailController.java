package kr.co.mlec.email.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import kr.co.mlec.email.service.EmailService;
import kr.co.mlec.emailhandler.EmailSender;
import kr.co.mlec.emailhandler.EmailVO;
import kr.co.mlec.member.vo.MemberVO;

@Controller
@SessionAttributes({"searchId","searchPwd"})
public class EmailController {
   @Autowired
   private EmailService service;
   
   @Autowired
   private EmailVO email;
   
   @Autowired
   private EmailSender emailSender;

   
   @RequestMapping(value = "/searchId", method = RequestMethod.GET)
   public String gotoSearchId(SessionStatus status) {
      status.setComplete();
      return "login/searchId";
   }
   

   @RequestMapping(value = "/searchId", method = RequestMethod.POST)
   public String searchId(@ModelAttribute MemberVO vo , Model model) throws Exception {
      System.out.println("SearchID POST 데이터베이스 이전");
      System.out.println(vo);
      MemberVO result = service.searchId(vo);
      
      System.out.println("SearchID POST 데이터베이스 이후");

      if(result!=null) {
         email.setSubject(result.getName()+"님 아이디 찾기 메일입니다.");
         email.setReceiver(result.getEmail());
         email.setContent(result.getName()+"님의 아이디는 :" + result.getId() + "입니다.");
         emailSender.SendEmail(email);
         model.addAttribute("searchId", "입력하신 Email로 ID를 보내드렸습니다.");
         return "login/login";
      }else {
         model.addAttribute("searchId", "입력하신 정보로 가입된 ID는 없습니다.");
         System.out.println("입력된 정보가 없다");
         return "redirect:/searchId";
      }
   }
   
   
   @RequestMapping(value = "/searchPwd", method = RequestMethod.GET)
   public String gotoSearchPwd(SessionStatus status) {
      status.setComplete();
      return "login/searchPwd";
   }
   
   
   @RequestMapping(value = "/searchPwd", method = RequestMethod.POST)
   public String searchPwd(@ModelAttribute MemberVO vo, Model model) throws Exception {
      System.out.println("비밀번호찾기 입력 "+vo);
      MemberVO result=service.searchPwd(vo);
      if(result!=null) {
         email.setSubject(result.getId() + "님 비밀번호 찾기 메일입니다.");
         email.setReceiver(result.getEmail());
         email.setContent(result.getId() + "님의 비밀번호는 " + result.getPwd()+"로 변경되었습니다 로그인 후 변경해주시기 바랍니다.");
         emailSender.SendEmail(email);
         model.addAttribute("searchPwd", "입력하신 Emial로 비밀번호를 보내드렸습니다.");
         return "login/login";
         }else {
         model.addAttribute("searchPwd", "입력하신 정보로 가입된 ID는 없습니다.");
         System.out.println("입력된 정보가 없다");
         return "redirect:/searchPwd";
      }

      
   }
}

