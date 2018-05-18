package webapp;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Colleges;
import data.Data;
import data.SignUpData;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditCollege")
public class EditCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCollege() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u = request.getRequestURI().substring(20);
		
		
		request.setAttribute("title", "Edit College");
		request.setAttribute("college", u);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditCollege.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Handle the incoming data.
		Enumeration<String> paramaters = request.getParameterNames();
		String paramater = null;
		String[] paramaterValue = null;
		
		
		while(paramaters.hasMoreElements()) {
			paramater = (String)paramaters.nextElement();
			paramaterValue = request.getParameterValues(paramater);
		}
		
		Colleges c = new Colleges();
		c.updateCollege(paramater, paramaterValue[0]);
		
		
		response.getWriter().append("Thank you");

		
	}

}
