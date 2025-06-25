package Logica;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cliente extends Usuario{
	//ATRIBUTOS
	static LinkedList<Cliente> clientes= new LinkedList<Cliente>();
	private LinkedList<Cliente> contactos;
	private LocalDate  fechaNac;
	//CONSTRUCTORES
	public Cliente(String nombre, String mail, String contrasenia,  LocalDate fechaNac) {
		super(nombre, mail, contrasenia);
		this.fechaNac = fechaNac;
	}
	public Cliente( String mail, String contrasenia) {
		super(mail, contrasenia);
	}
	//GETTERS Y SETTERS
	public LinkedList<Cliente> getContactos() {
		return contactos;
	}
	public void setContactos(LinkedList<Cliente> contactos) {
		this.contactos = contactos;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	//MÈTODOS
	@Override
	public String login() {
		for (Cliente cliente : clientes) {
			if (cliente.getMail().equals(this.getMail()) && cliente.getContrasenia().equals(this.getContrasenia())) {
				
				Cuenta cuenta = new Cuenta(this, "Caja de ahorro", "Activa");
				cuenta.menuCuenta();
				return "Encontrado!";
			}
			
		}
		
		
		return "";
	}
	@Override
	public void menu() {
		JOptionPane.showOptionDialog(null, "", "", 0, 0, null, OpcionesCliente.values(), OpcionesCliente.values()[0]);
	}
	public static void sobrecarga() {
		
		clientes.add(new Cliente("javier","javier@gmail.com","1234",LocalDate.of(2001, 01, 15)));
		clientes.add(new Cliente("bauti","bauti@gmail.com","4444",LocalDate.of(2006, 03, 17)));
		clientes.add(new  Cliente("tobi","tobi@gmail.com","3333",LocalDate.of(2002, 05, 05)));
	}
	
}

