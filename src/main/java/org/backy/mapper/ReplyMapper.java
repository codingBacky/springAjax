package org.backy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.backy.domain.Criteria;
import org.backy.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO no);	//Create

	public ReplyVO read(Long rno);	//Read
	
	public int delete(Long rno);	//Delete
	
	public int update(ReplyVO no);	//Update
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri")Criteria cri,
			@Param("bno")Long bno 
			);
	public int getCountByBno(Long bno);
}
