/**
 * 
 */
$(document).ready(function(){
	var actionForm = $("#actionForm");
	
	// 연주영상 조회 페이지로 이동 이벤트
	$(".pagingMove").on("click", function(e){
		e.preventDefault();
		// 조회 페이지로 가면 actionForm에서 bno값을 같이 들고간다
		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
		// 조회 페이지로 가기 위한 링크
		actionForm.attr("action","/playing/get");
		actionForm.submit();
	})
	
	// 클래스 조회 페이지로 이동 이벤트
	$(".pagingMove2").on("click", function(e){
		e.preventDefault();
		// 조회 페이지로 가면 actionForm에서 bno값을 같이 들고간다
		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
		// 조회 페이지로 가기 위한 링크
		actionForm.attr("action","/class/get");
		actionForm.submit();
	})


	
	
})

