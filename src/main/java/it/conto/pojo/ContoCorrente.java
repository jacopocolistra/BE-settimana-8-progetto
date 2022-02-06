package it.conto.pojo;

import java.util.Objects;

public class ContoCorrente {
	
	private int iban;
	private String intestatario;
	private double saldo;
	private String dataApertura;
	
	public int getIban() {return iban;}
	
	public void setIban(int iban) {this.iban = iban;}
	
	public String getIntestatario() {return intestatario;}
	
	public void setIntestatario(String intestatario) {this.intestatario = intestatario;}
	
	public double getSaldo() {return saldo;}
	
	public void setSaldo(double saldo) {this.saldo = saldo;}
	
	public String getDataApertura() {return dataApertura;}
	
	public void setDataApertura(String dataApertura) {this.dataApertura = dataApertura;}

	@Override
	public int hashCode() {return Objects.hash(iban);}

	@Override
	public boolean equals(Object obj) {if (this == obj) return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		return iban == other.iban;}
	
	

}
