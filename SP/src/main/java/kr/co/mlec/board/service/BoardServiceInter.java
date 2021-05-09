package kr.co.mlec.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardReplyVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.pill.vo.PillAge;
import kr.co.mlec.pill.vo.PillDiv;
import kr.co.mlec.pill.vo.PillListVO;
import kr.co.mlec.pill.vo.PillOld;
import kr.co.mlec.pill.vo.PillPreg;

@Service
public class BoardServiceInter implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> selectAllBoard(String name, String category,int start, int end) {
		
		List<BoardVO> boardList = boardDAO.selectAllBoard(name,category,start, end);
		return boardList;
	}

	public int allCount(String name, String category) {
		int count=boardDAO.allCount(name,category);
		return count;
	}
	@Override
	public void insertBoard(BoardVO board) {
		boardDAO.insert(board);
	}

	@Override
	public BoardVO detailBoardByNo(int no) {
		System.out.println("SERVICE detailBoardBYNo 호출");
		BoardVO board = boardDAO.selectByNoAll(no);
		
		return board;
	}

	@Override
	public void deleteBoardByNo(int no) {
		boardDAO.delete(no);
	}


	@Override
	public void editBoard(BoardVO board) {
		boardDAO.edit(board);
		
	}

	@Override
	public List<BoardReplyVO> selectReplyBoard(int bno) {
		List<BoardReplyVO> replylist= boardDAO.selectReplyByNo(bno);
		return replylist;
	}

	@Override
	public void insertReplyBoard(BoardReplyVO replylist) {
		boardDAO.insertReply(replylist);
		
	}

	@Override
	public void deleteReplyBoard(int reno) {
		boardDAO.deleteReply(reno);
	}
	public 	List<PillListVO> searchPill(PillListVO vo, int value){
		List<PillListVO> result = boardDAO.searchPill(vo,value);
		return result;
	}

	
	public int searchCount(PillListVO vo) {
		int num=boardDAO.searchCount(vo);
		return num;
	}
	
	public PillDiv searchDiv(String p_id){
		PillDiv pillDiv=boardDAO.searchDiv(p_id);
		return pillDiv;
	}
	public PillPreg searchPreg(String p_id){
		PillPreg pillPreg=boardDAO.searchPreg(p_id);
		return pillPreg;
	}
	public PillOld searchOld(String p_id){
		PillOld pillOld=boardDAO.searchOld(p_id);
		return pillOld;
	}
	public PillAge searchAge(String p_id){
		PillAge pillAge=boardDAO.searchAge(p_id);
		return pillAge;
	}

	
//	public List<BoardVO> selectBySearch(String val,String category,int start, int end){
//		List<BoardVO> result=boardDAO.selectBySearch(val,category,start,end);
//		return result;
//	}
	
}







