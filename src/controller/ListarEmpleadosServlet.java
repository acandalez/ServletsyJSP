package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Employee;
import model.service.EmployeeService;

/**
 * SERVLET LISTAR EMPLEADOS: muestra los empleados dado un departamento. La
 * funcion de esta clase es obtener la lista de empleados y mostrarla en el jsp
 * 
 * @author acandalez
 *
 */
public class ListarEmpleadosServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EmployeeService empService = new EmployeeService();
		String departamento = (String) req.getParameter("departamento");
		List<Employee> empleados = (ArrayList<Employee>) empService
				.getEmployeesByDepartment(departamento);
		req.setAttribute("empleados", empleados);
		// Obtengo la lista de empleados y la muestro en listarEmpleados.jsp
		req.getRequestDispatcher("listarEmpleados.jsp").forward(req, resp);
	}
}
