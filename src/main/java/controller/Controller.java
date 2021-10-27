package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/insertTarefa", "/listarTarefa", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans jb = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			usuario(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else if (action.equals("/insertTarefa")) {
			novaTarefa(request, response);
		} else if (action.equals("/listarTarefa")) {
			tarefas(request, response);
		} else if (action.equals("/select")) {
			listarTarefa(request, response);
		}  else if (action.equals("/update")) {
			editarTarefa(request, response);
		}else if (action.equals("/delete")) {
			removerTarefa(request, response);
		}else {
			response.sendRedirect("index.html");
		}

	}

	// usuário
	protected void usuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	
	int r;
	
	protected void fazerLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		String acao = request.getParameter("acao");
		if(acao.equals("login")) {
			String email = request.getParameter("email");
			String senha = request.getParameter("password");
			jb.setEmail(email);
			jb.setSenha(senha);
			
			r=dao.validar(jb);
			
			if(r==1) {
				request.getRequestDispatcher("listarTarefa.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
						
		}
	}

	// Listar tarefa
	protected void tarefas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados do JavaBeans
		ArrayList<JavaBeans> lista = dao.listarTarefa();

		request.setAttribute("tarefas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listaTarefas.jsp");
		rd.forward(request, response);

		// Teste de recebimento da lista
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getIdlista());
			System.out.println(lista.get(i).getTitulo());
			System.out.println(lista.get(i).getDescricao());
			System.out.println(lista.get(i).getData());
			System.out.println(lista.get(i).getStatus());
			System.out.println(lista.get(i).getPrioridade());
		}
	}

	// Inserir novo usuário
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variáveis JavaBeans
		jb.setNome(request.getParameter("nome"));
		jb.setFone(request.getParameter("fone"));
		jb.setEmail(request.getParameter("email"));
		jb.setSenha(request.getParameter("password"));

		dao.inserirUsuario(jb);

		response.sendRedirect("main");

	}

	protected void novaTarefa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variáveis JavaBeans
		jb.setTitulo(request.getParameter("titulo"));
		jb.setDescricao(request.getParameter("descricao"));
		jb.setData(request.getParameter("data"));
		jb.setStatus(request.getParameter("status"));
		jb.setPrioridade(request.getParameter("prioridade"));

		dao.inserirTarefa(jb);
		response.sendRedirect("listarTarefa");

	}

	// Editar Tarefa

	protected void listarTarefa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String idlista = request.getParameter("idlista");
			
		jb.setIdlista(idlista);
				
		dao.selecionarTarefa(jb);
		
		request.setAttribute("idlista", jb.getIdlista());
		request.setAttribute("titulo", jb.getTitulo());
		request.setAttribute("descricao", jb.getDescricao());
		request.setAttribute("data", jb.getData());
		request.setAttribute("status", jb.getStatus());
		request.setAttribute("prioridade", jb.getPrioridade());
		
		RequestDispatcher rd = request.getRequestDispatcher("editarTarefa.jsp");
		rd.forward(request, response);
		
	}
	
	protected void editarTarefa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
	//Setar variaveis JavaBeans
		jb.setIdlista(request.getParameter("idlista"));
		jb.setTitulo(request.getParameter("titulo"));
		jb.setDescricao(request.getParameter("descricao"));
		jb.setData(request.getParameter("data"));
		jb.setStatus(request.getParameter("status"));
		jb.setPrioridade(request.getParameter("prioridade"));
		
		dao.alterarTarefa(jb);
		response.sendRedirect("listarTarefa");
		
	}
	//Remover Tarefa
	protected void removerTarefa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String idlista = request.getParameter("idlista");
		jb.setIdlista(idlista);
		dao.deletarTarefa(jb);
		response.sendRedirect("listarTarefa");
	}
	

}
