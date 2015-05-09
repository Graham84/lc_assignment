package ie.cit.caf.lc_assignment.repository;

import java.util.List;

import ie.cit.caf.lc_assignment.ChObject;

public interface ChObjectRepository {
	
	public ChObject get( int id);
	
	public void save(ChObject chObject);
	
	public void remove(ChObject chObject);
	
	public List<ChObject> findAll();

}
