package a1;

import java.util.Scanner;
class item {
	int quantity = 0;
	String name = "";
	double price = 0;
}
class customer {
	String LAST = "";
	String FIRST = "";
	double TOTAL = 0;
	int ITEMS = 0;
	item[] CART;
}
public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		customer[] Customers = new customer[50];

		int itemcount = scan.nextInt();
		item[] items = new item[itemcount];
		for (int i = 0; i < itemcount; i++) {
			items[i] = new item();
			items[i].name = scan.next();
			items[i].price = scan.nextDouble();
		}
		int customercount = scan.nextInt();
		for (int j = 0; j < customercount; j++) {
			Customers[j] = new customer();
			Customers[j].FIRST = scan.next();
			Customers[j].LAST = scan.next();
			Customers[j].ITEMS = scan.nextInt();
			Customers[j].CART = new item[Customers[j].ITEMS];
			for (int k = 0; k < Customers[j].ITEMS; k++) {
				Customers[j].CART[k] = new item();
				Customers[j].CART[k].quantity = scan.nextInt();
				Customers[j].CART[k].name = scan.next();
				for (int l = 0; l < items.length; l++) {
					if (Customers[j].CART[k].name.equals(items[l].name)) {
						Customers[j].CART[k].price = items[l].price;
					}
				}
				Customers[j].TOTAL += Customers[j].CART[k].price * Customers[j].CART[k].quantity;
			}

		}

		double cur_max = Customers[0].TOTAL;
		String FIRST1 = Customers[0].FIRST;
		String LAST1 = Customers[0].LAST;
		for (int i = 0; i < customercount; i++) {
			if (Customers[i].TOTAL > cur_max) {
				cur_max = Customers[i].TOTAL;
				FIRST1 = Customers[i].FIRST;
				LAST1 = Customers[i].LAST;

			}
		}
		System.out.println("Biggest: " + FIRST1 + " " + LAST1 + " (" + cur_max + ")");

		double cur_min = Customers[0].TOTAL;
		String FIRST = Customers[0].FIRST;
		String LAST = Customers[0].LAST;
		for (int i = 0; i < customercount; i++) {
			if (Customers[i].TOTAL < cur_min) {
				cur_min = Customers[i].TOTAL;
				FIRST = Customers[i].FIRST;
				LAST = Customers[i].LAST;
			}
		}
		System.out.println("Smallest: " + FIRST + " " + LAST + " (" + cur_min + ")");

		double avg = 0;
		for (int j = 0; j < customercount; j++){
			avg += Customers[j].TOTAL;
		}
		avg = avg/customercount;
		System.out.println("Average: " + avg);

		scan.close();

	}
}
