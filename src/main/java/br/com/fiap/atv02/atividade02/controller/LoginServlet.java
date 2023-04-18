package br.com.fiap.atv02.atividade02.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

import br.com.fiap.atv02.atividade02.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/loginServlet/*")
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String txtLogin = request.getParameter("txtLogin");
		String txtSenha = request.getParameter("txtSenha");

		String paginaDestino;
		// aqui faremos a simulação do Login
		if (txtLogin.equals("user") && txtSenha.equals("1234")) {

			Usuario usuario = new Usuario();
			usuario.setLogin("user");
			usuario.setNome("Oliver Gulliver");
			usuario.setEmail("oliver@gulliver.com");

			// manteremos o usuário"logado" usando SESSION (chamaremos este 
			// objeto de User)
			request.getSession().setAttribute("User", usuario);
			paginaDestino = "/filtroHotel.jsp";
		}
		else {
			// vamos redirecionar para a pagina de erro com uma mensagem 
			// para ser exibida
			request.setAttribute("Mensagem","Erro de LOGIN");
			paginaDestino = "/erro.jsp";
		}

		// efetivamente fazemos o redirecionamento
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
}