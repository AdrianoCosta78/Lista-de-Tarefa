/**
 * Validador do formulario Editar Tarefa
	@autor Adriano Costa
 */

function confirmaSair(idlista){
	let resposta = confirm("Deseja realmente sair do ToDo List?")
	if(resposta === true){
		window.location.href = "sair=" + idlista
	}
}
