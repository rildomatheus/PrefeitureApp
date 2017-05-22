<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PrefeitureApp</title>

<link rel="stylesheet" type="text/css" href="StyleCadastroUsuario.css">
</head>
<body>

<div class="cadastro">
<img src="img/im.png">
   <form method="post" action="CadastroServlet"/>
      <input type="text" placeholder="Nome" name="nome"/><br>
      <input type="text" placeholder="Telefone" name="telefone"/><br>
      <input type="email" placeholder="Email" name="email"/><br>
      <input type="password" placeholder="Senha" name="senha"/><br>
      <button>Cadastrar</button>
    </form>
</div>
</body>
</html>