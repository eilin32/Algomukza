package kr.co.mlec.pill.vo;

import org.springframework.stereotype.Component;

@Component
public class PillDiv {
	private String pd_Id;
	private String pd_Name;
	private String pd_Content;
	private String pd_Etc;
	public String getPd_Id() {
		return pd_Id;
	}
	public void setPd_Id(String pd_Id) {
		this.pd_Id = pd_Id;
	}
	public String getPd_Name() {
		return pd_Name;
	}
	public void setPd_Name(String pd_Name) {
		this.pd_Name = pd_Name;
	}
	public String getPd_Content() {
		return pd_Content;
	}
	public void setPd_Content(String pd_Content) {
		this.pd_Content = pd_Content;
	}
	public String getPd_Etc() {
		return pd_Etc;
	}
	public void setPd_Etc(String pd_Etc) {
		this.pd_Etc = pd_Etc;
	}
	@Override
	public String toString() {
		return "PillDiv [pd_Id=" + pd_Id + ", pd_Name=" + pd_Name + ", pd_Content=" + pd_Content + ", pd_Etc=" + pd_Etc
				+ "]";
	}
	public PillDiv() {
	}
	public PillDiv(String pd_Id, String pd_Name, String pd_Content, String pd_Etc) {
		super();
		this.pd_Id = pd_Id;
		this.pd_Name = pd_Name;
		this.pd_Content = pd_Content;
		this.pd_Etc = pd_Etc;
	}
	
	
	
}
