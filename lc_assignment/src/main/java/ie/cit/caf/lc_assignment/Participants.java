
package ie.cit.caf.lc_assignment;

public class Participants{
   	private String person_date;
   	private String person_id;
   	private String person_name;
   	private String person_url;
   	private String role_display_name;
   	private String role_id;
   	private String role_name;
   	private String role_url;
   	
   	public String toString() {
		String participants = "\n-----Participant-----" + "\nParticipant ID: " + person_id + 
				"\nParticipant Name: " + person_name + "\nParticipant Date: " + person_date + 
				"\nParticipant URL: " + person_url + "\nRole ID: " + role_id + 
				"\nRole Display Name: " + role_display_name + "\nRole Name: " + role_name +
				"\nRole URL: " + role_url + "\n";
		return participants;
		
		}

 	public String getPerson_date(){
		return this.person_date;
	}
	public void setPerson_date(String person_date){
		this.person_date = person_date;
	}
 	public String getPerson_id(){
		return this.person_id;
	}
	public void setPerson_id(String person_id){
		this.person_id = person_id;
	}
 	public String getPerson_name(){
		return this.person_name;
	}
	public void setPerson_name(String person_name){
		this.person_name = person_name;
	}
 	public String getPerson_url(){
		return this.person_url;
	}
	public void setPerson_url(String person_url){
		this.person_url = person_url;
	}
 	public String getRole_display_name(){
		return this.role_display_name;
	}
	public void setRole_display_name(String role_display_name){
		this.role_display_name = role_display_name;
	}
 	public String getRole_id(){
		return this.role_id;
	}
	public void setRole_id(String role_id){
		this.role_id = role_id;
	}
 	public String getRole_name(){
		return this.role_name;
	}
	public void setRole_name(String role_name){
		this.role_name = role_name;
	}
 	public String getRole_url(){
		return this.role_url;
	}
	public void setRole_url(String role_url){
		this.role_url = role_url;
	}
}
