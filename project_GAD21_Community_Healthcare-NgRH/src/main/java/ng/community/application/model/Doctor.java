package ng.community.application.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Doctor implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable =false,unique = true,length = 45)
	private String name;
	@Column(nullable =false,unique = true,length = 45)
	private String email;
	@JsonIgnore
	@Column(nullable =false,length = 200)
	private String password;
	@Column(nullable =false,unique = true,length = 45)
	private int registrationNumber;
	
	private String hospitalName;
	@JsonIgnore
	@ManyToOne
	private HospitalService hospitalservice;
	

	
	
	
	
	
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
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public Doctor() {
		
	}
	
	public HospitalService getHospitalservice() {
		return hospitalservice;
	}
	public void setHospitalservice(HospitalService hospitalservice) {
		this.hospitalservice = hospitalservice;
	}
	public Doctor(Long id, String name, String email, String password, int registrationNumber, String hospitalName,
			HospitalService hospitalservice) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.registrationNumber = registrationNumber;
		this.hospitalName = hospitalName;
		this.hospitalservice = hospitalservice;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", registrationNumber=" + registrationNumber + ", hospitalName=" + hospitalName + ", hospitalservice="
				+ hospitalservice + "]";
	}
	
	
	
	
	
	
	
}