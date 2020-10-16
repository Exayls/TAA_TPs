package sample.simple.store;

public interface ILane {
	
	public void addItemToCart(String produit, int quantite);
	
	public void pay( int account);
}
