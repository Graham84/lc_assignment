package ie.cit.caf.lc_assignment.repository;


import ie.cit.caf.lc_assignment.Images;

import java.util.List;

public interface ImagesRepository {

	public Images get( int id);
	public void save(Images images);
	public void remove(Images images);
	public List<Images> findAll();
}
