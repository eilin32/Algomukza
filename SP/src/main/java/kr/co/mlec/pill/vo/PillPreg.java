package kr.co.mlec.pill.vo;

import org.springframework.stereotype.Component;

@Component
public class PillPreg {
	private String pp_Id;
	private String pp_Name;
	private String pp_Content;
	
	public String getPp_Id() {
		return pp_Id;
	}
	public void setPp_Id(String pp_Id) {
		this.pp_Id = pp_Id;
	}
	public String getPp_Name() {
		return pp_Name;
	}
	public void setPp_Name(String pp_Name) {
		this.pp_Name = pp_Name;
	}
	public String getPp_Content() {
		return pp_Content;
	}
	public void setPp_Content(String pp_Content) {
		this.pp_Content = pp_Content;
	}
	@Override
	public String toString() {
		return "PillPreg [pp_Id=" + pp_Id + ", pp_Name=" + pp_Name + ", pp_Content=" + pp_Content + "]";
	}
	public PillPreg() {}
	public PillPreg(String pp_Id, String pp_Name, String pp_Content) {
		this.pp_Id = pp_Id;
		this.pp_Name = pp_Name;
		this.pp_Content = pp_Content;
	}
	
	
}
