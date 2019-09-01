package a1;

import java.util.Scanner;

public class A1Adept {

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
		double[] customerSpent= new double[numCustomers];
		double totalSpent= 0;
		
		double largestAmtSpent=0;
		String largestSpender= "";
		double smallestAmtSpent= 0;
		String smallestSpender= "";

		for (int j=0; j<numCustomers; j++) {
			firstName[j]= scan.next();
			lastName[j]= scan.next();

			int itemsBought= scan.nextInt();
			for (int k=0; k<itemsBought; k++) {
				int[] itemQuant= new int[itemsBought];
				itemQuant[k]= scan.nextInt();

				String[] boughtItemName= new String[itemsBought];
				boughtItemName[k]= scan.next();

				for (int m=0; m<numItems; m++) {
					if (boughtItemName[k].equals(itemName[m])) {customerSpent[j]+= (itemQuant[k]*itemPrice[m]);}
//					^using .equals to compare strings
				}					
			}
			totalSpent+= customerSpent[j];
//			^moved out above loop to only added up the amount of customers there are
			
			largestAmtSpent= customerSpent[0];
			largestSpender= firstName[0]+ " " +lastName[0];
			smallestAmtSpent= customerSpent[0];
			smallestSpender= firstName[0]+ " " +lastName[0];
			
			for (int n=0; n<numCustomers; n++) {
				if (largestAmtSpent<customerSpent[n]) {
					largestAmtSpent= customerSpent[n];
					largestSpender= firstName[n]+ " " +lastName[n]; }

				if (smallestAmtSpent>customerSpent[n]) {
					smallestAmtSpent= customerSpent[n];
					smallestSpender= firstName[n]+ " " +lastName[n]; }
			}
		}
		double avgSpent= totalSpent/ numCustomers;

		System.out.println("Biggest: "+ largestSpender + " ("+ String.format("%.2f", largestAmtSpent) +")");
		System.out.println("Smallest: "+ smallestSpender + " ("+ String.format("%.2f",smallestAmtSpent) +")");
		System.out.println("Average: "+ String.format("%.2f", avgSpent));
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

*/