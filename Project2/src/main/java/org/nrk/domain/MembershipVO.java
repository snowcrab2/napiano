package org.nrk.domain;

import lombok.Data;

@Data
public class MembershipVO {
	private String id;
	private String password;
	private String nickname;
	private String phone;
	private String birth;
	private String gender;
}

