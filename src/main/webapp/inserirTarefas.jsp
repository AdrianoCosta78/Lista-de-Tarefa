<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Inserir Tarefas</title>

<link rel="stylesheet" href="css/styles.css">

</head>
<body>
	<nav>
		<div class="logo">To Do List</div>
			<ul>
				<li><a href="login.jsp">Logout</a></li>
				<li><a href="listaTarefas.jsp">Voltar</a></li>
			</ul>		
	</nav>
	<div id= "login2-container">
	
		<h1>Inserir Tarefas </h1>
		
		<form name="frmContato" action="insertTarefa">
			
			<label for="text">Titulo</label>
			<input type="text" name="titulo" id="titulo" placeholder="Informe o nome da tarefa" autocomplete="off">
			
				
			<label for="text">Descrição</label>
			<textarea class="borda" name="descricao" id="descricao" placeholder="Descreva a tarefa" autocomplete="off"></textarea>
			
			<div class="meia-tela spacing">
				<label for="data">Data</label>
				<input type="date" name= "data" id="data" placeholder="Escolha a data">
			</div>
			
			<div class="meia-tela spacing">
				<label for="text">Status</label>
				<select name="status" id = "status">
				<option selected="selected" value="">Selecione</option>
				<option value="concluido">Concluido</option>
				<option  value="pendende">Pendente</option>
				<option  value="em processo">Em processo</option>
			</select>
			</div>	
			
			<div class="meia-tela spacing">		
			<label for="">Prioridade</label>
			<select name="prioridade" id = "prioridade">
				<option selected="selected" value="">Selecione</option>
				<option value="baixa">Baixa</option>
				<option  value="media">Média</option>
				<option  value="alta">Alta</option>
			</select>
			</div>
			<input src="" type="submit" value="Inserir" onclick="validarTarefas()">
		</form>
		
	</div>
	<script src="scripts/validarTarefa.js"></script>	
</body>
</html>