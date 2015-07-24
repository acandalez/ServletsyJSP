package examples.val.AJAXBasic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class CargaJSON
 */

public class CargaJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Persona persona = new Persona("Jose", 23);
		Gson gson = new Gson(); //LIBRERÍA DE GOOGLE QUE ME PERMITE SERIALIZAR Y DESEREALIZAR UN OBJETO. INSTANCIAMOS UN NUEVO OBJETO
		String mensajeJson = gson.toJson(persona); //ME DEVUELVE UNA VARIABLE STRING PASÁNDOLE UN OBJETO EN GSON
		
		
		response.setContentType("application/json"); //TEXTO EN FORMATO JSON
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(mensajeJson); //OBTENGO EL MENSAJE EN EL CUERPO Y LO ESCRIBO EN LA PÁGINA JSON
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String json = request.getReader().readLine();
		Gson gson = new Gson();
		Persona p = gson.fromJson(json, Persona.class);
		System.out.println("El usuario ha mandado a una persona! " + p.getNombre() + " " + p.getEdad());
	}

}
