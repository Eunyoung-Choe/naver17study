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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
		body *{
			font-family: 'Jua';
		}
		.day{
			color:gray;
			font-size: 13px;
		}
		.smallphoto{
			width: 45px;
			height: 45px;
			border-radius: 25px;
			margin-right: 10px;
			cursor: pointer;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$(".btn").addClass("btn-sm btn-outline-secondarty").css("width","100px");
		});
	</script>
</head>
<body>
	<!-- 작성한 글 세부 페이지 -->
	
	<div style="margin: 20px;width: 600px;">
		<h1><b>${dto.subject }</b></h1>
		<div>
			<!-- 프로필 사진(dto.photo가 사진 경로) -->
			<img src="${dto.photo }" class="smallphoto" data-bs-toggle="modal" data-bs-target="#photoModal" /> <!-- id가 "photoModal"인 모달을 열도록 지정 -->
			
			<!-- 모달로 프로필 사진 확대 -->
			<div class="modal fade" id="photoModal">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="photoModalLabel">${dto.writer}님의 프로필</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			      <div class="modal-body text-center">
			        <img src="${dto.photo}" alt="Profile Photo">
			      </div>
			    </div>
			  </div>
			</div>
			
			<span>${dto.writer }</span><br>
			<span class="day">
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
				&nbsp;&nbsp;&nbsp;
				조회 ${dto.readcount }
			</span>
		</div>
		<hr>
		<pre style="font-size: 17px;">${dto.content }</pre>
		<div style="margin-top: 50px;">
			<button type="button" class="btn"
			onclick="location.href='./writeform'">글쓰기</button>
			
			<button type="button" class="btn"
			onclick="location.href='./list'">목록</button>
			
			<button type="button" class="btn"
			onclick="location.href='./writeform?num=${dto.num}&regroup=${dto.regroup }&restep=${dto.restep }$relevel=${dto.relevel }'">답글</button>
			
			<button type="button" class="btn"
			onclick="location.href='./writeform'">수정</button>
			
			<button type="button" class="btn"
			onclick="location.href='./writeform'">삭제</button>
			
		</div>
	</div>
</body>
</html>
