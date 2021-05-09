package kr.co.mlec.pill.vo;

import org.springframework.stereotype.Component;

@Component
public class PillAge {
	private String pa_Id;
	private String pa_Name;
	private String pa_Content;
	
	public String getPa_Id() {
		return pa_Id;
	}
	public void setPa_Id(String pa_Id) {
		this.pa_Id = pa_Id;
	}
	public String getPa_Name() {
		return pa_Name;
	}
	public void setPa_Name(String pa_Name) {
		this.pa_Name = pa_Name;
	}
	public String getPa_Content() {
		return pa_Content;
	}
	public void setPa_Content(String pa_Content) {
		this.pa_Content = pa_Content;
	}
	public PillAge(String pa_Id, String pa_Name, String pa_Content) {
	
		this.pa_Id = pa_Id;
		this.pa_Name = pa_Name;
		this.pa_Content = pa_Content;
	}
	public PillAge() {
	}
	@Override
	public String toString() {
		return "PillAge [pa_Id=" + pa_Id + ", pa_Name=" + pa_Name + ", pa_Content=" + pa_Content + "]";
	}
	
	
	
}
