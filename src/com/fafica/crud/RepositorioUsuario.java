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
		String sql = "insert into usuario(nome,telefone,email,senha,tipo)values(?,?,?,?,?)";
		PreparedStatement prepareStatement = conec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		prepareStatement.setString(1, usuario.getNome());
		prepareStatement.setString(2, usuario.getTelefone());
		prepareStatement.setString(3, usuario.getEmail());
		prepareStatement.setString(4, usuario.getSenha());
		prepareStatement.setString(5, usuario.getTipo());

		prepareStatement.execute();

	}

	public void removerUsuario(Usuario usuario) throws SQLException {
		String sql = "delete from usuario where idusuario = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, usuario.getIdUsuario());

		prepareStatement.executeUpdate();

	}

	public void atualizar(Usuario usuario) throws SQLException {

		String sql = "update usuario set nome = ?,telefone = ?,email = ?,senha = ?, tipo = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);

		prepareStatement.setString(1, usuario.getNome());
		prepareStatement.setString(2, usuario.getTelefone());
		prepareStatement.setString(3, usuario.getEmail());
		prepareStatement.setString(4, usuario.getSenha());
		prepareStatement.setString(5, usuario.getTipo());

		prepareStatement.executeUpdate();
	}

	public Usuario procurar(int idUsuario) throws SQLException {
		String sql = "select*from usuario where idusuario = ?";
		PreparedStatement prepareStatement = conec.prepareStatement(sql);
		prepareStatement.setInt(1, idUsuario);

		ResultSet resultadoBusca = prepareStatement.executeQuery();
		while (resultadoBusca.next()) {
			int idUsuarioAux = resultadoBusca.getInt(1);
			String nome = resultadoBusca.getString(2);
			String telefone = resultadoBusca.getString(3);
			String email = resultadoBusca.getString(4);
			String senha = resultadoBusca.getString(5);
			String tipo = resultadoBusca.getString(6);

			Usuario usuario1 = new Usuario();
			usuario1.setIdUsuario(idUsuarioAux);
			usuario1.setNome(nome);
			usuario1.setTelefone(telefone);
			usuario1.setEmail(email);
			usuario1.setSenha(senha);
			usuario1.setTipo(tipo);

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
			int idUsuario = resultadoBusca.getInt(1);
			String nome = resultadoBusca.getString(2);
			String telefone = resultadoBusca.getString(3);
			String email = resultadoBusca.getString(4);
			String senha = resultadoBusca.getString(5);
			String tipo = resultadoBusca.getString(6);

			Usuario usuario1 = new Usuario();
			usuario1.setIdUsuario(idUsuario);
			usuario1.setNome(nome);
			usuario1.setTelefone(telefone);
			usuario1.setEmail(email);
			usuario1.setSenha(senha);
			usuario1.setTipo(tipo);
			lista.add(usuario1);

		}

		return lista;
	}

	public Usuario consultar(String usuario, String senha) throws ClassNotFoundException, SQLException {
		Usuario autenticado = null;
		String sql = null;

		sql = "select*from usuario where email = ? and senha = ?";
		PreparedStatement stmt;

		try {
			stmt = (PreparedStatement) conec.prepareStatement(sql);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);

			ResultSet rs;
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idUsuario = rs.getInt(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String loginBanco = rs.getString(4);
				String senhaBanco = rs.getString(5);
				String tipo = rs.getString(6);
				if ((loginBanco.equals(usuario)) && (senhaBanco.equals(senha))) {
					autenticado = new Usuario();
					autenticado.setNome(nome);
					autenticado.setIdUsuario(idUsuario);
					autenticado.setTelefone(telefone);
					autenticado.setSenha(senhaBanco);
					autenticado.setEmail(loginBanco);
					autenticado.setTipo(tipo);
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
