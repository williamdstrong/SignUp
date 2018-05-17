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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SignUpData data = new SignUpData();
		@SuppressWarnings("rawtypes")
		List<Data> formData = data.metaDataToList();
		

		request.setAttribute("title", "Sign Up");
		request.setAttribute("list", formData);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SignUp.jsp");
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
				stoi(formData.get("yearsAtUniversity")),
				stoi(formData.get("liferayID"))
				);
		


		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ThankYou");
		dispatcher.forward(request, response);

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
