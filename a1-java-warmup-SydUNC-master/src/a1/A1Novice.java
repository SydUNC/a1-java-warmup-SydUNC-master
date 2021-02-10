package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		class item {
			int quantity = 0;
			String name = "";
			double price = 0;
		}
		class customer {
			String LAST = "";
			String INITIAL = "";
			double TOTAL = 0;
			int TYPES = 0;
			item[] CART;
		}

			int count = scan.nextInt();
		customer[] Customers = new customer[count];
		item[] items = new item[50];
		for (int i=0; i< count; i++){
			Customers[i] = new customer();
			Customers[i].INITIAL = scan.next();
			Customers[i].LAST = scan.next();
			Customers[i].TYPES = scan.nextInt();
			for (int j=0; j < Customers[i].TYPES; j++){
				items[i] = new item();
				items[i].quantity = scan.nextInt();
				items[i].name = scan.next();
				items[i].price = scan.nextDouble();
				Customers[i].TOTAL += items[i].price*items[i].quantity;
			}
			Customers[i].CART = items;
		}
		for (int i=0; i<count; i++){
			System.out.println(Customers[i].INITIAL.charAt(0)+". "+Customers[i].LAST+": "+Customers[i].TOTAL);			}
		scan.close();
		}}

