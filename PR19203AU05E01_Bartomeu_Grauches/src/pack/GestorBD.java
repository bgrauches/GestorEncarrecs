package pack;

import java.util.*;
import java.sql.*;

public class GestorBD {
	Connection conn;
	
	public GestorBD() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor_encarrecs", "root", "Cide2050");
	}
	
	public void tancar() throws Exception {
		conn.close();
	}
	
	//Posar un id al client a la bd
	public int obtenirNouIDClient() throws Exception { 
		Statement cercaMaxId = conn.createStatement();
		ResultSet r = cercaMaxId.executeQuery("SELECT MAX(ID) FROM CLIENTS");
		if (r.next()) return (1 + r.getInt(1));
		else return 1;
	}
	
	//Posar un id al producte a la bd
	public int obtenirNouIDProducte() throws Exception { 
		Statement cercaMaxId = conn.createStatement();
		ResultSet r = cercaMaxId.executeQuery("SELECT MAX(ID) FROM TIPUSPRODUCTE");
		if (r.next()) return (1 + r.getInt(1));
		else return 1;
	}
	
	public List<Client> cercarClient(String nom) throws Exception {
		Statement cerca = conn.createStatement();
		ResultSet r = cerca.executeQuery("SELECT * FROM CLIENTS WHERE NOM='" + nom + "'");
		LinkedList<Client> llista = new LinkedList<Client>();
		while (r.next()) {
			llista.add(new Client(r.getInt("ID"), r.getString("NOM"), r.getString("APOSTAL"), r.getString("AELECTRONICA"), r.getString("TELEFON")));
		}
		return llista;
	}
	
	//afegir Client a la bd
	public void afegirClient(Client c) throws Exception {
		Statement update = conn.createStatement();
		String valors = c.getId() + ",'" + c.getNom() + "','" + c.getAPostal() + "','" + c.getAElectronica() + "','" + c.getTelefon() + "'";
		update.executeUpdate("INSERT INTO CLIENTS VALUES(" + valors + ")");
	}
	
	//afegir Producte a la bd
	public void afegirProducte(Producte p) throws Exception {
		Statement update = conn.createStatement();
		String valors = p.getID() + ",'" + p.getNom() + "','" + p.getPreu() + "'";
		update.executeUpdate("INSERT INTO TIPUSPRODUCTE VALUES(" + valors + ")");
	}
}