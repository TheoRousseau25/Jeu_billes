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
 * Bille s'arr�tant sur les bords et subissant l'attraction des autres billes.
 *
 * Cette bille "hurle" aussi. Elle �met un son continu qui varie en fct de sa vitesse et de sa position.
 * 
 * Le son est st�r�o. la balance est d�termin�e par la position (abscisse) de la bille
 * Le volume du son et la fr�quence d'�missions augmentent avec la vitesse de la bille
 * 
 * 
 * 
 *  A MODIFIER
 *  
 *  */

public class BilleHurlanteMvtNewtonArret extends DecorateurBille implements ItemListener {
	
	private static final int DELAI_MIN = 10;    /* d�lai minimum de rafraichissement du son. en millisecondes */
	public static final int DELAI_MAX = 150;    /* d�lai maximum de rafraichissement du son. en millisecondes */
	public SonLong sonLong;                            /* bande son � diffuser */
	int i;              /* n� de l'�l�ment de sonLong � jouer. on doit avoir i >= 0. 
	                    sonLong se charge de faire le modulo pour obtenir un indice correct
	                    et pour boucler ainsi sur le tableau inscrit dans sonLong */
	long dernierInstant;        /* dernier instant o� le son a �t� diffus� */
	VueBillard vueBillard;
	
	private static final double COEFF_VOLUME = 6;      // plus la valeur est grande, plus le son augmente rapidement en fct de la vitesse de la boule 

	public BilleHurlanteMvtNewtonArret(Bille billeD�cor�, SonLong sonLong, VueBillard vueBillard) {
		super(billeD�cor�);
		this.sonLong = sonLong;
		i = 0;
		dernierInstant = System.currentTimeMillis();
		this.vueBillard = vueBillard;
	}
	
	public void d�placer(double deltaT)
	{
	   super.billeD�cor�.d�placer(deltaT);
	   Vecteur p = this.billeD�cor�.getPosition();
	   Vecteur v = this.billeD�cor�.getVitesse();
	   double xMax;

	   xMax = vueBillard.largeurBillard();

	   double n = v.norme();
	//double n2 = v.normeCarr�e();
	   double y = Math.exp(-COEFF_VOLUME*n);                // y = e^(-COEFF*n). on obtient donc 0 < y <= 1
	   double volume = 1-y;                                 // on obtient 0 <= volume < 1 avec volume == 0 si n == 0  et volume proche de 1 si n est grand
	   double x1 = p.x/xMax;                   /* on obtient 0 <= x1 <= 1 */ ////System.err.println("dans BilleHurlante.d�placer() : x1 =  "+ x1);
	   double balance = 2*x1 - 1;              // on obtient -1 <= balance <= 1
	                                                                ////System.err.println("volume = " + volume);
	//double v2 = volume*volume;
	   int d�lai = (int)(DELAI_MIN*volume + DELAI_MAX*y);              /* le d�lai entre 2 diffusions diminue lorsque la vitesse augmente */
	   long instant = System.currentTimeMillis();
	   if (instant - this.dernierInstant >=d�lai)                      /* la fr�quence de diffusion augmente donc avec la vitesse de la bille */
	   {
	       double coeffPitch = 1; 
	       this.sonLong.joue(i++, volume, balance, coeffPitch);            /* le son est diffus� dans un thread s�par� */
	       this.dernierInstant= instant;
	    }
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur) {
		Collisions.collisionBilleContourAvecArretHorizontal(this.billeD�cor�.getPosition(), this.billeD�cor�.getRayon(), this.billeD�cor�.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.billeD�cor�.getPosition(), this.billeD�cor�.getRayon(), this.billeD�cor�.getVitesse(), ordonn�eCoinHautGauche, hauteur);		
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
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeD�cor�.gestionAcc�l�ration(billes);	
		this.billeD�cor�.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));     // contribution de l'acc�l�ration due � l'attraction des autres billes
	}
}
