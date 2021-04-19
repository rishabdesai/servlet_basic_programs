package pojo;


public class UserPOJO {
	private String fullName, email, password;
	private String birthDate;
	
	public UserPOJO() {
		
	}

	public UserPOJO(String fullName, String email, String password, String birthdate) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.birthDate = birthdate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "user [fullName=" + fullName + ", email=" + email + ", password=" + password + ", birthDate=" + birthDate
				+ "]";
	}
	
	
	

}
