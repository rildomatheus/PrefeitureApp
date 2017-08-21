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
	
				
                <input type="hidden" name="titulo" class="g" value="<%=denuncia.getTitulo()%>">
                <input type="hidden" name="cidade" class="g"value=" <%=denuncia.getCidade()%>">
                <input type="hidden" name="bairro" class="g" value="<%=denuncia.getBairro()%>">
				<input type="hidden" name="setor" value="<%=denuncia.getSetor()%>">
                <input type="hidden" name="descricao" value="<%=denuncia.getDescricao()%>">
                
                <input type="hidden" name="foto" value="<%=denuncia.getFoto()%>">
                <input type="hidden" name="video" value="<%=denuncia.getVideo()%>">
                <input type="hidden" name="idDenuncia" value="<%=denuncia.getIdDenuncia()%>">
                <input type="hidden" name="idUsuario" value="<%=denuncia.getIdUsuario()%>">
                <label>Selecione o Status</label>
                <div class="endereco">
                
                <select name="status" class="descricao">
 					<option value="Pendente">Pendente</option>
  					<option value="Problema">Não Resolvido</option>
  					<option value="Resolvido">Resolvido</option>
				</select></div>

	<input type="hidden" name="idUsuario" value="<%=usuarioAutenticado.getIdUsuario()%>"/>
	<input type="submit" value="Editar">
	</form>
</div>
</section>	
</body>
</html>