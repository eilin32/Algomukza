package kr.co.mlec.pill.vo;

import org.springframework.stereotype.Component;

@Component
public class PillOld {
	private String po_Id; // 일련번호
	private String po_Name;//약 이름
	private String po_Content;// 약내용
	public String getPo_Id() {
		return po_Id;
	}
	public void setPo_Id(String po_Id) {
		this.po_Id = po_Id;
	}
	public String getPo_Name() {
		return po_Name;
	}
	public void setPo_Name(String po_Name) {
		this.po_Name = po_Name;
	}
	public String getPo_Content() {
		return po_Content;
	}
	public void setPo_Content(String po_Content) {
		this.po_Content = po_Content;
	}
	@Override
	public String toString() {
		return "PillOld [po_Id=" + po_Id + ", po_Name=" + po_Name + ", po_Content=" + po_Content + "]";
	}
	public PillOld(String po_Id, String po_Name, String po_Content) {
		this.po_Id = po_Id;
		this.po_Name = po_Name;
		this.po_Content = po_Content;
	}
	public PillOld() {
	}
	
	
}
