package com.fafica.crud;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioDenuncia {
	
	public void cadastrar(Denuncia denuncia) throws SQLException;
	public void remover(Denuncia denuncia) throws SQLException;
	public void atualizar(Denuncia denuncia) throws SQLException;
	public Denuncia procurar(Denuncia denuncia) throws SQLException;
	public ArrayList<Denuncia> listar() throws SQLException;

}
