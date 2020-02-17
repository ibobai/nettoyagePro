package nettoyageProPar;

import java.util.Scanner;

public class Operation {
	
	private String nom;
	private Type type;
	private int prix;
	private boolean etat;
	private String nomPrenomClient;
	private Employee employee;
	
	
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Operation(String nom, Type type, boolean etat, String nomPrenomClient, Employee employee) {
		super();
		this.nom = nom;
		this.type = type;
		this.etat = etat;
		this.nomPrenomClient = nomPrenomClient;
		this.employee = employee;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public String getNomPrenomClient() {
		return nomPrenomClient;
	}
	public void setNomPrenomClient(String nomPrenomClient) {
		this.nomPrenomClient = nomPrenomClient;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Nom de projet : " + this.nom + "\r\nNom prenom Client : " + nomPrenomClient + "\r\nType operation : "
				+ type + "\r\nEmployer :" + this.employee.getNomPrenom()+ "\r\nEtat : " + (this.isEtat()?"encours":"terminee") ;
	}

	/**
	 * 
	 */
	public String afficherFicheOperation() {
		return "Nom de projet : " + this.nom + "\r\nNom prenom Client : " + nomPrenomClient + "\r\nType operation : "
				+ type + "\r\n";
	}

	public Operation CreeUneOperation() {

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"-------------------------------    Creation d'une Operation   ------------------------------------------------\r\n");
		System.out.println("Nom Projet : ");
		this.setNom(sc.next());
		System.out.println("Nom Prenom client : ");
		this.setNomPrenomClient(sc.next());
		System.out.println("Type d'operation : \r\n" + "A-" + this.getType().GRAND + " \r\n" + "B-" + this.getType().MOY
				+ "\r\n" + "C-" + this.getType().PETIT + "\r\n");
		String option = sc.next();
		option = option.toUpperCase();
		if (option.equals("A")) {
			this.setType(getType().GRAND);
		}
		if (option.equals("B")) {
			this.setType(getType().MOY);
		}
		if (option.equals("C")) {
			this.setType(getType().PETIT);
		}

		System.out.println("Fiche projet: ");
		System.out.println(this.afficherFicheOperation());

		return this;
	}
	
	
}
