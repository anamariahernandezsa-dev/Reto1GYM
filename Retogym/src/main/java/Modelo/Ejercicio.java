package Modelo;

import java.util.ArrayList;

public class Ejercicio {
	private String nombre;
	private String descripcion;
	private int tiempoDescando;
	private ArrayList<Serie> series;
	
	
	public Ejercicio() {
		
	}
	
	public Ejercicio(String nombre, String descripcion, int tiempoDescando, ArrayList<Serie> series) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoDescando = tiempoDescando;
		this.series = series;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getTiempoDescando() {
		return tiempoDescando;
	}
	public void setTiempoDescando(int tiempoDescando) {
		this.tiempoDescando = tiempoDescando;
	}
	public ArrayList<Serie> getSeries() {
		return series;
	}
	public void setSeries(ArrayList<Serie> series) {
		this.series = series;
	}
	
}
