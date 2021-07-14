package societyAperson;
import java.util.Comparator;
/**
* The SortByNameLast Class runs as part of an Example application 
* Elec2021SortComparaTOR class with the purpose to sort the elector
* list by its name and last name column as a second option. this 
* class could be considered  as an instrument of a Comparator Java 
* interface useful to display the desired list by its ID column in 
* ascending order.
*
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-07-13
* @implements Comparator Functional Interface.
*/
class SortByNameLast implements Comparator<Elector2021Data>{
	/**
    * This is a neither default nor static method of the Comparator
	* functional Java interface which will be used to compare the 
	* two objects Ages letting them in ascending order.
	* @returns an int value = 0 if both ages are equal, less than
	* 0 if age1 is < age2 and greater than 0 otherwise.
    */
	public int compare(Elector2021Data e1, Elector2021Data e2){
		int name = e1.Name.compareTo(e2.Name);
		int lastN = e1.Last_Name.compareTo(e2.Last_Name);
		return (name == 0) ? lastN : name;
	}
}