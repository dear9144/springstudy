<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	

	$(function(){
		fnList();
		
	})
	
	$(document).on('ready', function(){
	
	})
	
	function fnList() {
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType:'json',
			success: function(resData){
				$('#staffList').empty();
				$.each(resData, function(i, staff){
					let str = '<tr>';
					str += '<td>' + staff.sno;
					str += '<td>' + staff.name;
					str += '<td>' + staff.dept;
					str += '<td>' + staff.salary;
					$('#staffList').append(str);
				})
			}
			
		})
	} //사원의 목록을 가지고 오는 function 
	
	
	

	
	
	function fnAdd(){
		var regSno = /^[0-9]{5}$/;
		$.ajax({
			type: 'post',
			url: '${contextPath}/add.do',
			data: $('#frm_add').serialize(),
			
			//응답
			dataType: 'text',
			success: function(resData){ //resData는 성공했을수도 있고 실패했을 수도 있음, 사원등록이 성공했습니다
				
				alert(resData);	
				fnList();//사원 목록을 갱신하라 function list를 호출하라 
				$('#sno').val('') //사원 목록을 리셋해라 
				$('#name').val('') //사원명을 리셋해라 
				$('#dept').val('') //부서명을 리셋해라 
			},
			error: function(jqXHR){ //jqXHR.responseText : 사원 등록이 실패했습니다 
			
				alert(jqXHR.responseText);
			}
		})
	}
	
	
	
</script>
</head>
<body>

	<div>
	<h3>사원등록</h3>
	<form id="frm_add">
		<input type="text" name="sno" id="sno" placeholder="사원번호">
		<input type="text" name="name" id="name" placeholder="사원명">
		<input type="text" name="dept" id="dept" placeholder="부서명">
		<input type="button" value="등록" onclick="fnAdd()">
	</form>
	</div>
	
	<hr>
	
	<div>
		<h3>사원조회</h3>
		<table id="frm_search">
			<input type="text" name="query" id="query" placeholder="사원번호입력">
			<input type="button" value="조회" onclick="fnSerch()">
			<input type="button" value="전체" onclick="fnList()">
		</table>
	</div>
	
	<hr>
	
	<div>
		<h3>사원목록</h3>
		<table border="1">
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>부서명</td>
					<td>연봉</td>
				</tr>
			</thead>	
			<tbody id="staffList"></tbody>
		</table>
	</div>
	
</body>
</html>