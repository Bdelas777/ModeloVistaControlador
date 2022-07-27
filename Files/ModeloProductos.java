package Bernardo.products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {
	
	private DataSource dataorigin;

	public ModeloProductos(DataSource dataorigin) {

		this.dataorigin = dataorigin;
		
	}
	
	public List <Products> getProducts() throws Exception{
		
		List<Products> products = new ArrayList <>();
		
		Connection myconnection = null;
		
		Statement mystatement = null;
		
		ResultSet myresultset = null;
		
		//Establecimiento de conexion
		
		myconnection = dataorigin.getConnection();
		
		//Sentencia sql y statement
		
		String mysql = "SELECT * FROM PRODUCTOS ";
		
		 mystatement = myconnection.createStatement();
		
		// Ejecucion
		 
		 myresultset = mystatement.executeQuery(mysql);
		
		// recorrer result set
		 
		 while(myresultset.next()) {
			 
			 String codarticle =  myresultset.getString("CÓDIGOARTÍCULO");
			 
			 String seccion =  myresultset.getString("SECCIÓN");
			 
			 String narticle =  myresultset.getString("NOMBREARTÍCULO");
			 
			 double price =  myresultset.getDouble("PRECIO");
			 
			 Date date =  myresultset.getDate("FECHA");
			 
			 String importado =  myresultset.getString("IMPORTADO");
			 
			 String origincountry =  myresultset.getString("PAÍSDEORIGEN");
				
			 Products tempProduct = new Products( codarticle, seccion,  narticle, 
					 importado, origincountry, price, date);
			
			 products.add(tempProduct);
			 
		 }
		 
		 return products;
	}
	
	
}
