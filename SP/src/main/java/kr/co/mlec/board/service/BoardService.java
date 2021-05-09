package kr.co.mlec.board.service;

import java.util.List;

import kr.co.mlec.board.vo.BoardReplyVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.pill.vo.PillAge;
import kr.co.mlec.pill.vo.PillDiv;
import kr.co.mlec.pill.vo.PillListVO;
import kr.co.mlec.pill.vo.PillOld;
import kr.co.mlec.pill.vo.PillPreg;

public interface BoardService {

	List<BoardVO> selectAllBoard(String name, String category,int start, int end);
	int allCount(String name, String category);
	void insertBoard(BoardVO board);
	BoardVO detailBoardByNo(int no);
	void deleteBoardByNo(int no);
	void editBoard(BoardVO board);
	List<BoardReplyVO> selectReplyBoard(int no);
	void insertReplyBoard(BoardReplyVO replylist);
	void deleteReplyBoard(int reno);
	
	//약
	int searchCount(PillListVO vo);
	List<PillListVO> searchPill(PillListVO vo, int value);
	PillDiv searchDiv(String p_id);
	PillPreg searchPreg(String p_id);
	PillOld searchOld(String p_id);
	PillAge searchAge(String p_id);
}
