package pack;

public class Producte {
	private int id;
	private String nom;
	private String preu;
	
	public Producte(int i, String n, String p) {
		id = i;
		nom = n;
		preu = p;
	}
	
	public int getID() {return id;}
	public String getNom() {return nom;}
	public String getPreu() {return preu;}
	
	@Override
	public String toString() {
		return id + "\t" + nom + "\t" + preu;
	}
}
