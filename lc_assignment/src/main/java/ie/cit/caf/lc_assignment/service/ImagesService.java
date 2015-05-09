package ie.cit.caf.lc_assignment.service;


import ie.cit.caf.lc_assignment.Images;

import java.util.List;

public interface ImagesService {

	void save(Images images);
	Images get(int id);
	void remove(Images images);
	List<Images> findAll();
	
}
