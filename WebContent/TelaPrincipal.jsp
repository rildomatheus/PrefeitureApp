<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.fafica.crud.RepositorioDenuncia"%>
<%@ page import="com.fafica.crud.Denuncia"%>
<link rel="stylesheet" type="text/css" href="StyleTelaPrincipal.css">

<html lang="en">
<head>
<meta charset="utf-8" />
<title>Denúncias</title>
<meta name="viewport"
	content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
</head>
<%
	RepositorioDenuncia repositorioDenuncia = new RepositorioDenuncia();
	List<Denuncia> denuncias = new ArrayList<Denuncia>();
	denuncias = repositorioDenuncia.listar();
%>

<body>
	<div class="table-title">
		<h3>Data Table</h3>
	</div>
	<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">Setor</th>
				<th class="text-left">Bairro</th>
				<th class="text-left">Cidade</th>
				<th class="text-left">Descrição</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<%
				for (Denuncia denuncia : denuncias) {
			%>
			<tr>
				<td class="text-left"><%=denuncia.getSetor()%></td>
				<td class="text-left"><%=denuncia.getBairro()%></td>
				<td class="text-left"><%=denuncia.getCidade()%></td>
				<td class="text-left"><%=denuncia.getDescricao()%></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>


</body>