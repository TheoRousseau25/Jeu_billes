package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public class BilleMvtNewtonFrottementRebond extends BilleMvtFrottementRebond {

	public BilleMvtNewtonFrottementRebond(Bille billeDécoré) {
		super(billeDécoré);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.accélération(billes);                              // remise à zéro du vecteur accélération
		this.billeDécoré.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));     // contribution de l'accélération due à l'attraction des autres billes
	}
}
