package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public class BilleMvtPesanteurFrottementRebond extends BilleMvtFrottementRebond {
	
	Vecteur pesanteur;

	public BilleMvtPesanteurFrottementRebond(Bille billeD�cor�, Vecteur pesanteur) {
		super(billeD�cor�);
		this.pesanteur = pesanteur;
	}
	
	public void gestionAcc�l�ration(Vector<Bille> billes)
	{
		this.acc�l�ration(billes);                              // remise � z�ro du vecteur acc�l�ration
	    this.getAcc�l�ration().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
	}
}
