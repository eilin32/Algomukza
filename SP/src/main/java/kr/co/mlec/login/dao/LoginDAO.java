package kr.co.mlec.login.dao;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kr.co.mlec.member.vo.MemberVO;

public interface LoginDAO {
	public void addmember(MemberVO vo);
	public int searchId(String id);
	public int searchName(String name);
	public MemberVO login(MemberVO vo);
	public void updateAuthkey(MemberVO vo);
	public int searchPwd(Map<String,String> map);
	public void updatePwd(Map<String,String> map);
	public void updateMyinfo(MemberVO vo);
}
