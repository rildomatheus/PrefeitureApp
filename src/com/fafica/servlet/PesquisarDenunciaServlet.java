package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.RepositorioDenuncia;
import com.fafica.entidades.Denuncia;

/**
 * Servlet implementation class PesquisarDenunciaServlet
 */
@WebServlet("/PesquisarDenunciaServlet")
public class PesquisarDenunciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private RepositorioDenuncia repositorioDenuncia;
    public PesquisarDenunciaServlet() {
        super();
        repositorioDenuncia = new RepositorioDenuncia();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("pesquisa");
		
		try {
			Denuncia denuncia = repositorioDenuncia.procurar(titulo);
			if(denuncia.getTitulo()!= null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("TelaPesquisa.jsp");
				request.setAttribute("denuncia", denuncia);
				dispatcher.forward(request, response);
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("NadaEncontrado.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
