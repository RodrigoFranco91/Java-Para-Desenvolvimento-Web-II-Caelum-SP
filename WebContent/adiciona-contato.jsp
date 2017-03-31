<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Adiciona Contatos</title>
		<link href="css/jquery-ui.css" rel="stylesheet">
		<script src="js/jquery.js" ></script>
		<script src="js/jquery-ui.js" ></script>
	</head>
		<body>
		<c:import url="cabecalho.jsp"></c:import>
			<h1>Adiciona Contatos</h1>
			<hr/>
			<form action="adicionaContato">
				<label>Nome:</label>
				<input type="text" name="nome"/><br/><br/>
				
				<label>Email:</label>
				<input type="text" name="email"/><br/><br/>
				
				<label>Endereço:</label>
				<input type="text" name="endereco"/><br/><br/>
				
				<label>DataNascimento:</label>
				<caelum:campoData id="dataNascimento" /><br/><br/>
				
				<input type="submit" value="Gravar"/>
			</form>
			<c:import url="rodape.jsp"></c:import>
		</body>
</html>