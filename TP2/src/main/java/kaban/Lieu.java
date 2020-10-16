package kaban;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lieu {
	private long id;
	private String name;
	
	
	public Lieu() {
	}
	
	public Lieu(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return this.name;
	}
	
	public String toString(){
		return this.name;
	}
}
