package a1;

import java.util.Scanner;

class jediitem {
	int quantity = 0;
	int totalbought= 0;
	int custamount = 0;
	String name = "";
	double price = 0;
}
	class jedicustomer {
		String LAST = "";
		String FIRST = "";
		double TOTAL = 0;
		int ITEMS = 0;
		jediitem[] CART;
		}
public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		jedicustomer[] Customers = new jedicustomer[50];
		int itemcount = scan.nextInt();
		jediitem[] items = new jediitem[itemcount];
		for (int i = 0; i < itemcount; i++) {
			items[i] = new jediitem();
			items[i].name = scan.next();
			items[i].price = scan.nextDouble();
		}
		int customercount = scan.nextInt();
		for (int j = 0; j < customercount; j++) {
			Customers[j] = new jedicustomer();
			Customers[j].FIRST = scan.next();
			Customers[j].LAST = scan.next();
			Customers[j].ITEMS = scan.nextInt();
			Customers[j].CART = new jediitem[Customers[j].ITEMS];
			for (int k = 0; k < Customers[j].ITEMS; k++) {
				Customers[j].CART[k] = new jediitem();
				Customers[j].CART[k].quantity = scan.nextInt();
				Customers[j].CART[k].name = scan.next();
				for (int l = 0; l < items.length; l++) {
					if (Customers[j].CART[k].name.equals(items[l].name)) {
						items[l].totalbought = items[l].totalbought + Customers[j].CART[k].quantity;
						items[l].custamount = items[l].custamount + 1;
					}
				}

			}

		}
		scan.close();
		for (int m = 0; m < itemcount; m++) {
			if (items[m].custamount == 0) {
				System.out.println("No customers bought " + items[m].name);
			} else {
				System.out.println(items[m].custamount + " customers bought " + items[m].totalbought + " " + items[m].name);
			}
		}
	}
}
