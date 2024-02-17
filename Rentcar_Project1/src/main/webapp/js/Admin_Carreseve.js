$('#Admin_Carreseve_cancle').click(function(){
	const target = $(this).closest('tr').prevAll().length;
	const _no = $('tr:eq('+target+')').find('td:eq(0)').text();
	const _qty = $('tr:eq('+target+')').find('td:eq(4)').text().replace(' 대','');
	const car_target = $('tr:eq('+target+')').find('td:eq(1)').text();
	let _data = {
	 	reserve_seq : _no,
	 	qty : _qty,
	 	no : car_target
	 }
	 if(confirm(_no+'번째 예약을 취소 하시겠습니까?')){
	 	$.ajax({
	 	tpye:"POST",
	 	url:"Admin_Carreseve.do",
	 	data : _data,
	 	success : function(data){
	 		if(data == 1){
	 			alert(_no+'번의 예약을 취소하였습니다.');
	 			location.href= location.href;
	 		}
	 	},
	 	error: function(){
	 		alert('error');
	 	}
	 	});
	 }
});