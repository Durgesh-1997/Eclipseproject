package in.pwskills.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import in.pwskills.utility.JdbcUtil;

public class SelectApp {
	public static void main(String[] args) {
// Resources used
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner scanner = null;
		Integer sid = null;
		try {
// Getting the connection
			connection = JdbcUtil.getDbConnection();
			String sqlSelectQuery = "select sid,sname,sage,saddress from student where sid = ? ";

			if (connection != null)

				pstmt = connection.prepareStatement(sqlSelectQuery);
			if (pstmt != null) {
				scanner = new Scanner(System.in);
				System.out.print("Enter the value of sid :: ");
				sid = scanner.nextInt();
// Setting the values for PreparedStatement
				pstmt.setInt(1, sid);
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {
				if (resultSet.next()) {
					System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));

				} else {
					System.out.println("Record not available for the give id :: " + sid);

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
