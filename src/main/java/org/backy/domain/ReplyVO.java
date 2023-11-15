package org.backy.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	private Long rno, bno;
	private String reply, replyer;
	private Date replyDate, updateDate;
}
