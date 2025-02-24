<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HYWU Software Board Login</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body *{
            font-family: 'Jua';
        }
        
        .content {
		    display: flex;
		    flex-direction: column;
		    justify-content: center; /* 세로 중앙 정렬 */
		    align-items: center; /* 가로 중앙 정렬 */
		    height: 100vh; /* 전체 화면 높이 설정 */
		}

     </style>
</head>
<body>
<%
//세션에 저장된 체크값과 아이디를 얻는다(없을경우는 null 값)
	String chksave=(String)session.getAttribute("chksave");
	String myid=(String)session.getAttribute("myid");
	
	if(chksave==null)
		myid="";
%>
<div class="content">
	<!-- 로그인 단색 배경 -->
	<div style="width: 300px; height:60px; margin-bottom: 5px; padding-top: 10px; text-align:center; background-color: #00467F; display: flex; justify-content: center; align-items: center;">
	    <h2 style="color:white;">로그인</h2>
	</div>

   <form action="./loginaction.jsp" method="post">
         <table class="table table-bordered" style="width:300px ;">
             <tr>
                 <td colspan="2" align="center">
                     <label><input type="checkbox" name="chksave"
                       <%=chksave==null?"":"checked" %>>아이디저장</label>
                 </td>
             </tr>
             <tr>
                 <th style="width:100px; padding-top: 15px; color: #4C4C4C; background-color: #F6F6F6;">아이디</th>
                 <td>
                     <input type="text" name="myid" class="form-control"
                     placeholder="아이디" autofocus value="<%=myid%>">
                 </td>
             </tr>
             <tr>
                 <th style="width:100px; padding-top: 15px; color: #4C4C4C; background-color: #F6F6F6;">비밀번호</th>
                 <td>
                     <input type="password" name="mypass" class="form-control"
                     placeholder="비밀번호">
                 </td>
             </tr>
             <tr>
                 <td colspan="2" align="center" style="background-color: gainsboro;">
                     <button type="submit"  class="btn btn-default" style="width:150px; color: #00467F; background-color: gainsboro;">
                     	<b style="font-size: 18px;">회원 로그인</b>
                   	</button>
                 </td>
             </tr>
         </table>
      </form>
      
      <!-- 가로 로고 사진 -->
      <div>
      	<img src="logo2.jpg" width="130px">
      </div>
 </div>
</body>
</html>