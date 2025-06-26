package Logica;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cuenta {
	//ATRIBUTOS
	private Cliente cliente;
	private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento> ();
	private double saldo;
	private int nroCuenta;
	private String tipoCuenta;
	private String estadoCuenta;
	static LinkedList<Cuenta> cuentas = new LinkedList<Cuenta>();;
	//CONSTRUCTOR
	public Cuenta(Cliente cliente, LinkedList<Movimiento> movimientos, double saldo, int nroCuenta, String tipoCuenta, String estadoCuenta,LinkedList<Cuenta> cuentas) {
		super();
		this.cliente = cliente;
		this.movimientos = movimientos;
		this.saldo = saldo;
		this.nroCuenta = nroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.estadoCuenta = estadoCuenta;
		Cuenta.cuentas = cuentas;
	}
	public Cuenta(Cliente cliente, LinkedList<Movimiento> movimientos, double saldo, int nroCuenta, String tipoCuenta, String estadoCuenta) {
		super();
		this.cliente = cliente;
		this.movimientos = movimientos;
		this.saldo = saldo;
		this.nroCuenta = nroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.estadoCuenta = estadoCuenta;
	}
	public Cuenta(Cliente cliente, double saldo, int nroCuenta, String tipoCuenta, String estadoCuenta) {
		super();
		this.cliente = cliente;
		this.saldo = saldo;
		this.nroCuenta = nroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.estadoCuenta = estadoCuenta;
	}

	public Cuenta(Cliente cliente, String tipoCuenta, String estadoCuenta) {
		super();
		this.cliente = cliente;
		this.saldo = (int)(Math.random()*1000+1);
		this.nroCuenta = (int)(Math.random()*999+1000);
		this.tipoCuenta = tipoCuenta;
		this.estadoCuenta = estadoCuenta;
	}
	//GETTERS Y SETTERS
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LinkedList<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(LinkedList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getEstadoCuenta() {
		return estadoCuenta;
	}
	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	public LinkedList<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(LinkedList<Cuenta> cuentas) {
		Cuenta.cuentas = cuentas;
	}
	//MÈTODOS
	public void menuCuenta() {
		int opcion;
		do {
			ImageIcon icono2 = new ImageIcon(getClass().getResource("/UI/cliente.png"));
			opcion = JOptionPane.showOptionDialog(null, "Menú de cliente", "",JOptionPane.DEFAULT_OPTION,
				    JOptionPane.INFORMATION_MESSAGE,
				    icono2, OpcionesCliente.values(), OpcionesCliente.values()[0]);

			switch (opcion) {
			case 0:
				this.verSaldo();
				break;
	
			default:
			case 1:
				this.Transferir(cuentas);
				    break;
			case 2:
				 String inputMonto = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
	                if (inputMonto != null) {
	                    double monto = Double.parseDouble(inputMonto);
	                    this.Depositar(monto);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Monto inválido.");
	                }
					break;
			case 3:
				this.verMovimientos();
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Salir");
				break;

			}
		} while (opcion!=4);
		
	}
	public void verSaldo(){
		JOptionPane.showMessageDialog(null, "Tu saldo es de " + this.saldo + "$");
	}
	

public void Transferir(LinkedList<Cuenta> cuentas) {
    String numeroStr = JOptionPane.showInputDialog("Ingrese el número de cuenta destino:");
    
    if (numeroStr.isEmpty()) {
    	JOptionPane.showMessageDialog(null, "El número no debe estar vacío");
    	return;
    } ;
    int numeroCuentaDestino = Integer.parseInt(numeroStr);

    String montoTra = JOptionPane.showInputDialog("Ingrese el monto a transferir:");

    double monto = Double.parseDouble(montoTra);
    
    if (montoTra.isEmpty()) {
    	JOptionPane.showMessageDialog(null, "El monto no debe estar vacío");
    	return;
    }

    if (monto <= 0) {
        JOptionPane.showMessageDialog(null, "El monto debe ser mayor que cero.");
        return;
    }

    if (this.saldo < monto) {
        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        return;
    }

    Cuenta cuentaDestino = null;
    for (Cuenta c : cuentas) {
        if (c.getNroCuenta() == numeroCuentaDestino) {
            cuentaDestino = c;
            break;
        }
    }
    if (cuentaDestino == null) {
        JOptionPane.showMessageDialog(null, "Cuenta destino no encontrada.");
        return;
    }
    this.saldo -= monto;
    cuentaDestino.saldo += monto;

    this.movimientos.add(new Movimiento("Transferencia enviada a cuenta " + numeroCuentaDestino,LocalDate.now(), monto));
    cuentaDestino.movimientos.add(new Movimiento("Transferencia recibida de cuenta " + this.nroCuenta, LocalDate.now(), monto));

    JOptionPane.showMessageDialog(null, "Transferencia realizada con éxito.");
}
	
	public void Depositar(double monto) {
	    if (monto > 0) {
	        this.setSaldo(this.getSaldo() + monto);
	        
	        Movimiento movimiento = new Movimiento("Depósito realizado", LocalDate.now(), monto);
	        this.agregarMovimiento(movimiento);

	        JOptionPane.showMessageDialog(null, "Depósito exitoso de $" + monto);
	    } else {
	        JOptionPane.showMessageDialog(null, "El monto a depositar debe ser mayor a cero.");
	    }
	}
	public void agregarMovimiento(Movimiento movimiento) {
	    movimientos.add(movimiento);
	}
	
	public void verMovimientos() {
	    if (movimientos.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay movimientos registrados en esta cuenta.");
	        return;
	    }

	    String historial = "Historial de Movimientos:\n";

	    for (Movimiento m : movimientos) {
	        historial = historial + "- " + m.getTipoMov() + "- " + m.getFechaMov() + " | Monto: $" + m.getMonto() + "\n";
	    }

	    JOptionPane.showMessageDialog(null, historial);
	}
	
     public static void sobrecargaDeCuentas() {
    	 
    	 cuentas.add(new Cuenta(new Cliente("javier", "javier@gmail.com", "1234", LocalDate.of(2001, 1, 15)), new LinkedList<>(), 0.0, 101, "Caja de ahorro", "Activa"));
    	 cuentas.add(new Cuenta(new Cliente("bauti", "bauti@gmail.com", "4444", LocalDate.of(2006, 3, 17)), new LinkedList<>(), 0.0, 102, "Caja de ahorro", "Activa"));
    	 cuentas.add(new Cuenta(new Cliente("tobi", "tobi@gmail.com", "3333", LocalDate.of(2002, 5, 5)), new LinkedList<>(), 0.0, 103, "Caja de ahorro", "Activa"));


	
	
	
	
}
}

