package lab04;

public class HashTableQuad {
	
	private int probes2; //integer representing number of keys 
	private double loadFactor2; //integer representing the load factor
	private int size2; // integer representing the size
	private Integer[] table2; //private variable of type Integer to store keys
	private int numKeys2 = 0;
	
	
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
	
    public HashTableQuad() {
    	size2 = 0;
        table2 = null;
        probes2 = 0;
        loadFactor2 = 0.0;
        numKeys2 = 0;
    }
	
	
	
	//LAB CODES
	
	

	//This method creates the hash table. It finds a prime number which works for the table size, and sets the load factor.
	public HashTableQuad(int maxNum, double load) {
		int temp  = (int) (maxNum/load);
		temp = primeNumberFinder(temp);
		loadFactor2 = load;
		size2 = temp;
		table2 = new Integer[size2];
	}
	
	/*This method returns true if the integer n is found in the array and, false if it is not. This function has a worst case 
	*time complexity of n and best case of 1*/
	public boolean isIn(int n) {
		int counter = 0;
		for(counter = 0 ; counter < size2; counter++) {
			if(table2[counter] != null) {
				if(table2[counter] == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	public void insert(int n) {
		int check = 0;
		if(isIn(n) == true) {
			System.out.println("Already in table");
			return;
		}
		for (int i = 0; i < size2; i++) {
			if(table2[i] == null) {
				check = 1;
				break;
			}
		}
		if (check == 0) {
			this.rehash();
		}
		
		if (isIn(n) == false) {
			int x = 1;
			int temp = x*x; 
			if (table2[n%size2]==null) {
				table2[n%size2] = n;
				temp = 0;
			}
			while(temp!=0) {
				if(table2[((n)%size2 + temp)%size2] == null) {
					table2[((n)%size2+temp)%size2] = n;
					temp = 0;
				}
				else {
					x ++;
					temp = x*x;
					this.probes2 = x;
					if(x>size2) {
						this.rehash();
						this.insert(n);
						return;
					}
				}
			}
			
		}
	}
	
	
	//this methopd is used to rehash a table. Its main function is really creating a new table with new sizes. The insert function 
	//will insert all values
	public void rehash() {
		int newsize = 2*size2;
		newsize = primeNumberFinder(newsize);
		Integer[] newtable = new Integer[newsize];
		HashTableQuad newSoln = new HashTableQuad();
		newSoln.size2 = newsize;
		newSoln.table2 = newtable;
		newSoln.loadFactor2 = loadFactor2;
		
		for (int counter = 0 ; counter < this.size2 ; counter++) {
			if(this.table2[counter] != null) {
				newSoln.insert(this.table2[counter]);
			}
		}
		
		
		
		this.table2 = newSoln.table2;
		this.size2 = newSoln.size2;
		this.loadFactor2 = newSoln.loadFactor2;
	}
	/*The following method will return all the values in the table*/
	public void printKeys() {
		for (int counter = 0; counter < size2; counter++) {
			if(table2[counter] != null) {
				System.out.println("Value: " + table2[counter]);
			}
		}
	}
	
	/*The following method will return all the values with their indexes in the table*/
	public void printKeysandIndexes() {
		for (int counter = 0; counter < size2; counter++) {
			if(table2[counter] != null) {
				System.out.println("Value: " + table2[counter] + " Index: " + counter);
			}
		}
	}
	
	
	
	//this method returns the loadfactor
	public double getLoad() {
		return loadFactor2;
	}
	
	
	//this method returns the size of the table
	public int getSize() {
		return size2;
	}
	
	public int getProbes() {
		return probes2;
	}
	
	
	public int getNumKeys() {
		for(int i = 0 ; i<size2; i++ ) {
			if(table2[i]!=null)
				numKeys2++;
		}
		return numKeys2;
	}
	
}
