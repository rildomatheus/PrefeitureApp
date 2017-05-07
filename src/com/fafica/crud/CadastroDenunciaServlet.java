package com.fafica.crud;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String setor = request.getParameter("setor");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String descricao = request.getParameter("descricao");
		
		Denuncia denuncia = new Denuncia();
		denuncia.setSetor(setor);
		denuncia.setCidade(cidade);
		denuncia.setBairro(bairro);
		denuncia.setDescricao(descricao);
		
		this.repositorio = RepositorioDenuncia.getInstance();
		try {
			repositorio.cadastrar(denuncia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("CadastroDenuncia.jsp");
		
		
		doGet(request, response);
	}

}