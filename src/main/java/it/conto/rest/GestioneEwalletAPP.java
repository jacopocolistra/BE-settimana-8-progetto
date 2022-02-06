package it.conto.rest;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.DELETE;
import it.conto.pojo.ContoCorrente;
import it.conto.pojo.Movimento;

@Path("/conto")
public class GestioneEwalletAPP {
	
	private static List<ContoCorrente> conti = new ArrayList<ContoCorrente>();
	private static List<Movimento> movimenti = new ArrayList<Movimento>();
	
	@GET
	@Path("/visualizzaconti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContoCorrente> retrieveConti() {return conti;}
	
	@GET
	@Path("/visualizzamovimenti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimento> retrieveMovimenti() {return movimenti;}
	
	@DELETE
	@Path("/eliminaconto/{iban}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminaConto(@PathParam("iban")int iban) {
		for(ContoCorrente cc : conti) {if(cc.getIban() == iban) {conti.remove(cc);
				break;}}
		return Response.status(300).entity("Eliminazione ContoCorrente avvenuta con grande successo").build();}

	@DELETE
	@Path("/eliminamovimento/{ibanMov}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminaMovimento(@PathParam("ibanMov")int ibanMov) {
		for(Movimento m : movimenti) {if(m.getIbanMov()== ibanMov) {movimenti.remove(m);
				break;}}
		return Response.status(300).entity("Eliminazione Movimento avvenuta con grande successo").build();}
	
	@POST
	@Path("/apriconto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response apriConto(ContoCorrente c) {conti.add(c);
		return Response.status(300).entity("Apertura ContoCorrente avvenuta con grande successo").build();}
	
	@PUT
	@Path("/aggiornaconto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aggiornaConto(ContoCorrente c) {
		for(ContoCorrente cc : conti) {if(cc.getIban() == c.getIban()) {int index = conti.lastIndexOf(cc);
				conti.set(index, c);}} 
		return Response.status(300).entity("Aggiornamento Conto avvenuto con grande successo").build();}
	
	@GET
	@Path("/cercaconto/{iban}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ContoCorrente retrieveByIban(@PathParam("iban") int iban) {ContoCorrente c = null;
		for(ContoCorrente cc : conti) {if(cc.getIban() == iban) {c = cc;}}
		return c;}
	
	@PUT
	@Path("/versa/{importo}/{iban}/{dataMov}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response versa(@PathParam("iban") int iban, @PathParam("dataMov") String dataMov, @PathParam("importo") double importo) {
		for(ContoCorrente c : conti) {if(c.getIban() == iban) {double saldo = c.getSaldo() - importo;
				c.setSaldo(saldo);
				Movimento m = new Movimento();
				m.setIbanMov(iban);
				m.setDataMov(dataMov);
				m.setOperazione("versamento");
				m.setImporto(importo);
				movimenti.add(m);}}
		return Response.status(300).entity("Versamento avvenuto con grande successo").build();}
	
	@PUT
	@Path("/preleva/{importo}/{iban}/{dataMov}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response preleva(@PathParam("iban") int iban, @PathParam("dataMov") String dataMov, @PathParam("importo") double importo) {
		for(ContoCorrente c : conti) {if(c.getIban() == iban) {double saldo = c.getSaldo() - importo;
				c.setSaldo(saldo);
				Movimento m = new Movimento();
				m.setIbanMov(iban);
				m.setDataMov(dataMov);
				m.setOperazione("prelevo");
				m.setImporto(importo);
				movimenti.add(m);}}
		return Response.status(300).entity("Prelievo avvenuto con grande successo").build();}
	
	
}
