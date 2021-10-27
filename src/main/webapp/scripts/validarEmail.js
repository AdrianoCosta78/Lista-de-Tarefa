/**
 * Validador do formulario Email
	@autor Adriano Costa
 */

function validarEmail(){
	let email = frmContato.email.value
	let password = frmContato.password.value
	if(email == ""){
		alert('Preencha o campo email')
		frmContato.email.focus()
		return false
	}else if(password === ""){
		alert('Preencha o campo senha')
		frmContato.password.focus()
		return false
	}else{
		document.frms["frmContato"].submit()
	}
}