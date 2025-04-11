package in.pwskills.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/test2")
public class SecondServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// Getting the old session object for the same user
		HttpSession session = request.getSession(false);
		if (session == null) {
			out.println("<h1>NO session information available w.r.t the user</h1>");
		} else {
			out.println("<table border='2'><tr><th>AttributeName</th><th>AttributeValue</th></tr>");

			// Retrieve the information from session object and process the data

			Enumeration<String> names = session.getAttributeNames();
			// Processing the information using while loop from enumeration object

			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				Object value = session.getAttribute(name);
				out.println("<tr><td>" + name + "</td><td>" + value +

						"</td></tr>");
			}
			out.println("</table>");
			// Extra information is also retrieved
			long creationTime = session.getCreationTime();
			long lastAccessedTime = session.getLastAccessedTime();
			int maxInactiveInterval = session.getMaxInactiveInterval();
			out.println("<h1>CreationTime is :: " + new

			Date(creationTime) + "</h1>");

			out.println("<h1>LastAccessedTime is :: " + new

			Date(lastAccessedTime) + "</h1>");

			out.println("<h1>MaxInactiveInterval is :: " + new

			Date(maxInactiveInterval) + "</h1>");

		}
		out.close();
	}

}
