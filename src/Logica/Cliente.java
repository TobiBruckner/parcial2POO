package Logica;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
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
		if (this.getMail() == null || this.getMail().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar un correo electrónico.");
	        return "Correo vacío";
	    }

	    if (this.getContrasenia() == null || this.getContrasenia().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña.");
	        return "Contraseña vacía";
	    }
		for (Cliente cliente : clientes) {
			if (cliente.getMail().equals(this.getMail()) && cliente.getContrasenia().equals(this.getContrasenia())) {
				
				Cuenta cuenta = new Cuenta(this, "Caja de ahorro", "Activa");
				cuenta.menuCuenta();
				return "Encontrado!";
			}
			
		}
		
		 JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.");
		    return "No encontrado";
	}
	@Override
	public void menu() {
		ImageIcon icono2 = new ImageIcon(getClass().getResource("/UI/cliente.png"));
		JOptionPane.showOptionDialog(null, "Menú de cliente", "Elija una opción", 
				JOptionPane.DEFAULT_OPTION,
			    JOptionPane.INFORMATION_MESSAGE,
			    icono2, OpcionesCliente.values(), OpcionesCliente.values()[0]);
	}
	public static void sobrecarga() {
		
		clientes.add(new Cliente("javier","javier@gmail.com","1234",LocalDate.of(2001, 01, 15)));
		clientes.add(new Cliente("bauti","bauti@gmail.com","4444",LocalDate.of(2006, 03, 17)));
		clientes.add(new  Cliente("tobi","tobi@gmail.com","3333",LocalDate.of(2002, 05, 05)));
	}
	
}

