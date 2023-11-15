package org.backy.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.backy.domain.SampleVO;
import org.backy.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@GetMapping(value = "/getText", produces = "text/plain; charset=utf-8")
	public String getTest() {
		log.info("MINE TYPE >" + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112,"스타2","로드2");
	}
	
	@GetMapping("/getSample2")
	public SampleVO setSample2() {
		return new SampleVO(113,"ㅋㅏ운팅 스ㅌr","로드");
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getlist(){
		return IntStream.range(1, 10).mapToObj(i->new SampleVO(i, i+"first", i+"last"))//1~10까지 new SampleVO 객체 생성
				.collect(Collectors.toList());//생성된 객체를 collect 수집해 리스트로 만듦
	}
	@GetMapping("/getList2")
	public List<SampleVO> getlist2(){
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i=1; i<10; i++) {
			list.add(new SampleVO(i, i+"first", i+"last"));
		}
		
		return list;
	}
	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		
		map.put("first", new SampleVO(111, "나른한 오후", "2시 29분"));
		
		return map;
	}
	@GetMapping(value="/check", params= {"height","weight"})//반드시 전달해주세요
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo =new SampleVO(0, ""+height, ""+ weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	@GetMapping("/product/{cat}/{pid}")
	public String[]	getPath(@PathVariable("cat")String cat, @PathVariable("pid")String pid) {
		return new String[] {"category :" + cat, "productid :" + pid};
	}
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert>" + ticket);
		return ticket;
	}
	
}
