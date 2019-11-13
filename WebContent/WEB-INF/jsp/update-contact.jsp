<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Contato</title>
</head>
	<body>
		<c:import url="	WEB-INF/jsp/Header.jsp"/>
		<h1>Alterar Contato</h1>
			<hr />
			<form action="mvc?logic=UpdateContactLogic&id=${param.id }" method="POST">
				Nome: 			 <input type="text" name="name""/><br />
				E-mail: 		 <input type="text" name="email" /><br />
				Endereço: 		 <input type="text" name="address"/><br />
				Data Nascimento: <input type="text" name="birthday"/>  								
				<input type="submit" value="Atualizar" />
			</form>	
	</body>
</html>