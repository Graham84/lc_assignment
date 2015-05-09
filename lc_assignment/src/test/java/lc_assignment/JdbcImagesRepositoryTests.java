package lc_assignment;

import static org.junit.Assert.*;
import ie.cit.caf.lc_assignment.Images;
import ie.cit.caf.lc_assignment.repository.JdbcChObjectRepository;
import ie.cit.caf.lc_assignment.repository.JdbcImagesRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) /*@ContextConfiguration({"classpath:configuration.xml"})*/
/*@SpringApplicationConfiguration(classes = DefaultConfig. class)
@ActiveProfiles("test")
@DirtiesContext(classMode=ClassMode. AFTER_EACH_TEST_METHOD)*/
public class JdbcImagesRepositoryTests {
	
	@Autowired
	JdbcImagesRepository repo;

	@Test
	public void get() {
		Images a = repo.get(68268701);
		assertEquals("d", a.getD());
	}

}
