package ie.cit.caf.lc_assignment.repository;

import ie.cit.caf.lc_assignment.ChObject;
import ie.cit.caf.lc_assignment.rowmapper.ChObjectRowMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcChObjectRepository implements ChObjectRepository{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcChObjectRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public ChObject get(int id) {
		String sql = "SELECT * FROM chObject WHERE id = ?";
		ChObject chObject = jdbcTemplate.queryForObject(sql, new Object[] {1},
				new ChObjectRowMapper());
		return chObject;
	}
	

	@Override
	public void save(ChObject chObject) {
		if (chObject.getId() !=0) {
			update(chObject);
		} else {
			add(chObject);
		}
		
	}

	private void add(ChObject chObject) {
		String sql = "Insert INTO chObject (id, title, date, medium, creditline, description, gallery_text) VALUES (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 
				new Object[] {chObject.getId(), chObject.getTitle(), chObject.getDate(), chObject.getMedium(),
				chObject.getCreditline(), chObject.getDescription(), chObject.getGallery_text()} );
	}
	
	
	private void update(ChObject chObject){
		String sql = "UPDATE chObject SET id = ?, title = ?, date = ?, medium = ?, creditline = ?, description = ?, gallery_text = ? WHERE id = ?";
		jdbcTemplate.update
		(sql, new Object[] {chObject.getId(), chObject.getTitle(), chObject.getDate(), chObject.getMedium(),
				chObject.getCreditline(), chObject.getDescription(), chObject.getGallery_text()} );
	}

	@Override
	public void remove(ChObject chObject) {
		String sql = "DELETE chObject WHERE id = ?" ;
		jdbcTemplate.update(sql, new Object[] { chObject.getId() } );
	}

	@Override
	public List<ChObject> findAll() {
		String sql = "SELECT * FROM chObject" ;
		return jdbcTemplate.query(sql, new ChObjectRowMapper());
	}
	
}
