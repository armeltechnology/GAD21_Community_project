package ng.community.application.configuration;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ng.community.application.model.Patient;

/*La classe User_Info_Mapper sert à mapper les colonnes
 de l'instruction SQL correspondant aux champs (field) de User_nathan.
 */
public class Patient_Info_Mapper implements RowMapper<Patient> {

	@Override
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long idUser=rs.getLong("Id");
		String email=rs.getString("Email");
		String Name=rs.getString("Name");
		String password=rs.getString("Password");
		String doctorchoice=rs.getString("Doctorchoice");
		Date birthdate=rs.getDate("Birthdate");
		int phone=rs.getInt("Phone");
		return new Patient(idUser,email,Name,password,birthdate, phone, doctorchoice);
	}

}
