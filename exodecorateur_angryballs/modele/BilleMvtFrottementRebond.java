package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;

public class BilleMvtFrottementRebond extends BilleMvtRebond {

	public BilleMvtFrottementRebond(Bille billeD�cor�) {
		super(billeD�cor�);
	}

	public void acc�l�ration(Vector<Bille> billes) {
		this.billeD�cor�.gestionAcc�l�ration(billes);                              // remise � z�ro du vecteur acc�l�ration
		this.billeD�cor�.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'acc�l�ration due au frottement dans l'air		
	}


}
