package UI;




import javax.swing.JOptionPane;

import Logica.Admin;
import Logica.Cliente;
import Logica.Cuenta;
import Logica.OpcionesUsuario;

public class Main {
	
	public static void main(String[] args) {
		Cliente.sobrecarga();
		Cuenta.sobrecargaDeCuentas();
		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Elija tipo de usuario", null, 0, 0, null, OpcionesUsuario.values(), OpcionesUsuario.values()[0]);
		
			switch (opcion) {
			case 0:
			String mail= 	JOptionPane.showInputDialog("Ingrese mail");
			String contra =JOptionPane.showInputDialog("Ingrese contraseña");
			Admin nuevo = new Admin(mail,contra);
			nuevo.login();
				break;
	
			default:
			case 1:
				 mail= 	JOptionPane.showInputDialog("Ingrese mail");
				 contra =JOptionPane.showInputDialog("Ingrese contraseña");
				Cliente cliente = new Cliente(mail,contra);
				cliente.login();
				
					break;
			case 2:
				JOptionPane.showMessageDialog(null, "Salir");
					break;

			}
		} while (opcion!=2);
		
		
	}

}