package exodecorateur_angryballs.modele;

import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public abstract class Bille 
{
//----------------- classe Bille-------------------------------------

/**
 * @return the position
 */
public abstract Vecteur getPosition();

/**
 * @return the rayon
 */
public abstract double getRayon();

/**
 * @return the vitesse
 */
public abstract Vecteur getVitesse();

/**
 * @return the acc�l�ration
 */
public abstract Vecteur getAcc�l�ration();

/**
 * @return the clef
 */
public abstract int getClef();

public abstract double masse();

/**
 * mise � jour de position et vitesse � t+deltaT � partir de position et vitesse � l'instant t
 * 
 * modifie le vecteur position et le vecteur vitesse
 * 
 * laisse le vecteur acc�l�ration intact
 *
 * La bille subit par d�faut un mouvement uniform�ment acc�l�r�
 * */
public  void  d�placer( double deltaT)
{
    Cinematique.mouvementUniform�mentAcc�l�r�( this.getPosition(), this.getVitesse(), this.getAcc�l�ration(), deltaT);
}

/**
 * calcul (c-�-d mise � jour) �ventuel  du vecteur acc�l�ration. 
 * billes est la liste de toutes les billes en mouvement
 * Cette m�thode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
 * La nature du calcul du vecteur acc�l�ration de la bille  est d�finie dans les classes d�riv�es
 * A ce niveau le vecteur acc�l�ration est mis � z�ro (c'est � dire pas d'acc�l�ration)
 * */
public  void gestionAcc�l�ration(Vector<Bille> billes) {
	this.getAcc�l�ration().set(Vecteur.VECTEURNUL);
}

/**
 * gestion de l'�ventuelle  collision de cette bille avec les autres billes
 *
 * billes est la liste de toutes les billes en mouvement
 * 
 * Le comportement par d�faut est le choc parfaitement �lastique (c-�-d rebond sans amortissement)
 * 
 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliqu�es dans le choc sont modifi�es
 * si renvoie false, il n'y a pas de collision et les billes sont laiss�es intactes 
 * */
public  boolean gestionCollisionBilleBille(Vector<Bille> billes) {
	 return OutilsBille.gestionCollisionBilleBille(this, billes);
}

/**
 * gestion de l'�ventuelle collision de la bille (this) avec le contour rectangulaire de l'�cran d�fini par (abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur)
 * 
 * d�tecte si il y a collision et le cas �ch�ant met � jour position et vitesse
 * 
 * La nature du comportement de la bille en r�ponse � cette collision est d�finie dans les classes d�riv�es
 * */
public abstract void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur);

public abstract void dessine (Graphics g);

public abstract String toString();

protected abstract void setPosition(Vecteur vecteur);

public boolean pointIsInsideBille(Vecteur vecteur) {
	   double distance = Math.sqrt(Math.pow(vecteur.x - this.getPosition().x, 2) + Math.pow(vecteur.y - this.getPosition().y, 2));
       return distance < this.getRayon();
}


//----------------- classe Bille -------------------------------------
}


