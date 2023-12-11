package Model;

public class Produit {
	public int id;
	public String nom;
	public String prix;
	public String employe_name;
	//Constructor
	public Produit(int id, String nom, String prix, String em) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.employe_name = em;
	}
	//Getters
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrix() {
		return prix;
	}
	public String getEmployeName() {
		return employe_name;
	}

	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public void setEmployeName(String em) {
		this.employe_name = em ;
	}

	//tostring
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", prix=" + employe_name + "]";
	}
}
