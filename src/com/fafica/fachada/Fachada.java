package com.fafica.fachada;

import java.sql.SQLException;

import com.fafica.crud.Denuncia;
import com.fafica.crud.RepositorioDenuncia;
import com.fafica.crud.RepositorioUsuario;
import com.fafica.crud.Usuario;

public class Fachada {
	
	private RepositorioUsuario rUsuario;
	private RepositorioDenuncia rDenuncia;
	private static Fachada instance;
	
	public Fachada() throws ClassNotFoundException{
		rUsuario = new RepositorioUsuario();
		rDenuncia = new RepositorioDenuncia();
	}
	
	public static Fachada getInstance(){
		if(instance == null){
			try {
				instance = new Fachada();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return instance;
	}
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException{
		rUsuario.cadastrarUsuario(usuario);
	
	}

	public void cadastrarDenuncia(Denuncia denuncia) throws SQLException{
		rDenuncia.cadastrar(denuncia);
	}
	

}
