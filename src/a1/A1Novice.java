package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Collects number of customers in store
		int numberOfCustomers = scan.nextInt();
		int c = 0;
		//Will loop for each customer in the store
		while(c < numberOfCustomers) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numberOfItems = scan.nextInt();
			int i = 0;
			//Initializing array to store each individual item total for each item
			double[] itemTotalsArray = new double[numberOfItems];
			//Will loop for each item that a customer bought
			while (i < numberOfItems) {
				int quantityOfItem = scan.nextInt();
				String item = scan.next();
				//System.out.println(item);
				double price = scan.nextDouble();
				//Calculating item total with quantity and price
				double itemTotal = quantityOfItem*price;
				//Storing individual item total in the array
				itemTotalsArray[i] = itemTotal;
				i++;
			}

			//Sums all individual item totals into a complete total
			int a = 0;
			double total = 0;
			while (a < numberOfItems) {
				total = total + itemTotalsArray[a];
				a++;
			}

			//Pulls together final information and prints output
			//Scanning first character from first name
			Scanner scanChar = new Scanner(firstName);
			char firstInitial = scanChar.next().charAt(0);
			//Formatting totals so they have two decimals
			String finalTotal = String.format("%.2f", total);
			System.out.println(firstInitial + ". " + lastName + ": " + finalTotal);
			c++;
		}
		
	}
}
