package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.vues.BoutonChoixHurlement;
import exodecorateur_angryballs.maladroit.vues.VueBillard;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;
import musique.SonLong;

/**
 * 
 * Bille s'arrétant sur les bords et subissant l'attraction des autres billes.
 *
 * Cette bille "hurle" aussi. Elle émet un son continu qui varie en fct de sa vitesse et de sa position.
 * 
 * Le son est stéréo. la balance est déterminée par la position (abscisse) de la bille
 * Le volume du son et la fréquence d'émissions augmentent avec la vitesse de la bille
 * 
 * 
 * 
 *  A MODIFIER
 *  
 *  */

public class BilleHurlanteMvtNewtonArret extends DecorateurBille implements ItemListener {
	
	private static final int DELAI_MIN = 10;    /* délai minimum de rafraichissement du son. en millisecondes */
	public static final int DELAI_MAX = 150;    /* délai maximum de rafraichissement du son. en millisecondes */
	public SonLong sonLong;                            /* bande son à diffuser */
	int i;              /* n° de l'élément de sonLong à jouer. on doit avoir i >= 0. 
	                    sonLong se charge de faire le modulo pour obtenir un indice correct
	                    et pour boucler ainsi sur le tableau inscrit dans sonLong */
	long dernierInstant;        /* dernier instant où le son a été diffusé */
	VueBillard vueBillard;
	
	private static final double COEFF_VOLUME = 6;      // plus la valeur est grande, plus le son augmente rapidement en fct de la vitesse de la boule 

	public BilleHurlanteMvtNewtonArret(Bille billeDécoré, SonLong sonLong, VueBillard vueBillard) {
		super(billeDécoré);
		this.sonLong = sonLong;
		i = 0;
		dernierInstant = System.currentTimeMillis();
		this.vueBillard = vueBillard;
	}
	
	public void déplacer(double deltaT)
	{
	   super.billeDécoré.déplacer(deltaT);
	   Vecteur p = this.billeDécoré.getPosition();
	   Vecteur v = this.billeDécoré.getVitesse();
	   double xMax;

	   xMax = vueBillard.largeurBillard();

	   double n = v.norme();
	//double n2 = v.normeCarrée();
	   double y = Math.exp(-COEFF_VOLUME*n);                // y = e^(-COEFF*n). on obtient donc 0 < y <= 1
	   double volume = 1-y;                                 // on obtient 0 <= volume < 1 avec volume == 0 si n == 0  et volume proche de 1 si n est grand
	   double x1 = p.x/xMax;                   /* on obtient 0 <= x1 <= 1 */ ////System.err.println("dans BilleHurlante.déplacer() : x1 =  "+ x1);
	   double balance = 2*x1 - 1;              // on obtient -1 <= balance <= 1
	                                                                ////System.err.println("volume = " + volume);
	//double v2 = volume*volume;
	   int délai = (int)(DELAI_MIN*volume + DELAI_MAX*y);              /* le délai entre 2 diffusions diminue lorsque la vitesse augmente */
	   long instant = System.currentTimeMillis();
	   if (instant - this.dernierInstant >=délai)                      /* la fréquence de diffusion augmente donc avec la vitesse de la bille */
	   {
	       double coeffPitch = 1; 
	       this.sonLong.joue(i++, volume, balance, coeffPitch);            /* le son est diffusé dans un thread séparé */
	       this.dernierInstant= instant;
	    }
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		Collisions.collisionBilleContourAvecArretHorizontal(this.billeDécoré.getPosition(), this.billeDécoré.getRayon(), this.billeDécoré.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.billeDécoré.getPosition(), this.billeDécoré.getRayon(), this.billeDécoré.getVitesse(), ordonnéeCoinHautGauche, hauteur);		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() instanceof BoutonChoixHurlement)
	    {
	        BoutonChoixHurlement boutonChoixHurlement = (BoutonChoixHurlement)(e.getSource());
	        this.sonLong = boutonChoixHurlement.sonLong;                                //System.err.println("dans BilleHurlanteMvtNewtonArret.itemStateChanged");
	    }		
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDécoré.gestionAccélération(billes);	
		this.billeDécoré.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes));     // contribution de l'accélération due é l'attraction des autres billes
	}
}
