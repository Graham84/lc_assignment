package ie.cit.caf.lc_assignment;


import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ChObject {
	
	private int id;
	private String title;
	private String date;
	private String medium;
	private String creditline;
	private String description;
	private String gallery_text;
	@JsonUnwrapped
	private List <Images> images;
	@JsonUnwrapped
   	private List <Participants> participants;
   	
	
	//Constructor - stops null point exception if participant/image = empty
   	public ChObject() {
		participants = Collections.<Participants>emptyList();
		images = Collections.<Images>emptyList();
	}
	
	public String toString() {
		String chObject = "\n-----Cultural Heritage Object-----" + "\nID: " + id + "\nTitle: " + title + "\nDate: " + date +
				"\nMedium: " + medium + "\nCreditline: " + creditline + "\nDescription: " + description +
				"\nGallery Text: " + gallery_text + "\n";
		for (Participants p : participants) {
			chObject += p.toString() + ",";
		}
		for (Images i : images) {
			chObject += i.toString() + ",";
		}
		chObject += "]]";
		return chObject;
	}
		/*for (Participants p : getParticipants()) {
			chObject += "\n--- Participant ---" + "\nPerson ID: " + p.getPerson_id() + "\nPerson Name: " + p.getPerson_name() + 
					"\nPerson Date: " + p.getPerson_date() +"\nPerson URL: " + p.getPerson_url() +
					"\nRole ID: " + p.getRole_id() + "\nRole Name: : " + p.getRole_name() +"\nRole Display Name: " + p.getRole_display_name() + 
					"\nRole URL: "+ p.getRole_url() + "\n";
		}
		for (Images i : getImages()) {
			chObject += "\n--- Images ---" + "\nImage: " + i.getB() + "\nImage Width: " + i.getB().getWidth() + "\nImage Height: " + i.getB().getHeight() +
					"\nImage ID: " + i.getB().getImage_id() + "\nImage Primary: " + i.getB().getIs_primary() +  "\nImage URL: " + i.getB().getUrl()
		
			+ "\n" + "\nImage: " + i.getD() + "\nImage Width: " + i.getD().getWidth() + "\nImage Height: " + i.getD().getHeight() +
			"\nImage ID: " + i.getD().getImage_id() + "\nImage Primary: " + i.getD().getIs_primary() +  "\nImage URL: " + i.getD().getUrl()
		
			+ "\n" + "\nImage: " + i.getN() + "\nImage Width: " + i.getN().getWidth() + "\nImage Height: " + i.getN().getHeight() +
			"\nImage ID: " + i.getN().getImage_id() + "\nImage Primary: " + i.getN().getIs_primary() +  "\nImage URL: " + i.getN().getUrl()
			
			+ "\n" + "\nImage: " + i.getSq() + "\nImage Width: " + i.getSq().getWidth() + "\nImage Height: " + i.getSq().getHeight() +
			"\nImage ID: " + i.getSq().getImage_id() + "\nImage Primary: " + i.getSq().getIs_primary() +  "\nImage URL: " + i.getSq().getUrl()
			
			+ "\n" + "\nImage: " + i.getZ() + "\nImage Width: " + i.getZ().getWidth() + "\nImage Height: " + i.getZ().getHeight() +
			"\nImage ID: " + i.getZ().getImage_id() + "\nImage Primary: " + i.getZ().getIs_primary() +  "\nImage URL: " + i.getZ().getUrl();
		}*/
	/*	return chObject;
		
	}*/


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getCreditline() {
		return creditline;
	}

	public void setCreditline(String creditline) {
		this.creditline = creditline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGallery_text() {
		return gallery_text;
	}

	public void setGallery_text(String gallery_text) {
		this.gallery_text = gallery_text;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}


	
	

}
