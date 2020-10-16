package kaban;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Fiche {
	
	private Long id;
	private String libelle;
	private Date butoire;
	private Personne executor;
	private int time;
	private Lieu lieu;
	private String url;
	private String explication;
	
	public Fiche() {
		
	}
	
	
	public Fiche(String libelle, Date b, Personne e, int time, Lieu l, String url, String explication) {
		this.libelle = libelle;
		this.butoire = b;
		this.executor = e;
		this.time = time;
		this.lieu = l;
		this.url = url;
		this.explication = explication;
	}

	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Date getButoire() {
		return butoire;
	}


	public void setButoire(Date butoire) {
		this.butoire = butoire;
	}

	@OneToOne(cascade = {CascadeType.PERSIST})
	public Personne getExecutor() {
		return executor;
	}


	public void setExecutor(Personne executor) {
		this.executor = executor;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}

	@ManyToOne(cascade = {CascadeType.ALL})
	public Lieu getLieu() {
		return lieu;
	}


	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getExplication() {
		return explication;
	}


	public void setExplication(String explication) {
		this.explication = explication;
	}
	
	public String toString() {
		return (this.libelle + "\n executeur : " + this.executor+ "\nfin : " + this.butoire 
				+ "\ntemps estime : " +this.time+ " minutes\nlieu : " + this.lieu+ "\nurl : "+ this.url+"\n" +this.explication);
	}
	
	
	
}
