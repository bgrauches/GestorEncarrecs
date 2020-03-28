package pack;

public class Client {
	private int id;
	private String nom;
	private String apostal;
	private String aelectronica;
	private String telefon;
	
	public Client(int i, String n, String ap, String ae, String t) {
		id = i;
		nom = n;
		apostal = ap;
		aelectronica =  ae;
		telefon = t; 
	}
	
	public int getId() {return id;}
	public String getNom() {return nom;}
	public String getAPostal() {return apostal;}
	public String getAElectronica() {return aelectronica;}
	public String getTelefon() {return telefon;}
	
	@Override
	public String toString() {
		return id + "\t" + nom + "\t" + apostal + "\t" + aelectronica + "\t" + telefon ;
	}
}
