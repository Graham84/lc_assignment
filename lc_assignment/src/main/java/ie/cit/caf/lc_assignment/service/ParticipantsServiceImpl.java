package ie.cit.caf.lc_assignment.service;

import ie.cit.caf.lc_assignment.Participants;
import ie.cit.caf.lc_assignment.repository.ParticipantsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantsServiceImpl implements ParticipantsService {
	
	ParticipantsRepository participantsRepository;
	
	@Autowired
	public ParticipantsServiceImpl(ParticipantsRepository participantsRepository) {
	this. participantsRepository = participantsRepository;
	}

	@Override
	public void save(Participants participants) {
		participantsRepository.save( participants);
		
	}

	@Override
	public Participants get(int id) {
		return participantsRepository.get(id);
	}

	@Override
	public void remove(Participants participants) {
		participantsRepository.remove( participants);
		
	}

	@Override
	public List<Participants> findAll() {
		return participantsRepository.findAll();
	}

}
