package Modelo;

public class Serie {
	private String nombre;
	private String foto;
	private int duracion;
	private int nRepeticiones;
	
	
	
	
	public Serie(String nombre, String foto, int duracion, int nRepeticiones) {
	
		this.nombre = nombre;
		this.foto = foto;
		this.duracion = duracion;
		this.nRepeticiones = nRepeticiones;
		
	}
	
	
	public Serie() {
	
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getnRepeticiones() {
		return nRepeticiones;
	}
	public void setnRepeticiones(int nRepeticiones) {
		this.nRepeticiones = nRepeticiones;
	}
	
	
}
