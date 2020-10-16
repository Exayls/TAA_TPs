package kaban;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Personne {
	
	private long id;
	
	private String nom;
	private String prenom;
	
	public Personne() {
	}
	
	public Personne(String prenom, String nom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String toString() {
		return (this.prenom + this.nom);
	}
	
	
	
	
	
}
