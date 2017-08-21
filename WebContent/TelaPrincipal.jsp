<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.fafica.crud.RepositorioUsuario"%>
<%@page import="com.fafica.crud.RepositorioDenuncia"%>
<%@page import="com.fafica.entidades.Usuario"%>
<%@page import="com.fafica.entidades.Comentario"%>
<%@page import="com.fafica.crud.RepositorioComentario"%>
<%@page import="com.fafica.entidades.Denuncia"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Denúncias</title>
<meta name="viewport"
	content="initial-scale=1.0, maximum-scale=1.0, width=device-width">
<link rel="stylesheet" type="text/css" href="w3.css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">

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
	font-family: 'Lato', sans-serif !important;
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
    border: 1px solid #b7b7b7;
    width: 70%;
    position: relative;
    left: 0px;
    right: 60px;
    /* padding-left: 3px; */
    margin-bottom: 15px;
    margin-left: 16px;
    padding: 5px;
    padding-left: 15px;
    box-shadow: 1px 1px 10px #ccc;
}

button {
	margin-left: 10%;
    border-radius: 5px;
    background-color: #2196f3;
    position: relative;
    right: 60px;
    padding: 4px;
    border: none;
    color: #FFFFFF;
    height: 35px;
    top: -0.1px;
    border-bottom-left-radius: 0;
    border-top-left-radius: 0;
}

form {
	margin-top: 15px;
}

#creu {
	background-color: white;
	padding-bottom: 15px;
}

.comentario {
	padding-top: 3px;
	padding-left: 10px;
	border: 1px solid #e2e2e2
}

.comentario:hover {
	background-color: #f5f3f3;
}

.comentario a:hover {
	text-decoration: none;
}

.comentario a {
	color: #000;
	margin-top: 8px;
	font-weight: bold;
	margin-top: 5px;
	text-decoration: none;
}

.comentario a:visited {
	color: #000;
}

.comentario p {
	margin: 0px 0px 0px 10px;
	color:#000;
}

#usuarioAnonimo {
	color: #2D292F;
	font-weight: bold;
	margin-left: 0px;
}

.w3-blue {
	padding: 0px;
}

h1 {
/*
	padding-left: 16px;
	display: inline-block;
	position: absolute;
	*/
}

.direita {
	float: right;
	margin-right: 3px;
	padding: 0px;
	visibility: hidden;
	text-decoration: none;
}

.comentario:hover .direita {
	visibility: visible;
}

.imagens-camera {
	width: 32px;
	box-shadow: 0 0 0 0;
	border: 0 none;
	outline: 0;
}

#botoes-camera {
/*
	position: relative;
	margin-left: 75%;
	margin-top: 25px;
	margin-bottom: 20px;
*/
}

.modal {
	text-align: center;
	position: fixed;
	font-family: Arial, Helvetica, sans-serif;
	top: 50;
	right: auto;
	bottom: auto;
	left: auto;
	background: rgba(0, 0, 0, 0.8);
	z-index: 99999;
	opacity: 0;
	-webkit-transition: opacity 400ms ease-in;
	-moz-transition: opacity 400ms ease-in;
	transition: opacity 400ms ease-in;
	pointer-events: none;
}

.modal:target {
	opacity: 1;
	pointer-events: auto;
}

