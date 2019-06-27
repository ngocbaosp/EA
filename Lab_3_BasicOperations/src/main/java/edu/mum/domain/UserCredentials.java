package edu.mum.domain;

import javax.persistence.*;


@Entity(name = "UserCredentials")
@Table(name = "authentication")

public class UserCredentials {

	@Id
	@Column(name = "USER",length = 127,nullable = false)
  	String username;
	@Column(name = "PASSWORD",length = 32,nullable = false)
	String password;
	@Transient
 	String verifyPassword;
	@Column(name ="enabled")
	Boolean enabled;




 	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
 	
}
