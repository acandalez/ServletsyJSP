package model.beans.JSF;

import javax.annotation.ManagedBean;

/**
 * practica mostrar numero incrementado.
 * 
 * @author acandalez
 *
 */
@ManagedBean
public class NumBean {

	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String mostrar() {
		System.out.println(this.num);
		return mostrar();

	}

}
