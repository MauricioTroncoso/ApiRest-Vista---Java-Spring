package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class usuario {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique =true ,nullable=false)
	private long id;
	@Column(name="user",length=20,nullable=false)
	private String user;
	@Column(name="pass",length=20,nullable=false)
	private String pass;
	@Column(name="role",length=20,nullable=false)
	private String role;
	
	public usuario() {
		super();
	}

	public usuario(String user, String pass, String role) {
		super();
		this.user = user;
		this.pass = pass;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
