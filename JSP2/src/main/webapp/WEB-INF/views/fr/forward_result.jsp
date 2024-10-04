<%-- c : 자주 사용하는 Java 코드들이 모여있음 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- fn : 컬렉션/문자열 관련 기능들이 모여있음 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>request scope 객체를 이용해서 전달 받은 값</h3>
	
	<ul>
		<li>forward 입력 1 : ${param.forwardInput1}</li>
		<li>forward 입력 2 : ${param.forwardInput2}</li>
		<li>str : ${str}</li>
	</ul>
</body>
</html>