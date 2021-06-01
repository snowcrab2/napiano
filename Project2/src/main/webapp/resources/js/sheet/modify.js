/**
 * 
 */
$(document).ready(function(){
	(function(){
		var bno = $("#bno");
		
		$.getJSON("/board/getAttachList", {bno: bno}, function(arr){
    		console.log(arr);
    		
    		var str = "";
    		$(arr).each(function(i, attach){
				// 이미지 타입
				if(attach.fileType){ // fileType이 true면(이미지 파일이면)
					// 파일 링크
					var fileCallPath = encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName);
					
					str += "<li data-path='"+attach.uploadPath+"'";
					str += "data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"'";
					str += " ><div>";
					str += "<span>"+attach.fileName+"</span>";
					str += "<button type='button' data-file=\'"+fileCallPath+"\' "
					str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str += "<img src='/display?fileName="+fileCallPath+"'>";
					str += "</div>";
					str + "</li>";
				}else{ // 이미지 파일이 아니면
					str += "<li ";
					str += "data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+
							attach.fileName+"' data-type='"+attach.fileType+"' ><div>";
					str += "<span> "+attach.fileName+"</span>";
					str += "<button type='button' data-file=\'"+fileCallPath+
							"\' data-type='file' ";
					str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str += "<img src='/resources/img/battle.png'></a>";
					str += "</div>";
					str + "</li>";
				}
			});
			$(".uploadResult ul").html(str);
    	}); //end getjson
	})();// end function
	
	// X 아이콘 클릭하면 삭제
	$(".uploadResult").on("click", "button", function(e){
		console.log("delete file");
		
		if(confirm("remove this file? ")){
			var targetLi = $(this).closest("li");
			targetLi.remove();
		}
	});
	
	// 파일 추가
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
			// formData에 fileData추가
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
				// 결과가 콘솔에 찍히게
				console.log(result);
				// showUploadResult 함수 호출
				showUploadResult(result);
			}
		}); // ajax end
		
	});
	
	function showUploadResult(arr){
		if(!arr || arr.length == 0){return;}
		
		var uploadUL = $(".uploadResult ul");
		var str = "";
		
		$(arr).each(function(i, obj){
			// 이미지 타입
			if(obj.image){ // 이미지 파일이면
				// 파일 링크
				var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
				
				str += "<li data-path='"+obj.uploadPath+"'";
				str += "data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'";
				str += " ><div>";
				str += "<span>"+obj.fileName+"</span>";
				str += "<button type='button' data-file=\'"+fileCallPath+"\' "
				str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
				str += "<img src='/display?fileName="+fileCallPath+"'>";
				str += "</div>";
				str + "</li>";
			}else{ // 이미지 파일이 아니면
				// 파일 링크
				var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
				
				str += "<li ";
				str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+
						obj.fileName+"' data-type='"+obj.image+"' ><div>";
				str += "<span> "+obj.fileName+"</span>";
				str += "<button type='button' data-file=\'"+fileCallPath+
						"\' data-type='file' ";
				str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
				str += "<img src='/resources/img/battle.png'></a>";
				str += "</div>";
				str + "</li>";
			}
			
		});
		// ul태그 안에 str을 넣는다
		// console.log(str)
		uploadUL.append(str);
	}
	
	var formObj = $("form");
	
	$("button").on("click",function(e){
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === 'remove'){
			formObj.attr("action","/board/remove");
		}else if(operation === 'list'){
			// move to list
			formObj.attr("action","/board/list").attr("method","get");
			var pageNumTag=$("input[name='pageNum']").clone();
			var amountTag=$("input[name='amount']").clone();
			var keywordTag=$("input[name='keyword']").clone();
			var typeTag=$("input[name='type']").clone();
			
			formObj.empty();
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			formObj.append(keywordTag);
			formObj.append(typeTag);
			
		}else if(operation === 'modify'){
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
			formObj.append(str).submit();
		}
		formObj.submit();
	});
	
})