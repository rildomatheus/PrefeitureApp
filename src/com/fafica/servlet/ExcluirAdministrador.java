package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.RepositorioAdministrador;
import com.fafica.crud.RepositorioComentario;
import com.fafica.entidades.Administrador;
import com.fafica.entidades.Comentario;

/**
 * Servlet implementation class ExcluirAdministrador
 */
@WebServlet("/ExcluirAdministrador")
public class ExcluirAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Administrador administrador = new Administrador();
		RepositorioAdministrador repositorio = new RepositorioAdministrador();
		
		String acao = request.getParameter("acao");
		
		 if(acao != null && acao.equals("ex")){
			 String nome  = request.getParameter("nome");
			 administrador.setNome(nome);
			 try {
				 repositorio.remover(administrador);
			 } catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }

			 response.sendRedirect("TelaPrincipal.jsp");
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
