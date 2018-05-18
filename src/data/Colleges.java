package data;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Colleges extends Database {

	List<String> colleges;
	
	public Colleges() {
		getListOfColleges();
		
	}
	
	public List<String> getColleges() {
		return colleges;
	}
	
	private void getListOfColleges() {
		String college;
		colleges =  new LinkedList<String>();
		readColleges();
		try {
			while (resultSet.next()) {
				SignUpData temp = new SignUpData();

				college = resultSet.getString(1);
				if (college != null) {
					colleges.add(college);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readColleges() {
		initDatabase();
		try {
			preparedStatement = connect.prepareStatement(
				"select college_name from user_information.colleges"
				);
			resultSet = preparedStatement.executeQuery();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void updateCollege(String old, String update) {
		initDatabase();
		try {
			preparedStatement = connect.prepareStatement(
					"update colleges set college_name = ? where college_name = ?");
			preparedStatement.setString(1, update);
			preparedStatement.setString(2, old);	
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeCollege(String c) {
		try {
			preparedStatement = connect.prepareStatement(
					"delete from colleges where college_name = ?");
			preparedStatement.setString(1, c);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
