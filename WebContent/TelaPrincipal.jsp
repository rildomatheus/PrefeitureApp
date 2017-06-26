<%@page import="com.fafica.crud.RepositorioUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.fafica.crud.RepositorioDenuncia"%>
<%@ page import="com.fafica.entidades.Usuario"%>
<%@ page import="com.fafica.entidades.Comentario"%>
<%@ page import="com.fafica.crud.RepositorioComentario"%>
<%@ page import="com.fafica.entidades.Denuncia"%>
<link rel="stylesheet" type="text/css" href="w3.css">

<html lang="en">
<head>
<meta charset="utf-8" />
<title>Denúncias</title>
<meta name="viewport"
	content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">

<style media="screen">
#denuncia {
	display: block;
	width: 70%;
	height: 300px;
	padding-top: 2cm;
	flex-direction: column;
}

body {
	background-color: white;
}

.w3-container {
	width: 100%;
	position: relative;
	background-color: #ebeae9;
}

.w3-card-4 {
	width: 50%;
	left: 33%;
	position: relative;
	margin-bottom: 20px;
}

input {
	border-radius: 5px;
	border: 1px solid #448ed3;
	width: 70%;
	position: relative;
	left: 0px;
	right: 60px;
	padding-left: 3px;
	margin-left:16px;
}

button {
	margin-left: 10%;
	border-radius: 5px;
	background-color: white;
	position: relative;
	right: 0px;
}

form {
	margin-top: 15px;
}

#creu {
	background-color: white;
}

.comentario{
padding-top: 3px;
padding-left: 10px;
border: 1px solid #448ed3;}

.comentario:hover{
	background-color: #448ed3
}
.comentario a:hover{
text-decoration: none;}

.comentario a{
	color: white;
	margin-top: 8px;
	font-weight: bold;
	margin-top: 5px;
	text-decoration: none;
}
.comentario a:visited{
color:white;}

.comentario p{
	margin: 0px 0px 0px 10px;
}
#usuarioAnonimo{
	color: white;
	font-weight: bold;
	margin-left: 0px;
}
.w3-blue{
padding: 0px;}

h1{
padding-left: 16px;}

.direita{
float:right;
margin-right: 3px;
padding: 0px;
visibility: hidden;
text-decoration: none;
}

.comentario:hover .direita{
	visibility: visible;
	
}

</style>


</head>
<body>
	<%
		RepositorioDenuncia repositorioDenuncia = new RepositorioDenuncia();
		RepositorioComentario repositorioComentario = new RepositorioComentario();
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();

		List<Denuncia> denuncias = new ArrayList<Denuncia>();
		List<Comentario> comentarios = new ArrayList<Comentario>();

		comentarios = repositorioComentario.listarComentario();
		denuncias = repositorioDenuncia.listar();

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
	%>

	<%
		for (Denuncia denuncia : denuncias) {
	%>

	<div class="w3-container">
		<div class="w3-card-4" style="width: 40%;">
			<header class="w3-container w3-blue">
				<h1><%=denuncia.getTitulo()%></h1>
			</header>

			<div class="w3-container" id="creu">
				<ul>
					<li>Setor: <%=denuncia.getSetor()%></li>
					<li>Cidade: <%=denuncia.getCidade()%></li>
					<li>Bairro: <%=denuncia.getBairro()%></li>
					<li>Descricao: <%=denuncia.getDescricao()%></li>
				</ul>
			</div>

			<footer class="w3-container w3-blue">

				<%
					for (Comentario comentario : comentarios) {
							if (denuncia.getIdDenuncia() == comentario.getIdDenuncia()) {
				%>
				<%
					if (comentario.getIdUsuario() != 0) {
									Usuario usuario = repositorioUsuario.procurar(comentario.getIdUsuario());
				%>
				<div class="comentario">
					<%if(usuarioAutenticado.getTipo().equals("Administrador")){ %>
					<div class="direita"><a href="ExcluirComentario?idComentario=<%=comentario.getIdComentario()%>&idUsuario=<%= usuarioAutenticado.getIdUsuario()%>">X</a></div><%} %>
					<a href="listarUsuario.jsp?idUsuario=<%=usuario.getIdUsuario()%>"><%=usuario.getNome()%></a>
					<p class="descricao"><%=comentario.getDescricao()%></p>
					
				</div>
				<%
					}else{ %>
					<div class="comentario">
					<%if(usuarioAutenticado.getTipo().equals("Administrador")){ %>
						<div class="direita"><a href="ExcluirComentario?idComentario=<%=comentario.getIdComentario()%>&idUsuario=<%= usuarioAutenticado.getIdUsuario()%>"">X</a></div><%} %>
						<p id="usuarioAnonimo">Usuario Anônimo</p>
						<p class="descricao"><%=comentario.getDescricao()%> </p>
						
					</div>
				<% 	}
	
					}
						}
				%>

				<form method="post" action="CadastroComentario">
					<%
						if (usuarioAutenticado.getTipo().equals("Anonimo")) {
					%>
					<input type="hidden" name="idUsuario" value="0">
					<%
						} else {
					%>
					<input type="hidden" name="idUsuario"
						value="<%=usuarioAutenticado.getIdUsuario()%>" />
					<%
						}
					%>
					<input type="hidden" name="idDenuncia"
						value="<%=denuncia.getIdDenuncia()%>"> <input type="text"
						name="descricao" required="required"
						placeholder="Escreva um comentário..." />
					<button>Enviar</button>
				</form>
			</footer>

		</div>

	</div>

	<%
		}
	%>
</body>
</html>