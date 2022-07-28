package Bernardo.products;

import java.util.Date;

public class Products {
	
	public Products(String codarticle, String seccion, String narticle, String importado, 
			String origincountry,double price, Date date) {
		super();
		
		this.codarticle = codarticle;
		
		this.seccion = seccion;
		
		this.narticle = narticle;
		
		this.importado = importado;
		
		this.origincountry = origincountry;
		
		this.price = price;
		
		this.date = date;
	}
	

	public Products(String seccion, String narticle, String importado, String origincountry,
			double price, Date date) {
		
		super();
		
		this.seccion = seccion;
		
		this.narticle = narticle;
		
		this.importado = importado;
		
		this.origincountry = origincountry;
		
		this.price = price;
		
		this.date = date;
	}
	


	public String getCodarticle() {
		
		return codarticle;
		
	}


	public void setCodarticle(String codarticle) {
		
		this.codarticle = codarticle;
		
	}


	public String getSeccion() {
		
		return seccion;
		
	}


	public void setSeccion(String seccion) {
		
		this.seccion = seccion;
		
	}


	public String getNarticle() {
		
		return narticle;
		
	}


	public void setNarticle(String narticle) {
		
		this.narticle = narticle;
		
	}


	public String getImportado() {
		
		return importado;
		
	}


	public void setImportado(String importado) {
		
		this.importado = importado;
		
	}


	public String getOrigincountry() {
		
		return origincountry;
		
	}


	public void setOrigincountry(String origincountry) {
		
		this.origincountry = origincountry;
		
	}


	public double getPrice() {
		
		return price;
		
	}


	public void setPrice(double price) {
		
		this.price = price;
		
	}


	public Date getDate() {
		
		return date;
		
	}


	public void setDate(Date date) {
		
		this.date = date;
		
	}



	
	public String toString() {
		
		return "Products [codarticle=" + codarticle + ", seccion=" + seccion + ", narticle="
	            + narticle + ", importado=" + importado + ", origincountry=" + origincountry 
	            + ", price=" + price + ", date=" + date + "]";
		
	}



	private String codarticle, seccion, narticle, importado, origincountry;
	
	private double price;
	
	private Date date;
	
	
	
}
