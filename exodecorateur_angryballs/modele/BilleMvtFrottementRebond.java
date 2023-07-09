package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;

public class BilleMvtFrottementRebond extends BilleMvtRebond {

	public BilleMvtFrottementRebond(Bille billeDécoré) {
		super(billeDécoré);
	}

	public void accélération(Vector<Bille> billes) {
		this.billeDécoré.gestionAccélération(billes);                              // remise à zéro du vecteur accélération
		this.billeDécoré.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'accélération due au frottement dans l'air		
	}


}
