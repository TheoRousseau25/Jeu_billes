package exodecorateur_angryballs.modele;

public abstract class BilleMvtRU extends DecorateurBille {

	public BilleMvtRU(Bille billeD�cor�) {
		super(billeD�cor�);
	}

	@Override
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur);

}
