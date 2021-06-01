/**
 * 
 */
$(document).ready(function(){
	
	// 첨부파일
	(function(){
		var bno = $("#bno").val();
		
		$.getJSON("/sheet/getAttachList", {bno: bno}, function(arr){
			console.log(arr);
			
			var str = "";
			
			$(arr).each(function(i, attach){
				var fileCallPath = encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName);
				
				str += "<li data-path='"+attach.uploadPath+"'";
				str += "data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"'";
				str += " ><div>";
				str += "<span>"+attach.fileName+"</span>";
				//str += "<img src='/display?fileName="+fileCallPath+"'>";
				str += "</div>";
				str + "</li>";
				
			})
			
			$(".uploadResult ul").html(str);
			
			$(".uploadResult ul").on("click", "li", function(e){
				var liObj = $(this);
				
				// 파일 링크
				var path = encodeURIComponent(liObj.data("path")+"/"+liObj.data("uuid")+"_"+liObj.data("filename"));
				
				self.location ="/download?fileName="+path
				
			})
			
		})// end getJSON
	})();// end function	
	
	
	
	var operForm = $("#operForm");
	
	// 글 수정 버튼
	$("button[data-oper='modify']").on("click", function(e){
		operForm.attr("action","/sheet/modify").submit();
	});
	
	// 글 목록 버튼
	$("button[data-oper='list']").on("click", function(e){
		operForm.find("#bno").remove();
		operForm.attr("action","/sheet/list");
		operForm.submit();
	})
	
	// 글 삭제 버튼
	$("button[data-oper='remove']").on("click", function(e){
		operForm.attr("action","/sheet/remove");
		operForm.submit();
	})
	
	
	// 댓글 목록 처리
	var bnoValue = $("#bno").val();
	var replyUL = $(".replyUL");
	
	showList(1);
	
	function showList(page){
		replyService.getList({bno:bnoValue, page:page||1}, function(replyCnt, list){
			if(page == -1){
				pageNum = Math.ceil(replyCnt/10.0);
				showList(pageNum);
				return;
			}
			
			var str = "";
			
			if(list == null || list.length == 0){
				replyUL.html("");
				return;
			}
			
			for(var i=0, len=list.length||0; i<len; i++){
				// 사용자 아이디 값
				var idValue = $("#idValue").val();
				
				str += '<li class="replylist" data-rno="'+list[i].rno+'">';
				str += '<img src="../../../resources/images/profile.png" id="replyImg">';
				str += '<div class="replyinfo"><strong>'+list[i].replyer+'</strong>';
				str += '<span class="divider">·</span>';
				str += '<small class="replyTime">'+replyService.displayTime(list[i].replyDate)+'</small>';
				if(list[i].id==idValue){
					str += '<a href="'+list[i].rno+'" class="commentModifyA">수정</a>';
					str += '<span class="divider">·</span>';
					str += '<a href="'+list[i].rno+'" class="commentDeleteA">삭제</a>';
				}
				str += '<p>'+list[i].reply+'</p></div></li>';
			}// end for
			replyUL.html(str);
			
			showReplyPage(replyCnt);
		}); // end function(list)
	}// end showList
	
	
	// 댓글 추가
	var CommentText = $(".CommentText");
	var nickname = $("#nickname");
	var idValue = $("#idValue");
	
	$("#CommentBtn").on("click", function(e){
		if(CommentText.val() != ""){
			var reply={
					reply:CommentText.val(),
					replyer:nickname.val(),
					id:idValue.val(),
					bno:bnoValue
			}
			replyService.add(reply, function(result){
				alert("댓글이 등록되었습니다");
				
				showList(-1);
				CommentText.val("");
			})
		}else{
			alert("댓글을 작성해주세요");
			return false;
		}
		
	});
	
	
	// 댓글 수정 클릭 시 이벤트
	replyUL.on("click", "li .commentModifyA", function(e){
		e.preventDefault();
		var rno = $(this).attr("href");
		var str = "";
		$(this).parent().addClass("thisModify");

		replyService.get(rno, function(reply){
			str += '<div class="modifyComment">';
			str += '<textarea rows="3" cols="80" class="modifyCommentText">'+reply.reply+'</textarea>';
			str += '<button id="commentModifyBtn" data-rno="'+rno+'">수정</button></div>';
			
			$("<div class='modifyZone'></div>").html(str).appendTo(".thisModify");
			
		})

	});
	
	// 댓글 수정
	replyUL.on("click", "li button", function(e){
		var modifyCommentText = $(".modifyCommentText");
		var rnoVal = $(this).data("rno");
		var reply = {rno:rnoVal, reply:modifyCommentText.val()};

		replyService.update(reply, function(result){
			showList(pageNum);
		})

	});
	
	// 댓글 삭제
	replyUL.on("click", "li .commentDeleteA", function(e){
		e.preventDefault();
		var rno = $(this).attr("href");
		
		replyService.remove(rno, function(result){
			showList(pageNum);
		})
	})

	
	
	// 댓글 페이징
	var pageNum = 1;
	var replyPageDiv = $(".replyPageDiv");
	
	function showReplyPage(replyCnt){
		var endNum = Math.ceil(pageNum/10.0)*10;
		var startNum = endNum - 9;
		
		var prev = startNum != 1;
		var next = false;
		
		if(endNum * 10 >= replyCnt){
			endNum = Math.ceil(replyCnt/10.0);
		}
		if(endNum * 10 < replyCnt){
			next = true;
		}
		
		var str = "<ul class='pageUL'>";
		
		// 이전 버튼 출력
		if(prev){
			str += "<li class='paginateBtn'><a href='"+(startNum-1)+"'>";
			str += "<img src='../../../resources/images/left-arrow.png'></a></li>";
		}
		// 페이징 번호 출력
		for(var i=startNum; i<=endNum; i++){
			var active = pageNum == i ? "active" : "";
			str += "<li class='paginateBtn "+active+"'><a href='"+i+"'>"+i+"</a></li>";
		}
		// 다음 버튼 출력
		if(next){
			str += "<li class='paginateBtn'><a href='"+(endNum-1)+"'>";
			str += "<img src='../../../resources/images/next.png'></a></li>";
		}
		str += "</ul>";
		
		replyPageDiv.html(str);
	}
	
	// 페이지 번호 클릭 시 이동 이벤트
	replyPageDiv.on("click", "li a", function(e){
		e.preventDefault();
		var targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showList(pageNum);
	})
	
	
	
	
	
	

})



