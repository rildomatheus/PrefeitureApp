package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fafica.crud.RepositorioDenuncia;
import com.fafica.entidades.Denuncia;

/**
 * Servlet implementation class UploadImagem
 */
@WebServlet("/uploadImagem")
public class UploadImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RepositorioDenuncia repositorioDenuncia = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImagem() {
        super();
        repositorioDenuncia = new RepositorioDenuncia();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDenuncia = Integer.parseInt(request.getParameter("idDenuncia"));
		String downloadLink = String.valueOf(request.getParameter("downloadUrl"));
		
		try {
			Denuncia denuncia = repositorioDenuncia.procurarId(idDenuncia);
			if(denuncia != null){
				denuncia.setFoto(downloadLink);
				repositorioDenuncia.atualizar(denuncia);
				response.sendRedirect("TelaPrincipal.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
