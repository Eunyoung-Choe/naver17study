<?xml version="1.0" encoding="UTF-8"?>
<%@page import="hywuboard.data.HywuDao"%>
<%@page import="hywuboard.data.HywuDto"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String avata=request.getParameter("avata");
	String nickname=request.getParameter("nickname");
	String message=request.getParameter("message");
	
	HywuDto dto=new HywuDto();
	dto.setAvata(avata);
	dto.setNickName(nickname);
	dto.setMessage(message);
	
	HywuDao dao=new HywuDao();
	dao.insertMemo(dto);
%>
<data>
	<result><%=nickname %>님의 메모를 DB 에 추가했습니다</result>
</data>