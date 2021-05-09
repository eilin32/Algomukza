package kr.co.mlec.emailhandler;

import org.springframework.stereotype.Component;

@Component
public class EmailVO {
	private String subject; // 제목
	private String content; // 내용
	private String receiver; //받는 사람

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public EmailVO(String subject, String content, String receiver) {
		super();
		this.subject = subject;
		this.content = content;
		this.receiver = receiver;
	}
	public EmailVO() {
		System.out.println("EamilVO 기본생성자 호출");
	}
	
	
	
}
