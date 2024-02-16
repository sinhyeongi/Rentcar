$('input[type=button]').click(function(){
	let t = $(this).closest('tr').prevAll().length;
	let _target = $('tr:eq('+t+')').find('td:eq(0)').text();
	let name = $('tr:eq('+t+')').find('td:eq(1)').text();
 	let ch = confirm(name+' 차량을 정말 삭제하시겠습니까?\n삭제 시 모든 예약이 취소 됩니다.');
 	
	if(ch == false){
		return;
	}
	let _data ={
		target : _target
	}
	$.ajax({
		type : "POST",
		url : "DeleteCar.do",
		data : _data,
		success: function(data){
			if(data != 'err'){
				alert(name+'차량을 삭제 하였습니다.\n'+data+'개의 예약을 취소 하였습니다');
				location.href = location.href;
				return;
			}
		},
		error:function(){
			alert('ERROR');
		}
	});
});

$('input[name=price]').click(function(e){
	if(confirm('가격을 수정하시겠습니까?')){
		$(this).removeAttr('readonly');
		return;
	}
	
});

$('input[name=price]').keydown(function(e){
	if(e.keyCode == 13&&confirm('수정을 완료하시겠습니까?')){
		//$(this).attr('readonly','readonly');
		let t = $(this).closest('tr').prevAll().length;
		let _target = $('tr:eq('+t+')').find('td:eq(0)').text();
		let _price = $(this).val();
		let name = $('tr:eq('+t+')').find('td:eq(1)').text();
		let _data = {
			no : _target,
			price : _price
		}
		$.ajax({
			type : "POST",
			url : "UpdateP_admin.do",
			data : _data,
			success : function(data){
				if(data == 1){
					alert(name+' 차량의 가격 수정이 완료되었습니다.');
					location.href = location.href;
					return;
				}
			}
		});
		return;
	}
});
$('input[name=total_qty]').click(function(){
	if(confirm('수량을 수정하시겠습니까?')){
		$(this).removeAttr('readonly');
		return;
	}
})
$('input[name=total_qty]').keydown(function(e){
	if(e.keyCode == 13&&confirm('수정을 완료하시겠습니까?')){
		//$(this).attr('readonly','readonly');
		let t = $(this).closest('tr').prevAll().length;
		let _target = $('tr:eq('+t+')').find('td:eq(0)').text();
		let _qty = $(this).val();
		let name = $('tr:eq('+t+')').find('td:eq(1)').text();
		let _data = {
			no : _target,
			total_qty : _qty
		}
		$.ajax({
			type : "POST",
			url : "UpdateQTY_admin.do",
			data : _data,
			success : function(data){
				if(data == 1){
					alert(name+' 차량의 수량 수정이 완료되었습니다.');
					location.href = location.href;
					return;
				}
			}
		});
		return;
	}
});
