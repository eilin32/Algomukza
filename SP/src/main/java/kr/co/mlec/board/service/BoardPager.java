package kr.co.mlec.board.service;

public class BoardPager {
	//페이지당 게시물 수
	public static final int PAGE_SCALE =10;
	//화면당 페이지 수 
	public static final int BLOCK_SCALE =10;

	private int curPage; //현재 페이지 수
	private int prevPage; //이전 페이지
	private int nextPage; //다음 페이지
	private int totPage; //전체 페이지 갯수
	private int totBlock; // 전체 페이지 블록 갯수
	private int curBlock; //현재 페이지 블록
	private int prevBlock; //이전 페이지 블록
	private int nextBlock; // 다음 페이지 블록
	
	private int pageBegin; // #{start}
	private int pageEnd; // #{end}
	private int blockBegin; // 현재 블록의 페이지 시작번호
	private int blockEnd ; // 현재 블록의 마지막 페이지
	
	public BoardPager() {};
	public BoardPager(int count, int curPage) {
		curBlock=1; // 현재 페이지 블록번호
		this.curPage =curPage;
		setTotPage(count);
		setPageRange();
		setTotBlock();
		setBlockRange();
	}
	
	public void setBlockRange() {
		curBlock=(int)Math.ceil((curPage-1)/BLOCK_SCALE)+1;
		//한 블럭에 10개씩 나오기 때문에 현재 페이지가 0단위 20, 30 이면 curBlock가 다음 페이지가 될 수 있기때문에 현재페이지에 -1을 해주는거임
		blockBegin = (curBlock-1) * BLOCK_SCALE+1; 
		//현재 블록의 시작페이지를 구해야하는데 한 블록에 10개니까 현재 블록페이지가 2이면 11부터 20까지 나와야하는데
		//이때 -1을 해주면 curBlock는 1이 되고 *11 을 해주니 첫 페이지인 11 페이지가 계산된다.
		blockEnd= blockBegin+BLOCK_SCALE-1;
		//현재 블록의 마지막 페이지를 구해야하기때문에 현재 블록의 시작페이지에 9를 더해주면된다. 총 10개가 나오니까
		
		if(blockEnd>totPage) blockEnd=totPage;
		prevPage =(curPage==1)? 1:(curBlock-1)*(BLOCK_SCALE);
		nextPage = curBlock>totBlock ? (curBlock*BLOCK_SCALE):(curBlock*BLOCK_SCALE)+1;
		if(nextPage>=totPage) nextPage=totPage;
		
	}
	
	public void setPageRange() {
		//한 페이지 블록에 10개가 나와야하니까 시자 페이지와 끝 페이지를 구한다.
		pageBegin=(curPage-1) *PAGE_SCALE+1;
		pageEnd= pageBegin+PAGE_SCALE-1;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int count) {
		totPage=(int)Math.ceil(count*1.0/PAGE_SCALE);
	}
	public int getTotBlock() {
		return totBlock;
	}
	public void setTotBlock() {
		totBlock=(int)Math.ceil(totPage/BLOCK_SCALE);
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getBlockBegin() {
		return blockBegin;
	}
	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}
	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	public static int getPageScale() {
		return PAGE_SCALE;
	}
	public static int getBlockScale() {
		return BLOCK_SCALE;
	}
	
	
	
	
	
	
	
}
