$('#addCar_submit').click(function(){
	if(check()){
		return;
	}
	let _data = {
		name : $('#name').val()
	};
	$.ajax({
		type:"POST",
		url : "UploadImgcheck.do",
		data : _data,
		success : function(data){
			if(data == 1){
				alert('중북된 차 이름이 있습니다.');
				$('#name').val('');
				return;
			}
			let target =$('#addCar_form')[0];
			let formData = new FormData(target);
			$.ajax({
				type:"POST",
				url : "UploadImg.do",
				data : formData,
				processData : false,
				contentType: false,
				success: function(data){
					if(data == 1){
						alert('데이터 추가 완료');
						location.href='Main.do';
						return;
					}
					location.href = location.href;
				},
				error : function(data){
					alert('Fail');
				}
			});
		}
	});
	
	
	
	
});
$('#img').change(function(){
	let t = $(this)[0].files[0].name;
	t = t.substring(0,t.indexOf('.'));
	const reg = /^[a-zA-Z0-9\_]+$/;
	if(reg.test(t) == false){
		alert('파일 명 한글은 불가능 합니다');
		$(this).val('');
		return;
	}
});
function check(){
	let numreg = /^[0-9]+$/;
	if(!$('#name').val()){
		alert('차량 이름을 입력해주세요');
		$('#name').focus();
		return true;
	}else if(!$('input[name=category]:checked').val()){
		alert('카테고리를 선택해주세요');
		return true;
	}else if(!$('#price').val()){
		alert('가격을 입력해주세요');
		$('#price').focus();
		return true;
	}else if(numreg.test($('#price').val()) == false){
		alert('가격을 숫자만 입력해주세요');
		$('#price').val('');
		$('#price').focus();
		return true;
	}else if($('#price').val() <= 1000){
		alert('가격을 1000원 이상 입력해주세요');
		$('#price').focus();
		return true;
	}else if(!$('#usepeople').val()){
		alert('승차 인원을 입력해주세요');
		$('#usepeople').focus();
		return true;
	}else if(numreg.test($('#usepeople').val()) == false){
		alert('승차 인원에 숫자만 입력해주세요');
		$('#usepeople').val('');
		$('#usepeople').focus();
		return true;
	}else if($('#usepeople').val() <= 1){
		alert('승차 인원을 2명 이상 입력해주세요');
		return true;
	}else if($('#usepeople').val() > 12){
		alert('최대 12명 까지만 가능합니다.');
		$('#usepeople').val('');
		return true;
	}else if(!$('#total_qty').val()){
		alert('렌트 카 수량을 입력해주세요');
		$('#total_qty').focus();
		return true;
	}else if(numreg.test($('#total_qty').val())==false){
		alert('렌트 카 수량에 숫자만 입력해주세요');
		$('#total_qty').val('');
		$('#total_qty').focus();
		return true;
	}else if($('#total_qty').val() < 1){
		alert('렌트 카 수량을 1이상 입력해주세요');
		return true;
	}else if(!$('#company').val()){
		alert('차량 회상 정보를 입력해주세요');
		$('#company').focus();
		return true;
	}else if(!$('#info').val()){
		alert('차량 정보를 입력해주세요');
		$('#info').focus();
		return true;
	}
	const _img = $('#img')[0];
	if(_img.files.length == 0){
		alert('파일을 업로드 해주세요');
		return true;
	}
	return false;
}
