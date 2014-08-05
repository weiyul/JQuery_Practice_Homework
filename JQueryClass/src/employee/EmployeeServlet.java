package employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employee.do")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private void doMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDao dao = new EmployeeDao();
		PrintWriter out = response.getWriter();
		Employee employee = dao.find(request.getParameter("name"));
		if(employee != null) {
			out.print(employee.getFirstName());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doMethod(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doMethod(request, response);
	}
}
