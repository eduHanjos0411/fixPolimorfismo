package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: "); 
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("Common, used or imported (c/u/i)? "); 
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: "); String name = sc.nextLine();
			System.out.print("Price: "); Double price = sc.nextDouble();
			if (ch == 'c') {
				list.add(new Product(name, price));
			} else if (ch == 'u') {
				System.out.println("manufacture date: ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			} else {
				System.out.print("Taxa de importacao: ");
				Double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));			
				}
		}
		
		System.out.println();
		System.out.println("ETIQUETAS DE PRECO:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
