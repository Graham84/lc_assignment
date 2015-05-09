package lc_assignment;

import ie.cit.caf.lc_assignment.ChObject;
import ie.cit.caf.lc_assignment.Images;
import ie.cit.caf.lc_assignment.Participants;
import ie.cit.caf.lc_assignment.repository.ChObjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration({"classpath:configuration.xml"})

public class ImagesRepositoryTest {

	@Autowired
	ApplicationContext context;

	@Test
	public void get() {
		Images b = Images.getB();
		assertEquals("Image D", b.getD());
	}

}
