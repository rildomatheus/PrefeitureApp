package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fafica.crud.IRepositorioDenuncia;
import com.fafica.crud.RepositorioDenuncia;
import com.fafica.crud.RepositorioUsuario;
import com.fafica.entidades.Denuncia;

/**
 * Servlet implementation class CadastroDenunciaServlet
 */
@WebServlet("/CadastroDenunciaServlet")
public class CadastroDenunciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IRepositorioDenuncia repositorio;
	
    public CadastroDenunciaServlet() {
        super();
        repositorio = new RepositorioDenuncia();
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
		String titulo = request.getParameter("titulo");
		String setor = request.getParameter("setor");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String descricao = request.getParameter("descricao"); 
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
		Denuncia denuncia = new Denuncia();
		denuncia.setTitulo(titulo);
		denuncia.setSetor(setor);
		denuncia.setCidade(cidade);
		denuncia.setBairro(bairro);
		denuncia.setDescricao(descricao);
		denuncia.setIdUsuario(idUsuario);
		
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		
		try {
			repositorio.cadastrar(denuncia);
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
