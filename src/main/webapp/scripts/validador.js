/**
 * Validador do formulario Novo Usuário
	@autor Adriano Costa
 */

function validar(){
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	let email = frmContato.email.value
	let password = frmContato.password.value
	if(nome === ""){
		alert('Preencha o campo nome')
		frmContato.nome.focus()
		return false
	} else if(fone ===""){
		alert('Preencha o campo fone ')
		frmContato.fone.focus()
		return false
	} else if(email ===""){
		alert('Preencha o campo e-mail ')
		frmContato.email.focus()
		return false
	} else if(password ===""){
		alert('Preencha o campo senha ')
		frmContato.password.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}


