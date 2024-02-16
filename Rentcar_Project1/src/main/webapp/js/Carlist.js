
 $('.img_session').click(function(data){
 	const car_target = ($(this).parent().find('td').eq(0).html())
 	
 	location.href="CarInfomation.do?target="+car_target;
 });