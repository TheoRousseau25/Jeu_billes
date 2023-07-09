package exodecorateur_angryballs.modele;

import mesmaths.cinematique.Collisions;

public abstract class BilleMvtRebond extends BilleMvtRU {

	public BilleMvtRebond(Bille billeD�cor�) {
		super(billeD�cor�);
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.billeD�cor�.getPosition(), this.billeD�cor�.getRayon(), this.billeD�cor�.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);		
	}
}
