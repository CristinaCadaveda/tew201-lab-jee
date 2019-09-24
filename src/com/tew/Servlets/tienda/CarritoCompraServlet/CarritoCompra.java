package com.tew.Servlets.tienda.CarritoCompraServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompra
 */
@WebServlet(name="CarritoCompra", urlPatterns = { "/CarritoCompra" })
public class CarritoCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //PRESENTA EL FORMULARIO
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String docType ="<!DOCTYPE HTML PUBLIC  \r\n" + 
				"\\\r\n" + 
				"\"-//W3C//DTD HTML 4.0”+           \r\n" + 
				"“Transitional//EN\\\">\n";
		out.println(docType + "<HTML>"+ "<HEAD><TITLE>" + "Carrito" + "</TITLE><HEAD>\n"
		+ "<BODY>" +
		"<H1>" + "Carrito de la compra" + "</H1>" +
		"<BR>" +
		" <form action='CarritoCompra' method='post'> " + 
			"<BR>"+
			"<table align='center'>" +
			"<TR>"+
				"<td align='center'>" + "Escoja el artículo que desea: " + "</td>" +
			"</TR>" +
			"<TR>" +
				"<TD>" +
				 	"<select name='producto' size='1'> " +
				 	"<option value='001'>" + "Informatica" + "</option>" +
					"<option value='002'>" + "Alimentacion" +"</option>" +
					"<option value='003'>" + "Ropa"+ "</option>" +
					"<option value='004'>" + "Vehiculos" + "</option>" +
					"<option value='005'>" + "Aventuras" +"</option>" +
					"<option value='006'>" + "Vacaiones"+ "</option>" +
					"<option value='007'>" + "Videojuegos" + "</option>" +
					"<option value='008'>" + "Infantil" +"</option>" +
					"<option value='009'>" + "Cine"+ "</option>" +
					"<option value='010'>" + "Television"+ "</option>" +
					"</select>" +
					"</td>" +        
					"</tr>" +
						"<tr>" +
						"<td align='center'><input type='submit' value='añadir al carrito...'>" +
						"</td>"+
					"</tr>"+
					"</table>"+
		"</FORM>"+ 
		 "</BODY>"+
		"</HTML>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//EJECUTA EL TRABAJO DEL CARRITO
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		String docType ="<!DOCTYPE HTML PUBLIC  \r\n" + 
				"\\\r\n" + 
				"\"-//W3C//DTD HTML 4.0”+           \r\n" + 
				"“Transitional//EN\\\">\n";
		@SuppressWarnings("unchecked")
		HashMap <String,Integer> carrito =(HashMap<String,Integer>)request.getSession().getAttribute("carrito");
		if ( carrito == null ) {
			carrito = new HashMap<String, Integer>();
			}
		//Añadimos el producto recibido al carrito de la compra (en caso de que no sea nulo!)
		String producto = request.getParameter("producto");
		if ( producto != null ){
			Integer cantidad = (Integer) carrito.get(producto);
			if ( cantidad == null ) cantidad = new Integer ( 1 );
		else cantidad = new Integer ( cantidad.intValue() + 1 );    
		//Y añadimos el producto al carrito
		carrito.put(producto, cantidad);
		//Añadimos el carrito a la sesión
		request.getSession().setAttribute("carrito",carrito);
		}
		
		Set<String> productos = carrito.keySet();
		Iterator iter = productos.iterator();
		while ( iter.hasNext() ) {String elemento = (String)iter.next();
		out.println(docType + "<HTML>"+ "<BODY>" +
			" <br>" + "Del producto " + elemento + ", " +
			(Integer)carrito.get(elemento) + " unidades"
			+
			 "</BODY>"+
			"</HTML>"
					);
					
	}

}
}
