package tailoredArrays;
/**
* Class that defines a generic interface.
* Fields: point => points out to last element of the array.
*         capacity => shows the capability of the array
* @implements DinamicArray
* @package tailoredArrays: that includes all classes and 
* interfaces that perform a generic array.
* @author  Hector Jose Vurchio Hurtado
* @version 1.0
* @since   2021-07-21 
*/
public class ArrayExpand<E extends ArrayElement<E>> implements DynamicArray<E>{
	private int point;
	private int capacity;
	private Object[] elements;
	
	public ArrayExpand(){
		this.point = 0;
		this.capacity = 1;
		this.elements = new Object[capacity];
	}
	@Override
	public void add(E element){
		if(point == capacity){expand();}
		elements[point] = element;
		point ++;
	}
	@Override
	public void delete(){
		if(this.point >= 0){
			elements[point] = null;
			point --;
			float quotient = point/capacity; 
			if(quotient <= 0.5){shrink();}
		}
	}
	@SuppressWarnings("unchecked")
	public E getValue(int index){
		E elm = (E)this.elements[0];
		if(index > point){
			return elm.error();
		}else{
			return (E)this.elements[index];
		}
	}
	@Override
	public int getSize(){
		return this.point;
	}
	private void expand(){
		int newCapacity = 2*capacity;
		Object[] tempElements = new Object[newCapacity];
		for(int i=0;i<capacity;i++){
			tempElements[i] = elements[i];
		}
		elements = tempElements;
		capacity = newCapacity;
	}
	private void shrink(){
		int newCapacity = point+1;
		Object[] tempElements = new Object[newCapacity];
		for(int i=0;i<newCapacity;i++){
			tempElements[i] = elements[i];
		}
		elements = tempElements;
		capacity = newCapacity;
	}
}