const price_view = $('.carreserve_option_price_td');
const renttime = $('input[name=rday]').val();
const rentcount = $('input[name=qty]').val();
const rentDate = $('input[name=dday]').val();
const usein = $('input[name=usein]');
const usewifi = $('input[name=usewifi]');
const usenavi = $('input[name=usenavi]');
const useseat = $('input[name=useseat]');
let date = new Date((rentDate.replace("/"," ")));
let rtdate = new Date((rentDate.replace("/"," ")));;
rtdate.setHours(rtdate.getHours() + 1);
date = date.getFullYear()+"년 "+('0' + (date.getMonth()+1)).slice(-2) + '월 '+ date.getDate() + "일 " + ('0' + date.getHours()).slice(-2) + ":" + ('0' + date.getMinutes()).slice(-2) + "시 부터";
rtdate = rtdate.getFullYear()+"년 "+('0'+(rtdate.getMonth()+1)).slice(-2) +"월 "+rtdate.getDate()+"일 "+rtdate.getHours()+":"+('0'+rtdate.getMinutes()).slice(-2) +"시 까지 입니다";


function ChangeSpan(data,price,time){
const span =$('.carreserve_option_price_span');
	if(data == 1){
	let spandata = (parseInt(span.text()) + ((price * (parseInt(renttime / time) +(time != 1 && renttime % time != 0 ? 1 : 0 )))) * rentcount);
		span.text(spandata);
		$('#hidden_price').val(spandata);
		return;
	}
	let spandata = (parseInt(span.text()) - (price * ((parseInt(renttime / time) +(time != 1 && renttime % time != 0  ? 1 : 0 )))) * rentcount);
	span.text(spandata);
	$('#hidden_price').val(spandata);
}
// 운전자 보험 가입 라디오 버튼 변경 이벤트
usein.change(function(){
	ChangeSpan($('input[name=usein]:checked').val(),5000,24);
});

// 인터넷 대여 라디오 버튼 변경 이벤트
usewifi.change(function(){
	ChangeSpan($('input[name=usewifi]:checked').val(),5000,1);
});
// 내비게이션 대여 라디오 버튼 변경 이벤트
usenavi.change(function(){
ChangeSpan($('input[name=usenavi]:checked').val(),5000,1);
});
//베이비 시트 적용 여부
useseat.change(function(){
	ChangeSpan($('input[name=useseat]:checked').val(),10000,24);
});
$('#carreserve_option_submit').click(function(){
	let cdata = {
		no : $('input[name=no]').val(),
		id : $('input[name=id]').val(),
		qty : $('input[name=qty]').val(),
		dday : $('input[name=dday]').val(),
		rday : $('input[name=rday]').val(),
		usein : $('input[name=usein]:checked').val(),
		usewifi : $('input[name=usewifi]:checked').val(),
		usenavi : $('input[name=usenavi]:checked').val(),
		useseat : $('input[name=useseat]:checked').val(),
		price : $('#hidden_price').val()
	};
	$.ajax({
		type:"POST",
		url : "CarReseveOption.do",
		data : cdata,
		success : function(data){
			if(data == 1){
				alert($('input[name=id]').val()+'님 예약을 완료 했습니다.\n총 금액 : '+$(".carreserve_option_price_span").text()+'원 입니다\n렌트 기간은 : '+date+" ~ "+rtdate);
				location.href="Main.do";
				return;
			}
			alert('오류 발생');
		}
	});
});