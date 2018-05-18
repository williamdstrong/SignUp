package data;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Users extends Database {

	private List<SignUpData> users;
	
	public Users() {
		getListOfUsers();
	}
	
	public List<SignUpData> getUsers() {
		return users;
	}
	
	private void getListOfUsers() {
		String email, firstName, lastName;
		users =  new LinkedList<SignUpData>();
		readUsers();
		try {
			while (resultSet.next()) {
				SignUpData temp = new SignUpData();

				email = resultSet.getString(1);
				firstName = resultSet.getString(2);
				lastName = resultSet.getString(3);
				if (firstName != null && lastName != null) {
					temp.setFirstName(firstName);
					temp.setLastName(lastName);
					temp.setEmail(email);
					users.add(temp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readUsers() {
		initDatabase();
		try {
			preparedStatement = connect.prepareStatement(
				"select email, first_name, last_name from user_information.sign_up"
				);
			resultSet = preparedStatement.executeQuery();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
