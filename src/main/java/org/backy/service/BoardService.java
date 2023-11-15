package org.backy.service;

import java.util.List;

import org.backy.domain.BoardVO;
import org.backy.domain.Criteria;

public interface BoardService {
	
	//public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(Criteria cri);
	public BoardVO get(Long bno);
	public void register(BoardVO board);
	public boolean modify(BoardVO board);
	public boolean remove(Long bno);
	public int getTotal(Criteria cri);
	
}
