package kr.co.mlec.mypills.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.mlec.mypills.service.MypillsServiceInter;
import kr.co.mlec.mypills.vo.MypillsVO;

@Controller
public class MypillsController {

	@Autowired
	private MypillsServiceInter service;
	
	@RequestMapping(value="/addmypill/{id}", method=RequestMethod.POST)
	public String addMypill(MypillsVO vo, @PathVariable("id") String id) {
		
		service.addMypillSer(vo);
		return "redirect:/mypage/"+id;
	}
	
	
	@RequestMapping(value="/deletemypill/{id}/{pNum}")
	public String deleteMypill(@PathVariable("pNum") int pNum, @PathVariable("id") String id) {
		service.deleteMypillSer(pNum);
		
		return "redirect:/mypage/"+id;
	}
}
