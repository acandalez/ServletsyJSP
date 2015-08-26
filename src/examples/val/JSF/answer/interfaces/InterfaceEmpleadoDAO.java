package examples.val.JSF.answer.interfaces;

import java.util.List;

import examples.val.JSF.answer.dao.InterfaceDAO;
import examples.val.JSF.answer.dto.Employees;

public interface InterfaceEmpleadoDAO extends InterfaceDAO {

	List<Employees> list(String id_departamento);

}
