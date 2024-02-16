/**
 * 
 */
 let today = new Date();
 let todaystr = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0'+today.getDate()).slice(-2);
 let sd = '';
 const startDate = $("#startDate");
 const endDate = $("#endDate");
 const start_H = $("#startH");
 const end_H = $("#endH");
 flatpickr(startDate,{
 	dateFormat : 'Y-m-d',
 	minDate : 'today',
 	defaultDate : 'today',
 	locale : 'ko',
 	onChange : function(selectedDates,datestr,instance){
 	$(".startH_td").css('visibility','visible');
 	start_H.css('visibility','visible');
 	flatpickr(start_H,{
 		dateFormat : 'H:00',
 		time_24hr : true,
 		enableTime : true,
 		noCalendar:true,
 		defaultDate : (datestr == todaystr?new Date().setHours(new Date().getHours()+1):''),
 		minTime : (datestr == todaystr?new Date().setHours(new Date().getHours()+1):''),
 		locale:'ko',
 		
 	});
 	let t_data = new Date();
 	//(!endDate.val().toString() ||new Date(endDate.val().toString()) < new Date(startDate.val().toString())?datestr:endDate.val().toString())
 	t_data.setHours(t_data.getHours()+2);
 	flatpickr(endDate,{
 		dateFormat : 'Y-m-d',
 		minDate : datestr < t_data ? datestr : t_data,
 		defaultDate : t_data,
 		locale:'ko',
 		onChange : function(selectedDates,datestr,instance){
 			$(".endH_td").css('visibility','visible');
 			end_H.css('visibility','visible');
 			flatpickr(end_H,{
 				dateFormat : 'H:00',
 				time_24hr : true,
 				enableTime:true,
 				noCalendar:true,
 				defaultDate : (datestr == startDate.val().toString()?(parseInt(start_H.val().split(':')[0]) + 1)+'' : ''),
 				minTime : (datestr == startDate.val().toString()?(parseInt(start_H.val().split(':')[0]) + 1)+'' : ''),
 				locale : 'ko'
 			});
 		}
	 });
 	}
 })
 
$(".price_btn").click(function(){
	if(startDate.val() == null || startDate.val() == ''){
		alert('시작일을 정해 주세요!');
		return;
	}else if(endDate.val()== null || endDate.val() == ''){
		alert('종료일을 정해 주세요!');
			return;
	}else if(start_H.val() == null || start_H.val() == ''){
		alert('시작 시간 정해 주세요!');
		return;
	}else if(end_H.val() == null || end_H.val() == ''){
		alert('종료 시간을 정해 주세요!');
		return;
	}else if($('input[name=car]:checked').val() == null){
	alert('렌트 하실 자동차를 선택해주세요');
	return;
	}
	let start = new Date(startDate.val()+' '+start_H.val());
	let ned = new Date(endDate.val()+' '+end_H.val());
	if((ned - start) <= 0 ){
		alert('시간을 확인해 주세요');
		return;
	}
	let time = (ned - start) / (1000 * 60 * 60);
	$(".total_price").last().text((time * $('input[name=car]:checked').val().split("/")[1]) * $('#car_count').val() +"원");
	$(".total_price").css("height","100%");
	$(".total_price").css("flex","1");
	$(".car_submit").css("height","100%");
	$(".car_submit").css("flex","1");
	$("#car_rent_time").val(time+'');
	let text = $(".total_price").last().text().replace("원","");
	$('.input_price').val(text);
	$('.car_submit').attr('type','submit');
});

$('input[name=car]').change(function(){
	if(!startDate.val() || !endDate.val() ||  !start_H.val() || !end_H.val()){
		$('.price_btn').css('flex','1');
 		$('.price_btn').css('height','100%');
 		$('.car_view_header').css('height','auto');
 		$('.car_view_header').css('display','table-cell');
 		$('.car_submit').attr('type','button');
		return;
	}
	let tartget= $(this).closest('tr').prevAll().length;
 	$('.price_btn').css('flex','1');
 	$('.price_btn').css('height','100%');
 	$('.car_view_header').css('height','auto');
 	$('.car_view_header').css('display','table-cell');
 	$('#car_count').val('1');
 	$('#car_count').prop('max',$('.car_max'+tartget).val());
 	$('.car_submit').attr('type','button');
});
$('#car_count').change(function(){
	let start = new Date(startDate.val()+' '+start_H.val());
	let ned = new Date(endDate.val()+' '+end_H.val());
	let time = (ned - start) / (1000 * 60 * 60);
	$(".total_price").last().text((time * $('input[name=car]:checked').val().split("/")[1]) * $('#car_count').val() +"원");
	let text = $(".total_price").last().text().replace("원","");
	$('.input_price').val(text);
	$('.car_submit').attr('type','button');
});
 