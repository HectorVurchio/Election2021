package societyAperson;
import java.time.LocalDate;
import java.time.LocalTime;

import tailoredArrays.*;
import java.lang.reflect.Field;
/**
* Elector is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* The current class is used to make the object that will be stored
* in the generic array. It implements the ArrayElement interface
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/
final class Elector implements ArrayElement<Elector>{
	public String Id_Number;
	public String Name;
	public String Last_Name;
	public LocalDate Birth_Date;
	public String Gender;
	public String Citizenship;
	public String Party;
	public String Status;
	public LocalTime Time;
	
	@Override
	public Elector error(){
			return null;
	}
	/**
	* The constructor which start with CitizenId object.
	* @param ArrayExpand<?>, generic array which uses a wild card class.
	* @return Nothing.
	*/	
	Elector(ArrayExpand<?> array)throws NoSuchFieldException,
												IllegalArgumentException, IllegalAccessException{
		for(int i = 0;i < array.getSize();i++){
			Class cl = array.getValue(i).getClass();
			Field fi = cl.getDeclaredFields()[0];
			Object gdf = cl.getDeclaredField(fi.getName()).get(array.getValue(i));
			switch(i){
				case 0:
					this.Citizenship = gdf.toString();
				break;
				case 1:
					this.Birth_Date = setBirth(gdf.toString());
				break;
				case 2:
					this.Gender = setGender(gdf.toString().charAt(0));
				break;
				case 3:
					this.Id_Number = gdf.toString();
				break;
				case 4:
					this.Name = gdf.toString();
				break;
				case 5:
					this.Last_Name = gdf.toString();
				break;
				case 6:
					this.Party = gdf.toString();
				break;
				case 7:
					setVoteStatus(gdf.toString().charAt(0));
				break;
				case 8:
					setTime(gdf.toString());
				break;
			}
		}
	}
	/**
	* Methods that manipulate the entry String to return its
	* respective object type.
	*/
	private LocalDate setBirth(String birth){
		String[] bida;
		if(birth.contains("/")){
			bida = birth.split("/");
		}else if(birth.contains("-")){
			bida = birth.split("-");
		}else{
			bida = LocalDate.now().toString().split("-");
		}
		return LocalDate.of(Integer.parseInt(bida[0]),
										  Integer.parseInt(bida[1]),
										  Integer.parseInt(bida[2]));
	}
	
	private String setGender(char g){
		switch(g){
			case 'f':
				return "Female";
			case 'm':
				return "Male";
			default:
				return "Undefined";
		}
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
				this.Status = "Yes";
				break;
			case 'n':
				this.Status = "No";
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
		this.Time = LocalTime.of(Integer.parseInt(vt[0]),
										Integer.parseInt(vt[1]),
										Integer.parseInt(vt[2]));
	}
	
}