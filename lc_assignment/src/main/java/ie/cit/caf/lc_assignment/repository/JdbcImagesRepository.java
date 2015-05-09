package ie.cit.caf.lc_assignment.repository;

import ie.cit.caf.lc_assignment.Images;
import ie.cit.caf.lc_assignment.rowmapper.ChObjectRowMapper;
import ie.cit.caf.lc_assignment.rowmapper.ImagesRowMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcImagesRepository implements ImagesRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcImagesRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Images get(int id) {
		String sql = "SELECT * FROM images WHERE id = ?";
		Images images = jdbcTemplate.queryForObject(sql, new Object[] {1},
				new ImagesRowMapper());
		return images;
	}

	@Override
	public void save(Images images) {
		if (images.getB() !=" ") {
			update(images);
		} else {
			add(images);
		}
		
	}
	
	private void add(Images images) {
		String sql = "Insert INTO images (b, d, n, sq, z) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 
				new Object[] {images.getB(), images.getD(), images.getN(), images.getSq(),
				images.getZ() } );
	}
	
	
	private void update(Images images){
		String sql = "UPDATE images SET b = ?, d = ?, n = ?, sq = ?, z = ?";
		jdbcTemplate.update
		(sql, new Object[] {images.getB(), images.getD(), images.getN(), images.getSq(),
				images.getZ()} );
	}

	@Override
	public void remove(Images images) {
		String sql = "DELETE chObject WHERE id = ?" ;
		jdbcTemplate.update(sql, new Object[] { images.getB() } );
		
	}

	@Override
	public List<Images> findAll() {
		String sql = "SELECT * FROM images" ;
		return jdbcTemplate.query(sql, new ImagesRowMapper());
	}

}
