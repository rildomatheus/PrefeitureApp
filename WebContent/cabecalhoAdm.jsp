
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.fafica.entidades.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css" media="screen">
</head>
<body>
	<%  HttpSession sessao = request.getSession();
	Usuario usuarioAutenticado = (Usuario) sessao.getAttribute("usuarioAutenticado"); 
	if(usuarioAutenticado != null){%>
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