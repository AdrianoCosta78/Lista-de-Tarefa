<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset=utf-8>
<title>Login</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<nav>
		<div class="logo">To Do List</div>
			<ul>
				<li><a href="index.html">Voltar</a></li>
			</ul>		
	</nav>
	
	<div id= "login-container">
		<h1>Login</h1>
		<form name="frmContato"  action="listarTarefa">
			<label for="email">E-mail</label>
			<input type="email" autocomplete="off" name="email" id="email" placeholder="Digite seu e-mail" autocomplete="off">
			<label for="password">Senha</label>
			<input type="password" autocomplete="off" name= "password" id="password" placeholder="Digite a sua senha">
			
			<a href="" id="forgot-pass">Esqueceu a senha?</a>
			<input  type="submit" value="login" name="acao" onclick="validarEmail()">
			
		</form>
		<div id="register-container">
			<p>Ainda não tem uma conta?</p>
			<a href="cadastro.jsp">Registrar</a>
		</div>
	</div>
		<script src="scripts/validarEmail.js"></script>
</body>
</html>
