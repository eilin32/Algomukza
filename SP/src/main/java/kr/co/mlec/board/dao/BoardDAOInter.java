package kr.co.mlec.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.board.vo.BoardReplyVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.pill.vo.PillAge;
import kr.co.mlec.pill.vo.PillDiv;
import kr.co.mlec.pill.vo.PillListVO;
import kr.co.mlec.pill.vo.PillOld;
import kr.co.mlec.pill.vo.PillPreg;

/**
 * 오라클용 게시판 CRUD(MyBatis 적용)
 * 
 * @author bit
 *
 */

@Repository
public class BoardDAOInter implements BoardDAO {

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<BoardVO> selectAllBoard(String name, String category, int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("name", name);
		map.put("category", category);
		List<BoardVO> boardList = session.selectList("board.dao.BoardDAO.selectAll", map);

		return boardList;
	}

	public int allCount(String name, String category) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("category", category);
		int count = session.selectOne("board.dao.BoardDAO.allCount", map);

		return count;
	}

	@Override
	public void insert(BoardVO board) {
		session.insert("board.dao.BoardDAO.insert", board);
	}

	@Override
	public BoardVO selectByNoAll(int no) {
		System.out.println("DAO selectByNoALl 호출");
		session.update("board.dao.BoardDAO.viewCntAdd", no);
		BoardVO board = session.selectOne("board.dao.BoardDAO.selectByNoAll", no);

		return board;
	}

	@Override
	public void delete(int no) {

		session.delete("board.dao.BoardReplyDAO.deleteReplyAll", no);
		session.delete("board.dao.BoardDAO.deleteByNo", no);

	}

	@Override
	public void edit(BoardVO board) {
		session.update("board.dao.BoardDAO.editByNo", board);
	}

	@Override
	public List<BoardReplyVO> selectReplyByNo(int bno) {
		List<BoardReplyVO> replylist = session.selectList("board.dao.BoardReplyDAO.selectReplyByNo", bno);
		return replylist;
	}

	@Override
	public void insertReply(BoardReplyVO replylist) {

		if (replylist.getRepno() != 0) {
			// 부모댓글이 있을 경우
			BoardReplyVO pnoInfo = session.selectOne("board.dao.BoardReplyDAO.selectByRepno", replylist.getRepno());

			replylist.setRedepth(pnoInfo.getRedepth() + 1);
			replylist.setReorder(pnoInfo.getReorder() + 1);
			session.selectOne("board.dao.BoardReplyDAO.updateReplyOrder", pnoInfo);
		} else {
			// 부모 댓글이 없으면 최대댓글 순서 다음 순서번호로 저장됨
			System.out.println(replylist.getBno());
			int reorder = session.selectOne("board.dao.BoardReplyDAO.replyMaxOrder", replylist.getBno());
			replylist.setReorder(reorder);
		}
		session.insert("board.dao.BoardReplyDAO.insertReply", replylist);
	}

	@Override
	public void deleteReply(int reno) {
		int chk = session.selectOne("board.dao.BoardReplyDAO.countReplyChild", reno);
		if (chk > 0) {
			session.update("board.dao.BoardReplyDAO.updateReplyDelete", reno);
		} else {
			session.delete("board.dao.BoardReplyDAO.deleteReply", reno);
		}

	}

	// 약
	public List<PillListVO> searchPill(PillListVO vo, int value) {
		System.out.println("DAO INTER VO 보기");
		System.out.println(vo);
		System.out.println("value :" + value);
		Map<String, Object> map = new HashMap<String, Object>();
		int value2 = value + 19;
		System.out.println("value2 :" + value2);

		map.put("vo", vo);
		map.put("start", value);
		map.put("end", value2);

		System.out.println("데이터베이스 들어가기전 ");
		List<PillListVO> result = session.selectList("board.dao.BoardDAO.searchPill", map);

		System.out.println("데이터베이스 갔다옴");
		return result;
	}

	public int searchCount(PillListVO vo) {
		int num = session.selectOne("board.dao.BoardDAO.searchCount", vo);
		return num;
	}

	public PillDiv searchDiv(String p_id) {
		PillDiv pillDiv = session.selectOne("board.dao.BoardDAO.searchDiv", p_id);
		return pillDiv;
	}

	public PillPreg searchPreg(String p_id) {
		PillPreg pillPreg = session.selectOne("board.dao.BoardDAO.searchPreg", p_id);
		return pillPreg;
	}

	public PillOld searchOld(String p_id) {
		PillOld pillOld = session.selectOne("board.dao.BoardDAO.searchOld", p_id);
		return pillOld;
	}

	public PillAge searchAge(String p_id) {
		PillAge pillAge = session.selectOne("board.dao.BoardDAO.searchAge", p_id);
		return pillAge;
	}

//	public List<BoardVO> selectBySearch(String name, String category,int start, int end){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("start",start);
//		map.put("end",end);
//		map.put("name", name);
//		map.put("category",category);
//	
//		List<BoardVO> result=session.selectList("board.dao.BoardDAO.searchAll",map);
//		
//		return result;
//		
//	}

}
