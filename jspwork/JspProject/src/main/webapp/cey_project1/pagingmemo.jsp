<%@page import="hywuboard.data.HywuDto"%>
<%@page import="hywuboard.data.HywuDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 페이징 추가한 부분 -->
<%
    int pageSize = 10;  // 한 페이지에 표시할 메모 수
    int defaultpage = 1;       // 기본 페이지는 1로 설정 
    
    // 클라이언트에서 전달된 페이지 번호를 받아옴
    String pageParam = request.getParameter("page");
    if (pageParam != null && !pageParam.isEmpty()) {
        try {
            defaultpage = Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            defaultpage = 1;  // 잘못된 페이지 번호는 1로 설정
        }
    }
    
    HywuDao dao = new HywuDao();
    List<HywuDto> list = dao.getMemosByPage(defaultpage, pageSize);  // 페이지에 맞는 데이터만 불러오기

    int totalCount = dao.getMemoCount();  // 전체 메모 개수
    int totalPages = (int) Math.ceil((double) totalCount / pageSize);  // 전체 페이지 수 계산
    
    JSONArray arr = new JSONArray(); 
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    for (HywuDto dto : list) {
        JSONObject ob = new JSONObject();
        ob.put("idx", dto.getIdx());
        ob.put("nickname", dto.getNickName());
        ob.put("avata", dto.getAvata());
        ob.put("message", dto.getMessage());
        ob.put("writeday", sdf.format(dto.getWriteday()));
        arr.add(ob);
    }
%>
<%= arr %>

<!-- 페이지 네비게이션 -->
<div>
    <!-- Previous 버튼 -->
    <a href="?page=<%= (defaultpage > 1) ? (defaultpage - 1) : 1 %>" <% if (defaultpage <= 1) { %>style="pointer-events: none; color: gray;"<% } %>>Previous</a>

    <% for (int i = 1; i <= totalPages; i++) { %>
        <a href="?page=<%= i %>" <% if (i == defaultpage) { %>style="font-weight: bold; color: red;"<% } %>><%= i %></a>
    <% } %>

    <!-- Next 버튼 -->
    <a href="?page=<%= (defaultpage < totalPages) ? (defaultpage + 1) : totalPages %>" <% if (defaultpage >= totalPages) { %>style="pointer-events: none; color: gray;"<% } %>>Next</a>
</div>
