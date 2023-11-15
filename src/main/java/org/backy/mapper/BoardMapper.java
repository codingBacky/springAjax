package org.backy.mapper;

import java.util.List;
import java.util.Map;

import org.backy.domain.BoardVO;
import org.backy.domain.Criteria;

public interface BoardMapper {
	//전체데이터 조회
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//insert문 bno 값 알아야 할 필요 없을때
	public void insert(BoardVO vo);
	
	public void insertSelectKey(BoardVO vo);
	
	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO vo);
	
	//전체 개수 구하기
	public int getTotalCount(Criteria cri);
	
	//테스트용
	public List<BoardVO> searchTest(Map<String, Map<String, String>> map);
} 
