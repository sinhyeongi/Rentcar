$('.deleteuser_ad_btn').click(function(){
	let t_c = $(this).closest('tr').prevAll().length;
	let _id = $('tr:eq('+t_c+')').find('td:eq(0)').text();
	let _data = {
		id : _id
	}
	if(confirm(_id+'회원 정보를 모두 삭제하시겠습니까?')){
		$.ajax({
			type:"POST",
			url : "Admin_Member.do",
			data : _data,
			success : function(data){
				if(data != 0){
					alert(_id+' 회원('+data+'개의 예약) 삭제 완료 되었습니다.');
					location.href = location.href;
					return;
				}
			}
		});
	}
});