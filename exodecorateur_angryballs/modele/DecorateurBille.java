package exodecorateur_angryballs.modele;

import java.awt.Graphics;
import java.util.Vector;

import controlleurs.ControleurGeneral;
import mesmaths.geometrie.base.Vecteur;

public abstract class DecorateurBille extends Bille {
	
	protected Bille billeDécoré; // le client qui doit être décoré. c'est-à-dire l'objet dont on va compléter un traitement
	ControleurGeneral controleurGeneral;

	/**
	 * @param clientDécoré : le client qui va être décoré. Celui dont un traitement va être complété par this
	 */
	public DecorateurBille(Bille billeDécoré)
	{
	    this.billeDécoré = billeDécoré;
	}

	@Override
	public Vecteur getPosition() {
		return this.billeDécoré.getPosition();
	}
	
	public void setPosition(Vecteur vecteur) {
		this.billeDécoré.setPosition(vecteur);
	}

	@Override
	public double getRayon() {
		return this.billeDécoré.getRayon();
	}

	@Override
	public Vecteur getVitesse() {
		return this.billeDécoré.getVitesse();
	}

	@Override
	public Vecteur getAccélération() {
		return this.billeDécoré.getAccélération();
	}

	@Override
	public int getClef() {
		return this.billeDécoré.getClef();
	}

	@Override
	public double masse() {
		return this.billeDécoré.masse();
	}

	@Override
	public void dessine(Graphics g) {
		this.billeDécoré.dessine(g);	
	}
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return this.billeDécoré.gestionCollisionBilleBille(billes);
	}

	@Override
	public String toString() {
		return this.billeDécoré.toString();
	}
}
