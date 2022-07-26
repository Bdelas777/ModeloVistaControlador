package Bernardo.products;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/*Servlet de Pruebas*/
/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Definir o establecer DataSource
	@Resource(name="jdbc/products")
	
	private DataSource mypool;
    /**
     * Default constructor. 
     */
    public ServletPruebas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Crear el objeto printWriter
		PrintWriter salida = response.getWriter();
		
		response.setContentType("text/plain");
		
		// Crear la conexion a la BBDD
		
		Connection myconnection = null;
		
		Statement mystatement = null;
		
		ResultSet myresultset = null;
		
		try {
			
			myconnection = mypool.getConnection();
			
			String mysql = "SELECT * FROM PRODUCTOS ";
			
			 mystatement = myconnection.createStatement();
			 
			 myresultset = mystatement.executeQuery(mysql);
			 
			 while(myresultset.next()) {
				 
				 String articlename = myresultset.getString(3);
				 
				 salida.println(articlename);
				 
			 }
			
		}catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
