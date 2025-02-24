<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
   <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
   <style>
      body * {
         font-family: 'Jua';
      }
   </style>
</head>

<body>
	<!-- 회원정보 수정 모달 -->
	<div class="modal fade" id="editMemberModal" tabindex="-1" aria-labelledby="editMemberModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="editMemberModalLabel">회원정보 수정</h5>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	            </div>
	            <div class="modal-body">
	                <form id="editMemberForm">
	                    <div class="mb-3">
	                        <label for="editName" class="form-label">회원명</label>
	                        <input type="text" class="form-control" id="editName" name="mname" value="${dto.mname}">
	                    </div>
	                    <div class="mb-3">
	                        <label for="editPhone" class="form-label">핸드폰</label>
	                        <input type="text" class="form-control" id="editPhone" name="mhp" value="${dto.mhp}">
	                    </div>
	                    <div class="mb-3">
	                        <label for="editAddress" class="form-label">주소</label>
	                        <input type="text" class="form-control" id="editAddress" name="maddr" value="${dto.maddr}">
	                    </div>
	                    <input type="hidden" id="editNum" name="num" value="${dto.num}">
	                </form>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	                <button type="button" class="btn btn-primary" id="saveChanges">저장</button>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>