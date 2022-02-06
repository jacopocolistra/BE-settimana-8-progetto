package it.conto.pojo;

import java.util.Objects;

public class Movimento {
	
	private int ibanMov;
	private double importo;
	private String dataMov;
	private String operazione; 
	
	public int getIbanMov() {return ibanMov;}
	
	public void setIbanMov(int ibanMov) {this.ibanMov = ibanMov;}
	
	public double getImporto() {return importo;}
	
	public void setImporto(double importo) {this.importo = importo;}
	
	public String getDataMov() {return dataMov;}
	
	public void setDataMov(String dataMov) {this.dataMov = dataMov;}

	public String getOperazione() {return operazione;}

	public void setOperazione(String operazione) {this.operazione = operazione;}

	@Override
	public int hashCode() {return Objects.hash(ibanMov);}

	@Override
	public boolean equals(Object obj) {if (this == obj)return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimento other = (Movimento) obj;
		return ibanMov == other.ibanMov;}

	

	
}
