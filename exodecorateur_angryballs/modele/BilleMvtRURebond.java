package exodecorateur_angryballs.modele;

import java.awt.event.ItemEvent;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class BilleMvtRURebond extends BilleMvtRebond {

	public BilleMvtRURebond(Bille billeD�cor�) {
		super(billeD�cor�);
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
          this.billeD�cor�.gestionAcc�l�ration(billes);		
	}
}
