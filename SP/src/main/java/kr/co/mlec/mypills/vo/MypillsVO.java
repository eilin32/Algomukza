package kr.co.mlec.mypills.vo;

public class MypillsVO {
	private String uId;
	private int pNum;
	private String pName;
	private String pCom;
	private int pCnt;
	private String pPer;
	private int pTnum;
	
	
	public MypillsVO() {
		super();
	}

	public MypillsVO(String uId, int pNum,  String pName, String pCom, int pCnt, String pPer, int pTnum) {
		super();
		this.uId = uId;
		this.pNum = pNum;
		this.pName = pName;
		this.pCom = pCom;
		this.pCnt= pCnt;
		this.pPer = pPer;
		this.pTnum = pTnum;
	}
	

	public String getuId() {
		return uId;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}

	
	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpCom() {
		return pCom;
	}


	public void setpCom(String pCom) {
		this.pCom = pCom;
	}


	public int getpCnt() {
		return pCnt;
	}

	public void setpCnt(int pCnt) {
		this.pCnt = pCnt;
	}

	public String getpPer() {
		return pPer;
	}


	public void setpPer(String pPer) {
		this.pPer = pPer;
	}


	public int getpTnum() {
		return pTnum;
	}


	public void setpTnum(int pTnum) {
		this.pTnum = pTnum;
	}


	@Override
	public String toString() {
		return "MypillsVO [uId=" + uId + ", pNum=" + pNum+", pName=" + pName + ", pCom=" + pCom + ", pPer=" + pPer + ", pTnum=" + pTnum
				+ "]";
	}
	
	
	
}
