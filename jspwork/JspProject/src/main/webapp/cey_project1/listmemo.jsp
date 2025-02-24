<%@page import="hywuboard.data.HywuDto"%>
<%@page import="hywuboard.data.HywuDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    HywuDao dao = new HywuDao();
    List<HywuDto> list = dao.getAllMemos();

    JSONArray arr = new JSONArray(); // org.json.simple.JSONArray 사용
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
<%= arr%> <%-- JSON 데이터를 문자열로 변환하여 출력 --%>

