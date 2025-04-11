package in.pwskills.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			System.out.println("Request Processing phase....");
			String username = request.getParameter("username");
			String usernumber = request.getParameter("usernumber");
			String[] courses = request.getParameterValues("course");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>OUTPUT</title></head>");
			out.println("<body>");
			out.println("<table border='1'>");
			out.println("<tr><td>USERNAME</td><td>" + username + "</td></tr>");
			out.println("<tr><td>USERNUMBER</td><td>" + usernumber + "</td></tr>");
			for (String course : courses) {
			out.println("<tr>");
			out.println("<td>COURSE</td><td>" + course + "</td>");
			out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			}

}
