package kr.co.mlec.mypills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.mypills.dao.MypillsDAO;
import kr.co.mlec.mypills.vo.MypillsVO;

@Service
public class MypillsServiceInter implements MypillsService{
	@Autowired
	private MypillsDAO dao;

	@Override
	public void addMypillSer(MypillsVO vo) {
		dao.addMypill(vo);
		
	}

	@Override
	public List<MypillsVO> selectMypillsSer(String id) {
		List<MypillsVO> mypills = dao.selectMypills(id);
		return mypills;
	}

	@Override
	public void deleteMypillSer(int pNum) {
		dao.deleteMypill(pNum);
		
	}
	
	
}
