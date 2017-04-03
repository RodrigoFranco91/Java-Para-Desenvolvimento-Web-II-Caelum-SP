package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements javax.servlet.Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			// CIANDO CONEXAO
			Connection connection = new ConnectionFactory().getConnection();

			// PENDURANDO A CONEXAO NA REQUISICAO
			request.setAttribute("conexao", connection);

			// DANDO CONTINUIDADE A EXECUCAO NORMAL DA REQUISICAO
			chain.doFilter(request, response);

			// TUDO QUE VEM APOS DOFILTER É APOS O FIM DA REQUISICAO, LOGO PODE FECHAR A CONEXAO
			connection.close();
		} catch (Exception e) {
			throw new ServletException();
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
