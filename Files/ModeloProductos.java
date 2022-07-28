package Bernardo.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			 
			 String codarticle =  myresultset.getString("C�DIGOART�CULO");
			 
			 String seccion =  myresultset.getString("SECCI�N");
			 
			 String narticle =  myresultset.getString("NOMBREART�CULO");
			 
			 double price =  myresultset.getDouble("PRECIO");
			 
			 Date date =  myresultset.getDate("FECHA");
			 
			 String importado =  myresultset.getString("IMPORTADO");
			 
			 String origincountry =  myresultset.getString("PA�SDEORIGEN");
				
			 Products tempProduct = new Products( codarticle, seccion,  narticle, 
					 importado, origincountry, price, date);
			
			 products.add(tempProduct);
			 
		 }
		 
		 return products;
	}

	public static void agregarnewproduc(Products newproduct) throws Exception {
		
		Connection myconnection = null;
		
		PreparedStatement mystatement = null;
		
		try {
			
			// Obtener la conexion
			
			myconnection = dataorigin.getConnection();
			
			// crear instruccion de inserccion
			
			String sql = "INSERT INTO PRODUCTOS(C�DIGOART�CULO,SECCI�N,NOMBREART�CULO,PRECIO,"
					+ "FECHA,IMPORTADO,)VALUES(?,?,?,?,?,?,?)";
			
			mystatement = myconnection.prepareStatement(sql);
			
			// establecer parametros para el productos
			
			mystatement.setString(1, newproduct.getCodarticle());
			
			mystatement.setString(2, newproduct.getSeccion());
			
			mystatement.setString(3, newproduct.getNarticle());
			
			mystatement.setDouble(4, newproduct.getPrice());
			
			java.util.Date utildate = newproduct.getDate();
			
			java.sql.Date fechaconvertida = new java.sql.Date(utildate.getTime());
			
			mystatement.setDate(5, fechaconvertida);
			
			mystatement.setString(6, newproduct.getImportado());
			
			mystatement.setString(7, newproduct.getOrigincountry());
			
			// ejecutar la instruccion sql
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			mystatement.close();
			
			myconnection.close();
		}
		
	}

	public static Products getProduct(String codigoarticulo) {
		
		Products theproducts = null;
		
		Connection myconnection = null;
		
		PreparedStatement mystatement = null;
		
		ResultSet myresultset = null;
		
		String CArt = codigoarticulo;
		try {
			
			// Establecer la conexion
			myconnection = dataorigin.getConnection();
			
			// Crear el sql que busque el producto
			
			String sql = " FROM * PRODUCTOS WHERE C�DIGOART�CULO=?";
			
			// consulta preparada
			mystatement = myconnection.prepareStatement(sql);
			
			// parametros
			mystatement.setString(1, CArt);
		
			//ejecutar consulta
			
			myresultset = mystatement.executeQuery(sql);
		
			//Obtener los datos de respuesta
			
			if(myresultset.next()) {
					
				String codarticulo = myresultset.getString("C�DIGOARTICULO");
				 
				 String seccion =  myresultset.getString("SECCI�N");
				 
				 String narticle =  myresultset.getString("NOMBREART�CULO");
				 
				 double price =  myresultset.getDouble("PRECIO");
				 
				 Date date =  myresultset.getDate("FECHA");
				 
				 String importado =  myresultset.getString("IMPORTADO");
				 
				 String origincountry =  myresultset.getString("PA�SDEORIGEN");
					
				 theproducts = new Products(codarticulo , seccion,  narticle, 
						 importado, origincountry, price, date);
				 
			 } else {
				 
				throw new Exception("No se ha encontrado el codigo articulo" + CArt); 
				 
			 }
					
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return theproducts;
		
	}

	public static void actualizarnewproduc(Products updateproduct) throws Exception{
		
		Connection myconnection = null;
		
		PreparedStatement mystatement = null;

			
			
			try {
				
				// Establecer la conexion
				myconnection = dataorigin.getConnection();
			
				// Crear la sentencia sql
			
				String sql = "UPDATE PRODUCSTO SET SECCI�N=?, NOMBREART�CULO=?, PRECIO=?"
						+ "FECHA=?, IMPORTADO=?, PA�SDEORIGEN=? WHERE C�DIGOART�CULO=?";
			
				// crear la consulta preparada
				mystatement = myconnection.prepareStatement(sql);
			
				//establecer los parametros
				mystatement.setString(1, updateproduct.getSeccion());
			
				mystatement.setString(2, updateproduct.getNarticle());
			
				mystatement.setDouble(3, updateproduct.getPrice());
			
				java.util.Date utildate = updateproduct.getDate();
			
				java.sql.Date fechaconvertida = new java.sql.Date(utildate.getTime());
			
				mystatement.setDate(4, fechaconvertida);
			
				mystatement.setString(5, updateproduct.getImportado());
			
				mystatement.setString(6, updateproduct.getOrigincountry());
			
				// ejecutar la instruccion sql
			
				mystatement.execute();
				} finally {
				
				mystatement.close();
				
				myconnection.close();
				
				}
		
	}

	public static void eliminaproducto(String codigoarticulo) throws Exception{
		
		Connection myconnection = null;
		
		PreparedStatement mystatement = null;

		
		try {
			// Establecer la conexion
			myconnection = dataorigin.getConnection();
		
			// Crear la sentencia sql
		
			String sql = "DELETE FROM * PRODUCTOS WHERE C�DIGOART�CULO=?";
		
			// crear la consulta preparada
		
			mystatement = myconnection.prepareStatement(sql);
		
			//establecer los parametros
		
			mystatement.setString(1, codigoarticulo);
		
			// ejecutar la instruccion sql
		
			mystatement.execute();
			
		} finally {
			
			mystatement.close();
			
			myconnection.close();
		}
	}	
	
}
