package Modelo;

import java.util.ArrayList;

public class Ejercicio {
	private String nombre;
	private String descripcion;
	private Long tiempoDescando;
	private ArrayList<Serie> series;
	
	
	public Ejercicio() {
		
	}
	
	public Ejercicio(String nombre, String descripcion, Long tiempoDescando, ArrayList<Serie> series) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoDescando = tiempoDescando;
		this.series = series;
	}
	public Ejercicio(String nombre, String descripcion, Long tiempoDescando) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoDescando = tiempoDescando;
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
	public Long getTiempoDescando() {
		return tiempoDescando;
	}
	public void setTiempoDescando(Long tiempoDescando) {
		this.tiempoDescando = tiempoDescando;
	}
	public ArrayList<Serie> getSeries() {
		return series;
	}
	public void setSeries(ArrayList<Serie> series) {
		this.series = series;
	}
	
}
