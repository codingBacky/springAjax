package org.backy.service;

import org.backy.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImplTests {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testRegister() {
		BoardVO board = BoardVO.builder()
			.title("새로 작성")
			.content("새로작성 내용")
			.writer("뉴비>.<")
			.build();
		boardService.register(board);
	}
	
//	@Test
//	public void testGetList() {
//		boardService.getList()
//		.forEach(board -> log.info(board));
//	}
	
	@Test
	public void testGet() {
		boardService.get(1L);
	}
	@Test
	public void testModify() {
		BoardVO vo = BoardVO.builder()
				.title("새로 작성")
				.content("새로작성 내용")
				.writer("뉴비>.<")
				.bno(1L)
				.build();
		boolean result = boardService.modify(vo);
		log.info("modify :" + result);
	}
	@Test
	public void testDelete() {
		boolean result = boardService.remove(1L);
		log.info("remove :" + result);
	}
}
