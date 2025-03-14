<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <!-- 이걸 import해야 c:를 사용 가능 -->
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 이걸 import해야 fmt:를 사용 가능 -->
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
   body *{
      font-family: 'Jua';
   }
   </style>
</head>
<body>
<!-- 글 목록 로비 페이지 -->

<jsp:include page="../kakao/kakaologin.jsp"/>
<hr>
<div style="margin: 20px; width : 600px;">
   <table class="tab1 table table-bordered">
      <caption align="top">
         <b>총 ${totalCount}개의 글이 있습니다.</b>
         
         <button type="button" class="btn btn-sm btn-outline-secondary" style="float:right;"
         onclick="location.href='./writeform'">글쓰기</button>
      </caption>
      <thead>
         <tr>
            <th width="50">번호</th>
            <th width="300">제목</th>
            <th width="70">작성자</th>
            <th width="70">작성일</th>
            <th>조회</th>
         </tr>
      </thead>
      <tbody>
         <c:if test="${totalCount==0}">
            <tr height="50">
               <td colspan="5" align="center" valign="middle">
                  <b> 등록된 게시글이 없습니다 </b>
               </td>
            </tr>
         </c:if>
         <c:if test="${totalCount>0}">
            <c:forEach var="dto" items="${list}" varStatus="i">
            	<tr>
            		<td align="center">${totalCount-i.index }</td>
            		<td>
            			<!-- 제목 부분 -->
            			<a style="cursor: pointer; text-decoration: none; color:black;" href="./detail?num=${dto.num }">
            				<!-- level 1당 3칸 정도 띄우기 -->
            				<c:forEach begin="1" end="${dto.relevel }">
            					&nbsp;&nbsp;&nbsp;
            				</c:forEach>
            				
            				<!-- 답글인 경우는 앞에 ㄴ리플 이미지 넣기 -->
            				<c:if test="${dto.relevel>0 }">
            					<img src="../image/re.png">
            				</c:if>
            				
            				<span>${dto.subject }</span>
            			</a>
            			
            			<td align="center">${dto.writer }</td>
            			<td align="center" style="font-size:0.9em;">
            				<fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd"/>
            			</td>	
            			<td align="center">${dto.readcount}</td>
            		</td>
            	</tr>
            </c:forEach>
         </c:if>
      </tbody>
   </table>


</body>
</html>