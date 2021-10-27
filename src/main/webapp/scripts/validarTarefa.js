/**
 * Validador do formulario Editar Tarefa
	@autor Adriano Costa
 */
function validarTarefas(){
	let titulo = frmContato.titulo.value
	let descricao= frmContato.descricao.value
	let data = frmContato.data.value
	let status = frmContato.status.value
	let prioridade = frmContato.prioridade.value
	if(titulo === ""){
		alert('Preencha o campo Titulo')
		frmContato.titulo.focus()
		return false
	} else if(descricao ===""){
		alert('Preencha o campo Descrição ')
		frmContato.descricao.focus()
		return false
	} else if(data ===""){
		alert('Preencha o campo Data ')
		frmContato.data.focus()
		return false
	} else if(status ===""){
		alert('Preencha o campo Status ')
		frmContato.status.focus()
		return false
	} else if (prioridade ===""){
		alert('Preencha o campo Prioridade ')
		frmContato.prioridade.focus()
		return false
	}else{
		document.forms["frmContato"].submit()
	}	
		
}

