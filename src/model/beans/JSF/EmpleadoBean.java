package model.beans.JSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.beans.Employee;
import model.service.EmployeeService;

/**
 * Bean de JSF que busca un empleado dada su id.
 * 
 * @author acandalez
 *
 */
@ManagedBean
@RequestScoped
public class EmpleadoBean {

	private Employee empleado;
	private int empleado_id;

	public String cargarEmpleado() {
		System.out.println(empleado_id);
		EmployeeService emp = new EmployeeService();
		empleado = (Employee) emp.obtenerEmpleado(empleado_id);
		return "resultadoEmpleado";// esto me lleva a la pagina de
									// resultadoEmpleado y me muestra los datos
									// que le he pedido.
	}

	public Employee getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employee empleado) {
		this.empleado = empleado;
	}

	public int getEmpleado_id() {
		return empleado_id;
	}

	public void setEmpleado_id(int empleado_id) {
		this.empleado_id = empleado_id;
	}

}
