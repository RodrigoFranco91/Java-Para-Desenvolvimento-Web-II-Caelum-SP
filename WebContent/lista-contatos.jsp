<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listagem de Contatos</title>
	</head>
	<body>
	
	<c:import url="cabecalho.jsp"></c:import>
	
	<!-- Cria o DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"></jsp:useBean>
	
	<h1>Listagem de contatos:</h1>
	<table>
		<tr>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Data Nascimento</td>
		</tr>
		
		<!--Percorre contatos -->
		<c:forEach var="contato" items="${dao.lista()}">
			<tr>
				<td>${contato.nome}</td>
				<td>
					<c:if test="${not empty contato.email }">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					
					<c:if test="${empty contato.email }">
						E-mail não informado.
					</c:if>
				</td>
				<td>${contato.endereco}</td>
				<td>
					<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="rodape.jsp"></c:import>
	</body>
</html>