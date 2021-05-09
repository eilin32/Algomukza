package kr.co.mlec.mypills.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.mypills.service.MypillsServiceInter;
import kr.co.mlec.mypills.vo.MypillsVO;
@RestController
public class MypillsRestController {
	
	@Autowired
	private MypillsServiceInter service;
	
	@RequestMapping(value="/addmypillM", method=RequestMethod.POST)
	public Map<String,Boolean> addMypillModal(MypillsVO vo) {
		System.out.println("모달 알약 추가 함수 호출됨");
		System.out.println(vo);
		service.addMypillSer(vo);
		Map<String,Boolean> result = new HashMap<>();
		result.put("flag", true);
		System.out.println(result);
		return result;
	}
}
