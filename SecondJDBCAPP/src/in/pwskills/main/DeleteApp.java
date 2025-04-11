package in.pwskills.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import in.pwskills.utility.JdbcUtil;

public class DeleteApp {
	public static void main(String[] args) {
// Resources used
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner scanner = null;
		try {
// Getting the connection
			connection = JdbcUtil.getDbConnection();
			String sqlDeleteQuery = "delete from student where sid = ? ";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			if (pstmt != null) {
				scanner = new Scanner(System.in);
				System.out.print("Enter the value of sid :: ");
				Integer sid = scanner.nextInt();
// Setting the values for PreparedStatement
				pstmt.setInt(1, sid);
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					System.out.println("deletion succesfull");
				} else {
					System.out.println("Record not available for deletion with the id:: " + sid);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
// Closing the resources
			try {
				JdbcUtil.closeResources(resultSet, pstmt, connection);
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}