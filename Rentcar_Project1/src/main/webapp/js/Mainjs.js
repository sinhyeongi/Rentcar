$(".category_select").change(function(data){
 	const target = $(".category_select option:selected").val();
 	let cdata = {
 		category : target  
 	};
 $.ajax({
 	type : "POST",
 	url : "Select_car.do",
 	data : cdata,
 	success : function(data){
 	$('.car_table').html(data);
 	} 
 	});
 });
 
$(".car_btn").click(function(){
	$('.category_select').css('visibility','visible');
	$('.car_table').css('display','block');
	$(".car_btn").css('display','none');
	$('#Main_log').css('height','0px');
	$('#Main_img_span').css('flex','1');
	$('#Main_img_span').css('width','100%');
});

 $('.img_session').click(function(data){
 	const car_target = ($(this).parent().find('td').eq(0).html())
 	
 	location.href="CarInfomation.do?target="+car_target;
 });
 
 