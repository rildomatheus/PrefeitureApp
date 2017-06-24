package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.IRepositorioUsuario;
import com.fafica.crud.RepositorioUsuario;
import com.fafica.entidades.Denuncia;
import com.fafica.entidades.Usuario;

/**
 * Servlet implementation class EditarUsuario
 */
@WebServlet("/EditarUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    IRepositorioUsuario repositorio;
	
    public EditarUsuario() {
        super();
        this.repositorio = new RepositorioUsuario();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		String i = request.getParameter("i");
		if(i != null && i != " "){
			int id = Integer.parseInt(i);
			this.repositorio = RepositorioUsuario.getInstance();
			 try {
				 
				usuario = repositorio.procurarId(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		request.setAttribute("usuario", usuario);
		dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		this.repositorio = RepositorioUsuario.getInstance();
		try {
			repositorio.cadastrarUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("CadastroDenuncia.jsp");
	}

}
