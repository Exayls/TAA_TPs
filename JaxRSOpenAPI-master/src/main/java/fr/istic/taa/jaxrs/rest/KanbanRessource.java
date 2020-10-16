package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import fr.istic.taa.jaxrs.dao.generic.TableauDAO;
import fr.istic.taa.jaxrs.domain.Tableau;


@Path("/Kanban")
@Produces({"application/json","application/xml"})
public class KanbanRessource {
	
	private TableauDAO dao;

	public KanbanRessource() {
		this.dao = new TableauDAO();
		this.dao.setClazz(Tableau.class);
	}
	
	@GET
	@Path("/first")
	public Tableau getKanban() {
		return this.dao.findAll().get(0);

	}
}