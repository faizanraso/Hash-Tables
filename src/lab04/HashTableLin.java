package lab04;


public class HashTableLin {
	private int probes; //integer representing number of keys 
	private double loadFactor; //integer representing the load factor
	private int size; // integer representing the size
	private Integer[] table; //private variable of type Integer to store keys
	private int numKeys = 0;
	
	/*The following two methods are used as a means to obtain the next prime nuymber used for the size of the has table
	the first method determines whether or not the integer is a prime number or not*/
	public boolean primeNumber(int x) {
		int check = 0;
		if(x == 1 || x == 0) {
			return false;
		}
		else {
			for (int temp = 2; temp <=  x/2; temp ++){
				if (x % temp == 0) {
					check = 2;
				}
			}
			if(check == 2) {
				return false;
			}
			else {
				return true;
			}
		}
	}
	/*This method is responsible for finding the next prime number which will be used for the size of the table*/
	public int primeNumberFinder(int x) {
		if (primeNumber(x)==true) {
			return x;
		}
		while (primeNumber(x) != true) {
			x += 1;
		}
		return x;
	}


    public HashTableLin() {
    	size = 0;
        table = null;
        probes = 1;
        loadFactor = 0.0;
        numKeys = 0;
    }
	
	
	
	//LAB CODES
	
	
	public void insert(int n) {
		int check = 0;
		for (int i = 0; i < size; i++) {
			if(table[i] == null) {
				check = 1;
				break;
			}
			this.probes++;
		}
		if (check == 0) {
			this.rehash();
		}
		if(isIn(n) == false) {
			int temp = 1; 
			if (table[n%size]==null) {
				table[n%size] = n;
				temp = 0;
				this.probes += 1;
			}
			while(temp!=0) {
				if(table[(n%size + temp)%size] == null) {
					table[(n%size +temp)%size] = n;
					this.probes += 1;
					temp = 0;
					
				}
				else {
					temp ++;
					this.probes += 1;
				}
			}
		}
	}
	
	
	//This method creates the hash table. It finds a prime number which works for the table size, and sets the load factor.
	public HashTableLin(int maxNum, double load) {
		int temp  = (int) (maxNum/load);
		temp = primeNumberFinder(temp);
		loadFactor = load;
		size = temp;
		table = new Integer[temp];
		
	}

	/*This method returns true if the integer n is found in the array and, false if it is not. This function has a worst case 
	*time complexity of n and best case of 1*/
	public boolean isIn(int n) {
		int counter = 0;
		for(counter = 0 ; counter < size; counter++) {
			if(table[counter] != null) {
				if(table[counter] == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/*The following method will return all the values in the table*/
	public void printKeys() {
		for (int counter = 0; counter < size; counter++) {
			if(table[counter] != null) {
				System.out.println("Value: " + table[counter]);
			}
		}
	}
	
	/*The following method will return all the values with their indexes in the table*/
	public void printKeysandIndexes() {
		for (int counter = 0; counter < size; counter++) {
			if(table[counter] != null) {
				System.out.println("Value: " + table[counter] + " Index: " + counter);
			}
		}
	}
	
	//this methopd is used to rehash a table. Its main function is really creating a new table with new sizes. The insert function 
	//will insert all values
	public void rehash() {
		int newsize = 2*size;
		newsize = primeNumberFinder(newsize);
		Integer[] newtable = new Integer[newsize];
		HashTableLin newSoln = new HashTableLin();
		newSoln.size = newsize;
		newSoln.table = newtable;
		newSoln.loadFactor = loadFactor;
		
		for (int counter = 0 ; counter < this.size ; counter++) {
			if(this.table[counter] != null) {
				newSoln.insert(this.table[counter]);
				
			}
		}
		
		this.table= newSoln.table;
		this.size = newSoln.size;
		this.loadFactor = newSoln.loadFactor;
	}
	
	//this method returns the loadfactor
	public double getLoad() {
		return loadFactor;
	}
	
	
	//this method returns the size of the table
	public int getSize() {

		return size;
	}
	
	public int getProbes() {

		return probes;
	}
	
	public int getNumKeys() {
		for(int i = 0 ; i<size; i++ ) {
			if(table[i]!=null)
				numKeys++;
		}
		return numKeys;
	}
	
}
