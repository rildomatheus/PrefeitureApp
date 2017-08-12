<%@page import="com.fafica.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Denuncia</title>

<link href='http://fonts.googleapis.com/css?family=OpenSans:300,400,700' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
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
	<section>
	
	<div class="formulario"> 
	
	<form method="post"action="CadastroDenunciaServlet" id="validate">
	
				<div class="endereco">
				<label>T�tulo</label>
                <input type="text" name="titulo" class="g">

                <label>Cidade</label>
                <input type="text" name="cidade" class="g">

                <label>Bairro</label>
                <input type="text" name="bairro" class="g">
                </div>	
                
                <div class="setor">
                
                <ul>
                	<p>Em qual setor � a sua den�ncia?</p>
                    <li><input type="radio" name="setor" value="H�drico">H�drico</li>
                    <li><input type="radio" name="setor" value="Saneamento b�sico">Saneamento b�sico</li>
                    <li><input type="radio" name="setor" value="Ilumina��o">Ilumina��o</li>
                    <li><input type="radio" name="setor" value="Sa�de">Sa�de</li>
                </ul>
                </div>
				
				<div class="descricao">
                <label>Descri��o do problema</label>
                <textarea name="descricao" cols="10" rows="5" class="g"></textarea>
                </div>

	<input type="hidden" name="idUsuario" value="<%=usuarioAutenticado.getIdUsuario()%>"/>
	<input type="submit" value="Cadastrar">
	</form>
</div>
</section>	
</body>
</html>