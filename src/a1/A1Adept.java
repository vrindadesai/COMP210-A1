package a1;

import java.util.Scanner;

import java.util.*;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//Catalogs all items in store with its prices
		int itemsInStore = scan.nextInt();
		//Initialize dictionary with item as key and then price as value
		Dictionary<String, java.lang.Double> itemPrices = new Hashtable<>();
		int s = 0;
		//Will loop for each item in the store
		while (s < itemsInStore) {
			String item = scan.next();
			double price = scan.nextDouble();
			// Store item as key and price as value, so price can be called by referenced by item
			itemPrices.put(item, price);
			s++;
		}

		//Calculates totals for each person
		int numberOfCustomers = scan.nextInt();
		//Initialize dictionary with customer total as key and customer name as value
		Dictionary<java.lang.Double, String> customerSpending = new Hashtable<>();
		//Initialize array to store customer totals (will be utilized in calculations)
		double[] customerTotalsArray = new double[numberOfCustomers];
		int c = 0;
		//Will loop for each customer in the store
		while (c < numberOfCustomers) {
			String firstName = scan.next();
			String lastName = scan.next();
			String fullName = firstName + " " + lastName;
			int numberOfItemsPurchased = scan.nextInt();
			//Initialize array to gather individual item totals
			double[] itemTotalsArray = new double[numberOfItemsPurchased];
			int i = 0;
			//Will loop for each item purchased by a customer
			while (i < numberOfItemsPurchased) {
				int quantityOfItem = scan.nextInt();
				String itemBought = scan.next();
				//Retrieving price from item-price dictionary
				double price = itemPrices.get(itemBought);
				//Calculating item total by multiplying quantity and price
				double itemTotal = price * quantityOfItem;
				//Storing individual item total in array
				itemTotalsArray[i] = itemTotal;
				i++;
			}
			//Sums individual item totals to calculate customer's complete total
			int a = 0;
			double total = 0;
			while (a < numberOfItemsPurchased) {
				total = total + itemTotalsArray[a];
				a++;
			}
			//Puts totals into array so we can calculate min/max/avg and then reference total for name
			customerTotalsArray[c] = total;
			//Puts totals into totals-customer dictionary so we can access a customer's name based on their total
			customerSpending.put(total, fullName);
			c++;
		}

		//Calculates and prints the max
		double max = customerTotalsArray[0];
		int x = 1;
		while (x < customerTotalsArray.length) {
			if (customerTotalsArray[x] > max) {
				max = customerTotalsArray[x];
			}
			x++;
		}
		//Formats output double with two decimal places
		String biggest = String.format("%.2f", max);
		System.out.println("Biggest: " + customerSpending.get(max) + " (" + biggest + ")");


		//Calculates and prints the min
		double min = customerTotalsArray[0];
		int n = 1;
		while (n < customerTotalsArray.length) {
			if (customerTotalsArray[n] < min) {
				min = customerTotalsArray[n];
			}
			n++;
		}
		//Formats output double with two decimal places
		String smallest = String.format("%.2f", min);
		System.out.println("Smallest: " + customerSpending.get(min) + " (" + smallest + ")");

		//Calculates and print the avg
		int g = 0;
		double sum = 0;
		//Finds the sum of all totals
		while (g < customerTotalsArray.length) {
			sum = sum + customerTotalsArray[g];
			g++;
		}
		//Divides sum of all totals by the number of totals
		double avg = sum / customerTotalsArray.length;
		//Formats output double with two decimal places
		String average = String.format("%.2f", avg);
		System.out.println("Average: " + average);



	}
}
