/**
 * 
 */
$(document).ready(function(){
	
	var operForm = $("#operForm");
	
	
	// 글 목록 버튼
	$("button[data-oper='list']").on("click", function(e){
		operForm.find("#bno").remove();
		operForm.attr("action","/class/list");
		operForm.submit();
	})
	
	
	// 글 추천 버튼
	$(".recBtn").on("click", function(){
		var rec = confirm("해당 강의를 추천하시겠습니까?");
		
		if(rec){
			operForm.attr("action","/class/recommend");
			operForm.submit();
			
			alert("해당 강의 추천하였습니다.");
		}
	})

	
})




