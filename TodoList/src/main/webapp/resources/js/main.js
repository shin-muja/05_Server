/* 제목이 작성되징 않은 경우 form 태그 제출 막기 */
const addForm = document.querySelector("#addForm"); // form
const title = document.querySelector("[name=title]"); // input

// addForm이 제출 될 때

addForm.addEventListener("submit", e => {
	// e : 이벤트 객체
	
	// 제목 입력 값 가져와서 양쪽 공백 제거
	const input = title.value.trim();
	
	// 제목이 입력되지 않았을때
	if(input.length == 0) {
		// form 제출 이벤트 막기
		e.preventDefault();
		
		// 알림창 띄우기
		alert("제목을 입력 해 주세요");
		
		// 제목 input 창에 포커싱 하기
		title.focus();
		title.value = "";
	}
	
});