package exodecorateur_angryballs.modele;

import java.awt.Graphics;
import java.util.Vector;

import controlleurs.ControleurGeneral;
import mesmaths.geometrie.base.Vecteur;

public abstract class DecorateurBille extends Bille {
	
	protected Bille billeD�cor�; // le client qui doit �tre d�cor�. c'est-�-dire l'objet dont on va compl�ter un traitement
	ControleurGeneral controleurGeneral;

	/**
	 * @param clientD�cor� : le client qui va �tre d�cor�. Celui dont un traitement va �tre compl�t� par this
	 */
	public DecorateurBille(Bille billeD�cor�)
	{
	    this.billeD�cor� = billeD�cor�;
	}

	@Override
	public Vecteur getPosition() {
		return this.billeD�cor�.getPosition();
	}
	
	public void setPosition(Vecteur vecteur) {
		this.billeD�cor�.setPosition(vecteur);
	}

	@Override
	public double getRayon() {
		return this.billeD�cor�.getRayon();
	}

	@Override
	public Vecteur getVitesse() {
		return this.billeD�cor�.getVitesse();
	}

	@Override
	public Vecteur getAcc�l�ration() {
		return this.billeD�cor�.getAcc�l�ration();
	}

	@Override
	public int getClef() {
		return this.billeD�cor�.getClef();
	}

	@Override
	public double masse() {
		return this.billeD�cor�.masse();
	}

	@Override
	public void dessine(Graphics g) {
		this.billeD�cor�.dessine(g);	
	}
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return this.billeD�cor�.gestionCollisionBilleBille(billes);
	}

	@Override
	public String toString() {
		return this.billeD�cor�.toString();
	}
}
