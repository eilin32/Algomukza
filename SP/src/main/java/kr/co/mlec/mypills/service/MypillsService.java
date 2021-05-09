package kr.co.mlec.mypills.service;

import java.util.List;

import kr.co.mlec.mypills.vo.MypillsVO;

public interface MypillsService {
	void addMypillSer(MypillsVO vo);
	List<MypillsVO> selectMypillsSer(String id);
	void deleteMypillSer(int pNum);
}
