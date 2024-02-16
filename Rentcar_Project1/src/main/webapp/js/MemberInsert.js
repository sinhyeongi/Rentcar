let isCheck = false;
$('#id_check').click(function(){
	let _id = $('#id');
	let idreg = /^[a-zA-Z0-9]{4,}$/;
	
	if(_id.val() == null || _id.val() == ''){
		alert('아이디를 입력해주세요');
		_id.focus();
		return;
	}else if(idreg.test(_id.val())== false){
		if(_id.val().length < 4){
			alert('4글자 이상 가능합니다');
		}else{
			alert('숫자와 영어만 입력 가능합니다.');
		}
		_id.val('');
		_id.focus();
		return;
	}
	let _data = {
		id : $('#id').val()
	};
	$.ajax({
		type : "POST",
		url : "MemberInsert.do",
		data : _data,
		success : function(data){
			if(data != '' && data == 0){
				isCheck = true;
				alert('사용 하실수있는 아이디 입니다.');
				_id.prop('readonly','readonly');
				_id.css('background-color','gray');
				return;
			}
			alert('중복된 아이디 입니다.');
			_id.val('');
			_id.focus();
		}
	});
	
});
$('.memberinsert_btn').click(function(){
	if(isCheck == false){
		alert('아이디 중복 검사를 진행해 주세요');
		return;
	}
	if(check()){
		return;
	}
	let _hobby = null;
	$('input[name=hobby]').each(function(){
		if($(this).is(':checked')){
			if(_hobby == null){
				_hobby = $(this).val();
				return;
			}
			_hobby += ", "+$(this).val();
		}
	});
	let _data = {
		id : $('#id').val(),
		pw : $('#pw').val(),
		email : $('#email').val(),
		tel : $('#tel').val(),
		hobby : _hobby,
		job : $('#job').val(),
		age : $('#age').val(),
		info : $('#info').val()
	}
	$.ajax({
		type : "POST",
		url : "MemberInsert.do",
		data : _data,
		success : function(data){
			if(data != '' && data == 1){
				alert(_data.id+"님 회원가입 완료 되었습니다.\n환영합니다");
				location.href="Main.do";
				return;
			}
			alert("회원가입 실패");
		}
	});
});
function check(){
	let emailref = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	let telreg =  /^\d{3}-\d{3,4}-\d{4}$/;
	let agereg = /^[a-zA-Z0-9]+$/;
	if($('#pw').val() == null || $('#pw').val()==''){
		alert('비밀번호를 입력해주세요');
		$('#pw').focus();
		return true;
	}else if($('#email').val() == null || $('#email').val() == '' ){
		alert('이메일을 입력해주세요');
		$('#email').focus()
		return true;
	}else if(emailref.test($('#email').val()) == false){
		alert('이메일을 형식에 맞취 입력해주세요');
		$('#email').val('');
		$('#email').focus()
		return true;
	}else if($('#tel').val() == null || $('#tel').val() == '' ){
		alert('전화번호를 입력해주세요');
		$('#tel').focus();
		return true;
	}else if(telreg.test($('#tel').val())==false){
		alert('전화번호를 형식에 맞취 입력해주세요');
		$('#tel').val('');
		$('#tel').focus()
		return true;
	}else if($('#job').val() == null || $('#job').val() == ''){
		alert('직업을 입력해주세요');
		$('#job').focus()
		return true;
	}else if($('#age').val() == null || $('#age').val() == ''){
		alert('나이를 입력해주세요');
		$('#age').focus()
		return true;
	}else if(agereg.test($('#age').val())==false){
		alert('나이에 숫자만 입력해주세요');
		$('#age').val('');
		$('#age').focus();
		return true;
	}
	return false;
}