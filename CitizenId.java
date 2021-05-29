package societyAperson;
/**
* CitizenId is a class that works with Election2021 class 
* in an application that will be used to give examples of some data structures
* and algorithms as well as talk about Java .
*
* The current class enclose fields such as id number, name and last name
* as well as an object of type BirthCertificate.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-05-15 
*/
class CitizenId{
	private BirthCertificate birthCert;
	private String id;
	private String name;
	private String lastName;
	/**
	* The constructor that populate the fields birthCert, id, name and lastName.
	* @param bc, a BirthCertificate object.
	* @param id, a String type object representing an id number.
	* @return Nothing.
	*/	
	CitizenId(BirthCertificate bc,String id){
		this.birthCert = bc;
		this.id = id;
		this.name = "Undefined";
		this.lastName = "Undefined";
	}
	/**
	* Setter and getter methods.
	*/
	public void setName(String name){this.name = name;}
	public void setLastName(String lastName){this.lastName = lastName;}
	public BirthCertificate getBirthCertificate(){return this.birthCert;}
	public String getId(){return this.id;}
	public String getName(){return this.name;}
	public String getLastName(){return this.lastName;}
}

