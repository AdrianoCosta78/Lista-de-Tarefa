<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro Novo Usuário</title>
<link rel="stylesheet" href="css/styles.css">

</head>
<body>
	<nav>
		<div class="logo">To Do List</div>
			<ul>
		
				<li><a href="login.jsp">Login</a></li>
				<li><a href="index.html">Voltar</a></li>
			</ul>		
	</nav>
	<div id= "login-container">

		<h1>Novo Usuário</h1>
		
		<form name="frmContato" action="insert">
			<label for="nome">Nome</label>
			<input type="text" name="nome" id="nome" placeholder="Digite seu nome" autocomplete="off">
			<label for="fone">Telefone</label>
			<input type="text" name="fone" id="fone" placeholder="Digite seu telefone" autocomplete="off">
			<label for="email">E-mail</label>
			<input type="email" name="email" id="email" placeholder="Digite seu e-mail" autocomplete="off">
			<label for="password">Senha</label>
			<input type="password" name= "password" id="password" placeholder="Digite a sua senha">
			
			<input type="submit" value="Cadastrar" onclick="validar()">
		</form>
		
	</div>
	<script src="scripts/validador.js"></script>	
</body>
</html>