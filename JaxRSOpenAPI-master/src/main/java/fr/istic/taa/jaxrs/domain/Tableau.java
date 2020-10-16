package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement(name="tableau")
public class Tableau implements Serializable{
	
	private long id;
	private String name;
	private Collection<Section> sections;
	
	
	public Tableau() {
		
	}
	
	public Tableau(String name) {
		this.name = name;
	}
	
	@XmlElement(name="libelle")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElementWrapper(name = "sections")
	@XmlElement(name="section")
	@OneToMany(cascade = {CascadeType.PERSIST})
	public Collection<Section> getSections() {
		return sections;
	}
	
	public void setSections(Collection<Section> list) {
		this.sections = list;
	}
	
	public void addSection(Section s ) {
		getSections().add(s);
	}
	
	@Id
	@XmlElement(name="id")
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	public String toString() {
		String res =  this.name + "\n\n";
		for (Section s : sections){
			res+= s+"\n";
		}
		return res;
	}
	
}
