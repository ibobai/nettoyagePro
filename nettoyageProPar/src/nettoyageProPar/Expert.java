package nettoyageProPar;

public class Expert extends Employee {

	public Expert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expert(String nomPrenom, String login, String mdp) {
		super(nomPrenom, login, mdp);
	
	}

	@Override
	public String affichageMenu() {
		return "Bonjour : " + this.getNomPrenom() + "\r\n"
				+ "-------------------------------    Nettoyage Pro Par   ------------------------------------------------\r\n"
				+ "A-	Creer une operation\r\n" + "B-	Lister mes operations en cours\r\n"
				+ "C-	Terminer une operation\r\n" + "D-	Afficher la liste des opetation en cours\r\n"
				+ "E-	Ajouter un employee\r\n" + "F-	Quitter\r\n"
				+ "---------------------------------------------------------------------------------------------------------------------\r\n"
				+ "Votre choix   : \r\n";

	}

	
	
}
