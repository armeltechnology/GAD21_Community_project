package ng.community.application.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;

@Entity

public class HospitalService implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(nullable =false,unique = true,length = 45)
	private String serviceName;
	
	private int price;
	
	@OneToMany(mappedBy = "hospitalservice")
	private Collection<Doctor> doctor;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Collection<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(Collection<Doctor> doctor) {
		this.doctor = doctor;
	}
	public HospitalService(Long id, String serviceName, int price, Collection<Doctor> doctor) {
		
		Id = id;
		this.serviceName = serviceName;
		this.price = price;
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "HospitalService [Id=" + Id + ", serviceName=" + serviceName + ", price=" + price + ", doctor=" + doctor
				+ "]";
	}
	public HospitalService() {
		
	}
	

}
