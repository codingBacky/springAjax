package org.backy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum; //page 1page, 2page, 3page
	private int amount; //page당 data 개수
	private String type;//T,C,W
	private String keyword;//검색내용
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//type = tcw로 , keyword="서울" 검색 => String[] str = {t, c, w}
	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split("");
	}
}
