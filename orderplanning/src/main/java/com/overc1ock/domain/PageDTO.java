package com.overc1ock.domain;

import lombok.Data;

@Data
public class PageDTO {
	
	// 페이지 바의 시작 번호, 끝 번호
	private int startPage, endPage;
		
	// 이전, 다음 표시 유무
	private boolean prev, next;
		
	// 전체 목록 개수
	private int total;
		
	// 현재 페이지와 보여줄 목록 개수
	private Criteria cri;
		
	public PageDTO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
			
		endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		startPage = endPage - 9;
			
		// 마지막 페이지
		int realEnd = (int) (Math.ceil((total*1.0) / cri.getAmount()));
		prev = (startPage > 1);
		next = (endPage < realEnd);
	}

}
