package org.nrk.domain;

import lombok.Data;

@Data
public class AttachFileDTO {
	// ���� ������ �̸�
		private String fileName;
		// ���ε� ���
		private String uploadPath;
		// UUID��
		private String uuid;
		// �̹��� ����
		private boolean image;
}
