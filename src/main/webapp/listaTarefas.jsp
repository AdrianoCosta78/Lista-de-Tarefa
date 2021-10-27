<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="model.DAO"%>
<%@page import="controller.Controller"%> 

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
	
	
 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista de Tarefas</title>
<link rel="stylesheet" href="css/styles.css">


</head>
<body>
	<nav>
		<div class="logo">To Do List</div>
			<ul>
				<li><a href="login.jsp">Logout</a></li>
			</ul>		
	</nav>
	<div id= "login3-container">
		<h1>Lista de Tarefas</h1>
		<table id="tabela">
			<thead>
				<tr>
					<th>Código</th>
					<th>Titulo</th>
					<th>Descrição</th>
					<th>Data</th>
					<th>Status</th>
					<th>Prioridade</th>
					<th>Opções</th>
				</tr>		
			</thead>
			<tbody>
				
				
				<%DAO dao = new DAO();	%>			
				<%ArrayList<JavaBeans> lista = dao.listarTarefa();%>
				
				<%for (int i = 0; i < lista.size(); i++){%>
				<tr>
					<td><%=lista.get(i).getIdlista()%></td>
					<td><%=lista.get(i).getTitulo()%></td>
				    <td><textarea><%=lista.get(i).getDescricao()%></textarea></td>
					<td><%=lista.get(i).getData()%></td>
					<td><%=lista.get(i).getStatus()%></td>
					<td><%=lista.get(i).getPrioridade()%></td>	
					<td><a href="select?idlista=<%=lista.get(i).getIdlista()%>" class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdlista()%>)" class="Botao2">Deletar</a></td>
				</tr>		
				<%}%>
				
				
			</tbody>
		</table>
		<form name="frmContato" action="inserirTarefas.jsp">
			
			<input src="inserirTarefas.jsp" type="submit" value="INSERIR NOVA TAREFA" >
		</form>
		
	</div>
	<script src="scripts/confirmaExclusao.js"></script>
</body>
</html>
