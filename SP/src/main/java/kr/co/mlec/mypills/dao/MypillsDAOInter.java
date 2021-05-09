package kr.co.mlec.mypills.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.mypills.vo.MypillsVO;

@Repository
public class MypillsDAOInter implements MypillsDAO{
	@Autowired
	SqlSessionTemplate session;

	@Override
	public void addMypill(MypillsVO vo) {
		
		session.insert("board.dao.PillsDAO.addmypills",vo);
	}

	@Override
	public List<MypillsVO> selectMypills(String id) {
		
		List<MypillsVO> mypills = session.selectList("board.dao.PillsDAO.mypillsAlllist", id);
		return mypills;
	}

	@Override
	public void deleteMypill(int pNum) {
		session.delete("board.dao.PillsDAO.deletemypill",pNum);
		
	}
	
	
	
}
