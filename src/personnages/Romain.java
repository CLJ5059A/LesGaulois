package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int forcebegin = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		}else {
			parler("J'abandonne...");
		}
		assert forcebegin - force > 0 ;
	}
	
	public void equiper(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		System.out.println("Le soldat " + nom + " s'équipe avec un" + equipement);
		nbEquipement++;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2 :
				System.out.println("Le soldat  " + nom + " est déjà bien protégé !");
				break;
			case 1 :
				if (equipements[0]==equipement) {
					System.out.println("Le soldat " + nom + " possède déjà " + equipement.toString() + " !");
					break;
				}
			case 0 : 
				equipements[nbEquipement] = equipement;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + " .");
				nbEquipement++;
				break;
			default :
				break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
