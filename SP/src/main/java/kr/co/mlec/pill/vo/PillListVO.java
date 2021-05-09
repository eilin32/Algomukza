package kr.co.mlec.pill.vo;

import org.springframework.stereotype.Component;

@Component
public class PillListVO {
	private String p_Id; //일련번호
	private String p_Name; //이름
	private String p_Com; //회사
	private String p_Img; //이미지
	private String p_MarkF; //마크 앞
	private String p_MarkB; //마크 뒤
	private String p_Shape; //약 모양
	private String p_ColorF; //약 색깔 앞 
	private String p_ColorB; //약 색깔 뒤
	private String p_SizeL; //약 크기 긴쪽
	private String p_SizeS; //약 크기 짧은쪽
	private String p_SizeW; //약 크기 넓이
	private String p_TypeN; //약 타입
	private String p_Tc; // 처방이냐 아니냐
	private String p_Date; // 약 만들어진 날짜
	private String p_ShapeType; //약 모양 타입?
	public String getP_Id() {
		return p_Id;
	}
	public void setP_Id(String p_Id) {
		this.p_Id = p_Id;
	}
	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public String getP_Com() {
		return p_Com;
	}
	public void setP_Com(String p_Com) {
		this.p_Com = p_Com;
	}
	public String getP_Img() {
		return p_Img;
	}
	public void setP_Img(String p_Img) {
		this.p_Img = p_Img;
	}
	public String getP_MarkF() {
		return p_MarkF;
	}
	public void setP_MarkF(String p_MarkF) {
		this.p_MarkF = p_MarkF;
	}
	public String getP_MarkB() {
		return p_MarkB;
	}
	public void setP_MarkB(String p_MarkB) {
		this.p_MarkB = p_MarkB;
	}
	public String getP_Shape() {
		return p_Shape;
	}
	public void setP_Shape(String p_Shape) {
		this.p_Shape = p_Shape;
	}
	public String getP_ColorF() {
		return p_ColorF;
	}
	public void setP_ColorF(String p_ColorF) {
		this.p_ColorF = p_ColorF;
	}
	public String getP_ColorB() {
		return p_ColorB;
	}
	public void setP_ColorB(String p_ColorB) {
		this.p_ColorB = p_ColorB;
	}
	public String getP_SizeL() {
		return p_SizeL;
	}
	public void setP_SizeL(String p_SizeL) {
		this.p_SizeL = p_SizeL;
	}
	public String getP_SizeS() {
		return p_SizeS;
	}
	public void setP_SizeS(String p_SizeS) {
		this.p_SizeS = p_SizeS;
	}
	public String getP_SizeW() {
		return p_SizeW;
	}
	public void setP_SizeW(String p_SizeW) {
		this.p_SizeW = p_SizeW;
	}
	public String getP_TypeN() {
		return p_TypeN;
	}
	public void setP_TypeN(String p_TypeN) {
		this.p_TypeN = p_TypeN;
	}
	public String getP_Tc() {
		return p_Tc;
	}
	public void setP_Tc(String p_Tc) {
		this.p_Tc = p_Tc;
	}
	public String getP_Date() {
		return p_Date;
	}
	public void setP_Date(String p_Date) {
		this.p_Date = p_Date;
	}
	public String getP_ShapeType() {
		return p_ShapeType;
	}
	public void setP_ShapeType(String p_ShapeType) {
		this.p_ShapeType = p_ShapeType;
	}
	@Override
	public String toString() {
		return "PillVO [p_Id=" + p_Id + ", p_Name=" + p_Name + ", p_Com=" + p_Com + ", p_Img=" + p_Img + ", p_MarkF="
				+ p_MarkF + ", p_MarkB=" + p_MarkB + ", p_Shape=" + p_Shape + ", p_ColorF=" + p_ColorF + ", p_ColorB="
				+ p_ColorB + ", p_SizeL=" + p_SizeL + ", p_SizeS=" + p_SizeS + ", p_SizeW=" + p_SizeW + ", p_TypeN="
				+ p_TypeN + ", p_Tc=" + p_Tc + ", p_Date=" + p_Date + ", p_ShapeType=" + p_ShapeType + "]";
	}
	public PillListVO(String p_Id, String p_Name, String p_Com, String p_Img, String p_MarkF, String p_MarkB,
			String p_Shape, String p_ColorF, String p_ColorB, String p_SizeL, String p_SizeS, String p_SizeW,
			String p_TypeN, String p_Tc, String p_Date, String p_ShapeType) {
		this.p_Id = p_Id;
		this.p_Name = p_Name;
		this.p_Com = p_Com;
		this.p_Img = p_Img;
		this.p_MarkF = p_MarkF;
		this.p_MarkB = p_MarkB;
		this.p_Shape = p_Shape;
		this.p_ColorF = p_ColorF;
		this.p_ColorB = p_ColorB;
		this.p_SizeL = p_SizeL;
		this.p_SizeS = p_SizeS;
		this.p_SizeW = p_SizeW;
		this.p_TypeN = p_TypeN;
		this.p_Tc = p_Tc;
		this.p_Date = p_Date;
		this.p_ShapeType = p_ShapeType;
	}
	public PillListVO() {}
	
	
	
	
	
}
