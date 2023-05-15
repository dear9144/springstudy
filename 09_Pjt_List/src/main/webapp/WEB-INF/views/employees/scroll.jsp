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
	//전역변수
	var page = 1;
	var totlaPage = 0;
	

	//db 에서 목록 가져온느 함수
	function fnGetEmployees() {
		// 목록 숨기기 
		$('.employees').hide();
		//로딩보여주기
		$('.loading_wrap').show();
		//목록 가져오는 ajax 처리 
		$.ajax({
			//요청
			type: 'get',
			url: '${contextPath}/employees/scroll.do',
			data: 'page=' +page,
			
			//응답
			dataType: 'json',
			success: function(resData) {
				totalPage = resData.totalPage;
				
				page++;
				//화면 뿌리기
				$.each(resData.employees, function(i, employee) {
					let str = '<div class="employee">';
					str += '<div>사원번호: ' + employee.employeeId + '</div>';
					str += '<div>사원이름: ' + employee.fistName + ' ' + employee.lastName + '</div>';
					str += '<div>부서명:' + employee.deptDTO.departmentName + '</div>';
					str += '</div>';
					$('.employees').append(str);
				})
				//목록 보여주기
				$('.employees').show();
				//로딩 숨기기
				$('.loading_wrap').hide();
			}
		})
	}	
	
	//호출
	fnGetEmployees();

	//스크롤 이벤트 
	$(window).on('scroll', function(){
		timerId = setTimeout(function(){
			let scrollTop = $(this).scrollTop();
			let windowHeight = $(this).height();
			let documentHeight = $(document).height();
			if((scrollTop + windowHeight + 50) >= documentHeight) {
				if(page > totalPage) {
					$('.loading_wrap').addClass()	
				}
			}
		}, 200);
		
	})
</script>
<style>
	.employees {
		width: 1000px;
		margin: 0 auto;
		display: flex;
		flex-wrap: wrap;
	}
	.employee {
		width: 300px;
		height: 300px;
		border: 1px solid gray;
		margin: 10px;
		text-align: center;
		padding-top: 120px; 
	}
	.loading_wrap {
		display: flex;            /* justify-content, align-items 속성 사용을 위해 설정 */
		justify-content: center;  /* class="loading"의 가로 가운데 정렬 */
		align-items: center;      /* class="loading"의 세로 가운데 정렬 */
		min-height: 80vh;         /* 최소 높이를 화면 높이의 80%로 설정 */
	}
	.loading {
		width: 300px;
		height: 300px;
		background-image: url('../resources/images/loading.gif');
		background-size: 300px 300px;
		background-repeat: no-repeat;
	}
</style>
</head>
<body>

	<div>
		<a href="${contextPath}/employees/search.do">사원 조회 화면으로 이동</a>
	</div>
	
	<h1>사원 목록</h1>
	
	<!-- 사원 목록 보여주는 곳 -->
	<div class="employees">
	
	</div>
	
	<!-- loading.gif 보여주는 곳 -->
	<div class="loading_wrap">
		<div class="loading"></div>
	</div>
	
</body>
</html>