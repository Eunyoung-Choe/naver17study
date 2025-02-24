<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>502jsp study</title>
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }

        a:link, a:visited {
            color: black;
            text-decoration: none;
        }

        a:hover {
            color: hotpink;
        }

        ul.menu {
            list-style: none;
        }

        ul.menu li {
            float: left;
            width: 75px;
            height: 40px;
         line-height: 40px;
         text-align: center;
         background-color: #ffe4e1;
         margin-right: 5px;
         border: 1px solid lightgray;
         border-radius: 20px;
        }

        ul.menu li:hover{
         background-color: lightgrey;
         box-shadow: 2px 2px 5px lightgrey;
        }
        .logintab tbody th{
            background-color: #e0ffff;
        }
        
        img.profilephoto {
        	width: 40px;
        	height: 40px;
        	border: 1px solid gray;
        	border-radius: 100px;
        	margin-right: 10px;
        	cursor: pointer;
        }
    </style>
</head>
<!-- 프로젝트 경로 구하기 - 절대경로를 위한 코드 -->
<c:set var="root" value="${pageContext.request.contextPath}"/> <!-- 프로젝트 경로 얻기 -->
<body>
<!-- The Modal -->
<div class="modal" id="myLoginModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">로그인</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form id="loginfrm">
                    <table class="logintab">
                        <tbody>
                            <tr>
                                <th width="80">아이디</th>
                                <td>
                                    <input type="text" id="loginid" placeholder="id"
                                    class="form-control" required="required">
                                </td>
                            </tr>
                            <tr>
                                <th width="80">비밀번호</th>
                                <td>
                                    <input type="password" id="loginpass" placeholder="password"
                                    class="form-control" required="required">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <button type="submit" class="btn btn-sm btn-success">로그인</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger btnclose" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>
<div style="margin: 10px">
    <h2 class="alert alert-success">
        <a href="${root}/">
            <img src="${root}/4.jpg" width="50">
            SpringBoot와 Mybatis를 이용한 PJ
        </a>
        <br>
        <span style="margin-left: 280px; font-size: 15px;">
                <c:if test="${sessionScope.loginstatus!=null}">
                	<!-- 로그인 프로필 이미지 -->
                	<img src="${root }/save/${sessionScope.loginphoto}" class="profilephoto" onerror="this.src='${root}/save/noimage.png'">
                	<script>
                		$(".profilephoto").click(function(){
                			location.href = `${root}/member/mypage`;
                		});
                	</script>
                	
                    <b>${sessionScope.loginid}</b>님이 로그인 중입니다
                </c:if>
        </span>
    </h2>
    <ul class="menu">
        <li>
            <a href="${root}/">Home</a>
        </li>
        <li>
            <a href="${root}/shop/list">상품목록</a>
        </li>
        <li>
            <a href="${root}/member/form">회원가입</a>
        </li>
        <c:if test="${sessionScope.loginstatus!=null and sessionScope.loginid=='admin'}">
            <li>
                <a href="${root}/member/list">회원목록</a>
            </li>
        </c:if>
        <li>
            <a href="${root}/board/list">회원게시판</a>
        </li>
        <li>
            <c:if test="${sessionScope.loginstatus!=null}">
                <span style="cursor: pointer" id="logout">로그아웃</span>
            </c:if>
            <c:if test="${sessionScope.loginstatus==null}">
                <span data-bs-toggle="modal" data-bs-target="#myLoginModal"
                      style="cursor: pointer;">로그인</span>
            </c:if>

        </li>
    </ul>
    <script>
        $("#loginfrm").submit(function (e){
            e.preventDefault();//서브밋의 기본 이벤트 무효화
            // alert("submit");
            let loginid=$("#loginid").val();
            let loginpass=$("#loginpass").val();

            $.ajax({
                type:"get",
                dataType:"json",
                data:{"loginid":loginid,"loginpass":loginpass},
                url:"${root}/member/login", // 절대주소 (상대주소면 경로 달라지면 바로 404 나옴.)
                success:function (res){
                    if(res.result=='success'){
                        //값 초기화
                        $("#loginid").val("");
                        $("#loginpass").val("");
                        //모달창 닫기
                        $(".btnclose").trigger("click");
                        //새로고침
                        location.reload();
                    }else {
                        alert("아이디 또는 비밀번호가 일치하지 않습니다")
                        $("#loginpass").val();
                    }
                }
            });
        });
        $("#logout").click(function (){
            $.ajax({
                type: "get",
                dataType: "text",
                url:"${root}/member/logout",
                success:function (res){
                    location.reload();
                }
            });
        });
    </script>
</div>
<br style="clear: both;">
</body>
</html>