package ie.cit.caf.lc_assignment.service;


import ie.cit.caf.lc_assignment.Participants;

import java.util.List;

public interface ParticipantsService {
	void save(Participants participants);
	Participants get(int id);
	void remove(Participants chObject);
	List<Participants> findAll();
	
}
