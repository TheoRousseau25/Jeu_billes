package exodecorateur_angryballs.maladroit.vues;

import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.event.MouseInputListener;

import exodecorateur_angryballs.modele.BillePiloté;

public class EcouteurSouris implements MouseInputListener {
	
	Vector<BillePiloté> billePilote = new Vector<BillePiloté>();

	public Vector<BillePiloté> getBillePilote() {
		return billePilote;
	}

	public void setBillePilote(Vector<BillePiloté> bille) {
		this.billePilote = bille;
	}
	
	public void addBillePilote(BillePiloté bille) {
		this.billePilote.add(bille);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.billePilote.forEach(b->b.gestionSouris(e));			
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.billePilote.forEach(b->b.gestionSouris(e));			
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
