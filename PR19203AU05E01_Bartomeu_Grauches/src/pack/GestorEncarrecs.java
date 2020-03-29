package pack;

import java.io.*;
import java.util.*;

public class GestorEncarrecs {

	GestorBD gestor;
	BufferedReader entrada;
	
	public static void main(String[] args) throws Exception {
		GestorEncarrecs gbd = new GestorEncarrecs();
		gbd.start();
	}

	public GestorEncarrecs() throws Exception {
		gestor = new GestorBD();
		entrada = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void start() throws Exception {
		int opcio;
		while (0 != (opcio = menuPrincipal())) {
			try {
				switch (opcio) {
				case 1:
					cercarClient();
					break;
				case 2:
					afegirClient();
					break;
				default: mostrarDades("Opció incorrecta\n");
				}
			} catch (Exception ex) {
				mostrarDades("S'ha produït un error: " + ex + "\n");
			}
		}
		gestor.tancar();
	}
	
	private int menuPrincipal() throws Exception {
		String menu = "\nQuina acció vols realitzar?\n" + "[1] Cercar client\n" + "[2] Afegir client\n" + "[3] Afegir producte\n" + "[0] Sortir\n" + "Opció>";
		String lin = entrarDades(menu);
		try { int opcio = Integer.parseInt(lin); return opcio;}
		catch (Exception ex) { return -1; }
	}
	
	private String entrarDades(String pregunta) throws IOException {
		mostrarDades(pregunta);
		return entrarDades();
	}
	
	private String entrarDades() throws IOException {
		String linia = entrada.readLine();
		if ("".equals(linia)) return null;
		return linia;
	}

	private void mostrarDades(String dades) throws IOException {
		System.out.println(dades);
	}
	
	private void cercarClient() throws Exception {
		String nom = entrarDades("Introdueix el nom del client: "); if (null == nom) return;
		List<Client> llista = gestor.cercarClient(nom);
		Iterator it = llista.iterator();
		mostrarDades("Els clients trobats amb aquest nom son:\n-----------------------------\n");
		while (it.hasNext()) {
			Client c = (Client)it.next();
			mostrarDades(c.toString() + "\n");
		}
	}
	
	public void afegirClient() throws Exception {
		mostrarDades("Introdueix les següents dades del nou client (deixa en blanc per sortir).\n");
		String nom = entrarDades("Nom: "); if (null == nom) return;
		String apostal = entrarDades("Adreça postal: "); if (null == apostal) return;
		String aelectronica = entrarDades("E-mail: "); if (null == aelectronica) return;
		String telefon = entrarDades("Telefon: "); if (null == telefon) return;
		int id = gestor.obtenirNouIDClient();
		gestor.afegirClient(new Client(id, nom, apostal, aelectronica, telefon));
		mostrarDades("Operació completada satisfactòriament.\n");
	}
	
	public void afegirProducte() throws Exception {
		mostrarDades("Introdueix les següents dades del nou producte (deixa en blanc per sortir).\n");
		String nom = entrarDades("Nom: "); if (null == nom) return;
		String preu = entrarDades("Nom: "); if (null == preu) return;
		int id = gestor.obtenirNouIDProducte();
		gestor.afegirProducte(new Producte(id, nom, preu));
		mostrarDades("Operació completada satisfactòriament.\n");
	}
	
}
