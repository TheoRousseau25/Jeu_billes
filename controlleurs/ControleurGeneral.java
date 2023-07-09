package controlleurs;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.event.MouseInputListener;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.BillePiloté;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public abstract class ControleurGeneral  {
	
	BillePiloté billePiloté;
	ControleurGeneral retour, suivant;
	
	public ControleurGeneral(BillePiloté billePiloté, ControleurGeneral retour, ControleurGeneral suivant){
		this.billePiloté = billePiloté;
		this.retour = retour;
		this.suivant = suivant;
	}
	
	public BillePiloté getBillePilote() {
		return this.billePiloté;
	}
	
	public ControleurGeneral getRetour() {
		return this.retour;
	}
	
	public ControleurGeneral getSuivant() {
		return this.suivant;
	}
	
	public void setRetour(ControleurGeneral retour) {
		this.retour = retour;	
	}

	public void setSuivant(ControleurGeneral suivant) {
		this.suivant = suivant;
	}

	protected double calculate(double d, double reducteur) {
		return d*reducteur;
	}
	
	public abstract void gestionAccélération(Bille g, Vector<Bille> billes, MouseEvent e);
	

	public void verifierSouris(MouseEvent e, ControleurGeneral controleur) {
		if(e.getID() == MouseEvent.MOUSE_DRAGGED){
			if(this.getBillePilote().pointIsInsideBille(new Vecteur(e.getX(), e.getY()))) {
				this.getBillePilote().setControleurGeneral(controleur.getSuivant());
			}
		}
		
	}

	public abstract void dessine(BillePiloté billePiloté, Graphics g);
	
	
}
