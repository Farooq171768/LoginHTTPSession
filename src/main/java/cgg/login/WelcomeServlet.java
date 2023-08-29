package cgg.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session!=null && session.getAttribute("username")!=null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>Welcome, "+session.getAttribute("username")+ "</h1>");
			out.println("<h3>You are now logged in!<h3>");
			out.println("<a href='logoutServlet'>Logout</a>");
			//session.invalidate();
		}
		else {
			response.sendRedirect("index.html");
		}
		
	}

}
