<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    <%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Contatos</title>
</head>
	<body>
		<c:import url="Header.jsp"/>
		<h1>Adiciona Contatos</h1>
			<hr />
			<form action="mvc?logic=AddContactLogic" method="POST">
				Nome: 			 <input type="text" name="name" /><br />
				E-mail: 		 <input type="text" name="email" /><br />
				Endereço: 		 <input type="text" name="address" /><br />
				Data Nascimento: <input type="text" name="birthday"/>  								
				<input type="submit" value="Gravar" />
			</form>
	
	</body>
</html>