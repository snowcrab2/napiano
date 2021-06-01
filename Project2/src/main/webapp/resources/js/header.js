/**
 * 
 */
$(document).ready(function(){
	var membershipForm = $(".membershipForm");
	$(".memberModify").on("click", function(e){
		e.preventDefault();
		membershipForm.append("<input type='hidden' name='id' value='"+$(this).attr("href")+"'>");
		membershipForm.attr("action","/membership/get");
		membershipForm.submit();
	})
})