package ie.cit.caf.lc_assignment;

import ie.cit.caf.lc_assignment.repository.ChObjectRepository;
import ie.cit.caf.lc_assignment.repository.ImagesRepository;
import ie.cit.caf.lc_assignment.repository.ParticipantsRepository;
import ie.cit.caf.lc_assignment.rowmapper.ChObjectRowMapper;
import ie.cit.caf.lc_assignment.rowmapper.ParticipantsRowMapper;
import ie.cit.caf.lc_assignment.service.ChObjectService;
import ie.cit.caf.lc_assignment.service.ImagesService;
import ie.cit.caf.lc_assignment.service.ParticipantsService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcTemplateTestApplication implements CommandLineRunner{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ChObjectRepository chObjectRepository;
	
	@Autowired
	ChObjectService chObjectService;
	
	@Autowired
	ParticipantsRepository participantsRepository;
	
	@Autowired
	ParticipantsService paticipantsService;
	
	@Autowired
	ImagesRepository imagesRepository;
	
	@Autowired
	ImagesService imagesService;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		query01();
		query02();
		query03();
		query04();
		/*query05();*/
		/*repositoryExample();*/
	}

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateTestApplication.class, args);
    
    }
    
    public void query01() {
    	// Query for a list of maps with key-value pairs
    	// The hard way!!!
    		
    	System.out.println("\nQuery 1 (List all objects using resultset Map)\n----------------");
    		
    	String sql = "SELECT * FROM chObject";
    	List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);
    		
    	for (Map<String, Object> row : resultSet) {
    		System.out.println("\nTitle: " + row.get("title"));
    		System.out.println("\nID: " + row.get("id"));
    		System.out.println("\nDate: " + row.get("date"));  
    		System.out.println("\nMedium:  " + row.get("medium"));
    		System.out.println("\nCreditLine: " + row.get("creditline"));			
    		System.out.println("\nDescription: " + row.get("description"));
    		System.out.println("\nGallery Text: " + row.get("gallery_text") + "\n");
    	}
    }
    	
    	public void query02() {
    		// Query for a list of objects - automatic mapping from row to object using RowMapper class
    		// Using parameterised "prepared statements" reduces the risk of a SQL inject attack
    			
    		System.out.println("\nQuery 2 (List of Objects from 1960 using RowMapper)\n-----------------");
    			
    		String sql = "SELECT * FROM chObject WHERE date = ?";
    		List<ChObject> chObjects = jdbcTemplate.query(sql, new Object[] { "1960" }, new ChObjectRowMapper());
    			
    		for (ChObject chObject : chObjects) {
    			System.out.println(chObject.toString());
    		}
    	}   
    	
    	public void query03() {
    		// Query for a specific object - automatic mapping from row to object using RowMapper class
    			
    		System.out.println("\nQuery 3 (Print artist with id 68268707 - uses RowMapper)\n------------------");
    			
    		String sql = "SELECT * FROM chObject WHERE id = ?";
    		ChObject chObject = jdbcTemplate.queryForObject(sql, new Object[] { 68268707 }, new ChObjectRowMapper());
    			
    		System.out.println(chObject.toString());
    	}
    	
    	@SuppressWarnings("deprecation")
		public void query04() {
    		// Query for specific column values
    			
    		System.out.println("\nQuery 4 (Specfic columns)\n------------------");
    			
    		// Old version (now deprecated)
    		String sql = "SELECT count(*) FROM chObject";
    		int chObjectCount = jdbcTemplate.queryForInt(sql);
    		System.out.printf("Number of Cultural Heritage Objects: %d\n", chObjectCount);
    			
    		// New way
    		sql = "SELECT count(*) FROM participants";
    		int participantsCount = jdbcTemplate.queryForObject(sql, Integer.class);
    		System.out.printf("Number of movements: %d\n", participantsCount);
    			
    		// Getting a map of values
    		sql = "SELECT id, title FROM chObject WHERE date = 1960";
    		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
    		System.out.printf("ID: %s, Title: %s\n", map.get("id"), 
    						map.get("title") +"\n");
    	}

    	/*public void query05() {
    		// Specific chObject and the chObject's participants (many-to-many)
    		// This is an inefficient version with 2 separate queries

    		System.out.println("\nQuery 5 (Print chObject and participants - 2 queries)\n------------------");

    		String sql = "SELECT * FROM chObject WHERE id = ?";
    		ChObject chObject = jdbcTemplate.queryForObject(sql, new Object[] { 68268701 }, new ChObjectRowMapper());

    		sql = "SELECT p.* FROM participants p, chObject_participants am WHERE p.id = am.participants_id AND am.chObject_id = ?";
    		List<Participants> participants = jdbcTemplate.query(sql, new Object[] { 68268701 }, new ParticipantsRowMapper());
    			
    		chObject.setParticipants(participants);
    		
    		System.out.println(chObject.toString());
    	}*/

    	/*public void repositoryExample() {
    		ChObject chObject = chObjectRepository.get(68268203);
    		System.out.println(chObject.toString());
    		
    		ChObject newChObject = new ChObject();
    		newChObject.setId(123456789);
    		newChObject.setTitle("My ChObject");
    		newChObject.setDate(1960);
    		newChObject.setMedium("Canvas");
    		newChObject.setCreditline("Gift of me");
    		newChObject.setDescription("Short description about my object");
    		newChObject.setGallery_text("Why");
    		chObjectRepository.save(newChObject);
    		
    		System.out.println("All ChObjects:");
    		List<ChObject> chObjects = chObjectRepository.findAll();
    		for (ChObject o : chObjects) {
    			System.out.println(o.toString());
    		}
    	}*/
    	
    }

