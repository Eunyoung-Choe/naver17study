<%@page import="hywuboard.data.HywuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	HywuDao dao = new HywuDao(); 
	dao.deleteMemo(idx);
%>