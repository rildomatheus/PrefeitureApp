<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Denuncia</title>

<link rel="stylesheet" type="text/css" href="cad-denuncia.css">
</head>
<body>
	<form method="post"action="CadastroDenunciaServlet">
	<h3>Em qual setor � a sua den�ncia?</h3>
	
	<div class="setor">
		<input type="radio" name="setor" value="hidrico"> Hidrico
		<input type="radio" name="setor" value="saneamento basico"> Saneamento b�sico
		<input type="radio" name="setor" value="iluminacao"> Ilumina��o
		<input type="radio" name="setor" value="saude"> Sa�de
	</div>
	
	<div class="endereco">
		<input type="text" placeholder="cidade">
		<input type="text" placeholder="bairro">
	</div>
	
	<div class="descricao">
		<h3>Descri��o do problema</h3>
		<textarea rows="10" cols="40"></textarea>
	</div>
	
	<button>Denunciar</button>
	</form>
</body>
</html>