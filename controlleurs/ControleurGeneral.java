package controlleurs;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.event.MouseInputListener;

import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.BillePilot�;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public abstract class ControleurGeneral  {
	
	BillePilot� billePilot�;
	ControleurGeneral retour, suivant;
	
	public ControleurGeneral(BillePilot� billePilot�, ControleurGeneral retour, ControleurGeneral suivant){
		this.billePilot� = billePilot�;
		this.retour = retour;
		this.suivant = suivant;
	}
	
	public BillePilot� getBillePilote() {
		return this.billePilot�;
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
	
	public abstract void gestionAcc�l�ration(Bille g, Vector<Bille> billes, MouseEvent e);
	

	public void verifierSouris(MouseEvent e, ControleurGeneral controleur) {
		if(e.getID() == MouseEvent.MOUSE_DRAGGED){
			if(this.getBillePilote().pointIsInsideBille(new Vecteur(e.getX(), e.getY()))) {
				this.getBillePilote().setControleurGeneral(controleur.getSuivant());
			}
		}
		
	}

	public abstract void dessine(BillePilot� billePilot�, Graphics g);
	
	
}
