package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public String extraireInstructionsOCaml() {
		String oCaml = "let musee = [\n";
		for (int i = 0; i < nbTrophee;i++) {
			oCaml += "\t\"" + trophees[i].getGaulois().getNom() + "\", \"" +
		trophees[i].getEquipement().toString() + "\"\n";
		}
		oCaml += "]";
		return oCaml;
	}
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois,equipement);
		trophees[nbTrophee]=trophee;
		nbTrophee++;
	}
}
