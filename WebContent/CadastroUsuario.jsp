<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PrefeitureApp</title>
<style>
body{ 
	  background: #E4F1FE;
	  font-family: "Tahoma";
	  width: 360px;
  	  padding: 2% 0 0;
      margin: auto;
}
form{
  position: relative;
  z-index: 1;
  background: #FFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);

}
img{
	width: 150px;
	height: 100px;
	padding:5px;
	border-radius: 25px;
	margin: auto;
	border:3px solid #448ed3;
	display: block;
	margin-bottom: 10px;
	
    
}

form input{
  font-family: "Tahoma", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

form button{
  font-family: "Tahoma", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #448ed3;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  cursor: pointer;
}

form button:hover{
	background-color: #3D7FBD; 
}

a{
  margin: 15px 0 0;
  color: #3D7FBD;
  font-size: 16px;	
  text-decoration: none;
}

</style>

<!--<link rel="stylesheet" type="text/css" href="StyleCadastroUsuario.css">-->
</head>
<body>

<div class="cadastro">
<img src="img/prefeitur1.jpeg">	
   <form method="post" action="CadastroServlet"/>
      <input type="text" placeholder="Nome" name="nome"/><br>
      <input type="text" placeholder="Telefone" name="telefone"/><br>
      <input type="email" placeholder="Email" name="email"/><br>
      <input type="password" placeholder="Senha" name="senha"/><br>
      <button>Cadastrar</button><br><br>
      <a href="Index.jsp">Sou um usu�rio!</a>
    </form>
</div>
</body>
</html>