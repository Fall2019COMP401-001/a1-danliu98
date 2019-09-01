package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numItems= scan.nextInt();
		String[] itemName= new String[numItems];
		double[] itemPrice= new double[numItems];
		
		for (int i=0; i<numItems; i++) {
			itemName[i]= scan.next();
			itemPrice[i]= scan.nextDouble();
		}

		int numCustomers= scan.nextInt();
		String[] firstName= new String[numCustomers];
		String[] lastName= new String[numCustomers];

		int[] totalEachItemBought= new int[numItems];
//      assign zero to each array slot?..		for ()
		int[] totalCustomerEachItemBought= new int[numItems];
		boolean[] noDoubleCount= new boolean[numItems];
		
		for (int j=0; j<numCustomers; j++) {
			
			for (int i=0; i<numItems; i++) {noDoubleCount[i]=false;}
			
			firstName[j]= scan.next();
			lastName[j]= scan.next();

			int itemsBought= scan.nextInt();
			for (int k=0; k<itemsBought; k++) {
				int[] itemQuant= new int[itemsBought];
				itemQuant[k]= scan.nextInt();

				String[] boughtItemName= new String[itemsBought];
				boughtItemName[k]= scan.next();

				for (int m=0; m<numItems; m++) {
					if (boughtItemName[k].equals(itemName[m])) {totalEachItemBought[m]+= itemQuant[k];}
					if (boughtItemName[k].equals(itemName[m]) && noDoubleCount[m]==false) {totalCustomerEachItemBought[m]++; noDoubleCount[m]=true;}
//					^using .equals to compare strings
					}				
				}	
			}
		
		for (int m=0; m<numItems; m++) {
			if (totalEachItemBought[m]==0) {System.out.println("No customers bought "+ itemName[m]);}
			else {System.out.println(totalCustomerEachItemBought[m]+ " customers bought "+ totalEachItemBought[m]+ " "+ itemName[m]);}
		}
		
	}
}


/*
6
Apple 0.25
Banana 0.75
Milk 3.15
Orange 1.25
Salami 2.50
Sponge 1.15
3 
Carrie Brownstein 3 2 Banana 1 Orange 2 Milk
Corin Tucker 2 3 Banana 2 Sponge
Janet Weiss 1 5 Salami


Should print:
No customers bought Apple
2 customers bought 5 Banana
1 customers bought 2 Milk
1 customers bought 1 Orange
1 customers bought 5 Salami
1 customers bought 2 Sponge
*/