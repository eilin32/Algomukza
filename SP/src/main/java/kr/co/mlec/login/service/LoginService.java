package kr.co.mlec.login.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kr.co.mlec.member.vo.MemberVO;

public interface LoginService {
	public void addMember(MemberVO vo, MultipartFile file);
	public int searchId(String id);
	public int searchName(String name);
	public MemberVO login(MemberVO vo);
	
	public int searchPwd(Map<String,String> map);
	public void changePwd(Map<String,String> map);
	public void changeMyinfo(MemberVO vo);
}
