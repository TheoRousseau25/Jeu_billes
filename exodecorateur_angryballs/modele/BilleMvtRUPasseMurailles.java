package exodecorateur_angryballs.modele;

import java.awt.event.ItemEvent;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class BilleMvtRUPasseMurailles extends DecorateurBille {

	public BilleMvtRUPasseMurailles(Bille billeDécoré) {
		super(billeDécoré);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {

		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
		
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDécoré.gestionAccélération(billes);	
	}

}
