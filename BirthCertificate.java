package societyAperson;
import java.time.LocalDate;
/**
* The BirthCertificate is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* The current class enclose parameters such as birth place, birth date an gender.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/
class BirthCertificate{
	private LocalDate birth;
	private String gender;
	private String placeOfBirth;
		/**
	* The constructor that populate the fields birth, gender or placeOfBirth.
	* @param pob place of birth.
	* @param birth date of birth e.g. "2021-01-30" or "2021/01/30".
	* @param g e.g m or f.
	* @return Nothing.
	*/
	public BirthCertificate(String pob,String birth,char g){
		this.placeOfBirth = pob;
		this.birth = setBirth(birth);
		this.gender = setGender(g);
	}
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
	* getters methods to obtain the value of the private declared fields
	* of the current class.
	*/
	public String getGender(){return this.gender;}
	public LocalDate getBirth(){return this.birth;}
	public String getPlaceOfBirth(){return this.placeOfBirth;}
}