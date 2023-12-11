import Controller.AchatController;
import Controller.ClientController;
import Controller.EmployeController;
import Controller.ProduitController;
import DAO.AchatDAO;
import DAO.ClientDAO;
import DAO.EmployeDAO;
import DAO.ProduitDAO;
import View.EntrepriseView;

public class Main {
    public static void main(String[] args) throws Exception {
        EntrepriseView view = new EntrepriseView();
        ProduitDAO pdo = new ProduitDAO();
        new ProduitController(pdo, view);
        EmployeDAO pdoem = new EmployeDAO();
        new EmployeController(pdoem, view);
        AchatDAO pdoac = new AchatDAO();
        new AchatController(pdoac, view);
        ClientDAO pdocl = new ClientDAO();
        new ClientController(pdocl, view, pdoac);
        
    }
}
