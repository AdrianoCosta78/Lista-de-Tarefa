/**
 * Confirmação de exclusão da tarefa
@author Adriano Costa	
 */

function confirmar(idlista){
	let resposta = confirm("Deseja realmente excluir essa tarefa?")
	if(resposta === true){
		window.location.href = "delete?idlista=" + idlista
	}
}