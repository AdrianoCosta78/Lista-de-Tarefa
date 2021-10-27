<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Tarefas</title>

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
	
		<h1>Editar Tarefas </h1>
		
		<form name="frmContato" action="update">
			
			<label for="text">Código</label>
			<input type="text" name="idlista" class="caixa3" readonly value="<%out.print(request.getAttribute("idlista")); %>">
			
			<label for="text">Titulo</label>
			<input type="text" name="titulo" value="<%out.print(request.getAttribute("titulo")); %>">
			
				
			<label for="text">Descrição</label>
			<input type="text" name="descricao" value="<%out.print(request.getAttribute("descricao")); %>">
			
			
			<div class="meia-tela spacing">
				<label for="data">Data</label>
				<input type="date" name= "data" value="<%out.print(request.getAttribute("data"));%>">
			</div>
			
			<div class="meia-tela spacing"  >
				<label for="status">Status</label>
				<input type="text" name= "status" value="<%out.print(request.getAttribute("status"));%>">
				<!--<select  name="status"   >
				<option selected="selected" >Selecione</option>
				<option value="concluido">Concluido</option>
				<option  value="pendende">Pendente</option>
				<option  value="em processo">Em processo</option>
			</select>-->
			</div>	
			
			<div class="meia-tela spacing"  >		
			<label for="text">Prioridade</label>
			<input type="text" name= "prioridade" value="<%out.print(request.getAttribute("prioridade"));%>">
			<!-- <select name="prioridade">
				<option selected="selected" >Selecione</option>
				<option value="baixa">Baixa</option>
				<option  value="media">Média</option>
				<option  value="alta">Alta</option>
			</select>-->
			</div>
			<input src="listaTarefas.jsp" type="submit" value="Salvar" onclick="validarTarefas()">
		</form>
		
	</div>
	<script src="scripts/validarTarefa.js"></script>	

</body>
</html>