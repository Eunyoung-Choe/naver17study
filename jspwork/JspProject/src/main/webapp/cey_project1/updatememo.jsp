<%@page import="hywuboard.data.HywuDao"%>
<%@page import="hywuboard.data.HywuDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	String avata=request.getParameter("avata");
	String nickname=request.getParameter("nickname");
	String message=request.getParameter("message");
	
	HywuDto dto=new HywuDto();
	dto.setIdx(idx);
	dto.setAvata(avata);
	dto.setNickName(nickname);
	dto.setMessage(message);
	
	HywuDao dao=new HywuDao();
	dao.insertMemo(dto);
%>
