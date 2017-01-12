package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name="tbtestweb")
public class Tbtestweb extends Model{
	
	@Id
	private Integer id;
	
	private String descrip;
	
	//public static final Finder<Integer, Tbtestweb> find = new Finder<Integer, Tbtestweb>(Integer.class, Tbtestweb.class);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	
//	public String validate() {
//		try {
//			
////			this.id = Country.find.byId(this.senderCountry.code);
////			if (this.senderCountry == null) {
////				return "Sender country not valid";
////			}
////			
////			this.senderCurrency = Currency.find.byId(this.senderCurrency.code);
////			if (this.senderCurrency == null) {
////				return "Sender currency not valid";
////			}
////
////			
////	    	if (this.channel.code.equals("07") && this.sender != null) {
////		    	if (this.sender.idToken == null || this.sender.idToken.equals("")) {
////					Customer customerSender = Customer.find.where()
////							.eq("firstName", this.sender.firstName)
////							.eq("lastName", this.sender.lastName)
////					if (customerSender == null) {
////						this.sender.personalIdCountry = this.sender.country;
////						this.sender.save();
////					} else {
////			    		this.sender = customerSender;
////			    	}
////		    	}
////	    	}
//			return null;
//		} catch(Exception e) {
//			e.printStackTrace();
//			return "Invalid parameter "+e.getMessage();
//		}
//	}

}
