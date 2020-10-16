package sample.simple.Provider;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Provider implements Iprovider {

	private Map<String, Integer> produits;
	
	
	public Provider() {
		
	}
	public int getPrice(String produit) {
		return produits.get(produit);
	}

	public void order(String produit, int quantite, Map<String, Integer> produitQuantite) {
		produitQuantite.put(produit, produitQuantite.getOrDefault(produit, 0)+quantite);
	}

	
	
}