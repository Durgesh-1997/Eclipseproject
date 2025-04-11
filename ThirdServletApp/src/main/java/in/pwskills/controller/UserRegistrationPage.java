package in.pwskills.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/reg")
public class UserRegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Servlet Loading...");
	}

	public UserRegistrationPage() {
		System.out.println("Servlet Instantiation....");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet Initialization...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request Processing....");
		String username = request.getParameter("username");
		String useraddr = request.getParameter("useraddr");
		String usermobile = request.getParameter("usermobile");

		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Output</title><style>\r\n" + "table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n" + "  border-collapse: collapse;\r\n" + "}\r\n" + "\r\n"
				+ "table.center {\r\n" + "  margin-left: auto; \r\n" + "  margin-right: auto;\r\n" + "}\r\n"
				+ "</style></head>");
		out.println("<body align='center'>");
		out.println("<h1 style='color:red; text-align:center;'>Student Details</h1>");
		out.println("<table class='center' border='1'>");
		out.println("<tr><th>NAME</th><th>ADDR</th><th>MOBILE</th></tr>");
		out.println("<tr><td>" + username + "</td><td>" + useraddr + "</td><td>" + usermobile + "</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}

