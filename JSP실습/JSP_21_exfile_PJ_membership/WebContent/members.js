/**
 * 
 */
function infoConfirm(){	//reg_frm은 form태그이름 / document는 폼에서 사용하고 있는 내용을 객체화 해서 한데 묶은 것
	if (document.reg_frm.id.value.length == 0){
		alert("아이디를 입력하세요");//
		reg_frm.id.focus();//reg_frm의 id 변수 읽는 위치로 이동시키는 함수
		return;
	}
	
	if(document.reg_frm.id.value.length < 4){
		alert("아이디를 4글자이상 입력하세요");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.pw.value.length == 0){
		alert("비밀번호를 입력하세요");
		reg_frm.pw.focus();
		return;
	}
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.name.value.length ==0){
		alert("이름을 입력하세요");
		reg_frm.name.focus();
		return;
	}
	if(document.reg_frm.eMail.value.length ==0){
		alert("이메일을 입력하세요");
		reg_frm.eMail.focus();
		return;
	}
	if(document.reg_frm.address.value.length ==0){
		alert("주소를 입력하세요");
		reg_frm.address.focus();
		return;
	}
	document.reg_frm.submit();
}

function updateInfoConfirm(){
	if(document.reg_frm.pw.value.length == ""){
		alert("비밀번호를 입력하세요");
		document.reg_frm.pw.focus();
		return;
	}
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다");
		reg_frm.pw.focus();
		return;
	}
	if(document.reg_frm.eMail.value.length ==0){
		alert("이메일을 입력하세요");
		reg_frm.eMail.focus();
		return;
	}
	document.reg_frm.submit();
}