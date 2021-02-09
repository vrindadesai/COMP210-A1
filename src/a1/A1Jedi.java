package a1;

import java.util.Scanner;

import java.util.*;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//Catalogs all items with blank counter
		int itemsInStore = scan.nextInt();
		//Initializes dictionaries that will include the item as key
		//Dictionary will track how many of that item were purchased
		Dictionary<String, java.lang.Integer> itemInventory = new Hashtable<>();
		//Dictionary will track how many customer purchased an item
		Dictionary<String, java.lang.Integer> customerCount = new Hashtable<>();
		//Initializes array that just include items in the store
		String[] itemsInStoreArray = new String[itemsInStore];
		int s = 0;
		int counter = 0;
		//Will loop for each item present in the store
		while (s < itemsInStore) {
			String item = scan.next();
			double price = scan.nextDouble();
			// Store item as key and counter as value, so counter can be called by referenced by item
			itemInventory.put(item, counter);
			customerCount.put(item, counter);
			itemsInStoreArray[s] = item;
			s++;
		}

		//Adds to both counters (item and customer)
		int numberOfCustomers = scan.nextInt();
		int c = 0;
		//Will loop for each customer in the store
		while (c < numberOfCustomers) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numberOfItemsPurchased = scan.nextInt();
			int i = 0;
			//Initialize and array which will track what item a customer bought WITHOUT repeats
			//The array has how every many items a customer purchased, but there may be empty spots because of repeats
			String[] itemArray = new String[numberOfItemsPurchased];
			//Will loop for each inidvidually written item a customer purchases
			while (i < numberOfItemsPurchased) {
				int quantityOfItem = scan.nextInt();
				String itemBought = scan.next();
				//Updates the counter that tracks how many of an item was purchased
				int updatedStock = itemInventory.get(itemBought) + quantityOfItem;
				itemInventory.put(itemBought, updatedStock);
				int a = 0;
				//Will update the array of items a customer bought
				while (a < itemArray.length) {
					//If the item already appears in the array, the loop will be fulfilled
					if (itemBought.equals(itemArray[a])) {
						a = itemArray.length;
					} else {
						//Once the loop reaches the end of the array and the item has not been see, it can be added
						if (a == itemArray.length - 1) {
							int b = 0;
							//This loop finds the next empty spot in the array where the item can be added
							while (b < itemArray.length) {
								if (itemArray[i] == null) {
									//Item is added in an empty spot
									itemArray[i] = itemBought;
									//Both loops are fulfilled
									b = itemArray.length;
									a = itemArray.length;
								} else {
									//Otherwise the loop repeats until there is an empty spot
									b++;
								}

							}
						//If the loop has not reached the end of the array, it will continue checking each spot
						} else {
							a++;
						}
					}
				}
				i++;
			}
			//Using itemArray that has eliminated repeats, the counter for how many customers purchased an item will be updated
			int d = 0;
			while (d < itemArray.length) {
				//If the spot is empty, it's ignored
				if (itemArray[d] != null) {
					int updatedCounter = customerCount.get(itemArray[d]) + 1;
					customerCount.put(itemArray[d], updatedCounter);
				}
				d++;
			}
			c++;
		}

		//Prints out final results of each product
		int e = 0;
		while (e < itemsInStoreArray.length) {
			//How many people bought an item
			int amountOfCustomer = customerCount.get(itemsInStoreArray[e]);
			//How many of an item was bought
			int amountOfItem = itemInventory.get(itemsInStoreArray[e]);
			//If 0 customers purchased an item, then it will print so
			if (amountOfCustomer == 0) {
				System.out.println("No customers bought " + itemsInStoreArray[e]);
			//Otherwise it will print how many people bought how many of an item
			} else {
				System.out.println(amountOfCustomer + " customers bought " + amountOfItem + " " + itemsInStoreArray[e]);
			}
			e++;

		}
	}
}

