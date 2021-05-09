package kr.co.mlec.email.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.email.dao.EmailDAO;
import kr.co.mlec.login.dao.LoginDAO;
import kr.co.mlec.login.service.LoginService;
import kr.co.mlec.member.vo.MemberVO;
@Service
public class EmailServiceInter implements EmailService {
	
	@Autowired
	private EmailDAO dao;
	
	@Override
	public MemberVO searchId(MemberVO vo) {
		MemberVO result=dao.searchId(vo);
		return result;
	}
	
	@Override
	public MemberVO searchPwd(MemberVO vo) {
		MemberVO result=dao.searchPwd(vo);
		System.out.println("EMAIL 서비스 DAO 갔다온후 : ");
		System.out.println(result);
		
		if(result!=null) {
			Random rnd = new Random();
			String sb = "";
			for(int i=0;i<10;i++) {
				String randString=(String.valueOf((char) ((int) (rnd.nextInt(26)) + 65)));
				sb=sb+randString;
			}
			result.setPwd(sb);
			dao.changePwd(result);
			System.out.println("if문 안에서의 " +result);

		}
		System.out.println("리턴하기 직전의 " +result);

		return result;
	}
	
	
}
