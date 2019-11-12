<%@page import="gubee.estudo.web.Contato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seus contatos</title>
</head>
	<body>
	<c:import url="cabecalho.jsp"></c:import>
	<jsp:useBean id="dao" class="gubee.estudo.jdbc.dao.ContatosDao"/>
		<table>
		<c:forEach var="contato" items="${dao.list}" varStatus="id">
		<h9 color:white>
			<tr bgcolor="#${id.count % 2 == 0 ? '#D697FF' : '#6B4C7F' }">
				<td>${contato.id}</td>
				<td>${contato.name}</td>
				<c:if test="${not empty contato.email}">
				<td>
				<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if>
				<c:if test="${contato.email}"> ${contato.email}
				</c:if>
				</td>
				<td>${contato.address}</td>
				<td><fmt:formatDate value="${contato.birthday.time}" pattern="dd/MM/yyyy"/></td>
			</tr>	
			</h9>		
		</c:forEach>
    </table>
	</body>
</html>