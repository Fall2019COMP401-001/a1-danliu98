package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
    
		int numCustomers= scan.nextInt();
		for (int i=0; i<numCustomers; i++) {
			String firstName= scan.next();
			String lastName= scan.next();
		
			int numItems = scan.nextInt();					
			double accum = 0;
			for (int j=0; j<numItems; j++) {
				int[] itemQuantArr = new int[numItems];
				itemQuantArr[j]= scan.nextInt();
				
				String[] itemNameArr = new String[numItems];
				itemNameArr[j]= scan.next();
				
				double[] itemPriceArr = new double[numItems];
				itemPriceArr[j]= scan.nextDouble();
				
				accum+= (itemQuantArr[j]*itemPriceArr[j]);
				}
			
			System.out.println(firstName.charAt(0)+ ". "+ lastName+ ": "+ String.format("%.2f", accum));
		
//			scan.close();
			}
	}
}


/*
3
Carrie Brownstein 3
2 Banana 0.75
1 Orange 1.25
2 Milk 3.15
Corin Tucker 2
3 Banana 0.75
2 Sponge 1.15
Janet Weiss 1
5 Salami 2.50

*/
