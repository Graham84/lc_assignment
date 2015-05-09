package ie.cit.caf.lc_assignment.service;

import ie.cit.caf.lc_assignment.ChObject;
import ie.cit.caf.lc_assignment.repository.ChObjectRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChObjectServiceImpl implements ChObjectService{
	
	ChObjectRepository chObjectRepository;
	
	@Autowired
	public ChObjectServiceImpl(ChObjectRepository chObjectRepository) {
	this. chObjectRepository = chObjectRepository;
	}

	@Override
	public void save(ChObject chObject) {
		chObjectRepository.save( chObject);
		
	}

	@Override
	public ChObject get(int id) {
		return chObjectRepository.get(id);
	}

	@Override
	public void remove(ChObject chObject) {
		chObjectRepository.remove( chObject);
		
	}

	@Override
	public List<ChObject> findAll() {
		return chObjectRepository.findAll();
	}

}
