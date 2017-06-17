package com.santivallejo.pojo;

public class Descuento {

	public static final String AREA_ANONIMA = "Anonimo";

	private int id;
	private double porcentaje;
	private String area;

	public Descuento() {
		super();
		this.porcentaje = 0.0;
		this.area = AREA_ANONIMA;
	}

	public Descuento(float porcentaje, String area) {
		super();
		setPorcentaje(porcentaje);
		setArea(area);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	

}
