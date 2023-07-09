package controlleurs;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.BillePilot�;
import mesmaths.mecanique.MecaniquePoint;

public class ControleurAttrapable extends ControleurGeneral {

	public ControleurAttrapable(BillePilot� billePilot�, ControleurGeneral retour, ControleurGeneral suivant) {
		super(billePilot�, retour, suivant);
	}

	@Override
	public void dessine(BillePilot� billePilot�, Graphics g) {
		
	}



	@Override
	public void gestionAcc�l�ration(Bille g, Vector<Bille> billes, MouseEvent e) {
        g.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(g.masse()*0.1 , g.getVitesse().produit(g.masse()/10000)));		
	}

}
