package org.nrk.domain;

import lombok.Data;

@Data
public class AttachFileDTO {
	// 원본 파일의 이름
		private String fileName;
		// 업로드 경로
		private String uploadPath;
		// UUID값
		private String uuid;
		// 이미지 여부
		private boolean image;
}
