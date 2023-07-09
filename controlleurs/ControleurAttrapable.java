package controlleurs;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.BillePiloté;
import mesmaths.mecanique.MecaniquePoint;

public class ControleurAttrapable extends ControleurGeneral {

	public ControleurAttrapable(BillePiloté billePiloté, ControleurGeneral retour, ControleurGeneral suivant) {
		super(billePiloté, retour, suivant);
	}

	@Override
	public void dessine(BillePiloté billePiloté, Graphics g) {
		
	}



	@Override
	public void gestionAccélération(Bille g, Vector<Bille> billes, MouseEvent e) {
        g.getAccélération().ajoute(MecaniquePoint.freinageFrottement(g.masse()*0.1 , g.getVitesse().produit(g.masse()/10000)));		
	}

}
