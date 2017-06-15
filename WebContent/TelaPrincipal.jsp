<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.fafica.crud.RepositorioDenuncia"%>
<%@ page import="com.fafica.crud.Denuncia"%>
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
  		position: relative;
   		width: 70%; 
  		height: 300px; 
   		left: 35%;
   		padding-top: 2cm;
   		flex-direction: column;
	}

	.w3-container {
		width:100%;
	}
</style>	


</head>
<%
	RepositorioDenuncia repositorioDenuncia = new RepositorioDenuncia();
	List<Denuncia> denuncias = new ArrayList<Denuncia>();
	denuncias = repositorioDenuncia.listar();
%>

<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
	<%for(Denuncia denuncia : denuncias){ %>
	<div id="denuncia">
	<div class="w3-container">
		<div class="w3-card-4" style="width: 50%;">
			<header class="w3-container w3-blue">
				<h1><%= denuncia.getTitulo()%></h1>
			</header>

			<div class="w3-container">
				<ul>
					<li>Setor: <%=denuncia.getSetor() %></li>
					<li>Cidade: <%=denuncia.getCidade() %></li>
					<li>Bairro: <%=denuncia.getBairro() %></li>
					<li>Descricao: <%=denuncia.getDescricao() %></li>
				</ul>
			</div>

			<footer class="w3-container w3-blue">
				<a href="TelaPrincipal.jsp"> Comentar </a>
			</footer>
		</div>
	</div>
	
</div>

<%	} %>

</body>