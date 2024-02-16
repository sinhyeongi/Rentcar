
function Check(){
	let log = $('#Main_log_session').val();
	if(log == null || log == ''){
		alert('로그인 후 이용해주세요');
		return true;
	}
	return false;
} 
$('#Main_log_header').click(function(){
	location.href="Main.do";
});
$("#main_btn").click(function(){
	location.href="Main.do";
});
 
$("#login_btn").click(function(){
	location.href="Login.do";
});
$("#logout_btn").click(function(){
 	$.ajax({
 		type:"post",
 		url:"Logout.do",
 		success: function(data){
 			if(data == "true"){
 			alert("로그아웃 완료");
 			location.href="Main.do";
 			return;
 			}
 		}
 	})
 });
 
 $("#car_btn").click(function(){
	if(Check()){
		return;
	}
	location.href="Carreserve.do";
});
$('#member_insert_btn').click(function(){
	location.href="MemberInsert.do";
});
$('#search_btn').click(function(){
	if(Check()){
		return;
	}
	location.href="CarreserveInfo.do";
});
$('#memberinfo_btn').click(function(){
	if(Check()){
		return;
	}
	location.href="MemberInfo.do";
});
$('#admin_car_add').click(function(){
	location.href = "addcar.do";
});