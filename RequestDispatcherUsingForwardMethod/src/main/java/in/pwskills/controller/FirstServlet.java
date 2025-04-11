package in.pwskills.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			// Adding the data to request object
			request.setAttribute("nitin", "java");
			//Transferring the control to second component(/second)
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/second");

			rd.forward(request, response);
			}
}
