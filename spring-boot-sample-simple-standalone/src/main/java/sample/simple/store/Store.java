package sample.simple.store;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import sample.simple.Provider.Iprovider;
import sample.simple.bank.IBank;

@Component
public class Store implements IFastLane, ILane, IJustHaveALook {
	@Autowired
	IBank bank;
	@Autowired
	Iprovider provider;
	
	
	Map<String, Integer> produits;
	Map<String, Integer> produitQuantite;
	Map<String, Integer> cart;
	
	
	private int storeAccount;
	
	
	public Store()
	{
		storeAccount = 1;
		
		produits = new HashMap<String,Integer>();
		produitQuantite = new HashMap<String,Integer>();
		cart = new HashMap<String,Integer>();
		
		produits.put("item1", 1);
		produitQuantite.put("item1", 250);
		
		produits.put("item2", 15);
		produitQuantite.put("item2", 250);
		
	}
	
	public int getPrice(String productName) {
		
		return produits.get(productName);
	}
	
	public boolean isAvailable(String produit, int quantity) {
		
		return produitQuantite.get(produit) >= quantity;
	}
	
	public void addItemToCart(String produit, int quantite) {
		if(produitQuantite.get(produit)<quantite)
		{
			System.err.println("plus de produit");
			return;
		}
		cart.put(produit, cart.getOrDefault(produit, 0) + quantite);
				
	}
	
	
	
	public void pay(int account) {
		int total = 0;
		
		for(Entry<String, Integer> entry : cart.entrySet()){
			
			total += getPrice(entry.getKey()) * entry.getValue();
			produitQuantite.put(entry.getKey(), produitQuantite.get(entry.getKey()) - entry.getValue());
		}
		bank.transfert(account, storeAccount, total);
		
		cart.clear();
		
	}
	
	
	
	public void oneShotOrder(String produit, int quantity, int account) {
		
		this.addItemToCart(produit, quantity);
		this.pay(account);		
	}
	
	public void oneShotOrder(String produit, int account) {
		
		this.oneShotOrder( produit,  account);
		
	}


}