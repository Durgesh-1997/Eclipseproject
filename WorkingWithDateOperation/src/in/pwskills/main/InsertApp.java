package in.pwskills.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import in.pwskills.utility.JdbcUtil;

public class InsertApp {
	public static void main(String[] args) {
// Resources used
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner scanner = null;
		try {
// Getting the connection
			connection = JdbcUtil.getDbConnection();
			String sqlInsertQuery = "insert into person(name,dob) values (?,?)";

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				scanner = new Scanner(System.in);
				System.out.print("Enter the value of sname :: ");
				String sname = scanner.next();
				System.out.print("Enter the value of dob(dd-mm-yyyy) :: ");

				String dob = scanner.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date utilDate = sdf.parse(dob);
				java.sql.Date sqlDate = new

				java.sql.Date(utilDate.getTime());

// Setting the values for PreparedStatement
				pstmt.setString(1, sname);
				pstmt.setDate(2, sqlDate);
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					System.out.println("Insertion succesfull");
				} else {
					System.out.println("Record not inserted to database...");

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