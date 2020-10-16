package sample.simple.Provider;

import java.util.Map;

public interface Iprovider {
	public int getPrice(String produit);
	public void order(String produit, int quantite, Map<String, Integer> produitQuantite);
}
