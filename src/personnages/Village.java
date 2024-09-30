package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom=nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public boolean ajouterHabitant(Gaulois habitant) {
		if (nbVillageois<villageois.length) {
			villageois[nbVillageois] = habitant;
			nbVillageois++;
			return true;
		}
		return false;
	}
	
	public Gaulois trouverHabitant(int numHabitant) {
		return villageois[numHabitant];
	}
	
	public void afficherVillageois() {
		if (chef!=null) {
			System.out.println("Dans " + nom + " du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		}else {
			System.out.println("Dans " + nom + " vivent les légendaires gaulois :");
		}
		for (int i=0;i<nbVillageois;i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30 );
//		Gaulois gaulois = village.trouverHabitant(30);
//		Le tableau possède 30 indice allant de 0 à 29. Donc l'indice 30 va au-delà du tableau.
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8, 0);
		village.ajouterHabitant(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		asterix se trouve à l'indice 0 du tableau et etant le seul villageois le reste du tableau 
//		ne contient au element
		
		village.afficherVillageois();
		Gaulois obelix = new Gaulois("Obélix", 25, 0);
		village.ajouterHabitant(obelix);
		
	}
	
}
