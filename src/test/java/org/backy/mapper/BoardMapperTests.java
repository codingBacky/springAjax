package org.backy.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.backy.domain.BoardVO;
import org.backy.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		List<BoardVO> list = mapper.getList();
//		
//		for(BoardVO vo :list)
//			log.info(vo);
		
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = BoardVO.builder()
		.title("인서트3")
		.content("인서트 내용")
		.writer("루루")
		.build();
		mapper.insert(vo);
	}
	
	@Test
	public void testinsertSelectKey() {
		BoardVO vo = BoardVO.builder()
				.title("인서트4")
				.content("인서트 내용")
				.writer("루루")
				.build();
		mapper.insertSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(1L);
		log.info("vovovovovo : " + vo);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(3L);
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = BoardVO.builder()
				.title("제목")
				.content("내용")
				.writer("글쓴이")
				.bno(2L)
				.build();
		
		int result = mapper.update(vo);
		log.info(result);
	}
	@Test
	public void testGetListWithPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(2);
		cri.setAmount(15);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria();
		cri.setType("TCW");
		cri.setKeyword("자바");
		log.info(mapper.getTotalCount(cri));
	}
	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("T", "잡아자바");
		map.put("C", "새글새글");
		map.put("W", "글쓴이");
		
		Map<String, Map<String, String>> outer = new HashMap<String, Map<String,String>>();
		outer.put("map", map);
		
		List<BoardVO> searchTestList = mapper.searchTest(outer);
		log.info(searchTestList);
	}
	
	@Test
	public void testSearchPaging() {
		Criteria cri = new Criteria();
		cri.setType("TW");
		cri.setKeyword("잡아자바");
		
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		log.info(list);
		
		mapper.getListWithPaging(cri).forEach(list -> log.info(list));
	}
}
