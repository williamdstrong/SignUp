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
		this.email.setData(email);
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
		this.yearsAtCollege.setData(yearsAtCollege);
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
		liferayID = new Data<Integer>("liferayID", "Liferay ID", "hidden");
	}
	
	public SignUpData(
			String e,
			String f,
			String l,
			String c,
			int y,
			int id) {
		email = new Data<String>("email", "Email Address");
		email.setData(e);
		firstName = new Data<String>("firstName", "First Name");
		firstName.setData(f);
		lastName = new Data<String>("lastName", "Last Name");
		lastName.setData(l);
		collegeName = new Data<String>("collegeName", "College/University Name");
		collegeName.setData(c);
		yearsAtCollege = new Data<Integer>("yearsAtCollege", "Number of years at college/university");
		yearsAtCollege.setData(y);
		liferayID = new Data<Integer>("liferayID", "Liferay ID", "hidden");
		liferayID.setData(id);
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
