package com.santivallejo.pojo;

public class Mensaje {

	private String status;
	private String mensaje;

	public Mensaje(String mensaje) {
		super();
		this.setStatus(0);
		this.mensaje = mensaje;
	}

	public Mensaje(int statusCode, String mensaje) {
		super();
		this.setStatus(statusCode);
		this.mensaje = mensaje;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatus(int statusCode) {
		if (statusCode == 200) {
			this.status = "Correcto";
		} else if (statusCode == -1) {
			this.status = "Excepcion";
		} else {
			this.status = "Error";
		}

	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
