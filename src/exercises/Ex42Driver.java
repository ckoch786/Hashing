package exercises;

public class Ex42Driver {

	/**
	 * @param args
	 * @author Cory Koch
	 * 
	 */
	public static void main(String[] args) {
		//Ex42<Integer> hashTable = new Ex42<Integer>();
		
		int values[] = {66,47,87,90,126,140,145,153,
				       177,285,393,467,566,620,735};
		
		int hashTable[] = new int[20]; // create hash table
		//initialize hash table
		for (int k=0; k < hashTable.length-1; k++ ){
			hashTable[k] = 0;
		}
		
		//Fill hash table with division method
		for (int i = 0; i < values.length; i++){
			hashTable[values[i] % hashTable.length] = values[i];
		}
		//Print out hashTable
		for (int j = 0; j < values.length; j++) {
			int location;
			location = hashTable[j];
			System.out.println("The element at location " + j 
					+ " is "+ location);
		}

	}
	

}
