<%@page import="com.fafica.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Denuncia</title>

<link rel="stylesheet" type="text/css" href="cad-denuncia.css">
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
	%>
	<form method="post"action="CadastroDenunciaServlet">
	
	<h3>Em qual setor � a sua den�ncia?</h3>
	
	<div class="setor">
		<input type="radio" name="setor" value="hidrico"> Hidrico
		<input type="radio" name="setor" value="saneamento basico"> Saneamento b�sico
		<input type="radio" name="setor" value="iluminacao"> Ilumina��o
		<input type="radio" name="setor" value="saude"> Sa�de
	</div>
	
	<div class="endereco">
		<input type="text" placeholder="T�tulo" name="titulo">
		<input type="text" placeholder="Cidade" name="cidade">
		<input type="text" placeholder="Bairro" name="bairro">
		
	</div>
	
	<div class="descricao">
		<h3>Descri��o do problema</h3>
		<textarea rows="10" cols="40" name="descricao"></textarea>
	</div>
	<input type="hidden" name="idUsuario" value="1"/>
	<button>Denunciar</button>
	</form>
</body>
</html>