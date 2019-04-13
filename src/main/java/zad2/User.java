package zad2;

import com.mongodb.BasicDBObject;

public class User {
	private String Name;
	private String Email;
	private String Password;
	private Credencials Cred = new Credencials();
	
	

	public User(String name, String password)
	{
	Credencials cred = new Credencials();
	this.Name = name;
	this.Password = password;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	public Credencials getCred() {
		return Cred;
	}

	public void setCred(Credencials cred) {
		Cred = cred;
	}
	
	

	
	
	
}
