package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fafica.crud.RepositorioComentario;
import com.fafica.crud.RepositorioUsuario;
import com.fafica.entidades.Comentario;

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
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		
		
		 
			 int idComentario  = Integer.parseInt(request.getParameter("idComentario"));
			 int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			 comentario.setIdComentario(idComentario);
			 try {
				 repositorio.removerComentario(comentario);
				 
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
