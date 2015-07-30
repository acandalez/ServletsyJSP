package model.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.beans.Department;

public class DepJDBCDAO {
	private Pool gbbdd = null;

	public DepJDBCDAO() {
		gbbdd = Pool.getInstance();
	}

	@SuppressWarnings("static-access")
	public List<Department> getDepartments() {
		List<Department> departamentos = new ArrayList<Department>();
		Connection conn = null;
		Department d = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = gbbdd.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from departments");
			while (rs.next()) {

				d = new Department(rs.getInt("department_id"),
						rs.getString("department_name"));
				departamentos.add(d);
			}
		} catch (Exception ex) {

		} finally {
			gbbdd.liberarRecursos(conn, st, rs);
		}
		return departamentos;
	}
}
