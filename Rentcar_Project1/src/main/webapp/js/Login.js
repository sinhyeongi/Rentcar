
 $("#login_submit").click(function(){
 let id = $('#id').val();
 let pw = $('#pw').val();
 	if( id == null || id == ''){
 		alert('아이디를 입력 해주세요');
 		$('#id').focus();
 		return;
 	}else if(pw == null || pw == ''){
 		alert('비밀번호를 입력 해주세요');
 		$('#pw').focus();
 		return;
 	}
 	let udata = {
 	id : $("#id").val(),
 	pw : $("#pw").val()
 	};
 	$.ajax({
 		type:"post",
 		url:"Login.do",
 		data:udata,
 		success: function(data){
 		if(data == ""){
 			alert("로그인 실패\n아이디 또는 비밀번호를 확인하세요");
 			return;
	 		}
	 		alert(data+'님 환영합니다');
 			location.href="Main.do";
 		}
 	});
 });
$("#id").keyup(function(e){
	if($(this).val() != '' &&$(this).val() != null&&e.keyCode == 13){
		$("#pw").focus();		
	}
});
$("#pw").keydown(function(e){
	//tap 버튼 이벤트
	if(e.keyCode == 9){
		$("#memberinfo_btn").focus();
	}
});
$("#pw").keyup(function(e){
	if(e.keyCode == 13){
		 $("#login_submit").click();
	}
});