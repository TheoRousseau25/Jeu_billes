package exodecorateur_angryballs.modele;

public abstract class BilleMvtRU extends DecorateurBille {

	public BilleMvtRU(Bille billeDécoré) {
		super(billeDécoré);
	}

	@Override
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur);

}
