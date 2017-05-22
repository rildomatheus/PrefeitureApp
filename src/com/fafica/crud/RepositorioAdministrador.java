package com.fafica.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class RepositorioAdministrador implements IRepositorioAdministrador {

	private Connection conec;
	private int idAdministrador;
	private static RepositorioAdministrador instance;
	
	public RepositorioAdministrador(){
		this.conec = (Connection) Conect.getInstance();
		this.idAdministrador = 1;
	}
	
	public static RepositorioAdministrador getInstance(){
		if(instance == null){
			instance = new RepositorioAdministrador();
		}return instance;
	}
	

	public void cadastra(Administrador administrador) throws SQLException {
		administrador.setId(idAdministrador);
		String sql = "insert into administrador(idadministrador,nome,email,senha)values(?,?,?,?)";
		PreparedStatement prepareStatement = conec.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
		prepareStatement.setInt(1, idAdministrador);
		prepareStatement.setString(2, administrador.getNome());
		prepareStatement.setString(3, administrador.getEmail());
		prepareStatement.setString(4, administrador.getSenha());
	
		
		
		prepareStatement.execute();
		idAdministrador++;

	}

	public void remover(Administrador administrador) throws SQLException {
		String sql = "delete from administrador where idAdministrador = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, administrador.getId());
		
		prepareStatement.executeUpdate();

	}

	public void atualizar(Administrador administrador) throws SQLException {
		
		String sql = "update administrador set nome = ?,email = ?,senha = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
		prepareStatement.setString(1, administrador.getNome());
		prepareStatement.setString(2, administrador.getEmail());
		prepareStatement.setString(3, administrador.getSenha());
		
		
		
		prepareStatement.executeUpdate();
	}

	public Administrador procurar(Administrador administrador) throws SQLException {
		String sql = "select*from Administrador where idAdministrador = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, administrador.getId());
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			String nome = resultadoBusca.getString(1);
			String email = resultadoBusca.getString(2);
			String senha = resultadoBusca.getString(3);
			
			Administrador administrador1 = new Administrador();
			administrador1.setNome(nome);
			administrador1.setEmail(email);
			administrador1.setSenha(senha);
			
			return administrador1;
		}
		return null;
	}

	public ArrayList<Administrador> listar() throws SQLException {
        ArrayList<Administrador> lista = new ArrayList<Administrador>();
		
        String sql = "select*from Administrador";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
		
		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while(resultadoBusca.next()){
			String nome = resultadoBusca.getString(1);
			String email = resultadoBusca.getString(2);
			String senha = resultadoBusca.getString(3);
			
			Administrador administrador1 = new Administrador();
			administrador1.setNome(nome);
			administrador1.setEmail(email);
			administrador1.setSenha(senha);
			lista.add(administrador1);
		
		}
		
		return lista;
	}	
	
	public boolean consultar(String usuario, String senha) throws ClassNotFoundException, SQLException {
		boolean autenticado = false;
		String sql = null;
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		
        
        
        sql = "select*from administrador where email = ? and senha = ?";
        PreparedStatement stmt;	
        
        try {
			stmt = (PreparedStatement) conec.prepareStatement(sql);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
 
            ResultSet rs;
            rs = stmt.executeQuery();
 
            while (rs.next()) {
                String loginBanco = rs.getString(1);
                String senhaBanco = rs.getString(2);
                if((loginBanco.equals(usuario))&&(senhaBanco.equals(senha))){
                	autenticado = true;
                	break;
                }
            }
            
            stmt.close();
   
 
            return autenticado;
 
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar Usuario/ senha.");
            throw new RuntimeException();
        }
        
	}	


}