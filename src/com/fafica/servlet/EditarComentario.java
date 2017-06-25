package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.IRepositorioComentario;
import com.fafica.crud.RepositorioComentario;
import com.fafica.entidades.Administrador;
import com.fafica.entidades.Comentario;

/**
 * Servlet implementation class EditarComentario
 */
@WebServlet("/EditarComentario")
public class EditarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
		IRepositorioComentario repositorio;
	
    public EditarComentario() {
        super();
        this.repositorio = new RepositorioComentario();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comentario comentario = new Comentario();
		String i = request.getParameter("i");
		if(i != null && i != " "){
			int id = Integer.parseInt(i);
			this.repositorio = RepositorioComentario.getInstance();
			 try {
				 
				comentario = repositorio.procurarId(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		request.setAttribute("comentario", comentario);
		dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String descricao = request.getParameter("descricao");
		
		
		Comentario comentario = new Comentario();
		comentario.setDescricao(descricao);
		
		this.repositorio = RepositorioComentario.getInstance();
		try {
			repositorio.atualizarComentario(comentario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("TelaPrincipal.jsp");
		doGet(request, response);
	}

}
