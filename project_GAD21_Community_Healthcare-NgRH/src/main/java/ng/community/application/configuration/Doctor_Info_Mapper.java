package ng.community.application.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ng.community.application.model.Doctor;

public class Doctor_Info_Mapper implements RowMapper<Doctor>{

	@Override
	public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long idUser=rs.getLong("Id");
		String email=rs.getString("Email");
		String Name=rs.getString("Name");
		String password=rs.getString("Password");
		String Hopital=rs.getString("HospitalName");
		int registrationnumber=rs.getInt("RegistrationNumber");
		return new Doctor();
	}
}
