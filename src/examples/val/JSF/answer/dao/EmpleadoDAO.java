package examples.val.JSF.answer.dao;

import java.util.List;

import examples.val.JSF.answer.dto.Employees;
import examples.val.JSF.answer.interfaces.InterfaceEmpleadoDAO;

public class EmpleadoDAO extends GenericDAO implements InterfaceEmpleadoDAO {

	@Override
	public Object create(Object objeto_dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object read(Object clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object objeto_dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object objeto_dto) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> list(String id_departamento) {
		List<Employees> lista_empleados = null;
		int n_dpto = 0;

		n_dpto = Integer.parseInt(id_departamento);

		lista_empleados = sesion
				.createSQLQuery(
						"Select * from Employees where department_id = "
								+ n_dpto).addEntity(Employees.class).list();

		return lista_empleados;
	}
}
