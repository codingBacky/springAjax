package org.backy.service;

import java.util.List;

import org.backy.domain.Criteria;
import org.backy.domain.ReplyPageDTO;
import org.backy.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rnl);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rnl);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
