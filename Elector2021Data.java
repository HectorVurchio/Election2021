package societyAperson;
import java.time.LocalDate;
import java.time.LocalTime;
/**
* Elector2021Data is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* This class will be used to get all the Elector data recorded with the
* purpose of got it widely displayed in the screen.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-30 
*/

class Elector2021Data {
	public String Id_Number;
	public String Name;
	public String Last_Name;
	public LocalDate Birth_Date;
	public String Gender;
	public String Citizenship;
	public String Party;
	public String Status;
	public LocalTime Time;
	/**
	* The constructor which build an object where enclose all 
	* the fields required to print an elector data
	*/		
	Elector2021Data(Elector elector){
		this.loadFields(elector);			
	}
	/**
	* This method load the values to all fields of this class.
	* @param elector, which brings all the elector information.
	* @return nothing.
	*/	
	private void loadFields(Elector elector){
		this.Id_Number = elector.getId();
		this.Name = elector.getName();
		this.Last_Name = elector.getLastName();	
		this.Birth_Date = elector.getBirth();
		this.Gender = elector.getGender();						
		this.Citizenship = elector.getCitizenship();					
		this.Party = elector.getParty();						
		this.Status = elector.getVoteStatus();						
		this.Time = elector.getTime();			
	}
}