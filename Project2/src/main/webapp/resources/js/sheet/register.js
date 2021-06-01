/**
 * 
 */
$(document).ready(function(e){
	var formObj = $("form[role='form']");
	
	// submit 버튼 클릭했을때
	$("button[type='submit']").on("click", function(e){
		// 기본 동작 막기
		e.preventDefault();
		console.log("submit clicked");
		
		var str = "";
		
		$(".uploadResult ul li").each(function(i, obj){
			var jobj = $(obj);
			console.dir(jobj);
			
			str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
			str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
			str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
			str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("type")+"'>";
			
		});
		//console.log(str);
		formObj.append(str).submit();
	});
	
	// 파일 확장자
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	// 파일 크기
	var maxSize = 5242880; // 5MB
	
	// 파일 확장자와 크기를 검사하는 함수
	function checkExtension(fileName, fileSize){
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	$("input[type='file']").change(function(e){
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		
		for(var i=0; i<files.length; i++){
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			formData.append("uploadFile", files[i]);
		}// end for
		
		// 첨부파일 업로드를 ajax를 통해
		$.ajax({
			url: "/uploadAjaxAction",
			processData: false,
			contentType: false,
			data: formData, // formData 전송
			type: "POST", // POST 방식으로 전송
			dataType: "json", // 데이터타입은 JavaScript
			success: function(result){
				console.log(result);
				showUploadResult(result);
			}
		}); // ajax end
		
	});
	
	function showUploadResult(uploadResultArr){
		if(!uploadResultArr || uploadResultArr.length == 0){return;}
		
		var uploadUL = $(".uploadResult ul");
		var str = "";
		
		$(uploadResultArr).each(function(i, obj){
			var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
			
			str += "<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"'";
			str += " data-filename='"+obj.fileName+"' data-type='"+obj.image+"'><div>";
			str += "<span>"+obj.fileName+"</span>";
			str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' class='circleBtn'>"
			str += "<img src='/resources/images/free-icon-letter-x-109602.png'></button><br></div></li>";			
		});
		uploadUL.append(str);
	}
	
	// X 아이콘 클릭하면 삭제
	$(".uploadResult").on("click", "button", function(e){
		console.log("delete file");
		// 선택한 파일의 경로와 이름
		var targetFile = $(this).data("file");
		// 파일의 종류(이미지 or 일반)
		var type = $(this).data("type");
		
		var targetLi = $(this).closest("li");
		
		// 데이터를 ajax로 처리
		$.ajax({
			url: "/deleteFile",
			data: {fileName: targetFile, type:type},
			dataType:"text",
			type:"POST",
			success:function(result){
				alert(result);
				targetLi.remove();
			}
		})// end ajax
	})
	
	
	
	
	
	
	
})