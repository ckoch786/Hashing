package lists;
/**
 * 
 * @author Cory Koch
 * The lists are unbounded and allow duplicate elements, but do not allow
 * null elements. As a general precondition, null elements are not passed as 
 * arguments to any of the methods.
 * 
 * The list has a special property called the current position - the position
 * of the next element to be accessed by getNext during an iteration through
 * the list. Only reset and getNext affect the current position.
 *
 */
public interface List<T> {
	/**
	 * 
	 * @return Returns the number of elements on this list.
	 */
	int size();
	/**
	 * 
	 * @param element 
	 * Adds element to this list.
	 */
	void add(T element);
	
	/**
	 * 
	 * @param element
	 * @return  
	 * Removes an element e from this list such that e.equals(element)
	 * and returns true; if no such element exists, returns false.
	 */
	boolean remove (T element);
	
	/**
	 * 
	 * @param element
	 * @return Returns true is this list contains an element e such that
	 * e.equals(element); otherwise, returns false.
	 */
	boolean contains (T element);
	
	/**
	 * 
	 * @param element
	 * @return Returns an element e from this list such that e.equals(element);
	 * if no such element exists, returns null.
	 */
	T get(T element);
	
	/**
	 * 
	 * @return Returns a nicely formatted string that represents this list.
	 */
	String toString();
	
	/**
	 * Initializes the current position for an iteration through this list,
	 * to the first element on this list.
	 */
	void reset();
	
	/**
	 * Preconditions: The list is not empty
	 * 			      The list has been reset
	 *                The list has not been modified since the most recent reset
	 * @return  Returns the element at the current position on this list.
	 * If the current position is the last element, then it advances the value 
	 * of the current position to the first element; otherwise it advances 
	 * the value of the current position to the next element.   
	 */
	T getNext();
   
}
