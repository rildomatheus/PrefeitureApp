package com.fafica.crud;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.entidades.Denuncia;

public interface IRepositorioDenuncia {
	
	public void cadastrar(Denuncia denuncia) throws SQLException;
	public void remover(int id) throws SQLException;
	public void atualizar(Denuncia denuncia) throws SQLException;
	public Denuncia procurar(Denuncia denuncia) throws SQLException;
	public ArrayList<Denuncia> listar() throws SQLException;
	public Denuncia procurarId(int id) throws SQLException;

}
