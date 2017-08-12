<%@page import="com.fafica.crud.RepositorioUsuario"%>
<%@page import="com.fafica.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Denuncia</title>


<style>
	body {
	background-color: white;
	padding: 0px;
	margin: 0px;
}
	.form {
  		background: #ffffff;
  		padding: 40px;
  		max-width: 600px;
  		margin: 40px auto;
  		border-radius: 4px;
  		box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
	}
	.req{
		font-size: 22px;
		font-weight: bold;
		margin: 0px;
  		color: black;
  	}
  	.req2{
  		font-size: 22px;
  		color: black;
  		margin: 5px;
  		
  	}
	
</style>
</head>
<body>
	<%
		HttpSession sessao = request.getSession();
		Usuario usuarioAutenticado = (Usuario) sessao.getAttribute("usuarioAutenticado");

		if (usuarioAutenticado == null) {
			usuarioAutenticado = new Usuario();
			usuarioAutenticado.setTipo("Anonimo");
		}

		if (usuarioAutenticado.getTipo().equals("Administrador")) {
	%>
	<jsp:include page="cabecalhoAdm.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<%
		}
		
		String idUsuario = request.getParameter("idUsuario");
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		Usuario usuario = repositorioUsuario.procurar(Integer.parseInt(idUsuario));
	%>
	<div class="form">
		<h1><%=usuario.getNome() %></h1>
		<p><span class="req">Email: </span><span class="req2"><%=usuario.getEmail() %></span></p>
		<p><span class="req">Telefone: </span><span class="req2"><%=usuario.getTelefone() %></span></p>
	</div>
</body>
</html>