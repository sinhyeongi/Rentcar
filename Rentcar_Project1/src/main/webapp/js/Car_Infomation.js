/**
 * 
 */
 const user = $('#log').val();
 $('.info_reserve').click(function(){
 	if(user == null || user == ''){
 		alert('로그인 후 예약이 가능합니다.');
 		return;
 	}
 	
 	let t = $('tr:eq(6)').find('td:eq(1)').text();
 	if(t.indexOf('매진') != -1){
 		alert('차량이 모두 예약 되어 예약이 불가능 합니다');
 		return;
 	}
 	alert('예약 페이지로 이동 합니다.');
 	location.href="Carreserve.do?target="+$('#target').val();
 });