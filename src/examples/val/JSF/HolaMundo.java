package examples.val.JSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//esto lo va instanciar el propio jsf para crear el objeto nombre
//automaticamente.

@ManagedBean
@RequestScoped
public class HolaMundo {

	private String nombre;

	public HolaMundo() {
		nombre = "Ignacio";
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int longuitud() {
		return this.nombre.length();
	}

}
