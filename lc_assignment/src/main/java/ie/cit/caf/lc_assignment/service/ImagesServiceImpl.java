package ie.cit.caf.lc_assignment.service;

import ie.cit.caf.lc_assignment.Images;
import ie.cit.caf.lc_assignment.repository.ImagesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesServiceImpl implements ImagesService {
	
ImagesRepository imagesRepository;
	
	@Autowired
	public ImagesServiceImpl(ImagesRepository imagesRepository) {
	this. imagesRepository = imagesRepository;
	}

	@Override
	public void save(Images images) {
		imagesRepository.save( images);
		
	}

	@Override
	public Images get(int id) {
		return imagesRepository.get(id);
	}

	@Override
	public void remove(Images images) {
		imagesRepository.remove( images);
		
	}

	@Override
	public List<Images> findAll() {
		return imagesRepository.findAll();
	}

}
