package exodecorateur_angryballs.modele;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.event.MouseInputListener;

import controlleurs.ControleurAttrapable;
import controlleurs.ControleurAttrapée;
import controlleurs.ControleurGeneral;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class BillePiloté extends DecorateurBille  {
	
	ControleurGeneral controleurGeneral;
	ControleurAttrapable controleurAttrapable;
	ControleurAttrapée controleurAttrapée;
	MouseEvent e;
	
	public BillePiloté(Bille billeDécoré) {
		super(billeDécoré);
		GenererGrapheControleurs();
	}
	
	
	public ControleurGeneral getControleurGeneral() {
		return controleurGeneral;
	}

	public void setControleurGeneral(ControleurGeneral controleurGeneral) {
		this.controleurGeneral = controleurGeneral;
	}


	public ControleurAttrapable getControleurAttrapable() {
		return controleurAttrapable;
	}


	public void setControleurAttrapable(ControleurAttrapable controleurAttrapable) {
		this.controleurAttrapable = controleurAttrapable;
	}


	public ControleurAttrapée getControleurAttrapée() {
		return controleurAttrapée;
	}


	public void setControleurAttrapée(ControleurAttrapée controleurAttrapée) {
		this.controleurAttrapée = controleurAttrapée;
	}


	private void GenererGrapheControleurs() {
		this.controleurAttrapable = new ControleurAttrapable(this, null, null);
		this.controleurAttrapée = new ControleurAttrapée(this, controleurAttrapable, controleurAttrapable);
		this.controleurAttrapable.setRetour(this.controleurAttrapée);
		this.controleurAttrapable.setSuivant(this.controleurAttrapée);
		this.controleurGeneral = this.controleurAttrapable;
	}
	
	public void gestionSouris(MouseEvent e) {
		this.e = e;
		this.controleurGeneral.verifierSouris(e, this.getControleurGeneral());
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.billeDécoré.getPosition(), this.billeDécoré.getRayon(), this.billeDécoré.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);		
	}
	
	public void dessine(Graphics g) {
		super.billeDécoré.dessine(g);
		controleurGeneral.dessine(this, g);
	}
	
	public void gestionAccélération(Vector<Bille> billes) {
		super.billeDécoré.gestionAccélération(billes);
		controleurGeneral.gestionAccélération(this, billes, e);
	}


}
