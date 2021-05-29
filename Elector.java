package societyAperson;
import java.time.LocalDate;
import java.time.LocalTime;
/**
* Elector is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* The current class is a sub class of Citizen having thought with it to be the last
* subclass from Citizen. This encloses three new fields from its super class.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/
final class Elector extends Citizen{
	static String eventOfDay = "Mega Election 2021 Great Day";
	static LocalDate electDay = LocalDate.of(2021,4,24);
	private String party;
	private String voteStatus;
	private LocalTime time;
	/**
	* The constructor which start with CitizenId object.
	* @param citizenId, Object of type CitizenId.
	* @return Nothing.
	*/	
	Elector(CitizenId citizenId){
		super(citizenId,"Country Of Freedom");
	}
	/**
	* a setter method to define the voter's party.
	* @param party, Object of type String with the name of
	* the elector's party.
	* @return Nothing.
	*/		
	public void setParty(String party){
		this.party = party;
	}
	/**
	* a setter method to define the voter's status, that means
	* if he/she has or not exercise his/her vote. This method
	* populates the voteStatus field with yes or no.
	* @param s, using the letter y or n.
	* @return Nothing.
	*/			
	public void setVoteStatus(char s){
		switch(s){
			case 'y':
				this.voteStatus = "Yes";
				break;
			case 'n':
				this.voteStatus = "No";
				break;
		}
	}
	/**
	* a setter method to define the voter's time at the moment
	* when he/she has exercised his/her vote.
	* @param time, with format hh:mm:ss.
	* @return Nothing.
	*/	
	public void setTime(String time){
		String[] vt; 
		if(time.contains(":")){
			vt = time.split(":");
		}else{
			vt = new String[]{"0","0","0"};
		}
		this.time = LocalTime.of(Integer.parseInt(vt[0]),
										Integer.parseInt(vt[1]),
										Integer.parseInt(vt[2]));
	}
	/**
	* a getter methods to obtain the values of the private
	* fields defined in this class
	*/		
	public LocalTime getTime(){return this.time;}
	public String getVoteStatus(){return this.voteStatus;}
	public String getParty(){return this.party;}
}


