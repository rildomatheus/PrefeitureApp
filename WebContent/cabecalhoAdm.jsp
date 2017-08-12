
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.fafica.entidades.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css" media="screen">
<style>
#pesquisa{
layout: inline-block;
position:absolute;
left:0%;
padding-left: 250px;
margin: 5px 0px 0px 200px;
right: 35%;

}
#barraPesquisa {
	border-radius: 5px;
	border: 1px solid #448ed3;
	width: 70%;
	position: relative;
	left: 0px;
	right: 80px;
	padding-left: 3px;
	margin-left:16px;
}
body{
padding: 0px;
margin: 0px;}
</style>
</head>
<body>
	<%  HttpSession sessao = request.getSession();
	Usuario usuarioAutenticado = (Usuario) sessao.getAttribute("usuarioAutenticado"); 
	if(usuarioAutenticado != null){%>
	<form  id="pesquisa" method="post" action="PesquisarDenunciaServlet"> 
		<input id="barraPesquisa" type="text" placeholder= "Pesquisar" name="pesquisa">
	</form>
	<div id="navegacao">
		<nav id="menu">
			<ul id="nav">
				<li class="selected"><a href="TelaPrincipal.jsp">Tela principal</a></li>
				<li class="selected"><a href="CadastroDenuncia.jsp">Cadastrar denúncia</a></li>
				<!-- <li class="selected"><a href="UsuariosServlet.jsp">Usuários</a></li>-->
				<li class="selected"><a href="IndexServlet">Sair</a></li>
			</ul>
		</nav>
	</div>
	<%}else{ %>
	<div id="navegacao">
		<nav id="menu">
			<ul id="nav">
				<li class="selected"><a href="TelaPrincipal.jsp">Tela principal</a></li>
				<li class="selected"><a href="CadastroDenuncia.jsp">Cadastrar denúncia</a></li>
				<li class="selected"><a href="UsuariosServlet.jsp">Usuários</a></li>
				<li class="selected"><a href="IndexServlet">Fazer login</a></li>
			</ul>
		</nav>
	</div><%} %>

</body>
</html>