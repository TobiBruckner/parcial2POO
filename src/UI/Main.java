package UI;




import javax.swing.ImageIcon;
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
			ImageIcon icono3 = new ImageIcon(Main.class.getResource("/UI/banco.png"));
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido al banco, elija su tipo de usuario",null, JOptionPane.DEFAULT_OPTION,
				    JOptionPane.INFORMATION_MESSAGE,
				    icono3, OpcionesUsuario.values(), OpcionesUsuario.values()[0]);
		
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