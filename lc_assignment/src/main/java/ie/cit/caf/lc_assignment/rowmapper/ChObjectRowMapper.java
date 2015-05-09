package ie.cit.caf.lc_assignment.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.caf.lc_assignment.ChObject;

import org.springframework.jdbc.core.RowMapper;

public class ChObjectRowMapper implements RowMapper<ChObject> {

	@Override
	public ChObject mapRow(ResultSet rs, int index) throws SQLException {
		ChObject chObject = new ChObject();
		
		chObject.setId(rs.getInt("id"));
		chObject.setTitle(rs.getString("title"));
		chObject.setDate(rs.getString("date"));
		chObject.setMedium(rs.getString("medium"));
		chObject.setCreditline(rs.getString("creditline"));
		chObject.setDescription(rs.getString("description"));
		chObject.setCreditline(rs.getString("gallery_text"));
		return chObject;
	}
}

