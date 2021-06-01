package org.nrk.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ClassBoardVO {
	private int bno;
	private String id;
	private String imglink;
	private String title;
	private String content;
	private String writer;
	private int recommend;
	private int price;
	private Date regdate;
	private Date updateDate;
}
