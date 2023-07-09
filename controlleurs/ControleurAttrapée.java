package controlleurs;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.BillePiloté;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;


public class ControleurAttrapée extends ControleurGeneral {

	public ControleurAttrapée(BillePiloté billePiloté, ControleurGeneral retour, ControleurGeneral suivant) {
		super(billePiloté, retour, suivant);
	}

	@Override
	public void dessine(BillePiloté billePiloté, Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gestionAccélération(Bille g, Vector<Bille> billes, MouseEvent e) {
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

        g.getAccélération().ajoute(direction);
        g.getAccélération().ajoute(MecaniquePoint.freinageFrottement(g.masse() * 0.1, g.getVitesse().produit(g.masse() / 10000)));	
	}

}
