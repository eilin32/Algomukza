package kr.co.mlec.board.dao;

import java.util.List;

import kr.co.mlec.board.vo.BoardReplyVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.pill.vo.PillAge;
import kr.co.mlec.pill.vo.PillDiv;
import kr.co.mlec.pill.vo.PillListVO;
import kr.co.mlec.pill.vo.PillOld;
import kr.co.mlec.pill.vo.PillPreg;

/**
 * Database를 통한 게시글 CRUD
 * 
 * @author bit
 *
 */
public interface BoardDAO {

	/**
	 * 전체게시글 조회서비스
	 * 
	 * @return 전체게시글
	 */
	public List<BoardVO> selectAllBoard(String name, String category, int start, int end);

	// 전체 게시글 갯수 (페이징)
	public int allCount(String name, String category);

	/**
	 * 게시글 등록서비스
	 */
	public void insert(BoardVO board);

	/**
	 * 게시글 상세조회
	 * 
	 * @param no 조회할 게시물 번호
	 * @return 조회된 게시물(BoardVO)
	 */
	public BoardVO selectByNoAll(int no);

	/*
	 * 게시글삭제
	 * 
	 * @param no 삭제할 게시물 번호 /
	 */
	public void delete(int no);

	// 게시글 수정
	public void edit(BoardVO board);

	// 해당 게시글 댓글 리스트 불러오기
	public List<BoardReplyVO> selectReplyByNo(int no);

	// 해당 게시글 댓글 삽입
	public void insertReply(BoardReplyVO replylist);

	// 해당 댓글 삭제처리
	public void deleteReply(int reno);

	// 약
	int searchCount(PillListVO vo);

	List<PillListVO> searchPill(PillListVO vo, int value);

	PillDiv searchDiv(String p_id);

	PillPreg searchPreg(String p_id);

	PillOld searchOld(String p_id);

	PillAge searchAge(String p_id);
}