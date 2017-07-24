package com.fafica.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.entidades.Denuncia;

public class RepositorioDenuncia implements IRepositorioDenuncia {
	
	private Connection conec;
	private static RepositorioDenuncia instance;
	
	public RepositorioDenuncia(){
		Conect conexao = new Conect();
		this.conec = conexao.getConnection();
	}
	
	public static RepositorioDenuncia getInstance(){
		if(instance == null){
			instance = new RepositorioDenuncia();
		}return instance;
	}
	

	public void cadastrar(Denuncia denuncia) throws SQLException {
		String sql = "insert into denuncia(titulo,setor,cidade,bairro,descricao,idusuario)values(?,?,?,?,?,?)";
		PreparedStatement prepareStatement = conec.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
		prepareStatement.setString(1, denuncia.getTitulo());
		prepareStatement.setString(2, denuncia.getSetor());
		prepareStatement.setString(3, denuncia.getCidade());
		prepareStatement.setString(4, denuncia.getBairro());
		prepareStatement.setString(5, denuncia.getDescricao());
		prepareStatement.setInt(6, denuncia.getIdUsuario());
		
		
		prepareStatement.execute();

	}

	public void remover(Denuncia denuncia) throws SQLException {
		String sql = "delete from denuncia where iddenuncia = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, denuncia.getIdDenuncia());
		
		prepareStatement.executeUpdate();

	}

	public void atualizar(Denuncia denuncia) throws SQLException {
		String sql = "update denuncia set titulo = ?,setor = ?,cidade = ?,bairro = ?,descricao = ?, foto = ?, video = ? WHERE iddenuncia = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
		prepareStatement.setString(1, denuncia.getTitulo());
		prepareStatement.setString(2, denuncia.getSetor());
		prepareStatement.setString(3, denuncia.getCidade());
		prepareStatement.setString(4, denuncia.getBairro());
		prepareStatement.setString(5, denuncia.getDescricao());
		prepareStatement.setString(6, denuncia.getFoto());
		prepareStatement.setString(7, denuncia.getVideo());
		prepareStatement.setInt(8, denuncia.getIdDenuncia());
		
		
		prepareStatement.executeUpdate();

}

	public Denuncia procurar(Denuncia denuncia) throws SQLException {
		String sql = "select*from denuncia where iddenuncia = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, denuncia.getIdDenuncia());
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			String titulo = resultadoBusca.getString(1);
			String setor = resultadoBusca.getString(2);
			String cidade = resultadoBusca.getString(3);
			String bairro = resultadoBusca.getString(4);
			String descricao = resultadoBusca.getString(5);
			
			Denuncia denuncia1 = new Denuncia();
			denuncia1.setTitulo(titulo);
			denuncia1.setSetor(setor);
			denuncia1.setCidade(cidade);
			denuncia1.setBairro(bairro);
			denuncia1.setDescricao(descricao);
			
			return denuncia1;
		}
		return null;

	}

	public ArrayList<Denuncia> listar() throws SQLException {
		ArrayList<Denuncia> lista = new ArrayList<Denuncia>();
		String sql = "select*from denuncia";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			String idDenuncia = resultadoBusca.getString(1);
			String titulo = resultadoBusca.getString(2);
			String setor = resultadoBusca.getString(3);
			String cidade = resultadoBusca.getString(4);
			String bairro = resultadoBusca.getString(5);
			String descricao = resultadoBusca.getString(6);
			int idUsuario = resultadoBusca.getInt(7);
			String foto = resultadoBusca.getString(9);
			String video = resultadoBusca.getString(10);
			
			Denuncia denuncia1 = new Denuncia();
			denuncia1.setIdDenuncia(Integer.parseInt(idDenuncia));
			denuncia1.setTitulo(titulo);
			denuncia1.setSetor(setor);
			denuncia1.setCidade(cidade);
			denuncia1.setBairro(bairro);
			denuncia1.setDescricao(descricao);
			denuncia1.setIdUsuario(idUsuario);
			denuncia1.setFoto(foto);
			denuncia1.setVideo(video);
			
			lista.add(denuncia1);
		}
		return lista;
	}
	
	public Denuncia procurarId(int id) throws SQLException{
		String sql = "select*from denuncia where iddenuncia = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, id);
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			int idDenuncia = resultadoBusca.getInt(1);
			String titulo = resultadoBusca.getString(2);
			String setor = resultadoBusca.getString(3);
			String cidade = resultadoBusca.getString(4);
			String bairro = resultadoBusca.getString(5);
			String descricao = resultadoBusca.getString(6);
			int idUsuario = resultadoBusca.getInt(7);
			String foto = resultadoBusca.getString(9);
			String video = resultadoBusca.getString(10);
			
			Denuncia denuncia1 = new Denuncia();
			denuncia1.setIdDenuncia(idDenuncia);
			denuncia1.setTitulo(titulo);
			denuncia1.setSetor(setor);
			denuncia1.setCidade(cidade);
			denuncia1.setBairro(bairro);
			denuncia1.setDescricao(descricao);
			denuncia1.setIdUsuario(idUsuario);
			denuncia1.setFoto(foto);
			denuncia1.setVideo(video);
			
			return denuncia1;
		}
		return null;
	}

}
