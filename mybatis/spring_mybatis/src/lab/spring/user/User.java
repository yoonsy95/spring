package lab.spring.user;

public class User {
	
	private int uno;	
	private String userid;
	private String username;
	private String email;
	private String phone;
	private String userpwd;	
    private String address;
    
    
	 
	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [uno=" + uno + ", userid=" + userid + ", username="
				+ username + ", email=" + email + ", phone=" + phone
				+ ", userpwd=" + userpwd + ", address=" + address + "]";
	}

	
	

}
