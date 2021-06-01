package org.nrk.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int rno;
	private int bno;
	private String id;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
	private int recommend;
}
