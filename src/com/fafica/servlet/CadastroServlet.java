package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fafica.crud.IRepositorioUsuario;
import com.fafica.crud.RepositorioUsuario;
import com.fafica.entidades.Usuario;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private IRepositorioUsuario repositorio;
    public CadastroServlet() {
        super();
        repositorio = new RepositorioUsuario();
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
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipo("Comum");
		
		this.repositorio = RepositorioUsuario.getInstance();
		try {
			repositorio.cadastrarUsuario(usuario);
			RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
			Usuario usuarioAux = repositorioUsuario.consultar(usuario.getEmail(), usuario.getSenha());
			if(usuario != null){
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioAutenticado", usuarioAux);
				request.getRequestDispatcher("TelaPrincipal.jsp").forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
