package kr.co.mlec.board.vo;

public class BoardReplyVO {
	private int reno;
	private int repno;
	private int bno;
	private String rewriter;
	private String recontent;
	private String reregdate;
	private int reorder;
	private int redepth;
	private String redeleted;
	
	public BoardReplyVO() {
		super();
	}

	public BoardReplyVO(int reno, int repno, int bno, String rewriter, String recontent, String reregdate,
			int reorder, int redepth, String redeleted) {
		super();
		this.reno = reno;
		this.repno = repno;
		this.bno = bno;
		this.rewriter = rewriter;
		this.recontent = recontent;
		this.reregdate = reregdate;
		this.reorder = reorder;
		this.redepth = redepth;
		this.redeleted = redeleted;
	}

	public int getReno() {
		return reno;
	}

	public void setReno(int reno) {
		this.reno = reno;
	}

	public int getRepno() {
		return repno;
	}

	public void setRepno(int repno) {
		this.repno = repno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getRewriter() {
		return rewriter;
	}

	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}

	public String getRecontent() {
		return recontent;
	}

	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}

	public String getReregdate() {
		return reregdate;
	}

	public void setReregdate(String reregdate) {
		this.reregdate = reregdate;
	}

	public int getReorder() {
		return reorder;
	}

	public void setReorder(int reorder) {
		this.reorder = reorder;
	}

	public int getRedepth() {
		return redepth;
	}

	public void setRedepth(int redepth) {
		this.redepth = redepth;
	}

	
	public String getRedeleted() {
		return redeleted;
	}

	public void setRedeleted(String redeleted) {
		this.redeleted = redeleted;
	}

	@Override
	public String toString() {
		return "BoardReplyVO [reno=" + reno + ", repno=" + repno + ", bno=" + bno + ", rewriter=" + rewriter
				+ ", recontent=" + recontent + ", reregdate=" + reregdate + ", reorder=" + reorder + ", redepth="
				+ redepth + "redeleted=" + redeleted+"]";
	}
	
	
	
}
