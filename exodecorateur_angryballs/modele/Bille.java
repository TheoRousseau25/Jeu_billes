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
 * @return the accélération
 */
public abstract Vecteur getAccélération();

/**
 * @return the clef
 */
public abstract int getClef();

public abstract double masse();

/**
 * mise à jour de position et vitesse à t+deltaT à partir de position et vitesse à l'instant t
 * 
 * modifie le vecteur position et le vecteur vitesse
 * 
 * laisse le vecteur accélération intact
 *
 * La bille subit par défaut un mouvement uniformément accéléré
 * */
public  void  déplacer( double deltaT)
{
    Cinematique.mouvementUniformémentAccéléré( this.getPosition(), this.getVitesse(), this.getAccélération(), deltaT);
}

/**
 * calcul (c-à-d mise à jour) éventuel  du vecteur accélération. 
 * billes est la liste de toutes les billes en mouvement
 * Cette méthode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
 * La nature du calcul du vecteur accélération de la bille  est définie dans les classes dérivées
 * A ce niveau le vecteur accélération est mis à zéro (c'est à dire pas d'accélération)
 * */
public  void gestionAccélération(Vector<Bille> billes) {
	this.getAccélération().set(Vecteur.VECTEURNUL);
}

/**
 * gestion de l'éventuelle  collision de cette bille avec les autres billes
 *
 * billes est la liste de toutes les billes en mouvement
 * 
 * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond sans amortissement)
 * 
 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquées dans le choc sont modifiées
 * si renvoie false, il n'y a pas de collision et les billes sont laissées intactes 
 * */
public  boolean gestionCollisionBilleBille(Vector<Bille> billes) {
	 return OutilsBille.gestionCollisionBilleBille(this, billes);
}

/**
 * gestion de l'éventuelle collision de la bille (this) avec le contour rectangulaire de l'écran défini par (abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur)
 * 
 * détecte si il y a collision et le cas échéant met à jour position et vitesse
 * 
 * La nature du comportement de la bille en réponse à cette collision est définie dans les classes dérivées
 * */
public abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur);

public abstract void dessine (Graphics g);

public abstract String toString();

protected abstract void setPosition(Vecteur vecteur);

public boolean pointIsInsideBille(Vecteur vecteur) {
	   double distance = Math.sqrt(Math.pow(vecteur.x - this.getPosition().x, 2) + Math.pow(vecteur.y - this.getPosition().y, 2));
       return distance < this.getRayon();
}


//----------------- classe Bille -------------------------------------
}


