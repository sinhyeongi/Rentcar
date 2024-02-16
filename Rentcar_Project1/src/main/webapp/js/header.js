//로그인 값 체크
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
//메인 화면 으로 이동
$("#main_btn").click(function(){
	location.href="Main.do";
});
 //로그인 버튼
$("#login_btn").click(function(){
	location.href="Login.do";
});
//로그아웃 버튼
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
 //차량 예약 버튼
 $("#car_btn").click(function(){
	if(Check()){
		return;
	}
	location.href="Carreserve.do";
});
// 회원 가입 버튼
$('#member_insert_btn').click(function(){
	location.href="MemberInsert.do";
});
//예약 정보 버튼
$('#search_btn').click(function(){
	if(Check()){
		return;
	}
	location.href="CarreserveInfo.do";
});
//나의 정보 버튼
$('#memberinfo_btn').click(function(){
	if(Check()){
		return;
	}
	location.href="MemberInfo.do";
});
//차량 추가 버튼
$('#admin_car_add').click(function(){
	location.href = "addcar.do";
});

// 차량 관리 버튼
$('#admin_car').click(function(){
	location.href = "Admin_Car.do";
});

$('#admin_member').click(function(){
	location.href = "Admin_Member.do";
})