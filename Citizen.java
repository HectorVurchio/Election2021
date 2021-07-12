package societyAperson;
import java.time.LocalDate;
/**
* Citizen is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* The current class enclose a field named citizenship and a CitizenId object.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/
class Citizen{
	private CitizenId citizenId;
	private String citizenship;
	/**
	* The constructor which populates the two private fields citizenship and citizenId.
	* @param citizenId, a CitizenId object.
	* @param citizenship, a String type object representing the citizenship.
	* @return Nothing.
	*/	
	Citizen(CitizenId citizenId,String citizenship){
		this.citizenId = citizenId;
		this.citizenship = citizenship;
	}
	/**
	* public getters metods
	*/
	public CitizenId getCitizenId(){return this.citizenId;}
	public String getCitizenship(){return this.citizenship;}
	/**
	* protected getters method written having in mind playing with the Java inheritance.
	* @return private fields from citizenId and birthCertificate class.
	*/
	protected String getId(){return this.citizenId.getId();}
	protected String getName(){return this.citizenId.getName();}
	protected String getLastName(){return this.citizenId.getLastName();}
	protected LocalDate getBirth(){return this.citizenId
												.getBirthCertificate()
												.getBirth();}
	protected String getGender(){return this.citizenId
													.getBirthCertificate()
													.getGender();}
	protected String getPlaceOfBirth(){return this.citizenId
															.getBirthCertificate()
															.getPlaceOfBirth();}
}


