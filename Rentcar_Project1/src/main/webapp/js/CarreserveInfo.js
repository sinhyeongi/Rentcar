/**
 * 
 */
 
 $('.Carreserve_cancel').click(function(data){
 	const t = $(this).closest('tr');
 	const _id = $('#log').val();
 	const name = t.find('td:eq(0)').text();
 	const _no = t.find('td:eq(0)').find('input[name=no]').val();
 	const _seq = t.find('td:eq(0)').find('input[name=seq]').val();
 	const time = t.find('td:eq(1)').text();
 	let _count = t.find('td:eq(3)').text().replace("대","");
 	const price = t.find('td:eq(5)').text();
 	let _data = {
 		id : _id,
 		no : _no,
 		qty : _count,
 		seq : _seq
 	}
 	$.ajax({
 		type:"POST",
 		url : "CarreserveInfo.do",
 		data : _data,
 		success : function(data){
 			if(data > 0){
 				alert(_id+"님의 예약 차량 "+name+'\n총 결재 금액 : '+price+'\n('+time+")의 예약이 취소 되었습니다.");
 				t.remove();
 			}
 		}
 	});
 });
 