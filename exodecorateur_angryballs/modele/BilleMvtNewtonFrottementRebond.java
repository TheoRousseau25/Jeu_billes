package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public class BilleMvtNewtonFrottementRebond extends BilleMvtFrottementRebond {

	public BilleMvtNewtonFrottementRebond(Bille billeD�cor�) {
		super(billeD�cor�);
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.acc�l�ration(billes);                              // remise � z�ro du vecteur acc�l�ration
		this.billeD�cor�.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));     // contribution de l'acc�l�ration due � l'attraction des autres billes
	}
}
