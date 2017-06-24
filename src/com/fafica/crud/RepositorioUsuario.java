package com.fafica.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.entidades.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario {

	private Connection conec;
	private static RepositorioUsuario instance;

	public RepositorioUsuario() {
		Conect conexao = new Conect();
		this.conec = conexao.getConnection();
	}

	public static RepositorioUsuario getInstance() {
		if (instance == null) {
			instance = new RepositorioUsuario();
		}
		return instance;
	}

	public void cadastrarUsuario(Usuario usuario) throws SQLException {
		String sql = "insert into usuario(nome,telefone,email,senha)values(?,?,?,?)";
		PreparedStatement prepareStatement = conec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		prepareStatement.setString(1, usuario.getNome());
		prepareStatement.setString(2, usuario.getTelefone());
		prepareStatement.setString(3, usuario.getEmail());
		prepareStatement.setString(4, usuario.getSenha());

		prepareStatement.execute();

	}

	public void removerUsuario(int id) throws SQLException {
		String sql = "delete from usuario where idusuario = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, id);

		prepareStatement.executeUpdate();

	}

	public void atualizar(Usuario usuario) throws SQLException {

		String sql = "update usuario set nome = ?,telefone = ?,email = ?,senha = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);

		prepareStatement.setString(1, usuario.getNome());
		prepareStatement.setString(2, usuario.getTelefone());
		prepareStatement.setString(3, usuario.getEmail());
		prepareStatement.setString(4, usuario.getSenha());

		prepareStatement.executeUpdate();
	}

	public Usuario procurar(Usuario usuario) throws SQLException {
		String sql = "select*from usuario where idusuario = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, usuario.getIdUsuario());

		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while (resultadoBusca.next()) {
			String nome = resultadoBusca.getString(1);
			String telefone = resultadoBusca.getString(2);
			String email = resultadoBusca.getString(3);
			String senha = resultadoBusca.getString(4);

			Usuario usuario1 = new Usuario();
			usuario1.setNome(nome);
			usuario1.setTelefone(telefone);
			usuario1.setEmail(email);
			usuario1.setSenha(senha);

			return usuario1;
		}
		return null;
	}

	public ArrayList<Usuario> listarUsuario() throws SQLException {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		String sql = "select*from usuario";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);

		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while (resultadoBusca.next()) {
			String nome = resultadoBusca.getString(1);
			String telefone = resultadoBusca.getString(2);
			String email = resultadoBusca.getString(3);
			String senha = resultadoBusca.getString(4);

			Usuario usuario1 = new Usuario();
			usuario1.setNome(nome);
			usuario1.setTelefone(telefone);
			usuario1.setEmail(email);
			usuario1.setSenha(senha);
			lista.add(usuario1);

		}

		return lista;
	}

	public boolean consultar(String usuario, String senha) throws ClassNotFoundException, SQLException {
		boolean autenticado = false;
		String sql = null;
		// PreparedStatement prepareStatement = conec.prepareStatement(sql);

		// fui pegar um biscoito - ii entao doidao. tbm peguei biscoito:)

		sql = "select*from usuario where email = ? and senha = ?";
		PreparedStatement stmt;

		try {
			stmt = (PreparedStatement) conec.prepareStatement(sql);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);

			ResultSet rs;
			rs = stmt.executeQuery();

			while (rs.next()) {
				String loginBanco = rs.getString(4);
				String senhaBanco = rs.getString(5);
				if ((loginBanco.equals(usuario)) && (senhaBanco.equals(senha))) {
					autenticado = true;
					break;
				}
			}

			stmt.close();

			return autenticado;

		} catch (SQLException ex) {
			System.out.println("Erro ao recuperar cliente/ senha.");
			throw new RuntimeException();
		}

	}
	
	public Usuario procurarId(int id) throws SQLException{
		String sql = "select*from usuario where idusuario = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, id);

		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while (resultadoBusca.next()) {
			String nome = resultadoBusca.getString(1);
			String telefone = resultadoBusca.getString(2);
			String email = resultadoBusca.getString(3);
			String senha = resultadoBusca.getString(4);

			Usuario usuario1 = new Usuario();
			usuario1.setNome(nome);
			usuario1.setTelefone(telefone);
			usuario1.setEmail(email);
			usuario1.setSenha(senha);

			return usuario1;
		}
		return null;
	}

}
