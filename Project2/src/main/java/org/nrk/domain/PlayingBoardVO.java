package org.nrk.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PlayingBoardVO {
	private int bno;
	private String id;
	private String title;
	private String content;
	private String category;
	private String link;
	private String writer;
	private Date regdate;
	private Date updateDate;
	private int recommend;
	private int hit;
	private int replycnt;
}
