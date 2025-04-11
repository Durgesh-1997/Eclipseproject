package in.pwskills.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			// Get the writer object to write the response
			PrintWriter out = response.getWriter();
			//Writing the response
			out.println("<h1>Hello this is FirstServlet</h1>");
			//Forwarding the request to second component(/second)
			RequestDispatcher rd = request.getRequestDispatcher("./second");
			rd.include(request, response);
			//Writing the response
			out.println("<h1>Hi this is FirstServlet Again...</h1>");
			// close the writer object
			out.close();
			}

}
