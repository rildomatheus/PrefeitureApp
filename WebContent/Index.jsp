<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="StyleIndex.css">
</head>
<body>

<div class="login">
	<img src="img/im.png">
		<form method="post" action="IndexServlet">
			<input type="text" placeholder="Login" name="usuario"/><br>
			<input type="password" placeholder="Senha" name="senha"/>
			<button>Entrar</button><br><br>
			<a href="CadastroUsuario.jsp">Cadastrar-se</a> 
			
		</form>
</div>
</body>
</html>