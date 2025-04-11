package in.pwskills.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import in.pwskills.utility.JdbcUtil;

public class SelectApp {
	public static void main(String[] args) {
// Resources used
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner scanner = null;
		String sname = null;
		try {
// Getting the connection
			connection = JdbcUtil.getDbConnection();
			String sqlSelectQuery = "select name,dob from person where name = ?";

			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			if (pstmt != null) {
				scanner = new Scanner(System.in);
				System.out.print("Enter the name of the person:: ");
				sname = scanner.next();
// Setting the values for PreparedStatement
				pstmt.setString(1, sname);
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {
				if (resultSet.next()) {
					System.out.println("NAME\tDOB");
					Date sqlDate = resultSet.getDate(2);

					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

					String stringDate = sdf.format(sqlDate);
					System.out.println(resultSet.getString(1) + "\t" +

							stringDate);

				} else {
					System.out.println("Record not available for the give name :: " + sname);
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
