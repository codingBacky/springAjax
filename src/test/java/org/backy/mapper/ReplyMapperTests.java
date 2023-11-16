package org.backy.mapper;

import java.util.stream.IntStream;

import org.backy.domain.Criteria;
import org.backy.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {2228239L
							,2228237L
							,2228236L
							,2228235L
							,2228234L};
		
	@Test
	public void testGetListWithPaging() {
		/*
		List<ReplyVO> list = mapper.getListWithPage(new Criteria(), 2228237L);
		list.forEach(vo -> log.info(vo));
		
		for(ReplyVO vo : list)
				log.info(vo);
		*/
		mapper.getListWithPaging(new Criteria(3,2), 2228237L)
		.forEach(reply -> log.info(reply));
		
		}
	@Test
	public void testGetCountByBno() {
		mapper.getCountByBno(2228237L);
	}
	
	@Test
	public void testCreate() {
		IntStream.range(1, 10).forEach(i->{
			ReplyVO vo = ReplyVO.builder()
						.bno(bnoArr[i%5])
						.reply("댓글테스트" + i)
						.replyer("댓글작성자" + i)
						.build();
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testCreate2() {
		
			ReplyVO vo = ReplyVO.builder()
						.bno(2228237L)
						.reply("댓글테스트3")
						.replyer("댓글작성자3")
						.build();
			mapper.insert(vo);
	
	}
	
	@Test
	public void testMapper(){
		log.info("mapper 연결 확인 >" + mapper);
	}
	
	@Test
	public void testRead() {
		log.info(mapper.read(1L));
	}
	@Test
	public void testDelete() {
		log.info(mapper.delete(11L));
	}
	@Test
	public void testUpdate() {
		ReplyVO vo = ReplyVO.builder()
					.rno(1L)
					.reply("수정 댓글테스트")
					.build();
		log.info(mapper.update(vo));
	}
	
}
