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

import data.Data;
import data.SignUpData;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u = request.getRequestURI().substring(17);
		
		SignUpData user = new SignUpData();
		user.readUser(u);
		
		List<Data> userData = user.toList(); 
		
		System.out.println(user.getLastName());
		
		request.setAttribute("title", "Edit User");
		request.setAttribute("list", userData);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditUser.jsp");
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
		String[] paramaterValue;
		Map<String, String> formData = new HashMap<String, String>();
		
		
		while(paramaters.hasMoreElements()) {
			paramater = (String)paramaters.nextElement();
			paramaterValue = request.getParameterValues(paramater);
			formData.put(paramater, paramaterValue[0]);
			
		}		
		
		SignUpData d = new SignUpData(				
				formData.get("email"),
				formData.get("firstName"),
				formData.get("lastName"),
				formData.get("collegeName"),
				stoi(formData.get("yearsAtCollege")),
				stoi(formData.get("liferayID"))
				);
		List<Data> data = d.toList();
		
		d.update();
		
		response.getWriter().append("<p>You have input</p>");

		for (Data i: data) {
			response.getWriter().append(
					"<p>" + i.getLabel() + ": " + i.getData() + "</p>"
		);}

	}
	
	private int stoi(String s) {
		try {
			int i = Integer.parseInt(s);
			return i;
		} catch (NumberFormatException e) {
			return -1;
		}
	}


}
