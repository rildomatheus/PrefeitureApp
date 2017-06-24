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
 * Servlet implementation class CadastroAdministradorServlet
 */
@WebServlet("/CadastroAdministradorServlet")
public class CadastroAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IRepositorioAdministrador repositorio;
    
    public CadastroAdministradorServlet() {
       this.repositorio = new RepositorioAdministrador();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			repositorio.cadastra(administrador);
			response.sendRedirect("CadastroDenuncia.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
