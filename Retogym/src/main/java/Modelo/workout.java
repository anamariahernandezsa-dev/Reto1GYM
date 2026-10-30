package Modelo;

import java.util.ArrayList;

public class workout {
	private String nombre;
	private String decripcion;
	private long nivel;
	private String url;
	private ArrayList<Ejercicio> ejercicio;
	
	
	
	public workout(String nombre, String decripcion, long nivel, String url, ArrayList<Ejercicio> ejercicio) {
		this.nombre = nombre;
		this.decripcion = decripcion;
		this.nivel = nivel;
		this.url = url;
		this.ejercicio = ejercicio;
	}
	public workout(String nombre, String decripcion, Long nivel, String url) {
		this.nombre = nombre;
		this.decripcion = decripcion;
		this.nivel = nivel;
		this.url = url;
	}
	public workout() {
		
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDecripcion() {
		return decripcion;
	}
	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}
	public long getNivel() {
		return nivel;
	}
	public void setNivel(long nivel) {
		this.nivel = nivel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ArrayList<Ejercicio> getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(ArrayList<Ejercicio> ejercicio) {
		this.ejercicio = ejercicio;
	}

}
