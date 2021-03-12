package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Contato;
import service.ContatoService;

@WebServlet({ "/addcontato", "/edtcontato", "/listcontato", "/findcontato", "/delcontato" })
public class ContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContatoService contatoService;

	public ContatoServlet() {
		contatoService = new ContatoService();
	}

	// atende o método HTTP GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/listcontato")) {
			listaDeContatos(request, response);
		} else if (request.getServletPath().equals("/findcontato")) {
			localizarContato(request, response);
		} else if (request.getServletPath().equals("/delcontato")) {
			excluirContato(request, response);
		} else {
			response.sendRedirect("error.jsp?status=404");
		}
	}

	// atende o método HTTP POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/addcontato")) {
			gravarContato(request, response);
		} else if (request.getServletPath().equals("/edtcontato")) {
			editarContato(request, response);
		} else {
			response.sendRedirect("error.jsp?status=404");
		}
	}

	private void gravarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contato contato = new Contato(request.getParameter("txtNome"), request.getParameter("txtEmail"),
				request.getParameter("txtTelefone"));
		
		if(contatoService.salvar(contato)) {
			response.getWriter().append("Dados gravados com sucesso");
		} else {
			response.getWriter().append("Falha ao gravar");
		}
	}

	private void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Contato contato = new Contato(Long.parseLong(request.getParameter("txtId")),request.getParameter("txtNome"), request.getParameter("txtEmail"),
				request.getParameter("txtTelefone"));
		
		if(contatoService.atualizar(contato)) {
			response.getWriter().append("Dados atualizados com sucesso");
		} else {
			response.getWriter().append("Falha ao atualizar");
		}
	}

	private void listaDeContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			List<Contato> lista = contatoService.lista();
			
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("/listar.jsp").forward(request, response);
	}

	private void localizarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contato contato = contatoService.buscaPorId(Long.parseLong(request.getParameter("id")));
		
		request.setAttribute("contato", contato);
		request.getRequestDispatcher("/edtform.jsp").forward(request, response);
	}

	private void excluirContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		contatoService.apagar(Long.parseLong(request.getParameter("id")));
		response.sendRedirect("/listar.jsp");
	}
}