package tailoredArrays;
/**
* Interface that contains the methods needed to operate
* any kind of array data structure.
* Abstract methods:
* 		Add => add elements at the end of the array
*		delete => delete an element stored at the end
*		getValue => returns the object stored in the array
*				at the specified index.
* 		getSize => returns the size of the array.
* @package tailoredArrays: that includes all classes and 
* interfaces that perform a generic array.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-07-21 
*/
public interface DynamicArray<E> {
	public void add(E element); 
	public void delete(); 
	public E getValue(int index); 
	public int getSize(); 
	
}