package model;

public class JavaBeans {
	
	private String idusuario;
	private String nome;
	private String fone;
	private String email;
	private String senha;
	private String idlista;
	private String titulo;
	private String descricao;
	private String data;
	private String status;
	private String prioridade;
	
	public JavaBeans() {
		super();
	}
	
	
	public JavaBeans(String idusuario, String nome, String fone, String email, String senha, String idlista,
			String titulo, String descricao, String data, String status, String prioridade) {
		super();
		this.idusuario = idusuario;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.senha = senha;
		this.idlista = idlista;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.status = status;
		this.prioridade = prioridade;
	}
	public String getIdlista() {
		return idlista;
	}
	public void setIdlista(String idlista) {
		this.idlista = idlista;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
		
	public String getIdcon() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
