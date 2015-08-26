package examples.val.JSF.answer.services;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import examples.val.JSF.answer.dao.DepartmentsDAO;
import examples.val.JSF.answer.dao.GenericDAO;
import examples.val.JSF.answer.dao.InterfaceDAO;
import examples.val.JSF.answer.dto.Departments;
import examples.val.JSF.answer.interfaces.InterfaceDepartamentsDAO;
import examples.val.JSF.answer.sesion.SesionManager;

@ManagedBean
@SessionScoped
public class DepartmentServices implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7357986089725740122L;
	InterfaceDAO departmentDAO;

	public DepartmentServices() {
		departmentDAO = new DepartmentsDAO();
	}

	public List<Departments> obtenerListaDepartamentos() {
		List<Departments> lista_departamentos = null;
		Session sesion = null;
		Transaction tx = null;

		try {
			sesion = SesionManager.obtenerSesionNueva();
			((GenericDAO) departmentDAO).setSesion(sesion);
			tx = sesion.beginTransaction();
			lista_departamentos = ((InterfaceDepartamentsDAO) departmentDAO)
					.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (null != sesion)
				try {
					sesion.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}

		return lista_departamentos;
	}

}
