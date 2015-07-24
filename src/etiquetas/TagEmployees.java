package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.beans.Employee;
import model.service.EmployeeService;

public class TagEmployees extends SimpleTagSupport {
	private int id = -1;
	private String name = null;
	private List<Employee> list = null;

	@Override
	public void doTag() throws JspException, IOException {
		EmployeeService empService = new EmployeeService();
		JspWriter out = getJspContext().getOut();
		if (null != name) {
			list = (ArrayList<Employee>) empService.getEmployeesByDepartment(name);
		} else if (-1 != id) {
			list = (ArrayList<Employee>) empService.getEmployeesByDepartment(id);
		}
		if (null != list) {
			out.println("<table id='empleados'><tr><th>ID</th><th>Nombre</th><th>Department ID</th><th>Salario</th></tr>");
			for (Employee employee : list) {
				out.println("<tr>");
				out.println("<td>"+employee.getEmployeeId()+"</td>");
				out.println("<td>"+employee.getFirstName()+" "+employee.getLastName()+"</td>");
				out.println("<td>"+employee.getDepartmentId()+"</td>");
				out.println("<td>"+employee.getSalary()+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

}
