package exodecorateur_angryballs.modele;

import mesmaths.cinematique.Collisions;

public abstract class BilleMvtRebond extends BilleMvtRU {

	public BilleMvtRebond(Bille billeDécoré) {
		super(billeDécoré);
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.billeDécoré.getPosition(), this.billeDécoré.getRayon(), this.billeDécoré.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);		
	}
}
