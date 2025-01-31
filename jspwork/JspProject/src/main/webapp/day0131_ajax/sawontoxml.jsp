<?xml version="1.0" encoding="UTF-8"?>
<%@page import="sawon.data.SawonDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="sawon.data.SawonDao"%>
<!-- 아래 text/xml로 적으면 실행시켰을 때 xml 문서로 출력됨. -->
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<%
	SawonDao dao = new SawonDao();
	String search = request.getParameter("search");
	List<SawonDto> list = dao.getAllDatas(search);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
	
	for(SawonDto dto:list)
	{%>
		<sawon num="<%=dto.getNum() %>">
			<sname><%=dto.getSname() %></sname>
			<sphoto><%=dto.getSphoto() %></sphoto>
			<sblood><%=dto.getSblood() %></sblood>
			<sbirth><%=dto.getSbirth() %></sbirth>
			<ipsaday><%=dto.getIpsaday() %></ipsaday>
			<writeday><%=sdf.format(dto.getWriteday()) %></writeday>
		</sawon>
	
     <%}
%>
</data>