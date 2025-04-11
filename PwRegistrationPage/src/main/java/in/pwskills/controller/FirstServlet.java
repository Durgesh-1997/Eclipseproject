package in.pwskills.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/second");
		rd.forward(request, response);
		System.out.println("Control coming back to First Servlet - :");
		out.println("<h1>Hello, This is FirstServlet Again...</h1>");// ignored by the container

		System.out.println(10 / 0);// ArithmeticException : /by Zero.
		out.close();
	}

}
