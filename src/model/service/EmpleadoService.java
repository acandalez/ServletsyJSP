package model.service;

import model.persistance.interfaces.Recuperable;

/**
 * obtiene un empleado.
 * 
 * @author acandalez
 *
 */
public class EmpleadoService {
	Recuperable dao = null;

	public EmpleadoService(Recuperable dao) {
		this.dao = dao;
	}

	public void setDao(Recuperable dao) {
		this.dao = dao;
	}

	public Object obtenerEmpleado(int empId) {
		return dao.obtenerEmpleado(empId);
	}

}
