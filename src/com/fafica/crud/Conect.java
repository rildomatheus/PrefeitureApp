package com.fafica.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conect {
	
	
static String url = "jdbc:mysql://localhost/prefeiture";
	
	public static Connection conexaoBanco(){
		try{
			Connection con = DriverManager.getConnection(url,"root","system");
			JOptionPane.showMessageDialog(null, "Execultado com sucesso!");
			return con;
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Conexão com o Banco de Dados Perdida!");
				return null;
			}
	}
	

}
