package tailoredArrays;
/**
* Interface to be implemented by every elements of the
* generic Array so that any exception that may occur 
* could be catched.
* @package tailoredArrays: that includes all classes and 
* interfaces that perform a generic array.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-07-21 
*/
public interface ArrayElement<E>{
	public E error();
}