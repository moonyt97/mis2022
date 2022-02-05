function loginCheck() {
	if (document.frm.memberid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.memberid.focus();
		return false;
	}
	if (document.frm.pw.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pw.focus();
		return false;
	}
	return true;
}

function idCheck() {
	if (document.frm.memberId.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.frm.memberId.focus();
		return;
	}
	var url = "Idcheck.do?memberId=" + document.frm.memberId.value;
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(memberId) {
	opener.frm.memberId.value = document.frm.memberId.value;
	opener.frm.reid.value = document.frm.memberId.value;
	self.close();
}

function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.memberid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.memberid.focus();
		return false;
	}
	if (document.frm.memberid.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.memberid.focus();
		return false;
	}
	if (document.frm.pw.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pw.focus();
		return false;
	}
	if (document.frm.pw.value != document.frm.pw_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pw.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.memberid.focus();
		return false;
	}
	return true;
}
function handleOnInput(e) {
	e.value = e.value.replace(/[^a-zA-Z0-9]*$/ig, '')
}