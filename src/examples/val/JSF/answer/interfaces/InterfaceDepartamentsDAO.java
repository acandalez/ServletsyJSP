package examples.val.JSF.answer.interfaces;

import java.util.List;

import examples.val.JSF.answer.dao.InterfaceDAO;
import examples.val.JSF.answer.dto.Departments;

public interface InterfaceDepartamentsDAO extends InterfaceDAO {

	List<Departments> list();

}
