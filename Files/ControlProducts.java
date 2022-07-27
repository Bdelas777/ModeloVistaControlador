package Bernardo.products;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControlProducts
 */
@WebServlet("/ControlProducts")
public class ControlProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modelo;
	
	@Resource(name="jdbc/products")
	
	private DataSource mypool;
	
	public void init() throws ServletException{
		
		super.init();
		
		// Coneccion con el modelo
		try {
			modelo = new ModeloProductos(mypool);
			
		} catch (Exception e) {
			
			throw new ServletException(e);
			
		}
		
		
	}
    /**
     * Default constructor. 
     */
    public ControlProducts() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtener lista de los productos desde el modelo
		
		List<Products> products;
		
		try {
			
			products = modelo.getProducts();
			
			//agregar lista de productos al request
			
			request.setAttribute("listproducts",products);
			
			// enviar a la pagina jsp
			
			RequestDispatcher myDispatcher = request.getRequestDispatcher("/listproducts.jsp");
			
			myDispatcher.forward(request,response);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
