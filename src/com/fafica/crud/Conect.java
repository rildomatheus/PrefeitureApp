package com.fafica.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conect {
	
	
	private static volatile Conect instance;
	private Connection conexao;

		private Conect(){
		

		}
		public Connection getConnection(){

			try{
				if(this.conexao == null){
					Class.forName("com.mysql.jdbc.Driver");
					conexao = DriverManager.getConnection("jdbc:mysql://localhost/prefeiture");
					System.out.println("conectei");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			return conexao;
		}

			public static Conect getInstance(){
				if(instance == null){
					synchronized(Conect.class){
						if(instance == null){
							instance = new Conect();
						}
					}
				}
				return instance;
			}

}
