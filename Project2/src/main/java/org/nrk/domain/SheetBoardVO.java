package org.nrk.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SheetBoardVO {
	private int bno;
	private String id;
	private String category;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	private String difficulty;
	private int price;
	private int hit;
	private int replycnt;
	
	private List<BoardAttachVO> attachList;
}
