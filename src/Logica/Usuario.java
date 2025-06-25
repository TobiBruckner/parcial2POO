package Logica;

public abstract class Usuario {
	//ATRIBUTOS
	private String nombre;
	private String mail;
	private String contrasenia;
	//CONSTRUCTORES
	public Usuario(String nombre,String mail, String contrasenia) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.contrasenia = contrasenia;
	}
	public Usuario( String mail, String contrasenia) {
		this.mail = mail;
		this.contrasenia = contrasenia;
	}
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	//MÈTODOS
	public String login() {
		
		return "";
	}
	public void menu() {
		
	}
	
}
