package com.fafica.crud;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.entidades.Administrador;

public interface IRepositorioAdministrador {
	
	public void cadastra(Administrador administrador) throws SQLException;
	public void remover(Administrador administrador) throws SQLException;
	public void atualizar(Administrador administrador) throws SQLException;
	public Administrador procurar(Administrador administrador) throws SQLException;
	public ArrayList<Administrador> listar() throws SQLException;

}
