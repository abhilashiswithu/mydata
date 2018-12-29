

import java.util.Date;

public class OutPatient {
	private int id;
	private String name;
	private int age;
	private Date dateOfBirth;
	private Date registrationTime;
	private String doctor;
	private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "OutPatient [id=" + id + ", name=" + name + ", age=" + age
				+ ", dateOfBirth=" + dateOfBirth + ", registrationTime="
				+ registrationTime + ", doctor=" + doctor + ", department="
				+ department + "]";
	}

}