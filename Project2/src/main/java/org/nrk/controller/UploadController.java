package org.nrk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.nrk.domain.AttachFileDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {
	private String getFolder() { // ���� ��¥�� ��θ� ���ڿ��� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
						// ������ ��δ� ���� ��η� ������ �� ����
		return str.replace("-", File.separator);
	}
	
		
	// �̹������� �˻��ϴ� �޼���
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
		
	@PostMapping(value = "/uploadAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";
			
		String uploadFolderPath = getFolder();
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		// ��¥�� ���� ��ΰ� �ִ��� �˻��ϰ� ���� ����
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
			
		for(MultipartFile multipartFile : uploadFile) {
			AttachFileDTO attachDTO = new AttachFileDTO();
				
			String uploadFileName = multipartFile.getOriginalFilename();
				
			// IE ���� ��� 
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name: " + uploadFileName);
			attachDTO.setFileName(uploadFileName);
				
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
				
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
					
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
					
				if(checkImageType(saveFile)) { // �̹��� Ÿ������ �˻�
					attachDTO.setImage(true);
						
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
						
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
						
					thumbnail.close();
				}// end if
				list.add(attachDTO);
			}catch(Exception e) {
				e.printStackTrace();
			}// end catch
		}// end for
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
		
	// ÷������ �ٿ�ε�
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> dounloadFile(@RequestHeader("User-Agent") String userAgent, String fileName){
		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
			
		if(resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		String resourceName = resource.getFilename();
			
		// UUID ����
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
			
		HttpHeaders headers = new HttpHeaders();
		try {
			String downloadName = null;
				
			// userAgent�� ���� Trident��(IE������ ���� �̸�)
			if(userAgent.contains("Trident")) {
				log.info("IE browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
					
			// userAgent�� ���� Edge��
			}else if(userAgent.contains("Edge")) {
				log.info("Edge browger");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
			}else {
				log.info("Chrome browser");
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}
			log.info("downloadName: " + downloadName);
			// �ٿ�ε�� ������ �̸��� ó��
			headers.add("Content-Disposition", "attachment; fileName=" + downloadName);
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
		
	// ÷������ ����
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("deleteFile: " + fileName);
			
		File file;
		try {
			// file�� ������ ��θ� ����
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
				
			// ������ ������ image��
			if(type.equals("image")) {
				// largeFileName�� ������ ������ ����
				String largeFileName = file.getAbsolutePath().replace("s_", "");
					
				log.info("largeFileName: " + largeFileName);
					
				file = new File(largeFileName);
				// ������ ����
				file.delete();
			}// end if
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}
