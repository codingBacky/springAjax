package org.backy.service;

import java.util.List;

import org.backy.domain.BoardVO;
import org.backy.domain.Criteria;
import org.backy.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	private final BoardMapper boardMapper;//final이 있으면 @autowired 없어도 알아서 주입해줌
	
//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList,.,,");
//		return boardMapper.getList();
//	}
	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		log.info("getListWithPaging,.,,");
		return boardMapper.getListWithPaging(cri);
	}
	@Override
	public BoardVO get(Long bno) {
		log.info("get,.,.,.,.,.");
		return boardMapper.read(bno);
	}

	@Override
	public void register(BoardVO board) {
		log.info("register : " + board);
		boardMapper.insertSelectKey(board);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify : " + board);
		
		return boardMapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove : " + bno);
		return boardMapper.delete(bno)==1;
	}
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total");
		return boardMapper.getTotalCount(cri);
	}
}
