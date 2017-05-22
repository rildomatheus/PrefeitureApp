package com.fafica.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		String sql = "insert into denuncia(setor,cidade,bairro,descricao,idusuario)values(?,?,?,?,?)";
		PreparedStatement prepareStatement = conec.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
		prepareStatement.setString(1, denuncia.getSetor());
		prepareStatement.setString(2, denuncia.getCidade());
		prepareStatement.setString(3, denuncia.getBairro());
		prepareStatement.setString(4, denuncia.getDescricao());
		prepareStatement.setInt(5, denuncia.getIdUsuario());
		
		
		prepareStatement.execute();

	}

	public void remover(Denuncia denuncia) throws SQLException {
		String sql = "delete from denuncia where iddenuncia = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, denuncia.getIdDenuncia());
		
		prepareStatement.executeUpdate();

	}

	public void atualizar(Denuncia denuncia) throws SQLException {
		String sql = "update denuncia set setor = ?,cidade = ?,bairro = ?,descricao = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
		prepareStatement.setString(1, denuncia.getSetor());
		prepareStatement.setString(2, denuncia.getCidade());
		prepareStatement.setString(3, denuncia.getBairro());
		prepareStatement.setString(4, denuncia.getDescricao());
		
		
		
		prepareStatement.executeUpdate();

}

	public Denuncia procurar(Denuncia denuncia) throws SQLException {
		String sql = "select*from denuncia where iddenuncia = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, denuncia.getIdDenuncia());
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			String setor = resultadoBusca.getString(1);
			String cidade = resultadoBusca.getString(2);
			String bairro = resultadoBusca.getString(3);
			String descricao = resultadoBusca.getString(4);
			
			Denuncia denuncia1 = new Denuncia();
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
			String setor = resultadoBusca.getString(1);
			String cidade = resultadoBusca.getString(2);
			String bairro = resultadoBusca.getString(3);
			String descricao = resultadoBusca.getString(4);
			
			Denuncia denuncia1 = new Denuncia();
			denuncia1.setSetor(setor);
			denuncia1.setCidade(cidade);
			denuncia1.setBairro(bairro);
			denuncia1.setDescricao(descricao);
			
			lista.add(denuncia1);
		}
		return lista;
	}

}
