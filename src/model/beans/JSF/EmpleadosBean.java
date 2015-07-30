package model.beans.JSF;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.beans.Employee;
import model.service.EmployeeService;

@ManagedBean
@RequestScoped
public class EmpleadosBean {

	private List<Employee> employee;
	private String selected;

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@PostConstruct
	public void listarEmpleados() {
		EmployeeService emp = new EmployeeService();
		employee = (List<Employee>) emp.getEmployeesByDepartment(selected);
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}
}
