package exodecorateur_angryballs.maladroit;

import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.Vector;


import mesmaths.geometrie.base.Vecteur;
import musique.SonLong;
import exodecorateur_angryballs.modele.Bille;
import exodecorateur_angryballs.modele.BilleHurlanteMvtNewtonArret;
import exodecorateur_angryballs.modele.BilleMvtNewtonFrottementRebond;
import exodecorateur_angryballs.modele.BilleMvtPesanteurFrottementRebond;
import exodecorateur_angryballs.modele.BilleMvtRUPasseMurailles;
import exodecorateur_angryballs.modele.BilleMvtRURebond;
import exodecorateur_angryballs.modele.BilleNormale;
import exodecorateur_angryballs.modele.BillePiloté;
import exodecorateur_angryballs.maladroit.AnimationBilles;
import exodecorateur_angryballs.maladroit.EcouteurBoutonArreter;
import exodecorateur_angryballs.maladroit.EcouteurBoutonLancer;
import exodecorateur_angryballs.maladroit.OutilsConfigurationBilleHurlante;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import exodecorateur_angryballs.maladroit.vues.VueBillard;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement différent
 * 
 * Idéal pour mettre en place le DP decorator
 * */
public class TestAngryBalls
{

/**
 * @param args
 */
public static void main(String[] args)
{
//---------------------- gestion des bruitages : paramétrage du chemin du dossier contenant les fichiers audio --------------------------

    File file = new File(""); // là où la JVM est lancée : racine du projet

    File répertoireSon = new File(file.getAbsoluteFile(),
    "exodecorateur_angryballs"+File.separatorChar+
    "maladroit"+File.separatorChar+"bruits");

//-------------------- chargement des sons pour les hurlements --------------------------------------

    Vector<SonLong> sonsLongs = OutilsConfigurationBilleHurlante.chargeSons(répertoireSon, "config_audio_bille_hurlante.txt");
 
    SonLong hurlements[] = SonLong.toTableau(sonsLongs);                // on obtient un tableau de SonLong

//------------------- création de la liste (pour l'instant vide) des billes -----------------------

    Vector<Bille> billes = new Vector<Bille>();

//---------------- création de la vue responsable du dessin des billes -------------------------

    int choixHurlementInitial = 0;
    CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                                        "Animation de billes ayant des comportements différents. Situation idéale pour mettre en place le DP Decorator",
                                        billes,hurlements, choixHurlementInitial);

    cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 5 billes -------------------------------

    double xMax, yMax;
    double vMax = 0.1;
    xMax = cadre.largeurBillard();      // abscisse maximal
    yMax = cadre.hauteurBillard();      // ordonnée maximale

    double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le même rayon, mais ce n'est pas obligatoire

    Vecteur p0, p1, p2, p3, p4,p5,  v0, v1, v2, v3, v4, v5;    // les positions des centres des billes et les vecteurs vitesse au démarrage. 
                                                    // Elles vont être choisies aléatoirement
    

//------------------- création des vecteurs position des billes ---------------------------------

p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
p5 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

//------------------- création des vecteurs vitesse des billes ---------------------------------

v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
v5 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie à changer ---------------------------------

Bille bille1 = new BilleNormale(p0, rayon, v0, Color.red);
Bille bille2 = new BilleNormale(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow);
Bille bille3 = new BilleNormale(p2, rayon, v2, Color.green);
Bille bille4 = new BilleNormale(p3, rayon, v3, Color.cyan);
Bille bille6 = new BilleNormale(p5, rayon, v5, Color.blue);

bille1 = new  BilleMvtRURebond(bille1);
bille2 = new  BilleMvtPesanteurFrottementRebond(bille2, new Vecteur(0,0.001));
bille3 = new  BilleMvtNewtonFrottementRebond(bille3);
bille4 = new  BilleMvtRUPasseMurailles(bille4);
bille6 = new  BillePiloté(bille6);

billes.add(bille1);
billes.add(bille2);
billes.add(bille3);
billes.add(bille4);
billes.add(bille6);

Bille bille5 = new BilleNormale(p4, rayon, v4,  Color.black);

bille5 = new BilleHurlanteMvtNewtonArret(bille5, hurlements[choixHurlementInitial], cadre);

billes.add(bille5);

cadre.addChoixHurlementListener((ItemListener) bille5);  // à présent on peut changer le son de la bille qui hurle*/

cadre.getBillard().getEcouteurSouris().addBillePilote((BillePiloté) bille6);


//---------------------- ici finit la partie à changer -------------------------------------------------------------

System.out.println("billes = " + billes);


//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

//----------------------- mise en place des écouteurs de boutons qui permettent de contrôler (un peu...) l'application -----------------

EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
EcouteurBoutonArreter écouteurBoutonArrêter = new EcouteurBoutonArreter(animationBilles); 

//------------------------- activation des écouteurs des boutons et ça tourne tout seul ------------------------------

cadre.lancerBilles.addActionListener(écouteurBoutonLancer);             // pourrait être remplacé par Observable - Observer 
cadre.arrêterBilles.addActionListener(écouteurBoutonArrêter);           // pourrait être remplacé par Observable - Observer

}

}
