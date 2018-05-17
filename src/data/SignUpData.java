package data;

import java.util.LinkedList;
import java.util.List;

import data.Data;

public class SignUpData {

	Data<String> email;
	Data<String> firstName;
	Data<String> lastName;
	Data<String> collegeName;
	Data<Integer> yearsAtCollege;
	Data<Integer> liferayID;
	public String getEmailData() {
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
	public List<Data> metaDataToList() {
		List<Data> d = new LinkedList<>();
		d.add(email);
		d.add(firstName);
		d.add(lastName);
		d.add(collegeName);
		d.add(yearsAtCollege);
		d.add(liferayID);
		return d;
	}
	
}
