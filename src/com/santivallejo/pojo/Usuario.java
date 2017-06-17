package com.santivallejo.pojo;

import org.kie.api.definition.type.PropertyReactive;

/**
 * Clase instanciable de tipo POJO o BEAN para representar a un usuario
 *
 * @author santivallejo
 *
 */

@PropertyReactive
public class Usuario {

	public static final String NOMBRE_ANONIMO = "Anonimo";
	public static final String SIN_DEFINIR = "Sin definir";

	/*
	 * atributos****************
	 */
	private int id;
	private String nombre;
	private String cp;
	private String geo;
	

	/*
	 * constructores****************
	 */

	/**
	 * Un <code>Usuario</code> recien instanciado tendra los siguientes valores:
	 * <ul>
	 * <li><code>nombre</code>: NOMBRE_ANONIMO</li>
	 * <li><code>cp</code>: codigo postal</li>
	 * <li><code>geo</code>: posicion geolocaliacion</li>
	 * </ul>
	 */
	public Usuario() {
		super();
		this.nombre = NOMBRE_ANONIMO;
		this.cp = "";
		this.geo = "";
		
	}

	public Usuario(String nombre, String cp) {
		super();
		this.nombre = nombre;
		setCp(cp);
		this.geo = "";
		
	}

	public Usuario(String nombre, String cp, String geo) {
		super();
		this.nombre = nombre;
		setCp(cp);
		this.geo = geo;
		
	}

	/*
	 * gets y sets****************
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp
	 *            the cp to set
	 */
	public void setCp(String cp) {
		if (cp.length() == 5) {
			this.cp = cp;
		} else {
			cp = null;
		}

	}

	/**
	 * @return the geo
	 */
	public String getGeo() {
		return geo;
	}

	/**
	 * @param geo
	 *            the geo to set
	 */
	public void setGeo(String geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", cp=" + cp + ", geo=" + geo + "]";
	}
	
	

	

}
