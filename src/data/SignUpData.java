package data;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import data.Data;
import data.Database;

public class SignUpData extends Database {

	Data<String> email;
	Data<String> firstName;
	Data<String> lastName;
	Data<String> collegeName;
	Data<Integer> yearsAtCollege;
	Data<Integer> liferayID;
		
	public String getEmail() {
		return email.getData();
	}
	
	public void setEmail(String email) {
		// If the string contains @ then it is not null.
		if (email.contains("@")) { this.email.setData(email); }
	}


	public String getFirstName() {
		return firstName.getData();
	}


	public void setFirstName(String firstName) {
		this.firstName.setData(firstName);
	}


	public String getLastName() {
		return lastName.getData();
	}


	public void setLastName(String lastName) {
		this.lastName.setData(lastName);
	}


	public String getCollegeName() {
		return collegeName.getData();
	}


	public void setCollegeName(String collegeName) {
		this.collegeName.setData(collegeName);
	}


	public Integer getYearsAtCollege() {
		return yearsAtCollege.getData();
	}


	public void setYearsAtCollege(Integer yearsAtCollege) {
		if (yearsAtCollege != -1) { this.yearsAtCollege.setData(yearsAtCollege); }
	}


	public Integer getLiferayID() {
		return liferayID.getData();
	}


	public void setLiferayID(Integer liferayID) {
		this.liferayID.setData(liferayID);
	}


	public SignUpData() {
		email = new Data<String>("email", "Email Address");
		firstName = new Data<String>("firstName", "First Name");
		lastName = new Data<String>("lastName", "Last Name");
		collegeName = new Data<String>("collegeName", "College/University Name");
		yearsAtCollege = new Data<Integer>("yearsAtCollege", "Number of years at college/university");
		liferayID = new Data<Integer>("liferayID", "", "hidden");
	}
	
	public SignUpData(
			String e,
			String f,
			String l,
			String c,
			int y,
			int id) {
		email = new Data<String>("email", "Email Address");
		setEmail(e);
		firstName = new Data<String>("firstName", "First Name");
		setFirstName(f);
		lastName = new Data<String>("lastName", "Last Name");
		setLastName(l);
		collegeName = new Data<String>("collegeName", "College/University Name");
		setCollegeName(c);
		yearsAtCollege = new Data<Integer>("yearsAtCollege", "Number of years at college/university");
		setYearsAtCollege(y);
		liferayID = new Data<Integer>("liferayID", "", "hidden");
		setLiferayID(id);
	}
	
	
	@SuppressWarnings("rawtypes")
	public List<Data> toList() {
		List<Data> d = new LinkedList<>();
		d.add(email);
		d.add(firstName);
		d.add(lastName);
		d.add(collegeName);
		d.add(yearsAtCollege);
		d.add(liferayID);
		return d;
	}


	public void readUser(String email) {
		initDatabase();
		try {
			preparedStatement = connect.prepareStatement(
					"select * from user_information.sign_up where email=?"
					);
			preparedStatement.setString(1, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (resultSet.next()) {
				try {
					setEmail(email);
					setFirstName(resultSet.getString("first_name"));			
					setLastName(resultSet.getString("last_name"));
					setCollegeName(resultSet.getString("college_name"));
					setYearsAtCollege(resultSet.getInt("years_at_college"));
					setLiferayID(resultSet.getInt("liferay_id"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readColleges() {
		
	}

	public void write() {
		initDatabase();
		try {
			preparedStatement = connect.prepareStatement(
					"insert into user_information.sign_up values (?, ?, ?, ?, ?, ?)"
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = 1;
		for (Data d : this.toList()) {
			if (i < 5) {
				insertValueString(i, d);
			} else
			{
				insertValueInt(i, d);
			}
			i++;
		}
		
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertValueString(int i, Data<String> d) {
		try {
			preparedStatement.setString(i, d.getData());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void insertValueInt(int i, Data<Integer> d) {
		try {
			preparedStatement.setInt(i, d.getData());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		initDatabase();
		try {
			preparedStatement = connect.prepareStatement(
					"update user_information.sign_up set email=?, first_name=?, last_name=?, college_name=?, years_at_college=?, liferay_id=? where email=?"
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = 1;
		for (Data d : this.toList()) {
			if (i < 5) {
				insertValueString(i, d);
			} else
			{
				insertValueInt(i, d);
			}
			i++;
		}
		
		try {
			preparedStatement.setString(7, email.getData());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
