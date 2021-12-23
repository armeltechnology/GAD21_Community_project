package ng.community.application.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Patient implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable =false,unique = true,length = 45)
	private String name;
	@Column(nullable =false,unique = true,length = 45)
	private String email;
	@Column(nullable =false,unique = false,length = 200)
	@JsonIgnore
	private String password;
	@Column(nullable =false,unique = false,length = 45)
	private Date birthDate;
	@Column(nullable =false,unique = true,length = 45)
	private int phone;
	@Column(nullable =false,unique = false,length = 45)
	private String doctorchoice;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public Patient() {
		
	}
	public String getDoctorchoice() {
		return doctorchoice;
	}
	public void setDoctorchoice(String doctorchoice) {
		this.doctorchoice = doctorchoice;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", birthDate="
				+ birthDate + ", phone=" + phone + ", doctorchoice=" + doctorchoice + "]";
	}
	public Patient(Long id, String name, String email, String password, Date birthDate, int phone,
			String doctorchoice) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.phone = phone;
		this.doctorchoice = doctorchoice;
	}
	
	
	
	
	
	
}
