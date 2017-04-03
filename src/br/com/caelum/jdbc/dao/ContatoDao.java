package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	//CONSTRUTOR QUE RECEBE POR PARAMETRO A CONEXAO, POIS AGORA A CONEXAO É CRIADA NO FILTRO ( INJECAO DE DEPENDENCIA E INVERSAO DE CONTROLE)
	public ContatoDao(Connection con){
		this.connection = con;
	}

	public void adiciona(Contato c){
		String sql="INSERT INTO CONTATOS(nome,email,endereco,dataNascimento) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getEndereco());
			ps.setDate(4, new Date(c.getDataNascimento().getTimeInMillis()));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Contato> lista(){
		List<Contato> contatoList = new ArrayList<Contato>();
		String sql = "SELECT * FROM CONTATOS";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Contato c = new Contato();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				//montando a data:
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				c.setDataNascimento(data);
				
				contatoList.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contatoList;
	}
	
	public void altera(Contato c){
		String sql = "UPDATE CONTATOS SET nome =?, email=?, endereco=?, dataNascimento=? WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getEndereco());
			ps.setDate(4, new Date(c.getDataNascimento().getTimeInMillis()));
			ps.setLong(5, c.getId());
			ps.execute();	
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleta(Contato c){
		String sql = "DELETE FROM Contatos WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, c.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
