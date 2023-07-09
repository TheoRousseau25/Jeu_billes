package exodecorateur_angryballs.modele;

import java.awt.event.ItemEvent;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class BilleMvtRURebond extends BilleMvtRebond {

	public BilleMvtRURebond(Bille billeDécoré) {
		super(billeDécoré);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
          this.billeDécoré.gestionAccélération(billes);		
	}
}
