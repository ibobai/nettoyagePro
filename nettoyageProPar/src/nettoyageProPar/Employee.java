package nettoyageProPar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {

	private String nomPrenom;
	private String login;
	private String mdp;
	private List<Operation> operations;

	/**
	 * constructor par defaut
	 */
	public Employee() {
		super();
		this.operations = new ArrayList<>();
	}

	/**
	 * creation employer saisissant nomPrenom, etc...
	 */
	public Employee(String nomPrenom, String login, String mdp) {
		super();
		this.nomPrenom = nomPrenom;
		this.login = login;
		this.mdp = mdp;
		this.operations = new ArrayList<>();
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	/**
	 * affichage du menu apres s'etre connectee"
	 */
	public String affichageMenu() {

		return "Bonjour : " + this.getNomPrenom() + "\r\n"
				+ "-------------------------------    Nettoyage Pro Par   ------------------------------------------------\r\n"
				+ "A-	Creer une operation\r\n" + "B-	Lister mes operations en cours\r\n"
				+ "C-	Terminer une operation\r\n" + "D-	Afficher la liste des opetation en cours\r\n"
				+ "E-	Quitter\r\n"
				+ "---------------------------------------------------------------------------------------------------------------------\r\n"
				+ "Votre choix   : \r\n" + "";

	}

	public int theLogin(ArrayList<Employee> employees, Employee typeDemployee) {
		/**
		 * A method for users login !
		 */

		System.out.println(
				"\n------------------------- Bien venu ----------------------------\n\tSachez que vous avez 3 essaies pour vous vous connceter.");
		Scanner scan = new Scanner(System.in);

		int existe = 0;
		Employee theUser = new Employee();

		int essaies = 1;
		while (essaies != 4 && existe != 1) {
			System.out.print("Entrez votr login SVP : ");
			String login = scan.nextLine();

			for (Employee employee : employees) {
				existe = employee.getLogin().equals(login)
						&& (employee.getClass().getName().equals(typeDemployee.getClass().getName())) ? 1 : 0;
				theUser = employee;
			}
			essaies++;
		}

		if (existe == 1) {

			essaies = 1;
			existe = 0;
			while (essaies != 4 && existe != 1) {
				System.out.print("Entrez votre mot de passe SVP: ");
				String mdp = scan.nextLine();
				existe = mdp.equals(theUser.getMdp()) ? 1 : 0;
				essaies++;
			}

		}

		return existe;

	}

	public void login(ArrayList<Employee> employees) {
		System.out.println("-------------------------");
		Scanner scan = new Scanner(System.in);
		System.out.print("Vous êtes : \n A- Expert.\n B- Senior.\n C- Aprenti.");
		System.out.println("\n--------------------------");
		System.out.print("Entrez votre role SVP: ");
		String sonType = scan.nextLine();
		String message = "";
		int verif = 0;

		if (sonType.equalsIgnoreCase("A")) {
			verif = this.theLogin(employees, new Expert());
			if (verif == 1) {
				message = "Bien venu admin";
			} else {
				message = "Vous n'êtes pas un admin! ";
			}
		} else if (sonType.equalsIgnoreCase("B")) {
			verif = this.theLogin(employees, new Senior());
			if (verif == 1) {
				message = "Bien venu " + this.getNomPrenom();
			} else {
				message = "Vous n'êtes pas un senior! ";
			}
		} else if (sonType.equalsIgnoreCase("C")) {
			verif = this.theLogin(employees, new Apprenti());
			if (verif == 1) {
				message = "Bien venu " + this.getNomPrenom();
			} else {
				message = "Vous n'êtes pas un appernti! ";
			}
		} else {
			System.out.println("Valeur inccorrect!");
		}

		System.out.println(message);

	}

	public void afficherLaListe() {
		if (operations.isEmpty()) {
			System.out.println("La listes des operation est vide!");
		} else {
			System.out.println("La liste des operations en cours :\r\n");
			for (Operation operation : operations) {
				System.out.println(operation.toString());
				System.out.println("----------------------------\r\n");

			}

		}

	}

	public Operation CreeUneOperation() {
		Operation operation = new Operation();
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"-------------------------------    Creation d'une Operation   ------------------------------------------------\r\n");
		System.out.println("Nom Projet : ");
		operation.setNom(sc.next());
		System.out.println("Nom Prenom client : ");
		operation.setNomPrenomClient(sc.next());
		System.out.println("Type d'operation : \r\n" + "A-" + operation.getType().GRAND + " \r\n" + "B-"
				+ operation.getType().MOY + "\r\n" + "C-" + operation.getType().PETIT + "\r\n");
		String option = sc.next();
		option = option.toUpperCase();
		if (option.equals("A")) {
			operation.setType(operation.getType().GRAND);
		}
		if (option.equals("B")) {
			operation.setType(operation.getType().MOY);
		}
		if (option.equals("C")) {
			operation.setType(operation.getType().PETIT);
		}
		System.out.println("Fiche projet: ");
		System.out.println(operation.afficherFicheOperation());
		operation.setEmployee(this);
		this.operations.add(operation);
		return operation;
	}

}
