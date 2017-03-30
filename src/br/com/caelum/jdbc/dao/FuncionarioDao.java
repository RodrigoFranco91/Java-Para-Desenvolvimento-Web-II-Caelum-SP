package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {

	private Connection connection;

	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario f) {
		String sql = "INSERT INTO funcionario(nome, usuario, senha) VALUES(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, f.getNome());
			ps.setString(2, f.getUsuario());
			ps.setString(3, f.getSenha());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Funcionario> lista() {
		List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM funcionario";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Funcionario f = new Funcionario();
				f.setId(rs.getLong("id"));
				f.setNome(rs.getString("nome"));
				f.setUsuario(rs.getString("usuario"));
				f.setSenha(rs.getString("senha"));
				funcionarioList.add(f);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return funcionarioList;
	}
	
	public void altera(Funcionario f){
		String sql = "UPDATE funcionario set nome=?, usuario=?, senha=? WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, f.getNome());
			ps.setString(2, f.getUsuario());
			ps.setString(3, f.getSenha());
			ps.setLong(4, f.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleta(Funcionario f){
		String sql = "DELETE FROM funcionario WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, f.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
