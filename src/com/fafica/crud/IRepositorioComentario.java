package com.fafica.crud;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.entidades.Comentario;

public interface IRepositorioComentario {
	
	public void cadastrarComentario(Comentario comentario) throws SQLException;
	public void removerComentario(int id) throws SQLException;
	public void atualizarComentario(Comentario comentario) throws SQLException;
	public Comentario procurarComentario(Comentario comentario) throws SQLException;
	public ArrayList<Comentario> listarComentario() throws SQLException;
	public Comentario procurarId(int id) throws SQLException;

}
