package exodecorateur_angryballs.maladroit.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import exodecorateur_angryballs.modele.Bille;

/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class Billard extends Canvas
{
Vector<Bille> billes;
EcouteurSouris ecouteurSouris;

public EcouteurSouris getEcouteurSouris() {
	return ecouteurSouris;
}
public void setEcouteurSouris(EcouteurSouris ecouteurSouris) {
	this.ecouteurSouris = ecouteurSouris;
}

public Billard(Vector<Bille> billes)
{
    this.billes = billes;
    ecouteurSouris = new EcouteurSouris();
    this.addMouseListener(ecouteurSouris);
    this.addMouseMotionListener(ecouteurSouris);
}
    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics graphics)
    {
    int i;
    
    for ( i = 0; i < this.billes.size(); ++i)
        this.billes.get(i).dessine(graphics);
    
    //System.out.println("billes dans le billard = " + billes);
    }

    
 
}
