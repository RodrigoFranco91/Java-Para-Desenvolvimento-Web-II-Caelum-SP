<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,
				br.com.caelum.jdbc.dao.*, 
				br.com.caelum.jdbc.modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listagem de Contatos</title>
	</head>
	<body>

			
			<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.lista();
			
			for(Contato contato : contatos){
				
			%>
			<tr>
				<td>Nome:</td>
				<td>Email:</td>
				<td>Endereço:</td>
				<td>Data de Nascimento:</td><br/>
			</tr>
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=contato.getDataNascimento().getTime() %></td><br/>
			</tr>
			<%
			}
			%>
		</table>
	</body>
</html>