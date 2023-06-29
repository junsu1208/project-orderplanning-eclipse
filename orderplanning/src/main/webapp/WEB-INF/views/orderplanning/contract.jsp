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
<title>계약 등록</title>
<script type="text/javascript" src="/resources/js/txn-add-scripts.js"></script>
<script type="text/javascript" src="/resources/js/common-scripts.js"></script>
<script type="text/javascript" src="/resources/js/navbar-scripts.js"></script>
<script src="/resources/js/core/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script src="/resources/js/core/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
</head>
<body>
	<div>
		<div>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
				style="position: relative;">
				<div class="container-fluid">
					<a class="navbar-brand" href="/" onclick="goToHome();">
						<h2>
							<b>조달구매시스템</b>
						</h2>
					</a>
				</div>
				<div class="collapse navbar-collapse" id="navbarSupportedContent"
					style="position: absolute; left: 250px; top: 40px;">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="/orderplanning/iteminfo" id="iteminfo">품목
								정보 등록</a></li>
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="/orderplanning/contract" id="contract">계약
								등록</a></li>
						<li class="nav-item" style="margin-left: 10px;"><a
							class="nav-link" href="/orderplanning/procurementplan"
							id="procurementplan">조달 계획 등록</a></li>
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
		<form action="registercontract" method="post"
			enctype="multipart/form-data" style="position: relative;"
			onsubmit="return contractConfirm();" id="registerForm">
			<div class="wrap">
				<div class="card">
					<div class="card-header">
						<b id="cardTitle">계약 등록</b>
					</div>
					<div class="card-body">
						<div class="row g-3">
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="contractName" class="input-group-text">계약명</label>
									<input type="text" class="form-control" id="contract_name"
										name="contract_name" required />
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group mb-3" id="item_code_tag">
									<label for="itemCode" class="input-group-text">품목 코드</label> <select
										id="item_code" class="form-select" tabindex="1"
										name="item_code" required>
										<option selected>(품목 코드 선택)</option>
										<c:forEach items="${ getItemCodeForContract }" var="item">
											<option><c:out value="${ item.item_code }"></c:out>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group mb-3">
									<label for="itemName" class="input-group-text">품목명</label> <input
										type="text" class="form-control" id="item_name"
										name="item_name" readonly />
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group mb-3">
									<label for="majorcategory" class="input-group-text">대분류</label>
									<input type="text" class="form-control" id="mc_name"
										name="major_category" readonly />
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group mb-3">
									<label for="subcategory" class="input-group-text">중분류</label> <input
										type="text" class="form-control" id="sc_name"
										name="sub_category" readonly />
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group mb-3">
									<label for="standard" class="input-group-text">규격</label> <input
										type="text" class="form-control" id="standard" name="standard"
										readonly />
								</div>
							</div>
							<div class="col-md-3">
								<div class="input-group mb-3">
									<label for="material" class="input-group-text">재질</label> <input
										type="text" class="form-control" id="material" name="material"
										readonly />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="specificationFile" class="input-group-text">제작
										사양</label> <input type="text" class="form-control"
										id="specification_file" name="specification_file" readonly />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="drawFile" class="input-group-text">도면 파일</label> <input
										type="text" class="form-control" id="draw_file"
										name="draw_file" readonly />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="subcontractorName" class="input-group-text">협력
										업체명</label> <select id="subcontractor_name" class="form-select"
										tabindex="1" name="subcontractor_name" required>
										<option selected>(협력 업체명 선택)</option>
										<c:forEach items="${ getSubcontractorName }"
											var="subcontractor">
											<option><c:out
													value="${ subcontractor.subcontractor_name }"></c:out></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="subcontractorTel" class="input-group-text">협력
										업체 전화번호</label> <input type="text" class="form-control"
										id="subcontractor_tel" name="subcontractor_tel" readonly />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="subcontractorEmail" class="input-group-text">협력
										업체 이메일</label> <input type="text" class="form-control"
										id="subcontractor_email" name="subcontractor_email" readonly />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="subcontractorPerson" class="input-group-text">협력
										업체 담당자</label> <input type="text" class="form-control"
										id="subcontractor_person" name="subcontractor_person" readonly />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="supplyPrice" class="input-group-text">공급 가격</label>
									<input type="number" class="form-control" id="supply_price"
										name="supply_price" required />
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="agreementDate" class="input-group-text">계약
										날짜</label> <input type="date" id="agreement_date"
										class="form-control datepicker" name="agreement_date"
										aria-label="agreementDate" required> <span
										class="input-group-text"> <img
										src="/resources/img/calendar3.svg" alt="" width="16"
										height="16" title="calendar" />
									</span>
								</div>
							</div>
							<div class="col-md-6">
								<div class="input-group mb-3">
									<label for="leadtime" class="input-group-text">L/T</label> <input
										type="number" class="form-control" id="leadtime"
										name="leadtime" required />
								</div>
							</div>
							<div class="col-md-6" id="contractfile_tag">
								<div class="input-group mb-3">
									<label for="contractFile" class="input-group-text">계약서
										첨부</label> <input type="file" class="form-control"
										id="contract_imagefile" name="contract_imagefile" required />
								</div>
							</div>
							<div id="contractfile_view"></div>
							<div>
								<label for="contractText" class="form-label">비고:</label>
								<textarea rows="3" class="form-control" id="contract_text"
									name="contract_text"></textarea>
							</div>
							<div class="col-md-1" id="inputbtn">
								<button type="submit" id="registerContract"
									class="btn btn-primary btn-primary"
									style="background-color: #42d676; border-color: #42d676;">계약
									등록</button>
							</div>
							<div class="col-md-1" id='backbtn'></div>
						</div>
					</div>
				</div>
			</div>
			<input type="hidden" name="contract_code" id="cCode">
		</form>
			<input type="hidden" name="contract_file" id="cFile">
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
		<form action="deletecontract" method="post">
			<table id='myTable'
				class="table table-bordered table-striped table-hover caption-top">
				<caption style="color: black;">
					<b>계약 품목 정보 목록</b>
				</caption>
				<button type="button" class="btn btn-primary"
					style="position: absolute; left: 1030px;"
					onclick="inquiryContractFunc()">계약 조회 및 수정</button>
				<button type="submit" class="btn btn-danger"
					style="position: absolute; left: 1190px; background-color: red; border-color: red;">계약
					삭제</button>	
				<thead class="table-dark">
					<tr>
						<th scope="col" style="text-align: center;">선택</th>
						<th scope="col" style="text-align: center;">순번</th>
						<th scope="col" style="text-align: center;">계약명</th>
						<th scope="col" style="text-align: center;">품목 코드</th>
						<th scope="col" style="text-align: center;">품목명</th>
						<th scope="col" style="text-align: center;">공급가격</th>
						<th scope="col" style="text-align: center;">L/T</th>
						<th scope="col" style="text-align: center;">협력 업체</th>
						<th scope="col" style="text-align: center;">계약 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="no" value="0" />
					<c:forEach items="${ contract }" var="contract">
						<tr>
							<th scope="row" style="text-align: center;"><input
								type="radio" name="contract_code"
								value="${ contract.contract_code }" /></th>
							<td style="text-align: center;">${ no = no + 1 }</td>
							<td style="text-align: center;"><span>${ contract.contract_name }</span></td>
							<td style="text-align: center;"><span>${ contract.item_code }</span></td>
							<td style="text-align: center;"><span>${ contract.item_name }</span></td>
							<td style="text-align: center;"><span><fmt:formatNumber
										value="${ contract.supply_price }" pattern="#,###" /></span></td> 
							<td style="text-align: center;"><span>${ contract.leadtime }일</span></td>
							<td style="text-align: center;"><span>${ contract.subcontractor_name }</span></td>
							<td style="text-align: center;"><span> <fmt:parseDate
										value="${ contract.agreement_date }" var="agreement_date"
										pattern="yyyy-MM-dd" /> <fmt:formatDate
										value="${ agreement_date }" pattern="yyyy-MM-dd" />
							</span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</form>
	</div>
	<input type="hidden" value="2" id="flag">
	<script src="/resources/js/core/popper.min.js" type="text/javascript"></script>
	<script src="/resources/js/core/bootstrap-5.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(function() {
				$("#agreementDate").datepicker();
			});
			$('#subcontractorName').change(function() {
				$("#subcontractorName").prop("disabled", false);
			});
		});
	</script>
	<script>
		if (document.getElementById("flag").value == 2) {
			document.getElementById("contract").style.backgroundColor = "#fff";
			document.getElementById("contract").style.color = "#000000";
			document.getElementById("contract").style.fontWeight = "bold";
			document.getElementById("procurement").style.backgroundColor = "#fff";
			document.getElementById("procurement").style.color = "#000000";
			document.getElementById("procurement").style.fontWeight = "bold";
		}
	</script>
	<script>
	var registerFormhtml = $('#registerForm').html();
	function registerContractForm(){
		$('#registerForm').html(registerFormhtml);
		$('#registerForm').attr('action', 'registercontract');
	}
	</script>
	<script>
	$(document).on('change', '#item_code', function() {
		var itemCode = $('#item_code').val();
		console.log("선택된 품목 코드 : " + itemCode);
		$.ajax({
					type : 'get',
					url : '/orderplanning/api/getiteminfoforcontract?item_code='
							+ itemCode,
					contentType : 'application/json; charset=utf-8',
					success : function(data, status, xhr) {
						console.log("품목 코드 Ajax 결과 : "
								+ data.item_name,
								data.standard,
								data.material,
								data.specification_file,
								data.draw_file,
								data.sc_name, data.mc_name);
						$('#item_name').val(data.item_name);
						$('#standard').val(data.standard);
						$('#material').val(data.material);
						$('#specification_file').val(
								data.specification_file);
						$('#draw_file').val(data.draw_file);
						$('#sc_name').val(data.sc_name);
						$('#mc_name').val(data.mc_name);
						
						var sfcontent = "/orderplanning/api/display?fileName=" + data.specification_file;
						var dfcontent = "/orderplanning/api/display?fileName=" + data.draw_file;
						$('#specification_file').attr('onclick', 'window.open(' + '"' + sfcontent + '"' + ', "_blank")');
						$('#draw_file').attr('onclick', 'window.open(' + '"' + dfcontent + '"' + ', "_blank")');
					}
				})
	});
	$(document).on('change', '#subcontractor_name', function() {
		var subcontractorName = $('#subcontractor_name').val();
		console.log("선택된 협력 업체 이름 : " + subcontractorName);
		$.ajax({
			type : 'get',
			url : '/orderplanning/api/getsubcontractor?subcontractor_name='
					+ subcontractorName,
			contentType : 'application/json; charset=utf-8',
			success : function(data, status, xhr) {
				console.log("협력 업체 이름 Ajax 결과 : "
						+ data.subcontractor_tel,
						data.subcontractor_email,
						data.subcontractor_person);
				$('#subcontractor_tel').val(
						data.subcontractor_tel);
				$('#subcontractor_email').val(
						data.subcontractor_email);
				$('#subcontractor_person').val(
						data.subcontractor_person);
			}
		})
	});
	
	$(document).on('click', '#contractviewbtn', function() {
		var contractFile = $('#cFile').val();
		console.log("선택된 계약서 파일 경로 : " + contractFile);
		window.open("/orderplanning/api/display?fileName=" + contractFile, "_blank");
	});
	</script>
	<script>
		$(document).on('keyup', '#supply_price', function() {
			$('#agreement_date').val(new Date().toISOString().slice(0, 10));
		})
	</script>
	<script>
		function contractConfirm() {
			var content = "계약서명: " + $('#contract_name').val() + "\n품목 코드: "
					+ $('#item_code').val() + "\n품목명: " + $('#item_name').val()
					+ "\n협력 업체: " + $('#subcontractor_name').val() + "\n공급 가격: "
					+ $('#supply_price').val() + "원\nL/T: "
					+ $('#leadtime').val() + "일\n비고: " + $('#contract_text').val() + "\n위 내용으로 계약서를 등록하시겠습니까?"
			return confirm(content);
		}
	</script>
	<script>
		var cItemCode = "${ cvo.item_code }";
		if (cItemCode != "") {
			alert("품목 코드: " + "${ cvo.item_code }" + "\n품목명: "
					+ "${ cvo.item_name }" + "\n협력 업체: "
					+ "${ cvo.subcontractor_name }" + "\n공급 가격: "
					+ "${ cvo.supply_price }" + "\nL/T : " + "${ cvo.leadtime }"
					+ "\n계약서 등록이 완료되었습니다.");
		}
		var mContractCode = "${ modifyvo.contract_code }";
		var mFlag = "${ modifyres }";
		if (mContractCode != "" && mFlag){
			alert("계약서명: " + "${ modifyvo.contract_name }"
					+ "\n계약서 수정이 완료되었습니다.");
		}
		var deleteResult = "${ deleteres }";
		if (deleteResult == 1) {
			alert("계약서 삭제가 완료되었습니다.");
		} else if (deleteResult == -1) {
			alert("해당 계약서는 삭제할 수 없습니다.\n구매발주서 발행 시에 이미 사용된 계약서가 아닌지 확인바랍니다.");
		}
	</script>
	<script>
	    $(document).ready(function() {
	        $('#myTable').tablesorter();
	      });
	</script>
	<script>
		function inquiryContractFunc() {
			var checkedContractCode = $(
					'input[type=radio][name=contract_code]:checked').val();
			if (checkedContractCode) {
				$.ajax({
							type : 'get',
							url : '/orderplanning/api/inquirycontract?contract_code='
									+ checkedContractCode,
							contentType : 'application/json; charset=utf-8',
							success : function(data, status, xhr) {
								console.log("선택한 계약서 불러오기 Ajax 결과 : "
										+ data.contract_name);
								$('#contract_name').val(data.contract_name);
								$('#item_code_tag').html('<label for="itemCode" class="input-group-text">품목 코드</label> <input type="text" class="form-control" id="item_code" name="item_code" value="' + data.item_code + '" readonly />')
								$('#item_name').val(data.item_name);
								$('#standard').val(data.standard);
								$('#material').val(data.material);
								$('#specification_file').val(
										data.specification_file);
								$('#draw_file').val(data.draw_file);
								$('#sc_name').val(data.sc_name);
								$('#mc_name').val(data.mc_name);
								$('#subcontractor_name').val(
										data.subcontractor_name);
								$('#subcontractor_tel').val(
										data.subcontractor_tel);
								$('#subcontractor_email').val(
										data.subcontractor_email);
								$('#subcontractor_person').val(
										data.subcontractor_person);
								$('#agreement_date').val(new Date(data.agreement_date).toISOString().slice(0, 10));
								$('#leadtime').val(data.leadtime);
								$('#supply_price').val(data.supply_price);
								$('#contract_text').val(data.contract_text);
								$('#contractfile_tag').attr('class','col-md-4');
								$('#contractfile_view').attr('class','col-md-2');
								$('#contractfile_view').html('<button type="button" class="btn btn-primary" id="contractviewbtn">기존 계약서</button>');
								$('#registerContract').text('계약 수정');
								$('#backbtn').html('<button type="button" class="btn btn-primary" onclick="registerContractForm()">돌아가기</button>');
								$('#registerForm').attr('action','modifycontract');
								$('#contract_imagefile').attr('required', false);
								$('#cCode').val(data.contract_code);
								$('#cFile').val(data.contract_file);
								$('#cardTitle').text("계약 조회");
								
								var sfcontent = "/orderplanning/api/display?fileName=" + data.specification_file;
								var dfcontent = "/orderplanning/api/display?fileName=" + data.draw_file;
								$('#specification_file').attr('onclick', 'window.open(' + '"' + sfcontent + '"' + ', "_blank")');
								$('#draw_file').attr('onclick', 'window.open(' + '"' + dfcontent + '"' + ', "_blank")');
							}	
						})
			} else {
				alert("계약 조회를 위해 계약서를 선택해주세요.");
			}
		};
		

	</script>
</body>
</html>