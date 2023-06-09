<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Suraj">
<!--meta name="_csrf" th:content="${_csrf.token}"/>
    <meta name="_csrf_header" th:content="${_csrf.headerName}"/-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/css/jquery-ui.css"
	type="text/css" />
<link rel="stylesheet" href="/resources/css/core/bootstrap-5.min.css"
	type="text/css" />
<link rel="stylesheet" href="/resources/css/custom.css" type="text/css" />
<link rel="stylesheet" href="/resources/css/core/flag-icon.min.css"
	type="text/css" />
<title>협력 업체 등록</title>
<script type="text/javascript" src="/resources/js/txn-add-scripts.js"></script>
<script type="text/javascript" src="/resources/js/common-scripts.js"></script>
<script type="text/javascript" src="/resources/js/navbar-scripts.js"></script>
</head>
<body>
	<div>
		<div>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
				style="position: relative;">
				<div class="container-fluid">
					<a class="navbar-brand" href="/">
						<h2>
							<b>조달구매시스템</b>
						</h2>
					</a>
				</div>
				<div class="collapse navbar-collapse" id="navbarSupportedContent"
					style="position: absolute; left: 250px; top: 40px;">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="/registerinfo/subcontractor" id="subcontractor">협력 업체 등록</a></li>
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="/registerinfo/productionplan" id="productionplan">제품 생산 계획 등록</a></li>
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="/registerinfo/itemuseplan" id="itemuseplan">품목 사용 계획 등록</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</nav>
			<div class="area"></div>
			<nav class="main-menu">
				<ul>
					<li class="has-subnav" style="font-size: 10px;"><a
						href="/orderplanning/iteminfo" style="height: 50px;"
						id="procurement">
							<div class="nav-text" style="position: relative; left: 10px;">
								조달 관리</div>
					</a></li>
					<li class="has-subnav" style="font-size: 10px;"><a
						href="/purchaseorder/issue" style="height: 50px;" id="order">
							<div class="nav-text" style="position: relative; left: 10px;">
								발주 관리</div>
					</a></li>
					<li class="has-subnav" style="font-size: 10px;"><a
						href="/stockmanagement/inbound" style="height: 50px;" id="stock">
							<div class="nav-text" style="position: relative; left: 10px;">
								자재 관리</div>
					</a></li>
					<li class="has-subnav" style="font-size: 10px;"><a
						href="/registerinfo/subcontractor" style="height: 50px;"
						id="register">
							<div class="nav-text" style="position: relative; left: 10px;">
								정보 등록</div>
					</a></li>
				</ul>
			</nav>
			<br />
		</div>
	</div>
	<div class="container"
		style="position: absolute; left: 250px; width: 3000px;">
		<div class="wrap">
			<form action="registerSubcontractor" method="post">
				<div class="card">
					<div class="card-header">
						<b>협력 업체 등록</b>
					</div>
					<div class="card-body">
						<div class="row g-3">
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="subcontractorName" class="input-group-text">협력 업체명</label>
									<input type="text" class="form-control" id="subcontractor_name" name="subcontractor_name" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="subcontractorPerson" class="input-group-text">담당자 성함</label>
									<input type="text" class="form-control" id="subcontractor_person" name="subcontractor_person" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="subcontractorTel" class="input-group-text">전화번호</label>
									<input type="text" class="form-control" id="subcontractor_tel" name="subcontractor_tel" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="subcontractorEmail" class="input-group-text">이메일</label>
									<input type="text" class="form-control" id="subcontractor_email" name="subcontractor_email" />
								</div>
							</div>
							<div class="input-group mb-3">
								<label for="subcontractorEmail" class="input-group-text">주소</label>
								<input type="text" class="form-control" id="subcontractor_address" name="subcontractor_address" />
								<button type="button" id="address" class="btn btn-primary btn-primary" onclick="execPostCode(); return false;">우편번호 찾기</button>
							</div>
						</div>
						<div class="row g-3">
							<div class="col-md-3">
								<button type="submit" id="registerSubcontractor" class="btn btn-primary btn-primary" style="background-color:#42d676; border-color:#42d676;">협력 업체 등록</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<br /> <br />
			<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
		                <symbol id="check-circle-fill" fill="currentColor"
					viewBox="0 0 16 16">
		                    <path
					d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
		                </symbol>
		                <symbol id="info-fill" fill="currentColor"
					viewBox="0 0 16 16">
		                    <path
					d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
		                </symbol>
		                <symbol id="exclamation-triangle-fill"
					fill="currentColor" viewBox="0 0 16 16">
		                    <path
					d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
		                </symbol>
		            </svg>
			<table id='myTable'
				class="table table-bordered table-striped table-hover caption-top">
				<caption style="color: black;">
					<b>협력 업체 목록</b>
				</caption>
				<thead class="table-dark">
					<tr>
						<th scope="col" style="text-align: center;">순번</th>
						<th scope="col" style="text-align: center;">협력 업체명</th>
						<th scope="col" style="text-align: center;">담당자 성함</th>
						<th scope="col" style="text-align: center;">전화번호</th>
						<th scope="col" style="text-align: center;">이메일</th>
						<th scope="col" style="text-align: center;">주소</th>
						<th scope="col" style="text-align: center;">등록 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="no" value="0" />
					<c:forEach items="${ subcontractor }" var="subcontractor">
						<tr>
							<td style="text-align: center;">${ no = no + 1 }</td>
							<td style="text-align: center;"><span>${ subcontractor.subcontractor_name }</span></td>
							<td style="text-align: center;"><span>${ subcontractor.subcontractor_person }</span></td>
							<td style="text-align: center;"><span>${ subcontractor.subcontractor_tel }</span></td>
							<td style="text-align: center;"><span>${ subcontractor.subcontractor_email }</span></td>
							<td style="text-align: center;"><span>${ subcontractor.subcontractor_address }</span></td>
							<td style="text-align: center;">
								<span>
									<fmt:parseDate value="${ subcontractor.subcontractor_date }" var="subcontractor_date" pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${ subcontractor_date }" pattern="yyyy-MM-dd"/>
								</span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<input type="hidden" value="2" id="flag">
	<script src="/resources/js/core/jquery-3.2.1.min.js"
		type="text/javascript"></script>
	<script src="/resources/js/core/popper.min.js" type="text/javascript"></script>
	<script src="/resources/js/core/bootstrap-5.min.js"
		type="text/javascript"></script>
	<script src="/resources/js/core/jquery-ui.min.js"
		type="text/javascript"></script>
	<script>
		if (document.getElementById("flag").value == 2) {
			document.getElementById("subcontractor").style.backgroundColor = "#fff";
			document.getElementById("subcontractor").style.color = "#000000";
			document.getElementById("subcontractor").style.fontWeight = "bold";
			document.getElementById("register").style.backgroundColor = "#fff";
			document.getElementById("register").style.color = "#000000";
			document.getElementById("register").style.fontWeight = "bold";
		}
	</script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function execPostCode() {
			 new daum.Postcode({
				 oncomplete: function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					 
					// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
					var extraRoadAddr = ''; // 도로명 조합형 주소 변수
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
	                    extraRoadAddr += data.bname;
	                }
	             	// 건물명이 있고, 공동주택일 경우 추가한다.
	                if (data.buildingName !== '' && data.apartment === 'Y') {
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if (extraRoadAddr !== '') {
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	                if (fullRoadAddr !== '') {
	                    fullRoadAddr += extraRoadAddr;
	                }
	                
					// 주소 정보를 해당 필드에 넣는다.
					console.log(fullRoadAddr);
					
					$("[name=subcontractor_address]").val(fullRoadAddr);
				 }
			 }).open();
		}
	</script>
</body>
</html>