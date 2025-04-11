package in.pwskills.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/home")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static {
		System.out.println("Servlet Loading...");
		}
		public MyServlet() {
		System.out.println("Servlet Instantiation...");
		}
		public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet Initialization...");
		}
		public void destroy() {
		System.out.println("Servlet DeInstantiation...");
		}
		public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		System.out.println("Request Processing phase....");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Response</title></head>");
		out.println("<body bgcolor='red'><marquee><h1>Welcome to Servlet coding....</h1></marquee></body>");
		out.println("</html>");
		out.close();
		}

}
