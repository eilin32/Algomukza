package kr.co.mlec.mypills.dao;

import java.util.List;

import kr.co.mlec.mypills.vo.MypillsVO;

public interface MypillsDAO {
	public void addMypill(MypillsVO vo);
	public List<MypillsVO> selectMypills(String id);
	public void deleteMypill(int pNum);
}
