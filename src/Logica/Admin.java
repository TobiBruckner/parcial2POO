package Logica;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Admin extends Usuario{
	//ATRIBUTOS
	private String sector;
	//CONSTRUCTORES
	public Admin(String nombre, String mail, String contrasenia, String sector) {
		super(nombre, mail, contrasenia);
		this.sector = sector;
	}
	public Admin(String mail, String contrasenia) {
		super(mail, contrasenia);
		this.sector = sector;
	}
	//GETTERS Y SETTERS
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	//MÈTODOS
	@Override
	public String login() {
		if (this.getMail().equals("ghami@gmail.com")&&this.getContrasenia().equals("1234")) {
			this.menu();
			return "logueo exitoso";
		}else {
			JOptionPane.showMessageDialog(null, "Usuario o contraseña inválidos, intente de nuevo");
			return "Hubo un error";

		}
		
	}

	@Override
	public void menu() {
			int opcion;
			do {
				opcion = JOptionPane.showOptionDialog(null, "Menú admin", "Seleccione una opción", 0, 0, null, OpcionesAdmin.values(), OpcionesAdmin.values()[0]);

				switch (opcion) {
				case 0:
					this.verClientes();
					break;
		
				default:
				case 1:
					this.desactivarCuenta();
					    break;
				case 2:
					JOptionPane.showMessageDialog(null, "Salir");
						break;
				}
			} while (opcion!=2);
	}
	
	public void verClientes() {
		LinkedList<Cliente> clientes = Cliente.clientes;
	    for (Cliente cliente : clientes) {
	        JOptionPane.showMessageDialog(null, "Nombre: " + cliente.getNombre() + " | Fecha de nacimiento: " + cliente.getFechaNac());
	    }
	}
	
	public void desactivarCuenta() {
		LinkedList<Cuenta> cuentas = Cuenta.cuentas;
		int numeroCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de cuenta a desactivar: "));
	    for (Cuenta cuenta : cuentas) {
	        if (cuenta.getNroCuenta() == numeroCuenta) {
	            cuenta.setEstadoCuenta("Inactiva");
	            JOptionPane.showMessageDialog(null, "Cuenta " + numeroCuenta + " desactivada.");
	            return;
	        }
	    }
	}

}
