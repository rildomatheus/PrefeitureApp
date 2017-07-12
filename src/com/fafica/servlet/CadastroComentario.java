package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fafica.crud.IRepositorioComentario;
import com.fafica.crud.RepositorioComentario;
import com.fafica.crud.RepositorioUsuario;
import com.fafica.entidades.Comentario;

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
		int idDenuncia = Integer.parseInt(request.getParameter("idDenuncia"));
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
		
		Comentario comentario = new Comentario();
		comentario.setIdDenuncia(idDenuncia);
		comentario.setDescricao(descricao);
		comentario.setIdUsuario(idUsuario);
		
		this.repositorio = RepositorioComentario.getInstance();
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		try {
			repositorio.cadastrarComentario(comentario);
			
			if(idUsuario != 0){
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioAutenticado", repositorioUsuario.procurar(idUsuario));
				request.getRequestDispatcher("TelaPrincipal.jsp").forward(request, response);	
			}else{ response.sendRedirect("TelaPrincipal.jsp");}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
