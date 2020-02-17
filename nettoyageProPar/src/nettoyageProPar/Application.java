package nettoyageProPar;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		 affichageGlobal();
	}

	/**
	 * afficher la fiche d'employee
	 * @param employer connecter
	 */
	private static void profelEmployee(Employee e) {
		String choix = scannerResultat(e.affichageMenu());
		while (!choix.equalsIgnoreCase("Q")) {
			if (choix.equalsIgnoreCase("A")) {
				e.CreeUneOperation();
				choix = "Q";
			}
			if (choix.equalsIgnoreCase("B")) {
				e.afficherLaListe();
			}
			if (choix.equalsIgnoreCase("C")) {
				
			}
			if (choix.equalsIgnoreCase("D")) {
				e.afficherLaListe();
			}
			if (choix.equalsIgnoreCase("E")) {
				choix = "Q";
			}
		}
	}
	
	
	


	/**
	 * affichage de l'accueil
	 */
	public static void accueil() {
		System.out.println(
				"-------------------------------   ACCUEIL   ------------------------------------------------\r\n"
						+ "A-	Se connecter\r\n" + "B-	Afficher la Liste des operations\r\n" + "Q-	Quitter \r\n");
	}

	public static String scannerResultat(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.println(str);
		return sc.next();
	}

	public static void affichageGlobal() {
		Employee e = new Senior("Ibo bai", "ibo", "ibo");
		Employee ea = new Expert("Julien", "jul", "jul");
		Operation op = new Operation("taor", Type.GRAND, true, "toto", ea);
		Operation op1 = new Operation("taor", Type.PETIT, true, "toto", e);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(e);
		//e.getOperations().add(op1);
		//e.getOperations().add(op);
		String choix = "n";

		while (!choix.equals("Q")) {
			accueil();
			choix = scannerResultat("Fait un choix");
			choix = choix.toUpperCase();
			if (choix.equals("A")) {
				e.login(employees);
				if( true ) {
					profelEmployee(e);
				}
			}
			if (choix.equals("B")) {
				e.afficherLaListe();
			}
			if (choix.equals("Q")) {
				System.exit(0);
			}
		}

	}

}