package controlleurs;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.BillePilot�;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;


public class ControleurAttrap�e extends ControleurGeneral {

	public ControleurAttrap�e(BillePilot� billePilot�, ControleurGeneral retour, ControleurGeneral suivant) {
		super(billePilot�, retour, suivant);
	}

	@Override
	public void dessine(BillePilot� billePilot�, Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gestionAcc�l�ration(Bille g, Vector<Bille> billes, MouseEvent e) {
        Vecteur position = g.getPosition();
        Vecteur actuel = new Vecteur(e.getX(), e.getY());
        Vecteur direction = actuel.difference(position);
        direction = direction.produit(0.0001);
        direction = direction.produit(10.0);
        double reducteur = 5;
        if (direction.x < 0) {
            direction.x = -calculate(-direction.x, reducteur);
        } else {
            direction.x = calculate(direction.x, reducteur);

        }
        if (direction.y < 0) {
            direction.y = -calculate(-direction.y, reducteur);
        } else {
            direction.y = calculate(direction.y, reducteur);

        }
        direction = direction.produit(0.01);

        g.getAcc�l�ration().ajoute(direction);
        g.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(g.masse() * 0.1, g.getVitesse().produit(g.masse() / 10000)));	
	}

}
