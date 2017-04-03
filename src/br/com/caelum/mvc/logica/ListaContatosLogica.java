package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatosLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<Contato> contatos = new ContatoDao().lista();
		req.setAttribute("contatos", contatos);
		
		return "lista-contatos.jsp";
	}

}
