package ie.cit.caf.lc_assignment.service;

import java.util.List;

import ie.cit.caf.lc_assignment.ChObject;

public interface ChObjectService {
	
	void save(ChObject chObject);
	ChObject get(int id);
	void remove(ChObject chObject);
	List<ChObject> findAll();
	
}
