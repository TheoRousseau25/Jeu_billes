package exodecorateur_angryballs.modele;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.event.MouseInputListener;

import controlleurs.ControleurAttrapable;
import controlleurs.ControleurAttrap�e;
import controlleurs.ControleurGeneral;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class BillePilot� extends DecorateurBille  {
	
	ControleurGeneral controleurGeneral;
	ControleurAttrapable controleurAttrapable;
	ControleurAttrap�e controleurAttrap�e;
	MouseEvent e;
	
	public BillePilot�(Bille billeD�cor�) {
		super(billeD�cor�);
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


	public ControleurAttrap�e getControleurAttrap�e() {
		return controleurAttrap�e;
	}


	public void setControleurAttrap�e(ControleurAttrap�e controleurAttrap�e) {
		this.controleurAttrap�e = controleurAttrap�e;
	}


	private void GenererGrapheControleurs() {
		this.controleurAttrapable = new ControleurAttrapable(this, null, null);
		this.controleurAttrap�e = new ControleurAttrap�e(this, controleurAttrapable, controleurAttrapable);
		this.controleurAttrapable.setRetour(this.controleurAttrap�e);
		this.controleurAttrapable.setSuivant(this.controleurAttrap�e);
		this.controleurGeneral = this.controleurAttrapable;
	}
	
	public void gestionSouris(MouseEvent e) {
		this.e = e;
		this.controleurGeneral.verifierSouris(e, this.getControleurGeneral());
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.billeD�cor�.getPosition(), this.billeD�cor�.getRayon(), this.billeD�cor�.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);		
	}
	
	public void dessine(Graphics g) {
		super.billeD�cor�.dessine(g);
		controleurGeneral.dessine(this, g);
	}
	
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		super.billeD�cor�.gestionAcc�l�ration(billes);
		controleurGeneral.gestionAcc�l�ration(this, billes, e);
	}


}
