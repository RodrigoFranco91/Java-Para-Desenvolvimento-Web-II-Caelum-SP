package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		// fazer a conversao da data:

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (java.text.ParseException e) {
			System.out.println("Erro ao converter a data!");
			return;
		}
		
		//montando objeto:
		
		Contato c = new Contato();
		c.setNome(nome);
		c.setEndereco(endereco);
		c.setEmail(email);
		c.setDataNascimento(dataNascimento);
		
		//salva o contato:
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(c);
		
		//retorno para o navegador(cliente):
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Contato Adicionado!t</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("O Contato "+ c.getNome() + " foi adicionado com exito!");
		out.println("</body>");
		out.println("</html>");

	}

}
