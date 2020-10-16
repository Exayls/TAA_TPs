package kaban;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Section {
	
	private long id;
	private String name;
	private Collection<Fiche> fiches;
	
	public Section() {
	}
	
	public Section(String name) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(cascade = {CascadeType.PERSIST})
	public Collection<Fiche> getFiches() {
		return fiches;
	}
	public void setFiches(Collection<Fiche> list) {
		this.fiches = list;
	}
	
	public void addFiches(Fiche f ) {
		this.fiches.add(f);
	}
	
	public String toString() {
		String res = this.name + "\n";
		for (Fiche f : this.fiches) {
			res+= f + "\n";
		}
		return res;
	}
	
	
	
	
}
