package ie.cit.caf.lc_assignment.repository;


import ie.cit.caf.lc_assignment.Participants;

import java.util.List;

public interface ParticipantsRepository {
	
	public Participants get( int id);
	public void save(Participants participants);
	public void remove(Participants participants);
	public List<Participants> findAll();

}
