package app.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import constante.BaseDeDonnees;

public abstract class GenericDao {
	protected Connection conn;

	protected String table;

	public GenericDao() {
		try {
			this.conn = (Connection) DriverManager.getConnection(BaseDeDonnees.URL.getBdd(),
					BaseDeDonnees.USER.getBdd(), BaseDeDonnees.PASSWD.getBdd());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Object[]> getAll() {
		List<Object[]> res = new ArrayList<Object[]>();
		try {
			Statement state = (Statement) this.conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM " + this.table + " ;");
			ResultSetMetaData rsmd = rs.getMetaData();
			Object[] row = new Object[rsmd.getColumnCount()];
			while (rs.next()) {
				for (int i = 0; i < row.length; i++)
					row[i] = rs.getObject(i);
				res.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public Object[] getById(int id) {
		Object[] row = null;
		try {
			Statement state = (Statement) this.conn.createStatement();
			ResultSet rs = state
					.executeQuery("SELECT * FROM " + this.table + " where id" + this.table + " = " + id + " ;");
			ResultSetMetaData rsmd = rs.getMetaData();
			row = new Object[rsmd.getColumnCount()];
			while (rs.next())
				for (int i = 0; i < row.length; i++)
					row[i] = rs.getObject(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public boolean insert(Object[] row) {
		try {
			Statement state = (Statement) this.conn.createStatement();
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO " + this.table + " VALUES(null, ");
			for (int i = 0; i < row.length; i++) {
				query.append(row[i].toString());
				if (i != row.length - 1)
					query.append(", ");
			}
			query.append(");");
			state.executeUpdate(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
