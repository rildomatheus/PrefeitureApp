package com.fafica.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.entidades.Comentario;
import com.fafica.entidades.Denuncia;

public class RepositorioComentario implements IRepositorioComentario {
	
	private Connection conec;
	private static RepositorioComentario instance;
	
	public RepositorioComentario(){
		Conect conexao = new Conect();
		this.conec = conexao.getConnection();
	}
	
	public static RepositorioComentario getInstance(){
		if(instance == null){
			instance = new RepositorioComentario();
		}return instance;
	}
	

	public void cadastrarComentario(Comentario comentario) throws SQLException {
		String sql = "insert into comentario(descricao,iddenuncia)values(?,?)";
		PreparedStatement prepareStatement = conec.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
		prepareStatement.setString(1, comentario.getDescricao());
		prepareStatement.setInt(2, comentario.getDenuncia().getIdDenuncia());
		
		
		prepareStatement.execute();


	}

	public void removerComentario(int id) throws SQLException {
		String sql = "delete from comentario where idcomentario = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, id);
		
		prepareStatement.executeUpdate();


	}

	public void atualizarComentario(Comentario comentario) throws SQLException {
		String sql = "update comentario set descricao = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
		prepareStatement.setString(1, comentario.getDescricao());
	
		
		
		
		prepareStatement.executeUpdate();

	}

	public Comentario procurarComentario(Comentario comentario) throws SQLException {
		String sql = "select*from comentario where idcomentario = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, comentario.getIdComentario());
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			String descricao = resultadoBusca.getString(1);

			
			Comentario comentario1 = new Comentario();
			comentario1.setDescricao(descricao);
			
			return comentario1;
		}
		return null;
	}

	public ArrayList<Comentario> listarComentario() throws SQLException {
		ArrayList<Comentario> lista = new ArrayList<Comentario>();
		String sql = "select*from comentario";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			String descricao = resultadoBusca.getString(1);
			
			Comentario comentario1 = new Comentario();
			comentario1.setDescricao(descricao);
			
			lista.add(comentario1);
		}//https://colorlib.com/wp/css3-table-templates/
		return lista;
	
	}
	
	public Comentario procurarId(int id) throws SQLException{
		String sql = "select*from comentario where idcomentario = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, id);
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			String descricao = resultadoBusca.getString(1);

			
			Comentario comentario1 = new Comentario();
			comentario1.setDescricao(descricao);
			
			return comentario1;
		}
		return null;
	}

}
