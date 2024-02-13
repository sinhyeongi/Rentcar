
 $("#login_submit").click(function(){
 	let udata = {
 	id : $("#id").val(),
 	pw : $("#pw").val()
 	};
 	$.ajax({
 		type:"post",
 		url:"Login.do",
 		data:udata,
 		success: function(data){
 			if(data){
 			alert('로그인 성공');
 			location.href="Main.do";
 			return;
 			}
 			alert('로그인 실패');
 		}
 	});
 });
 
