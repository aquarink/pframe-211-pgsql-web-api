package controllers;

import static play.data.Form.form;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import library.ConnectionHttp;
import models.Tbtestweb;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result formulir() {
    	return ok(createDisp.render("FORMULIR - POST"));
    }
    
    //
    public static Result olahformulir() {
    	
    	// id
    	// descript
    	
    	Form<Tbtestweb> tbtestweb = form(Tbtestweb.class).bindFromRequest();
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	
//    	int id = declareData.get().getId();
//    	String title = declareData.get().getDescrip();
    	String data = "";
    	
    	if(tbtestweb.hasErrors()) {
    		Logger.debug("declareData hasErrors");
        } else {
        	
        	try {
//        		Tbtestweb data2 = new Tbtestweb();
//        		data2.setId(1);
//        		data2.setDescrip("salfj");
//        		data2.save();
        		tbtestweb.get().save(); // <<<<
        		
        		// success
        		
            	try {
            		
        			data = objectMapper.writeValueAsString(tbtestweb.get());
        			
        		} catch (JsonGenerationException e) {
        			Logger.debug("JsonGenerationException");
        		} catch (JsonMappingException e) {
        			Logger.debug("JsonMappingException");
        		} catch (IOException e) {
        			Logger.debug("IOException");
        		}
        		
        		try {
        			ConnectionHttp.httpPost(data, "http://localhost:8787/serverPost");
        		} catch(Exception e) {
        			Logger.debug("Exception 1");
        		}
        		
        		//
        	} catch(Exception e) {
        		//e.printStackTrace();
        		Logger.debug("Exception 2");
        	}
        	
        }
    	
    	
		Logger.debug("Website Data : "+data);
		//return ok((id + titleInt)+"");
		return ok(data);
    }
  
}
