package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kaban.Tableau;
import kaban.TableauDAO;

@Controller
public class TableauController {
	
	
	@RequestMapping("/create")
	  @ResponseBody
	  public String create(String name) {
	    String id = "";
	    try {
	      Tableau t = new Tableau( name);
	      dao.saveTableau(t);
	      id = String.valueOf(t.getId());
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "table succesfully created with id = " + id;
	  }
	  
	  
	  @Autowired
	  private TableauDAO dao;
	  
	  
	  
}
