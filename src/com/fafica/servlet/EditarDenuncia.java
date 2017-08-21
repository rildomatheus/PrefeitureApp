package com.fafica.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
		String status = request.getParameter("status");
		String foto = request.getParameter("foto");
		String video = request.getParameter("video");
		int idDenuncia = Integer.parseInt(request.getParameter("idDenuncia"));
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
		Denuncia denuncia = new Denuncia();
		denuncia.setTitulo(titulo);
		denuncia.setSetor(setor);
		denuncia.setCidade(cidade);
		denuncia.setBairro(bairro);
		denuncia.setDescricao(descricao);
		denuncia.setIdUsuario(idUsuario);
		denuncia.setStatus(status);
		denuncia.setIdDenuncia(idDenuncia);
		denuncia.setFoto(foto);
		denuncia.setVideo(video);
		
		try {
			repositorio.atualizar(denuncia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("TelaPrincipal.jsp");
	
	}

}
