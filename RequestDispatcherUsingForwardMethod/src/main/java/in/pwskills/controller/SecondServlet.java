package in.pwskills.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Getting the Writer object to write the response
		PrintWriter out = response.getWriter();
		out.println("<h1>Forward Request Attribute</h1>");
		// Accessing the attributes
		Enumeration<String> names = request.getAttributeNames();
		// Retrieving all the attributes
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			Object value = request.getAttribute(name);
			out.println(name + " " + value + "<br/>");
		}
	}
}
