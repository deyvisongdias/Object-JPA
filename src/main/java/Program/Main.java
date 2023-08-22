package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.ImportedProduct;
import dominio.Product;
import dominio.UsedProduct;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testejpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// em.persist(p1);

		Product product = null, importedProduct = null, usedProduct = null;
		int numberP;
		char ver;
		String name;
		Double price;
		System.out.println("Enter with number of products:");
		numberP = sc.nextInt();
		for (int i = 0; i < numberP; i++) {
			System.out.println("Common, used or imported (c/u/i)?");
			ver = sc.next().charAt(0);
			if (ver == 'c') {
				System.out.println("Enter with name");
				name = sc.next();
				System.out.println("Enter with price");
				price = sc.nextDouble();
				product = new Product(name, price);

			}
			if (ver == 'i') {
				System.out.println("Enter with name");
				name = sc.next();
				System.out.println("Enter with price");
				price = sc.nextDouble();
				importedProduct = new ImportedProduct(name, price, 20.0);

			}
			if (ver == 'u') {
				System.out.println("Enter with name");
				name = sc.next();
				System.out.println("Enter with price");
				price = sc.nextDouble();
				usedProduct = new UsedProduct(name, price, 30.0);

			} else {
				break;
			}
		}
		em.persist(product);
		em.persist(importedProduct);
		em.persist(usedProduct);

		em.getTransaction().commit();
		sc.close();
		System.out.println("pronto");
	}
}
