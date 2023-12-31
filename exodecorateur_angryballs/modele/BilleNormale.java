package exodecorateur_angryballs.modele;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

/**
 * Cas g�n�ral d'une bille de billard
 * 
 * Aucune des classes du package maladroit.modele ne doit faire de r�f�rence � des classes de java.awt ni � aucune autre librairie graphique JAVA car 
 * le mod�le NE DOIT PAS d�pendre de la vue !!! Vous devez faire les modifications en cons�quence !! Exploitez les Design Patterns. 
 * 
 * On rappelle que ces r�f�rences � une librairie graphique sont n�fastes car si on change de librairie graphique, voire on fait migrer le projet sur android, 
 * il faut modifier les classes du mod�le. La maintenance devient catastrophique 
 * 
 *  A MODIFIER
 *  
 * 
 * */
public class BilleNormale extends Bille
{
//----------------- classe Bille-------------------------------------

public  Vecteur position;   // centre de la bille
public  double rayon;            // rayon > 0
public  Vecteur vitesse;
public  Vecteur acc�l�ration;
public int clef;                // identifiant unique de cette bille

private Color couleur;          // r�f�rence awt : mauvais

private static int prochaineClef = 0;

public static double ro = 1;        // masse volumique

/**
 * @param centre
 * @param rayon
 * @param vitesse
 * @param acc�l�ration
 * @param couleur
 */
public BilleNormale(Vecteur centre, double rayon, Vecteur vitesse,
        Vecteur acc�l�ration, Color couleur)
{
    this.position = centre;
    this.rayon = rayon;
    this.vitesse = vitesse;
    this.acc�l�ration = acc�l�ration;
    this.couleur = couleur;
    this.clef = BilleNormale.prochaineClef ++;
}

/**
 * @param position
 * @param rayon
 * @param vitesse
 * @param couleur
 */
public BilleNormale(Vecteur position, double rayon, Vecteur vitesse, Color couleur)
{
    this(position,rayon,vitesse,new Vecteur(),couleur);
}

/**
 * @return the position
 */
public Vecteur getPosition()
{
    return this.position;
}

/**
 * @return the rayon
 */
public double getRayon()
{
    return this.rayon;
}

/**
 * @return the vitesse
 */
public Vecteur getVitesse()
{
    return this.vitesse;
}

/**
 * @return the acc�l�ration
 */
public Vecteur getAcc�l�ration()
{
    return this.acc�l�ration;
}

/**
 * @return the clef
 */
public int getClef()
{
    return this.clef;
}

public double masse() {return ro*Geop.volumeSph�re(rayon);}

/**
 * gestion de l'�ventuelle collision de la bille (this) avec le contour rectangulaire de l'�cran d�fini par (abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur)
 * 
 * d�tecte si il y a collision et le cas �ch�ant met � jour position et vitesse
 * 
 * La nature du comportement de la bille en r�ponse � cette collision est d�finie dans les classes d�riv�es
 * */
public  void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
}

/* cette m�thode engendre des clignotements : id�e : utiliser l'active rendering et le double buffering pour �viter �a */

public void dessine (Graphics g)    // r�f�rence awt : mauvais
    {
    int width, height;
    int xMin, yMin;
    
    xMin = (int)Math.round(position.x-rayon);
    yMin = (int)Math.round(position.y-rayon);

    width = height = 2*(int)Math.round(rayon); 

    g.setColor(couleur);
    g.fillOval( xMin, yMin, width, height);
    g.setColor(Color.CYAN);
    g.drawOval(xMin, yMin, width, height);
    }


public String toString() 
    {
    return "centre = " + position + " rayon = "+rayon +  " vitesse = " + vitesse + " acc�l�ration = " + acc�l�ration + " couleur = " + couleur + "clef = " + clef;
    }

@Override
protected void setPosition(Vecteur vecteur) {
	this.position = vecteur;
	
}





//----------------- classe Bille -------------------------------------
}


