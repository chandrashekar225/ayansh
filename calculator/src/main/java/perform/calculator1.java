package perform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculator1
 */
@WebServlet("/calculator1")
public class calculator1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out=null;
try {
	out=response.getWriter();
	out.println("<center>");
	double a=Integer.parseInt(request.getParameter("t1"));
	double b=Integer.parseInt(request.getParameter("t2"));
	double c=0;
String op=request.getParameter("btn");
if(op.equals("+"))c=a+b;
if(op.equals("-"))c=a-b;
if(op.equals("*"))c=a*b;
if(op.equals("/"))c=a/b;
out.println("<h3>"+a+op+b+ "="+c+"</h3>");
} catch (Exception e) {
out.println("error"+e.getMessage());
}
finally {
	out.println("<br>");
	out.println("To GOto main page <a href=index1.html>CLICK HERE </a>");
	out.println("</center");

}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
