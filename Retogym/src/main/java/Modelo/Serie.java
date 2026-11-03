package Modelo;

public class Serie {
	private String nombre;
	private String foto;
	private Long duracion;
	private Long nRepeticiones;
	
	
	
	
	public Serie(String nombre, String foto, Long duracion, Long nRepeticiones) {
	
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
	public Long getDuracion() {
		return duracion;
	}
	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}
	public Long getnRepeticiones() {
		return nRepeticiones;
	}
	public void setnRepeticiones(Long nRepeticiones) {
		this.nRepeticiones = nRepeticiones;
	}
	
	
}
