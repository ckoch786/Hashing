/**
*Employee.java 		Modified by Cory Koch		Chapter10
*
*Example of a class for use wih a hash table
*/
   
public class Employee implements Hashable {
   protected String name;
   protected int idNum;
   protected int yearsOfService;

   protected final int MAX_ELEMENTS = 100;

   public Employee(String name, int id, int years) {
      this.name      = name;
      idNum          = id;
      yearsOfService = years;
   }

   /**
   *@return Returns an integer between 0 and MAX_ELEMENTS - 1.
   */
   public int hash() {
      return (idNum % MAX_ELEMENTS); 
   }




   //"SImple" Examples:
   /**
   *A simple list method get
   *@return Returns and element e from this list such that e.equals(element).
   */
   public Hashable get(Hashable element) {
      int location;
      int location = element.hash();
      return(Hashable)list[location];
   }

   /**
   *A simple list method add
   *Adds element to this list at position element.hash().
   */
   public void add (Hashable element) {
      int location;
      location = element.hash();
      list[location] = element;
      numElements++;
   }
   
   // Linear Probing Examples For collision handling
   /**
   *using linear probing to find a place in which to store a new element.	
   *Adds element to this list at postition element.hash();
   *or the next free array slot
   */
   public static void add (Hashable element) {
       int location;
       location = element.hash();
       while (list[location] != null)
	   location = (location + 1) % list,length;
       list[location] = element;
       numElements++;
   }

   /**
   *@return Returns an element e from this list such that e.equals(element).
   */
   public static Hashable get (Hashable element) {
       int location;
       location = element.hash();
       while(!list[location].equals(element)
	   location = (location + 1) % list.length;

       return (Hashable)list[location];
   }
   

  

}
