package Bernardo.products;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		//Leer el parametro del formulario
		String  comando = request.getParameter("instruction");
		// sino se envia el parametro listar productos
		
		if(comando==null) comando="listar";
		//Redirigir el flujo de ejecucion al metodo adecuado
		
		switch(comando) {
		
			case "listar":
				obtenerproductos(request,response);
				break;
				
			case"insertaBBDD":
				agregarproductos(request,response);
				break;
				
			case"cargar":
				try {
					
					cargaproductos(request,response);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
				break;
				
			case"updateBBDD":
				try {
					
				
				actualizaproducto(request,response);			
				} catch (Exception e) {
			
					e.printStackTrace();
			
				}
				break;
			case"eliminar":
				eliminarproducto(request,response);
				break;
				
			default:
				obtenerproductos(request,response);
		}
		
		
		
	}
	private void eliminarproducto(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		// capturar el codigo
		String codigoarticulo = request.getParameter("CArticulo");
		
		//borrar el producto de la bbdd
		
		ModeloProductos.eliminaproducto(codigoarticulo);
		
		//volver a la lista del producto
		obtenerproductos(request,response);
		
	}
	private void actualizaproductos (HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		//Leer los datos que lee vienen del formulario a actualizar
		
		String CArt = request.getParameter("CArt");
		
		String seccion = request.getParameter("seccion");
		
		String NArt = request.getParameter("NArt");
		
		SimpleDateFormat  formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha = null; 
		
		try {
			
			fecha =formatofecha.parse(request.getParameter("fecha"));
		
		}catch (ParseException e) {
			
			e.printStackTrace();
			
		}
		
		double precio = Double.parseDouble(request.getParameter("precio"));
		
		String importado = request.getParameter("importado");
		
		String POrig = request.getParameter("POrig");
		
		// Crear objeto tipo producto con la info del formulario		
		Products updateproduct = new Products(CArt, seccion, NArt, importado, POrig,  precio,
				fecha );
			
		//Actualizar la bbdd con la info producto
		ModeloProductos.actualizarnewproduc(updateproduct);
		
		// volver al listado con la info actualzada
		obtenerproductos(request,response);
		
	}
	
	private void cargaproductos (HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		//Leer codigo articulo del listado
		
		String codigoarticulo =  request.getParameter("CArt");
		
		//Enviar codigo articulo a modelo
		
		Products theproduct = ModeloProductos.getProduct(codigoarticulo);
		
		// Colocar atributo correspondiente a cod articulo
		
		request.setAttribute("updateproduct",theproduct);
		
		// Enviar producto al formulario de actualizar
		
		RequestDispatcher myDispatcher = request.getRequestDispatcher("/updateproducts.jsp");
		
		myDispatcher.forward(request,response);
		
		
	}
	
	private void agregarproductos (HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		//Leer la informacion del producto
		
		String CArt = request.getParameter("CArt");
		
		String seccion = request.getParameter("seccion");
		
		String NArt = request.getParameter("NArt");
		
		SimpleDateFormat  formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha = null; 
		
		try {
			
		fecha =formatofecha.parse(request.getParameter("fecha"));
		
		}catch (ParseException e) {
			
			e.printStackTrace();
			
		}
		
		double precio = Double.parseDouble(request.getParameter("precio"));
		
		String importado = request.getParameter("importado");
		
		String POrig = request.getParameter("POrig");
		
		//Crear un objeto producto
		
		Products newproduct = new Products(CArt, seccion, NArt, importado, POrig,  precio,
				fecha );
		
		//enviar objeto al modelo
		
		ModeloProductos.agregarnewproduc(newproduct);
		
		//volver al listado de productos
		
		obtenerproductos(request,response);
	}
	
	private void obtenerproductos (HttpServletRequest request, HttpServletResponse response) {
		
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
