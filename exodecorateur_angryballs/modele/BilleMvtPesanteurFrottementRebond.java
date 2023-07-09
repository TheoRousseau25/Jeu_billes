package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public class BilleMvtPesanteurFrottementRebond extends BilleMvtFrottementRebond {
	
	Vecteur pesanteur;

	public BilleMvtPesanteurFrottementRebond(Bille billeDécoré, Vecteur pesanteur) {
		super(billeDécoré);
		this.pesanteur = pesanteur;
	}
	
	public void gestionAccélération(Vector<Bille> billes)
	{
		this.accélération(billes);                              // remise à zéro du vecteur accélération
	    this.getAccélération().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
	}
}
