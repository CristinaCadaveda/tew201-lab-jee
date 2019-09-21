package com.tew.Servlets.HolaMundoVistaServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoVista
 */
@WebServlet(name = "HolaMundoVista", urlPatterns = { "/HolaMundoVista" }) 
public class HolaMundoVista extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoVista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = (String) request.getParameter("NombreUsuario");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		@SuppressWarnings("unchecked")
		Vector<String> listado = (Vector<String>)request.getSession().getAttribute("listado");
		if (listado == null){listado = new Vector<String>();}
		if ( nombre != null ){out.println("<br>Hola "+nombre+"<br>");
		listado.addElement(nombre);}
		request.getSession().setAttribute("listado",listado);
		out.println("Bienvenido a mi primera página web!");
		out.println("<br>");
		out.println("Contigo, hoy me han visitado:<br>");
		for ( int i = 0 ; i < listado.size() ; i++ ){out.println("<br>"+(String)listado.elementAt(i));}
		Integer contador= (Integer) getServletContext().getAttribute("contador");
		if ( contador == null ){contador = new Integer(0);}
		// Establecemos el contador como atributo del contextbajo el nombre 
		//contador. En caso de que ya existiera, sobreescribiríala referencia
		// existentecon la nueva.
		getServletContext().setAttribute("contador", new Integer(contador.intValue()+1));
		out.println("<br><br>" + contador +" visitas");
		out.println("<br><a href=\"index.html\">volver</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
