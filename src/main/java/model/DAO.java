package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAO implements Validar{
	
	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/login?useTimezone=true&serverTimezone=UTC";
    //private String url2 = "jdbc:mysql://127.0.0.1:3306/lista_tarefas?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "1234";

	// Método de conexão
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/*public Connection conectar2() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url2, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}*/

	/* CRUD CREATE */

	public void inserirUsuario(JavaBeans jb) {
		String create = "insert into usuarios(usuario, senha, email, fone) values (?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, jb.getNome());
			pst.setString(2, jb.getSenha());
			pst.setString(3, jb.getEmail());
			pst.setString(4, jb.getFone());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inserirTarefa(JavaBeans jb) {
		String create = "insert into tarefas (lista_titulo, lista_descricao, lista_data, lista_status, prioridade) values  (?,?,?,?,?)";
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, jb.getTitulo());
			pst.setString(2, jb.getDescricao());
			pst.setString(3, jb.getData());
			pst.setString(4, jb.getStatus());
			pst.setString(5, jb.getPrioridade());
			
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*CRUD READ*/
	public ArrayList<JavaBeans> listarTarefa(){
	    ArrayList<JavaBeans> lista = new ArrayList<JavaBeans>();
		String read = "select * from tarefas order by lista_titulo";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
			    String idlista = rs.getString("cod_lista");
				String titulo = rs.getString("lista_titulo");
				String descricao = rs.getString("lista_descricao");
				String data = rs.getString("lista_data");
				String status = rs.getString("lista_status");
				String prioridade = rs.getString("prioridade");
				//popular o ArrayList
				lista.add(new JavaBeans(titulo,descricao,data,status, prioridade,idlista, titulo,descricao, data, status, prioridade));
			
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//Crud UpDate

	//Selecionar tarefa
	public void selecionarTarefa(JavaBeans jb) {
		String read2 = "select * from tarefas where cod_lista = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, jb.getIdlista());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				jb.setIdlista(rs.getString(1));
				jb.setTitulo(rs.getString(2));
				jb.setDescricao(rs.getString(3));
				jb.setData(rs.getString(4));
				jb.setStatus(rs.getString(5));
				jb.setPrioridade(rs.getString(6));
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Editar Tarefa
	public void alterarTarefa(JavaBeans jb) {
		String create = "update tarefas set lista_titulo=?, lista_descricao=?, lista_data=?, lista_status=?, prioridade=? where cod_lista=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, jb.getTitulo());
			pst.setString(2, jb.getDescricao());
			pst.setString(3, jb.getData());
			pst.setString(4, jb.getStatus());
			pst.setString(5, jb.getPrioridade());
			pst.setString(6, jb.getIdlista());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	} 
	
	//CRUD DELETE
	
	public void deletarTarefa(JavaBeans jb) {
		String delete = "delete from tarefas where cod_lista = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, jb.getIdlista());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Override
	public int validar(JavaBeans jb) {
		int r=0;
		String logar = "select * from usuarios where email=? and senha=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(logar);
			pst.setString(1, jb.getEmail());
			pst.setString(2, jb.getSenha());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				r=r+1;
				jb.setEmail(rs.getString("email"));
				jb.setSenha(rs.getString("password"));
			}
			if(r==1) {
				return 1;
			}else {
				return 0;
			}
			
			
		} catch (Exception e) {
			return 0;
			
		}
	}

	@Override
	public int validar() {
		
		return 0;
	}

}
