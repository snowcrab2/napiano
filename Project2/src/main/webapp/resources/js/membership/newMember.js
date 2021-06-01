/**
 * 
 */
$(document).ready(function(){
	$("#headImg img").on("click", function(){
		self.location="/";
	})
	
	// id 정규식
	var idExp = /[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]/;
	// 비밀번호 정규식
	var pwExp = /[A-Za-z0-9]{8,32}/;
	// 생년월일 정규식
	var birthExp = /\d{8}/;
	// 닉네임 정규식
	var nicknameExp = /[가-힣A-Za-z0-9_\.\-]{1,20}/;

	// id 유효성 검사
	$("#id").blur(function(){
		var user_id = $("#id").val();
		var userData ={"id" : user_id}
		
		$.ajax({
			type : "POST",
			url : "/membership/emailChk",
			data : userData,
			dataType : "json",
			error : function(error){
				alert("다시 시도해주세요")
			},
			success : function(result){
				if(result == 1){ // 아이디가 중복되면
					$(".id_fail").text("사용중인 이메일입니다");
					$(".id_fail").css({"color":"#CC3D3D","fontSize":"13px","padding":"5px 50px"})
				}else if(result == 0){ // 사용중이지 않으면
					if(!idExp.test(user_id)){ // 정규식
						$(".id_fail").text("이메일을 다시 확인해 주세요");
						$(".id_fail").css({"color":"#CC3D3D","fontSize":"13px","padding":"5px 50px"})
					}else if(idExp.test(user_id)){
						$(".id_fail").text("");
					}
				}
			}
		})
	})
	
	// pw 유효성 검사
	$("#password").blur(function(){
		if(!pwExp.test($("#password").val())){
			$(".pw_fail").text("8~32자의 영문, 숫자만 사용 가능합니다.");
			$(".pw_fail").css({"color":"#CC3D3D","fontSize":"13px","padding":"5px 50px"});
		}else if(pwExp.test($("#password").val())){
			$(".pw_fail").text("");
		}
	})
	
	// 생년월일 유효성 검사
	$("#birth").blur(function(){
		if(!birthExp.test($("#birth").val())){
			$(".birth_fail").text("8자의 숫자만 사용 가능합니다.");
			$(".birth_fail").css({"color":"#CC3D3D","fontSize":"13px","padding":"5px 50px"});
		}else if(birthExp.test($("#birth").val())){
			$(".birth_fail").text("");
		}
	})
	
	// 닉네임 유효성 검사
	$("#nickname").blur(function(){
		if(!nicknameExp.test($("#nickname").val())){
			$(".namechk_fail").text("닉네임을 다시 확인해주세요(최대 20자, 특수문자 사용 불가)");
			$(".namechk_fail").css({"color":"#CC3D3D","fontSize":"13px","padding":"5px 50px"});
		}else if(nicknameExp.test($("#nickname").val())){
			$(".namechk_fail").text("");
		}
	})
	
	// 인증번호 전송 버튼
	$("#phoneChkBtn").on("click", function(){
		if($(".phone").val() != null){
			var str = "<input type='text' placeholder='인증번호 6자리를 입력해주세요' class='phoneChkInput'>"
				$(".phoneChk").html(str);
		}
		
	})

	
	$("#submit").on("click", function(){
		if($("#id").val() == "" || !idExp.test($("#id").val())){
			alert("이메일을 다시 확인해주세요");
			$("#id").focus();
			return false;
		}
		if($("#password").val() == "" || !pwExp.test($("#password").val())){
			alert("비밀번호를 다시 확인해주세요");
			$("#password").focus();
			return false;
		}
		if($("#nickname").val() == "" || !nicknameExp.test($("#nickname").val())){
			alert("닉네임을 다시 확인해주세요");
			$("#nickname").focus();
			return false;
		}
		if($(".phone").val() == ""){
			alert("휴대폰번호를 입력해주세요");
			$(".phone").focus();
			return false;
		}
		if($("#birth").val() == "" || !birthExp.test($("#birth").val())){
			alert("생년월일을 다시 확인해주세요");
			$("#birth").focus();
			return false;
		}
		if($("#password").val() != $("#passwordChk").val()){
			alert("비밀번호를 다시 확인해주세요");
			$("#passwordChk").focus();
			return false;
		}
	})
})