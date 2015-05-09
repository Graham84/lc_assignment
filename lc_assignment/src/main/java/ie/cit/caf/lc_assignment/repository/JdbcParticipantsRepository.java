package ie.cit.caf.lc_assignment.repository;

import ie.cit.caf.lc_assignment.Participants;
import ie.cit.caf.lc_assignment.rowmapper.ParticipantsRowMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcParticipantsRepository implements ParticipantsRepository{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParticipantsRepository(JdbcTemplate jdbcTemplate) {
	this. jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Participants get(int id) {
		String sql = "SELECT * FROM participants WHERE id = ?" ;
		Participants participants = jdbcTemplate.queryForObject( sql, new Object[] { 1 },
		new ParticipantsRowMapper());
		return participants;
	}

	@Override
	public void save(Participants participants) {
		if (participants.getPerson_id() != " ") {
			update(participants);
			} else {
			add(participants);
			}
		
	}
	
	private void add(Participants participants) {
		String sql = "INSERT INTO artists (person_id, person_name, person_date, person_url, role_id, role_name, role_display_name, role_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
		jdbcTemplate.update(sql,
		new Object[] { participants.getPerson_id(), participants.getPerson_name(), participants.getPerson_date(), participants.getPerson_url(), 
				participants.getRole_id(), participants.getRole_name(), participants.getRole_display_name(), participants.getRole_url() } );
		}
	
		private void update(Participants participants) {
		String sql = "UPDATE participants SET person_id = ?, person_name = ?, person_date = ?, person_url = ?, role_id = ?, role_name = ?, role_display_name = ?, role_url = ? " ;
		jdbcTemplate.update(sql, new Object[] { participants.getPerson_id(), participants.getPerson_name(), participants.getPerson_date(), participants.getPerson_url(), 
				participants.getRole_id(), participants.getRole_name(), participants.getRole_display_name(), participants.getRole_url()} );
		}

	@Override
	public void remove(Participants participants) {
		String sql = "DELETE participants WHERE person_id = ?" ;
		jdbcTemplate.update(sql, new Object[] { participants.getPerson_id() } );
		
	}

	@Override
	public List<Participants> findAll() {
		String sql = "SELECT * FROM participants" ;
		return jdbcTemplate.query(sql, new ParticipantsRowMapper());
	}

}
