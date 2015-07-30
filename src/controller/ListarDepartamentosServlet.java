package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.DepartamentosService;

/**
 * 
 * SERVLET LISTAR DEPARTAMENTOS: muestra los departamentos existentes en la BD.
 * La funcion de esta clase es obtener la lista de departamemtos y mostrarla en
 * el jsp
 * 
 * @author acandalez
 *
 */
public class ListarDepartamentosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DepartamentosService dptosService = new DepartamentosService();
		req.setAttribute("departamentos", dptosService.getDepartments());
		// obtengo la lista de departamentos y la muestro en
		// listarPorDepartamento.jsp
		req.getRequestDispatcher("listarPorDepartamento.jsp")
				.forward(req, resp);
	}

}
