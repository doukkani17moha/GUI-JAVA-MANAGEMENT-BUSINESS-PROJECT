package Model;

public class Achat {
	private int id;
    private String ClientName, ProductName, dateachat, status;
	private int idcli;


	    // Constructors, getters, and setters

		public Achat(int id, String ClientName, String ProductName, String dateachat, String status) {
			this.id = id;
			this.ClientName = ClientName;
			this.ProductName = ProductName;
			this.dateachat = dateachat;
			this.status = status;
		}
		public Achat(int id, int idcli, String ProductName) {
			this.id = id;
			this.idcli = idcli;
			this.ProductName = ProductName;
		}
	
		// Getters and setters for other columns
	
		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public String getNameClient() {
			return ClientName;
		}
	
		public void setNameClient(String ClientName) {
			this.ClientName = ClientName;
		}
	
		public String getIdProduit() {
			return ProductName;
		}
	
		public void setIdProduit(String ProductName) {
			this.ProductName = ProductName;
		}
	
		public String getDateachat() {
			return dateachat;
		}
	
		public void setDateachat(String dateachat) {
			this.dateachat = dateachat;
		}
	
		public String getStatus() {
			return status;
		}
	
		public void setStatus(String status) {
			this.status = status;
		}
	

}
