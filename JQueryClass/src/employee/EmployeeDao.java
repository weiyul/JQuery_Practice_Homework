package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDao {
	private static final String SELECT = "SELECT * FROM Employees WHERE FirstName = ?";
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=Northwind";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	
	public Employee find(String name) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee employee = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(SELECT);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				employee = new Employee();
				employee.setFirstName(rs.getString("FirstName"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return employee;
	}
}
