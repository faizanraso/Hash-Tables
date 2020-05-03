package lab04;

import java.util.Random;

public class TestTableClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTableLin linTable = new HashTableLin(2, 0.5);
		System.out.println("Linear Hashtable, with values inserted as 2, 22, 3, 30, 31");
		System.out.println("Size: " + linTable.getSize());
		linTable.insert(0);
		linTable.insert(5);
		linTable.insert(10);
		linTable.insert(30);
		linTable.insert(31);
		linTable.printKeysandIndexes();
		System.out.println("Is 30 in the table: " + linTable.isIn(30));
		System.out.println("Is 300 in the table: " + linTable.isIn(300));
		System.out.println("\n\n");
		
		System.out.println("Added another value to the same table, thus causing it to rehash");
		linTable.insert(5);
		System.out.println("Size: " + linTable.getSize() + " Load: " + linTable.getLoad());
		linTable.getLoad();
		linTable.printKeysandIndexes();
	
		System.out.println("\n\n");
		
		
		HashTableQuad quadTable = new HashTableQuad(2, 0.5);
		System.out.println("Quad Hashtable, with values inserted as 1, 11, 21, 28");
		System.out.println("Size: " + quadTable.getSize());
		quadTable.insert(0);
		quadTable.insert(5);
		quadTable.insert(10);
		quadTable.insert(28);

		quadTable.printKeysandIndexes();
		System.out.println("\n\n");
		
		System.out.println("Adding more values to force a rehash: ");
		quadTable.insert(52);
		quadTable.insert(27);
		quadTable.insert(19);
		quadTable.insert(927);
		System.out.println("Size: " + quadTable.getSize() +" Num of Keys: " + quadTable.getNumKeys());
		quadTable.printKeysandIndexes();
		

		
		
		
		
		
		System.out.println("\n\n");
		int n = 100;
		int n2 = 1000;
		int n3 = 100000;
		
		
		double probes = 0;
		int x = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.1");
		Random r = new Random();
		HashTableLin linear = new HashTableLin(100000, 0.1);
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.1);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(100000000));
			}
			probes += linear.getProbes();
		}
		System.out.println("Avg probes: " + probes/n3);
		
		
		probes = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.2");
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.2);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(100000000));
			}
			probes += linear.getProbes();
		}
		System.out.println("Avg probes: " + probes/n3);
		
		
		
		probes = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.3");
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.3);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(100000000));
			}
			probes += linear.getProbes();
		}
		System.out.println("Avg probes: " + probes/n3);
		
		
		probes = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.4");
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.4);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(100000000));
			}
			probes += linear.getProbes();
		}
		System.out.println("Avg probes: " + probes/n3);
		
		probes = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.5");
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.5);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(100000000));
			}
			probes += linear.getProbes();
		}
		System.out.println("Avg probes: " + probes/n3);
		
		probes = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.6");
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.6);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(100000000));
			}
			probes += linear.getProbes();
		}
		System.out.println("Avg probes: " + probes/n3);
		
		probes = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.7");
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.7);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(100000000));
			}
			probes += linear.getProbes();
		}
		System.out.println("Avg probes: " + probes/n3);
		
		
		probes = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.8");
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.8);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(100000000));
			}
			probes += linear.getProbes();
		}
		System.out.println("Avg probes: " + probes/n3);
		
		probes = 0;
		System.out.println("TESTING LINEAR WITH LAMBDA AS 0.9");
		for(int i = 0; i < n; i++) {
			linear = new HashTableLin(n2, 0.9);
			for(int j = 0; j < n2; j++) {
				linear.insert(r.nextInt(2147483647));
			}
			probes += linear.getProbes();
		}
		
		System.out.println("Avg probes: " + probes/n3);
		
		
		
		System.out.println("\n\n");
		
		
//		
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.1");
//		HashTableQuad quad = new HashTableQuad();
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.1);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000));
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
//		
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.2");
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.2);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000));
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
//
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.3");
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.3);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000));
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
//
//		
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.4");
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.4);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000));
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
//		
//
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.5");
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.5);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000));
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
//		
//
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.6");
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.6);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000)); 
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
//		
//
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.7");
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.7);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000));
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
//
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.8");
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.8);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000));
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
//
//		probes = 0;
//		System.out.println("TESTING QUAD WITH LAMBDA AS 0.9");
//		for(int i = 0; i < n; i++) {
//			quad = new HashTableQuad(n2, 0.9);
//			for(int j = 0; j < n2; j++) {
//				quad.insert(r.nextInt(100000000));
//			}
//			probes += quad.getProbes();
//		}
//		System.out.println("Avg probes: " + probes/n3);
	}
}
