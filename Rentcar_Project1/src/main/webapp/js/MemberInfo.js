function check(){
	let id = $('#id');
	let email = $('#email');
	let tel = $('#tel');
	let hobby = $('#hobby');
	let job = $('#job');
	let age = $('#age');
	let info = $('#info');
	let emailreg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	let telreg = /^\d{3}-\d{3,4}-\d{4}$/;
	let agereg = /^(100|[0-9]{1,2})$/;
	if(id.val() == null || id.val() == ''){
		alert('아이디를 입력해주세요');
		id.focus();
		return true;
	}else if(email.val() == null || email.val()==''){
		alert('이메일을 입력해주세요');
		email.focus();
		return true;
	}else if(emailreg.test(email.val()) == false){
		alert('이메일을 형식에 맞게입력해주세요');
		email.val('');
		return true;
	}else if(tel.val() == null || tel.val() == ''){
		alert('휴대폰 번호를 입력해주세요');
		tel.focus();
		return true;
	}else if(telreg.test(tel.val()) == false){
		alert('휴대폰 번호를 형식에 맞게 입력해주세요');
		tel.val('');
		return true;
	}else if(job.val() == null || job.val() == ''){
		alert('직업을 입력해주세요');
		job.focus();
		return true;
	}else if(age.val() == null || age.val() == ''){
		alert('나이를 입력해주세요');
		age.focus();
		return true;
	}else if(agereg.test(age.val()) == false){
		alert('나이를 다시 입력해주세요');
		age.val('');
		return true;
	}
	return false;
}
$('#MemberInfo_submit').click(function(){
	let _id = $('#id').val();
	let _email = $('#email').val();
	let _tel = $('#tel').val();
	let _hobby = $('#hobby').val();
	let _job = $('#job').val();
	let _age = $('#age').val();
	let _info = $('#info').val();
	if(check()){
		return;
	}
	let _data = {
		id : _id,
		email : _email,
		tel : _tel,
		hobby : _hobby,
		job : _job,
		age : _age,
		info : _info
	};
	$.ajax({
		type:"POST",
		url : "MemberInfo.do",
		data : _data,
		success : function(data){
			if(data === 'ok'){
				alert('업데이트 완료');
				location.href = location.href;
			}
		}
	});
});

 $('#MemberDelete_btn').click(function(){
 	let conf = confirm('정말 탈퇴 하시겠습니까?');
 	if(conf == false){
 		return;
 	}
 	let _id = $('tr:eq(0)').find('td').text();
 	let _data = {
 	id : _id};
 	$.ajax({
 		type : "POST",
 		url : "DeleteMember.do",
 		data : _data,
 		success : function(data){
 			if(data != '' && data == 1){
 				alert(_data.id+"님 회원 탈퇴 완료 되었습니다.");
 				location.href="Main.do"
 				return;
 			}
 			alert('Err');
 		}
 	});
});