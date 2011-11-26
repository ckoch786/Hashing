package exercises;

import lists.ArrayUnsortedList;
import hash.Hashable;
/**
 * 
 * @author Cory Koch
 * Use the following values
 * 66,47,87,90,126,140,145,153,177,285,393,467,566,620,735
 * 
 * Store the values of a hash table with 20 positions, using the division method 
 * of hashing and the linear probing methods of resolving collisions.
 * 
 */
public class Ex42<Integer> extends ArrayUnsortedList<Integer> implements Hashable {
	//protected int idNum;
	
	protected final int MAX_ELEMENTS = 20;

	public int hash(int idNum) {
		return ( idNum % MAX_ELEMENTS );
	}
	/**
	 * A simple list method
	 * Adds element to this list at position element.hash().
	 */
	public void add (Hashable element) {
		int location;
		int idNum = 0;
		location = element.hash(idNum);
		list[location] = (Integer) element;
		numElements++;
	}
	/**
	 * A simple list method get
	 * @param element
	 * @return Returns an element e from this list such that e.equals(element).
	 * 
	 */
	public Hashable get(Hashable element) {
		int location;
		int idNum = 0;
	    location = element.hash(idNum);
		return(Hashable)list[location];
	}
	
}
