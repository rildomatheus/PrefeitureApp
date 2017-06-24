package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.IRepositorioDenuncia;
import com.fafica.crud.RepositorioDenuncia;
import com.fafica.entidades.Denuncia;

/**
 * Servlet implementation class EditarDenuncia
 */
@WebServlet("/EditarDenuncia")
public class EditarDenuncia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    IRepositorioDenuncia repositorio;
	
    public EditarDenuncia() {
        super();
        this.repositorio = new RepositorioDenuncia();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Denuncia denuncia = new Denuncia();
		String i = request.getParameter("i");
		if(i != null && i != " "){
			int id = Integer.parseInt(i);
			this.repositorio = RepositorioDenuncia.getInstance();
			 try {
				 
				denuncia = repositorio.procurarId(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editar.jsp");
		request.setAttribute("denuncia", denuncia);
		dispatcher.forward(request, response);
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
