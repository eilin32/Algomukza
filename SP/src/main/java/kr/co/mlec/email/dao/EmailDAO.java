package kr.co.mlec.email.dao;

import kr.co.mlec.member.vo.MemberVO;


public interface EmailDAO  {
	public MemberVO searchId(MemberVO vo);
	public MemberVO searchPwd(MemberVO vo);
	public MemberVO changePwd(MemberVO vo);

}
