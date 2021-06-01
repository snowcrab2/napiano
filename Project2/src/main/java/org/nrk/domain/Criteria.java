package org.nrk.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	// 검색
	private String type;
	private String keyword;
	
	// 카테고리
	private String category;
	
	public Criteria() {
		this(1,9);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// 검색 조건 배열로
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	// 파라미터 유지
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		return builder.toUriString();
	}
}
