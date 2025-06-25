package Logica;

import java.time.LocalDate;

public class Movimiento {
	//ATRIBUTOS
	private String tipoMov;
	private LocalDate fechaMov;
	private double monto;
	//CONSTRUCTOR
	public Movimiento(String tipoMov, LocalDate fechaMov,double monto) {
		this.tipoMov = tipoMov;
		this.fechaMov = fechaMov;
		this.monto = monto;
	}
	//GETTERS Y SETTERS
	public String getTipoMov() {
		return tipoMov;
	}
	public void setTipoMov(String tipoMov) {
		this.tipoMov = tipoMov;
	}
	public LocalDate getFechaMov() {
		return fechaMov;
	}
	public void setFechaMov(LocalDate fechaMov) {
		this.fechaMov = fechaMov;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	

	
}

