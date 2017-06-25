package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.RepositorioComentario;
import com.fafica.crud.RepositorioUsuario;
import com.fafica.entidades.Comentario;
import com.fafica.entidades.Usuario;

/**
 * Servlet implementation class ExcluirComentario
 */
@WebServlet("/ExcluirComentario")
public class ExcluirComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comentario comentario = new Comentario();
		RepositorioComentario repositorio = new RepositorioComentario();
		
		String acao = request.getParameter("acao");
		
		 if(acao != null && acao.equals("ex")){
			 String descricao  = request.getParameter("descricao");
			 comentario.setDescricao(descricao);
			 try {
				 repositorio.removerComentario(comentario);
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
