function submitChk() {
	if(frm.id.value.length == 0) {
		alert('아이디를 입력해 주세요.');
		return false;
	}
	if(frm.nm.value.length == 0) {
		alert('이름을 입력해 주세요.');
		return false;
	}
	
	if(frm.pw.value.length == 0) {
		alert('비밀번호를 입력해 주세요.');
		return false;
	}
	
	if(frm.pw.value !== frm.repw.value) {
		alert('비밀번호를 확인해 주세요.');
		return false;
	}
	
	return true;
}