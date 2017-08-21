<%@page import="com.fafica.entidades.Denuncia"%>
<%@page import="com.fafica.entidades.Usuario"%>
<%@page import="com.fafica.crud.RepositorioDenuncia" %>
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
		RepositorioDenuncia repositorioDenuncia = new RepositorioDenuncia();
		Denuncia denuncia = new Denuncia();
		
		int idDenuncia = Integer.parseInt(request.getParameter("idDenuncia"));
		denuncia = repositorioDenuncia.procurarId(idDenuncia);
		
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
	
	<form method="post"action="EditarDenuncia" id="validate">
	
				<div class="endereco">
				<label>Título</label>
                <input type="text" name="titulo" class="g" value="<%=denuncia.getTitulo()%>">

                <label>Cidade</label>
                <input type="text" name="cidade" class="g"value=" <%=denuncia.getCidade()%>">

                <label>Bairro</label>
                <input type="text" name="bairro" class="g" value="<%=denuncia.getBairro()%>">
                </div>
                <div class="setor">
                
                <ul>
                	<p>Em qual setor é a sua denúncia?</p>
                    <li><input type="radio" name="setor" value="Hídrico">Hídrico</li>
                    <li><input type="radio" name="setor" value="Saneamento básico">Saneamento básico</li>
                    <li><input type="radio" name="setor" value="Iluminação">Iluminação</li>
                    <li><input type="radio" name="setor" value="Saúde">Saúde</li>
                </ul>
                </div>	
                <div class="descricao">
                <label>Descrição do problema</label>
                <textarea name="descricao" cols="10" rows="5" class="g"><%=denuncia.getDescricao()%></textarea>
                </div>
                
                <input type="hidden" name="foto" value="<%=denuncia.getFoto()%>">
                <input type="hidden" name="video" value="<%=denuncia.getVideo()%>">
                <input type="hidden" name="status" value="<%=denuncia.getStatus()%>">
                <input type="hidden" name="idDenuncia" value="<%=denuncia.getIdUsuario()%>">
                <input type="hidden" name="idUsuario" value="<%=denuncia.getIdDenuncia()%>">

	<input type="hidden" name="idUsuario" value="<%=usuarioAutenticado.getIdUsuario()%>"/>
	<input type="submit" value="Editar">
	</form>
</div>
</section>	
</body>
</html>