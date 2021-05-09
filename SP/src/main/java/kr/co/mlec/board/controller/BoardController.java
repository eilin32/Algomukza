package kr.co.mlec.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.board.service.BoardPager;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardReplyVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.pill.vo.PillAge;
import kr.co.mlec.pill.vo.PillDiv;
import kr.co.mlec.pill.vo.PillListVO;
import kr.co.mlec.pill.vo.PillOld;
import kr.co.mlec.pill.vo.PillPreg;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	// 알약 검색

	@RequestMapping(value = "/searchPill2", method = RequestMethod.POST)
	public ModelAndView searchPill2(PillListVO vo, @RequestParam(defaultValue = "1") int value) {
		System.out.println(vo);
		System.out.println(value);
		Map<String, Object> map = new HashMap<String, Object>();

		List<PillListVO> result = service.searchPill(vo, value);
		List<PillDiv> div = new ArrayList<PillDiv>();
		List<PillOld> old = new ArrayList<PillOld>();
		;
		List<PillPreg> preg = new ArrayList<PillPreg>();
		;
		List<PillAge> age = new ArrayList<PillAge>();
		;

		int size = result.size();
		for (int i = 0; i < size; i++) {
			div.add(service.searchDiv(result.get(i).getP_Id()));
			old.add(service.searchOld(result.get(i).getP_Id()));
			preg.add(service.searchPreg(result.get(i).getP_Id()));
			age.add(service.searchAge(result.get(i).getP_Id()));

		}

		map.put("pillListVo", result);
		map.put("pillDiv", div);
		map.put("pillOld", old);
		map.put("pillPreg", preg);
		map.put("pillAge", age);

		ModelAndView mav = new ModelAndView("../../index");
		mav.addObject("result", map);

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/searchPill/{value}", method = RequestMethod.POST)
	public Map<String, Object> searchPill(PillListVO vo, @PathVariable int value) {

//		System.out.println("ajax 시작!!");
//		System.out.println(vo);
//		System.out.println("value :" + value);
//		
//		System.out.println("ajax 넘어옴 service전");
//		List<PillListVO> result=service.searchPill(vo,value);
//		System.out.println("ajax 넘어옴 service 후");
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("pillList", result);
//		System.out.println("검색한 결과");
//		System.out.println("검색결과 size : " + result.size());
//		return map;
		Map<String, Object> map = new HashMap<String, Object>();
		List<PillListVO> result = service.searchPill(vo, value);
		List<PillDiv> div = new ArrayList<PillDiv>();
		List<PillOld> old = new ArrayList<PillOld>();
		;
		List<PillPreg> preg = new ArrayList<PillPreg>();
		;
		List<PillAge> age = new ArrayList<PillAge>();
		;

		int size = result.size();
		for (int i = 0; i < size; i++) {
			div.add(service.searchDiv(result.get(i).getP_Id()));
			old.add(service.searchOld(result.get(i).getP_Id()));
			preg.add(service.searchPreg(result.get(i).getP_Id()));
			age.add(service.searchAge(result.get(i).getP_Id()));

		}
		map.put("pillList", result);
		map.put("pillDiv", div);
		map.put("pillOld", old);
		map.put("pillPreg", preg);
		map.put("pillAge", age);

		return map;
	}

	// 게시판
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String category)
			throws Exception {
		int count = service.allCount(name, category);
		BoardPager boardPager = new BoardPager(count, curPage);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		List<BoardVO> boardList = service.selectAllBoard(name, category, start, end);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardList", boardList);
		map.put("boardPager", boardPager);
		map.put("name", name);
		map.put("category", category);
		ModelAndView mav = new ModelAndView("board/list");

		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping(value = "/board", method = RequestMethod.POST)
	public ModelAndView searchBoard(String name, String category, @RequestParam(defaultValue = "1") String curPage) {

		int curPage1 = Integer.parseInt(curPage);
		int count = service.allCount(name, category);

		BoardPager boardPager = new BoardPager(count, curPage1);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<BoardVO> boardList = service.selectAllBoard(name, category, start, end);

		ModelAndView mav = new ModelAndView("board/list");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardList", boardList);
		map.put("boardPager", boardPager);
		map.put("name", name);
		map.put("category", category);
		map.put("boardList", boardList);
		mav.addObject("map", map);
		return mav;
	}

	// write.jsp로 이동
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String writeForm() {
		return "board/write";
	}

	// write.jsp에서 input받은 값 데이터베이스에 삽입
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO board) {

		service.insertBoard(board);

		return "redirect:/board";
	}

	// edit.jsp로 이동
	@RequestMapping(value = "/board/edit/{no}", method = RequestMethod.GET)
	public ModelAndView editForm(@PathVariable("no") int no) {

		BoardVO board = service.detailBoardByNo(no);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/edit");
		mav.addObject("board", board);
		return mav;
	}

	// edit.jsp에서 input받은 값 데이터베이스에 다시 update
	@RequestMapping(value = "/board/edit/{no}", method = RequestMethod.POST)
	public String edit(BoardVO board) {

		service.editBoard(board);
		return "redirect:/board/{no}";
	}

	// 해당 게시글 번호 상세정보 detail.jsp로 이동
	@RequestMapping(value = "/board/{no}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("no") int no) {
		
		System.out.println("상세조회 GET 호출");
		BoardVO board = service.detailBoardByNo(no);
		int bno = no;
		List<BoardReplyVO> replylist = service.selectReplyBoard(bno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/detail");
		mav.addObject("board", board);
		mav.addObject("replylist", replylist);

		return mav;
	}

	// 해당 게시글 댓글 삽입
	@RequestMapping(value = "/insertReply/{no}")
	public String InsertReply(BoardReplyVO replylist) {
		service.insertReplyBoard(replylist);
		return "redirect:/board/{no}";
	}

	@RequestMapping(value = "/deleteReply/{no}/{reno}")
	public String DeleteReply(@PathVariable("reno") int reno) {

		service.deleteReplyBoard(reno);
		return "redirect:/board/{no}";
	}
}
