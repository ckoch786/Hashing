package lists;

public class ArrayUnsortedList<T> implements List<T>{
   protected final int MAX_ELEMENTS = 100; //default capacity
   protected int origCap;         //original capacity
   protected T[] list;   //array to hold this list's elements
   protected int numElements = 0; //number of elements in this list
   protected int currentPos;  //current position for iteration
   
   //set by find method
   protected boolean found; // true if element found, otherwise false
   protected int location; // indicates location of element if found
   
   public ArrayUnsortedList() {
	   list = (T[]) new Object[MAX_ELEMENTS];
	   origCap = MAX_ELEMENTS;
   }
   public ArrayUnsortedList(int origCap) { 
	   list = (T[]) new Object[origCap];
	   this.origCap = origCap;
   }
   
   /**
    * Increments the capacity of the list by an amount
    * equal to the original capacity
    * 
    */
   protected void enlarge() {
	   //Create the larger array.
	   T[] larger = (T[]) new Object[list.length + origCap];
	   
	   //Copy the contenets from the smaller array to the larger array
	   for (int i =0; i < numElements; i++) {
		   larger[i] = list[i];
	   }
	   
	   //Reassign list reference.
	   list = larger;
   }
   /**
    * Searches list for an occurrence of an element e such that
    * e.equals(target). If successful, sets instance variables
    * found to true and location to the array index of e. If
    * not successful, sets found to false.
    * @param target
    */
   protected void find(T target)  {
	   location = 0;
	   found = false;
	   
	   while (location < numElements) {
		   if (list[location].equals(target)) {
			   found = true;
			   return;
		   }else
			   location++;
	   }
   }
   /**
    * Adds element to this list.
    */
   public void add(T element) {
	   if (numElements == list.length)
		   enlarge();
	   list[numElements] = element;
	   numElements++;
   }
   /**
    * Removes an element e from this list such that e.equals(element)
    * @return and returns true; if no such element exists, returns false.
    */
   public boolean remove (T element) {
	   find(element);
	   if (found) {
		   list[location] = list[numElements -1];
		   list[numElements - 1] = null;
		   numElements--;
	   }
	   return found;
   }
   /**
    * @return Returns the number of elements on this list.
    */
   public int size() {
	   return numElements;
   }
   /**
    * @return Returns true if list contains an element e such that
    * e.equals(element); otherwise returns false.
    */
   public boolean contains (T element) {
	   find(element);
	   return found;
   }
   /**
    * @return Returns an element e from this list such that e.equals(element);
    * if no such element exists, return null.
    */
   public T get(T element) {
	   find(element);
	   if(found)return list[location];
	   else     return null;
   }
   /**
    * @return Returns a nicely formatted string that represents the list.
    */
   public String toString() {
	   String listString = "List:\n";
	   for (int i = 0; i < numElements; i++) {
		   listString = listString + " " + list[i] + "\n";
	   }
	   return listString;
   }
   /**
    * Initializes current position for an iteration through this list,
    * to the first element on this list.
    */
   public void reset() {
	   currentPos = 0;
   }
   /**
    * @preconditions The list is not empty
    *                The list has been reset
    *                The list has not been modified since the most recent reset
    * @return Returns the element at the current position on this list.
    * If the current position is the last element, it advances the value
    * of the current position to the first element; otherwise, it advances 
    * the value og the current position to the next element.
    */
   public T getNext() {
	   T next = list[currentPos];
	   if (currentPos == (numElements - 1)) currentPos = 0;
	   else currentPos++;
	   return next;
   }
}
