package org.elsysbg.ip.todo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;

//	private String passwordHash;
//	private String passwordSalt;
//	private String role;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
//	public String getPasswordHash() {
//		return passwordHash;
//	}
//	public void setPasswordHash(String passwordHash) {
//		this.passwordHash = passwordHash;
//	}
//	public String getPasswordSalt() {
//		return passwordSalt;
//	}
//	public void setPasswordSalt(String passwordSalt) {
//		this.passwordSalt = passwordSalt;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
}
