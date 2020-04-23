package org.shope.Resource;

public class Commande {
	
	public String produit;
	public float total;
	public int qte;
	public Commande() {
		super();
	}
	public Commande(String produit, float total, int qte) {
		super();
		this.produit = produit;
		this.total = total;
		this.qte = qte;
	}
	
	

}
