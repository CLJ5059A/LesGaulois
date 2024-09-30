package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];


	public Gaulois(String nom, int force,int nbTrophees) {
		this.nom = nom;
		this.force = force;
		this.nbTrophees = nbTrophees;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
//	private String prendreParole() {
//		return  "Le gaulois " + nom + " : ";
//	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force*effetPotion/3);
//	}
	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, Je sens que ma force est "
		+ effetPotion + " fois d'écuplée");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}
	
	public void faireUneDonnation(Musee musee) {
		parler("Je donne au musee tous mes trophees : ");
		for (int i = 0; i != nbTrophees;i++) {
			musee.donnerTrophee(this, trophees[i]);
			System.out.println("- " + trophees[i].toString());
		}
		nbTrophees = 0;
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8, 0);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.boirePotion(7);
	}
}
