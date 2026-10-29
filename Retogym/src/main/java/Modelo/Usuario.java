package Modelo;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contraseña;
	private String email;
	private int nivel;
	private String fechaNaci;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String apellido, String usuario, String contraseña, String email,String fechaNaci) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.email = email;
		this.fechaNaci = fechaNaci;
	}
	public Usuario(int id, String nombre, String apellido, String usuario, String contraseña, String email, int nivel,
			String fechaNaci) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.email = email;
		this.nivel = nivel;
		this.fechaNaci = fechaNaci;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String getFechaNaci() {
		return fechaNaci;
	}
	public void setFechaNaci(String fechaNaci) {
		this.fechaNaci = fechaNaci;
	}
	
	
}
