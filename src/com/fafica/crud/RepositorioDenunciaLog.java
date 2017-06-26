package com.fafica.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.entidades.Denuncia;
import com.fafica.entidades.DenunciaLog;

public class RepositorioDenunciaLog{
	
	private Connection conec;
	private static RepositorioDenunciaLog instance;
	
	public RepositorioDenunciaLog(){
		
		Conect conexao = new Conect();
		this.conec = conexao.getConnection();
		
	}
	
	public static RepositorioDenunciaLog getInstance(){
		if(instance == null){
			instance = new RepositorioDenunciaLog();
		}return instance;
	}
	

	public void cadastrar(DenunciaLog denunciaLog) throws SQLException {
		
		String sql = "insert into denunciaLog(titulo,setor,cidade,bairro,descricao,idusuario)values(?,?,?,?,?,?)";
		PreparedStatement prepareStatement = conec.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
		prepareStatement.setString(1, denunciaLog.getTitulo());
		prepareStatement.setString(2, denunciaLog.getSetor());
		prepareStatement.setString(3, denunciaLog.getCidade());
		prepareStatement.setString(4, denunciaLog.getBairro());
		prepareStatement.setString(5, denunciaLog.getDescricao());
		prepareStatement.setInt(6, denunciaLog.getIdUsuario());
		
		
		prepareStatement.execute();	
		
	}

	public void remover(DenunciaLog denunciaLog) throws SQLException {
		
		String sql = "delete from denunciaLog where iddenuncia = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, denunciaLog.getIdDenuncia());
		
		prepareStatement.executeUpdate();
		
		
	}

	public void atualizar(DenunciaLog denunciaLog) throws SQLException {
		
		String sql = "update denunciaLog set setor = ?,cidade = ?,bairro = ?,descricao = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
		prepareStatement.setString(1, denunciaLog.getTitulo());
		prepareStatement.setString(2, denunciaLog.getSetor());
		prepareStatement.setString(3, denunciaLog.getCidade());
		prepareStatement.setString(4, denunciaLog.getBairro());
		prepareStatement.setString(5, denunciaLog.getDescricao());
		
		
		
		prepareStatement.executeUpdate();
		
		
	}

	public Denuncia procurar(DenunciaLog denunciaLog) throws SQLException {
		
		return null;
	}

	public ArrayList<Denuncia> listar() throws SQLException {
		
		return null;
	}

}