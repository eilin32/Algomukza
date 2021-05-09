package kr.co.mlec.login.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.member.vo.MemberVO;

@Repository
public class LoginDAOInter implements LoginDAO {
	
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public void addmember(MemberVO vo) {
		// TODO Auto-generated method stub
		session.insert("member.dao.memberDAO.addMember",vo);
	}
	@Override
	public int searchId(String paramId) {
		int num=session.selectOne("member.dao.memberDAO.searchId", paramId);
		return num;
	}
	@Override
	public int searchName(String name) {
		int num=session.selectOne("member.dao.memberDAO.searchName",name);
		return num;
	}
	@Override
	public MemberVO login(MemberVO vo) {
		MemberVO result = session.selectOne("member.dao.memberDAO.login",vo);
		return result;
	}
	
	public void updateAuthkey(MemberVO vo) {
		session.update("member.dao.memberDAO.authkey",vo);
	}
	@Override
	public int searchPwd(Map<String,String> map) {
		int num= session.selectOne("member.dao.memberDAO.searchPwd",map);
		return num;
	}
	@Override
	public void updatePwd(Map<String, String> map) {
		session.update("member.dao.memberDAO.updatePwd",map);
		
	}
	@Override
	public void updateMyinfo(MemberVO vo) {
		session.update("member.dao.memberDAO.updateMyinfo",vo);
		
	}

	
	
	
	
}
