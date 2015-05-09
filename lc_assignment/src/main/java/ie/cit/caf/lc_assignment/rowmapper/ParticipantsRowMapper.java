package ie.cit.caf.lc_assignment.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.caf.lc_assignment.Participants;

import org.springframework.jdbc.core.RowMapper;

public class ParticipantsRowMapper implements RowMapper<Participants> {


		@Override
		public Participants mapRow(ResultSet rs, int index) throws SQLException {
			Participants participants = new Participants();
			
			participants.setPerson_id(rs.getString("person_id"));
			participants.setPerson_name(rs.getString("person_name"));
			participants.setPerson_date(rs.getString("person_date"));
			participants.setPerson_url(rs.getString("person_url"));
			participants.setRole_id(rs.getString("role_id"));
			participants.setRole_name(rs.getString("role_name"));
			participants.setRole_display_name(rs.getString("role_display_name"));
			participants.setRole_url(rs.getString("role_url"));
			
			return participants;
		}
		

}
