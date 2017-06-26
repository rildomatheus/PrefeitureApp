package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.IRepositorioAdministrador;
import com.fafica.crud.RepositorioAdministrador;
import com.fafica.entidades.Administrador;

/**
 * Servlet implementation class EditarAdministrador
 */
@WebServlet("/EditarAdministrador")
public class EditarAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		IRepositorioAdministrador repositorio;
	
    public EditarAdministrador() {
        super();
        repositorio = new RepositorioAdministrador();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Administrador administrador = new Administrador();
		String i = request.getParameter("i");
		if(i != null && i != " "){
			int id = Integer.parseInt(i);
			this.repositorio = RepositorioAdministrador.getInstance();
			 try {
				 
				administrador = repositorio.procurarId(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		request.setAttribute("administrador", administrador);
		dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Administrador administrador = new Administrador();
		administrador.setNome(nome);
		administrador.setEmail(email);
		administrador.setSenha(senha);
		
		try {
			repositorio.atualizar(administrador);
			response.sendRedirect("CadastroDenuncia.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