.modal>div {
	width: 400px;
	position: relative;
	margin: 10% auto;
	padding: 5px 20px 13px 20px;
	border-radius: 10px;
	background: #fff;
	background: -moz-linear-gradient(#fff, #999);
	background: -webkit-linear-gradient(#fff, #999);
	background: -o-linear-gradient(#fff, #999);
}

.fechar {
	background: #606061;
	color: #FFFFFF;
	line-height: 25px;
	position: absolute;
	right: 12px;
	text-align: center;
	top: 10px;
	width: 24px;
	font-weight: bold;
	-webkit-border-radius: 12px;
	-moz-border-radius: 12px;
	border-radius: 12px;
	-moz-box-shadow: 1px 1px 3px #000;
	-webkit-box-shadow: 1px 1px 3px #000;
	box-shadow: 1px 1px 3px #000;
}

.fechar:hover {
	background: #00d9ff;
	text-decoration: none;
}

#imgExibi {
	border-radius: 5px;
	cursor: pointer;
	transition: 0.1s;
	margin-left: auto;
	margin-right: auto;
	padding-left: 20px;
	padding-right: 20px;
	padding-bottom: 10px;
	width: 100%;
}

.header-items {
	display: flex !important;
	justify-content: center !important;
	flex-direction: column !important;
	border-bottom: 1px solid #dcd8d8 !important;
	color: #000000;
	
}

.titulo-item{
    display: flex !important;
    justify-content: center !important;
}

.w3-blue, .w3-hover-blue:hover{
	background-color: rgba(216, 216, 216, 0.98) !important;
}


.icons-header-items{
	display: flex !important;
    justify-content: center !important;
    margin-top: -20px !important;
}

.test:after {
  content: '\2807';
  font-size: 3em;
  color: #2e2e2e
}
.dropdown {
  position: absolute;
  display: inline-block;
  border: none;
  height: 62px;
  width: 25px;
  margin-bottom: 26px;
  right: 10px;
}
.dropdown a:hover{
	text-decoration: none;
}
.menu {
  padding: 15px;
  display: none;
  position: absolute;
  border: 1px solid gray;
  z-index: 1;
}
.menu a {
  padding: 15px;
  display: block;
  width: 150px;
  background-color: white;
  border: 1px solid black;
}

.menu a:hover{
background-color: #B4B9B4;
}
.dropdown:hover {
  background-color: #B4B9B4;
}
.dropdown:hover .menu {
  display: block;
}

.cores-comentarios{
	background-color: #FFFFFF !important;
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
		System.out.println(usuarioAutenticado);
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

			//Pendente == Azul (Respondido)
			//Resolvido == Verde (Prefeitura resolve)
			//Bloqueado == vermelho (Prefeitura não respondeu)
	%>

	<div class="w3-container">

		<%
			if (denuncia.getStatus().equals("Pendente")) {
		%>
		<div class="w3-card-4" style="width: 40%;
		box-shadow:0px 0px 6px rgb(180, 185, 180), 0 3px 6px rgba(0,0,0,0.23);">
		<header class="w3-container w3-blue">
			<%
				}
			%>
			<%
				if (denuncia.getStatus().equals("Resolvido")) {
			%>
			<div class="w3-card-4" style="width: 40%;
		box-shadow:0px 0px 6px rgb(180, 185, 180), 0 3px 6px rgba(0,0,0,0.23);">
				<header class="w3-container w3-green">
				<%
					}
				%>
				<%
					if (denuncia.getStatus().equals("Problema")) {
				%>
				<div class="w3-card-4" style="width: 40%;
		box-shadow: 0px 0px 6px rgb(180, 185, 180), 0 3px 6px rgba(0,0,0,0.23);">
		<header class="w3-container w3-red">
					<%
						}
					%>
						<div class="header-items">
							<div class="titulo-item">
								<h1><%=denuncia.getTitulo()%></h1>
							</div>
							
							
							<%if((!usuarioAutenticado.getTipo().equals("Anonimo")) && usuarioAutenticado.getIdUsuario() == denuncia.getIdUsuario()){ %>
							<div class="dropdown">
									<a href=""><div class="test"></div></a>
									<div class="menu">
										<a href="Upload-Imagem.jsp?idDenuncia=<%=denuncia.getIdDenuncia()%>"> Enviar Imagem </a> 
										<a href="#"> Enviar Vídeo </a> 
										<a href="EditarDenuncia.jsp?idDenuncia=<%=denuncia.getIdDenuncia()%>"> Editar </a>
								</div>
							</div>
							<%} %>
							<%if(usuarioAutenticado.getTipo().equals("Administrador")){ %>
								<div class="dropdown">
									<a href=""><div class="test"></div></a>
									<div class="menu">
										<a href="TrocaStatus.jsp?idDenuncia=<%=denuncia.getIdDenuncia()%>"> Mudar status </a>
								</div>
							</div>
							<%} %>
							
							
							
							<!--
							<div class="icons-header-items">
								 <form id="botoes-camera" action="Upload-Imagem.jsp">
									<input type="hidden" id="idDenuncia" name="idDenuncia"
										value="<%=denuncia.getIdDenuncia()%>" /> <input
										class="imagens-camera" type="image" src="img/camera-foto.png"
										alt="Submit" width="32" height="32"> <input
										class="imagens-camera" type="image" src="img/camera-video.png"
										alt="Submit" width="32" height="32">
								</form>
							</div> -->

						</div>
						
					</header>

					<div class="w3-container" id="creu">
						<ul>
							<li><b>Setor: </b><%=denuncia.getSetor()%></li>
							<li><b>Cidade: </b><%=denuncia.getCidade()%></li>
							<li><b>Bairro: </b><%=denuncia.getBairro()%></li>
							<li><b>Descricao: </b><%=denuncia.getDescricao()%></li>
						</ul>
						<%
							if (denuncia.getFoto() != null) {
						%>
						<a href="#abrirModal<%=denuncia.getIdDenuncia()%>"> <img
							id="imgExibi" src="<%=denuncia.getFoto()%>" width="200"
							height="150"></a>

						<div id="abrirModal<%=denuncia.getIdDenuncia()%>" class="modal">

							<!-- conteúdo do modal aqui -->
							<a href="#fechar" title="Fechar" class="fechar">x</a> <img
								src="<%=denuncia.getFoto()%>">
								
								<video src="" width="" height=""></video>

						</div>
						<%
							}
						%>
					</div>


					<footer class="w3-blue cores-comentarios">
						<%
							for (Comentario comentario : comentarios) {
									if (denuncia.getIdDenuncia() == comentario.getIdDenuncia()) {
						%>
						<%
							if (comentario.getIdUsuario() != 0) {
											Usuario usuario = repositorioUsuario.procurar(comentario.getIdUsuario());
						%>
						<div class="comentario">
							<%
								if (usuarioAutenticado.getTipo().equals("Administrador")  || (usuarioAutenticado.getIdUsuario() == comentario.getIdUsuario() && usuarioAutenticado.getIdUsuario() != 0)) {
							%>
							<div class="direita">
								<a
									href="ExcluirComentario?idComentario=<%=comentario.getIdComentario()%>&idUsuario=<%=usuarioAutenticado.getIdUsuario()%>">X</a>
							</div>
							<%
								}
							%>
							<a href="listarUsuario.jsp?idUsuario=<%=usuario.getIdUsuario()%>"><%=usuario.getNome()%></a>
							<p class="descricao"><%=comentario.getDescricao()%></p>

						</div>
						<%
							} else {
						%>
						<div class="comentario">
							<%
								if (usuarioAutenticado.getTipo().equals("Administrador")) {
							%>
							<div class="direita">
								<a
									href="ExcluirComentario?idComentario=<%=comentario.getIdComentario()%>&idUsuario=<%=usuarioAutenticado.getIdUsuario()%>">X</a>
							</div>
							<%
								}
							%>
							<p id="usuarioAnonimo">Usuario Anônimo</p>
							<p class="descricao"><%=comentario.getDescricao()%>
							</p>

						</div>
						<%
							}

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
								value="<%=denuncia.getIdDenuncia()%>"> <input
								type="text" name="descricao" required="required"
								placeholder="Escreva um comentário..." />
							<button>Enviar</button>
						</form>
					</footer>

				</div>

			</div>

			<%
				sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);
				}
			%>
			
			<!-- 
			<script>
				// Get the modal
				var modal = document.getElementById('myModal');

				// Get the image and insert it inside the modal - use its "alt" text as a caption
				var img = document.getElementById('myImg');
				var modalImg = document.getElementById("img01");
				var captionText = document.getElementById("caption");
				img.onclick = function() {
					modal.style.display = "block";
					modalImg.src = this.src;
					captionText.innerHTML = this.alt;
				}

				// Get the <span> element that closes the modal
				var span = document.getElementsByClassName("close")[0];

				// When the user clicks on <span> (x), close the modal
				span.onclick = function() {
					modal.style.display = "none";
				}
			</script> -->
</body>
</html>