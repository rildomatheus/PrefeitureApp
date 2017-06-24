package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.IRepositorioComentario;
import com.fafica.crud.RepositorioComentario;
import com.fafica.entidades.Comentario;
import com.fafica.entidades.Usuario;

/**
 * Servlet implementation class CadastroComentario
 */
@WebServlet("/CadastroComentario")
public class CadastroComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IRepositorioComentario repositorio;
	
    public CadastroComentario() {
        super();
        repositorio = new RepositorioComentario();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			repositorio.cadastrarComentario(comentario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("TelaPrincipal.jsp");
		doGet(request, response);
	}

}
