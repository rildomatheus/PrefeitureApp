<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.fafica.crud.RepositorioUsuario"%>
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
	padding-bottom: 15px;
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
padding-left: 16px;
text-align:center;}

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

.imagens-camera{
width: 32px;

}

#botoes-camera{
    position: relative;
    margin-left: 75%;
    margin-top: 25px;
    margin-bottom: 20px;
}


.modal {
text-align: center;
position: fixed;
font-family: Arial, Helvetica, sans-serif;
top: 50;
right: auto;
bottom: auto;
left: auto;
background: rgba(0,0,0,0.8);
z-index: 99999;
opacity:0;
-webkit-transition: opacity 400ms ease-in;
-moz-transition: opacity 400ms ease-in;
transition: opacity 400ms ease-in;
pointer-events: none;
}

.modal:target {
opacity:1;
pointer-events: auto;
}

.modal > div {
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

.fechar:hover { background: #00d9ff; 
text-decoration:none;}

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
    
</style>


</head>
<body>
	<%
		
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();

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

	

<h1> Nenhuma denuncia foi encontrada! </h1>
</body>
</html>