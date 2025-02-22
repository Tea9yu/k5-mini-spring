package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.CmtRepository;
import jakarta.transaction.Transactional;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private CmtRepository cmtRepo;
	
	
	
	// 게시글 목록 
	public List<Board> getBoards() {
		return boardRepo.findAll();
	}

	// 데이터 내가 원하는 것만 id로 검색해서 가져옴
	public Board getBoard (Long seq) {
		return boardRepo.findById(seq).get();
	}

	// 데이터 추가
	public String add(Board board) {
		boardRepo.save(board);
		return "게시글을 작성했습니다.";
	}

	// 데이터를 수정할껀데 네임만 수정할 수도 있고, 패스만 수정 할 수 있다.
	// 그런데 하나만 수정했을 때 나머지가 null로 되면 안되고 원래값을 유지하도록
	
	// 데이터 수정 (ex. id=2, name=홍길동)
	public String update(Board board) {
		try {
		 // 겟멈버 해서 일단 불러 온다음에 
		Board m = getBoard(board.getSeq()); //(seq값은 있는거 입력해줘야 그다음이 수정됨.)
		 // 내가 수정할 부분만 변경
		if (board.getTitle() != null)
				m.setTitle(board.getTitle());
		if (board.getContent() != null)
				m.setContent(board.getContent());
		boardRepo.save(m);
		
		} catch (Exception e) { 
			e.printStackTrace();
			return "업데이트 실패";
		}
		return "게시판 업데이트 완료";
	}

	
	// 게시글 삭제하면 게시글에 달려있던 댓글들도 다 같이 삭제.
	@Transactional
	public String delete(Long seq) {
			try {
				if (boardRepo.existsById(seq) ) { // 기존 데이터가 있는 경우에만 실행
					cmtRepo.deleteCmt(seq);
					boardRepo.deleteById(seq);
				}else {
					return "삭제할 데이터가 없습니다.";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "삭제 실패";
			}
			return "삭제 성공";
	}
}