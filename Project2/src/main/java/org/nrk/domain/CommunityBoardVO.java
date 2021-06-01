package org.nrk.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommunityBoardVO {
	private int bno;
	private String id;
	private String category;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	private int recommend;
	private int hit;
	
	// ´ñ±Û¼ö
	private int replycnt;
}
