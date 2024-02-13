/**
 * 
 */
  $("#logout_btn").click(function(){
 	$.ajax({
 		type:"post",
 		url:"Logout.do",
 		success: function(data){
 			if(data == true){
 			alert("로그아웃 완료");
 			return;
 			}
 		}
 	})
 });