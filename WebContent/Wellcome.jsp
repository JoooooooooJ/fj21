<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bem Vindo</title>
</head>
	<body>
				<c:import url="WEB-INF/views/Header.jsp"></c:import>
            	 <h1>"Bem vindo ao sistema de agenda do FJ-21!"</h1>
                 <br />
				 <h4>Desenvolvido por JooJ</h4>
                 <br />                 
                 <form method="POST" action="addContact">
                 <input type="submit" value="Adicionar Contatos"/>
                 </form>
                 <form method="POST" action="mvc?logic=ListContactLogic">
                 <input type="submit" value="Visualizar Contatos"/>
                 </form>
	</body>
</html>