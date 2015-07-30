package model.beans.JSF;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.beans.Department;
import model.service.DepartamentosService;

/**
 * 
 * @author acandalez
 *
 */
@ManagedBean
@RequestScoped
public class Departamentos {

	private List<Department> lista;
	private String selected;

	@PostConstruct
	public void init() {
		DepartamentosService dep = new DepartamentosService();
		lista = dep.getDepartments();
	}

	public List<Department> getLista() {
		return lista;
	}

	public void setLista(List<Department> lista) {
		this.lista = lista;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

}
