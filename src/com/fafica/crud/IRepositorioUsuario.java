package com.fafica.crud;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.entidades.Usuario;

public interface IRepositorioUsuario {
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException;
	public void removerUsuario(Usuario usuario) throws SQLException;
	public void atualizar(Usuario usuario) throws SQLException;
	public Usuario procurar(int idUsuario) throws SQLException;
	public ArrayList<Usuario> listarUsuario() throws SQLException;
	public Usuario procurarId(int id) throws SQLException;

}
