package View;

import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import DAO.ProduitDAO;
import Model.Achat;
import Model.Client;
import Model.Employe;
import Model.Produit;

import java.awt.*;

public class EntrepriseView extends JFrame {
	public JTextField nomPrField, prixPrField, NEmpPrField, nomClField, prenomClField, emailClField, nomEmField,
			prenomEmField, salaireEmField;
	public ArrayList<Produit> products;
	private JTable Tab1, Tab2, Tab3,Tab4;
	private JButton addButtonEm, displayButtonEm, deleteButtonEm, addButtonPr, displayButtonPr, deleteButtonPr,
			addButtonCl, displayButtonCl, deleteButtonCl, allachatsButton, achatsnopButton, achatpayButton;
	private JPanel P1, P2, P3, PaneauPr, P4, P5, P6, PaneauCl, P7, P8, P9, PaneauEm, P10, P11,P12, PaneauAc;
	private JLabel nomPrlabel, prixPrlabel, NEmpPrLabel, nomCllabel, prenomCllabel, emailCllabel, nomEmLabel,
			prenomEmLabel, salaireEmLabel;
	private DefaultTableModel te, te1, te2,te3;
	JComboBox productListComboBox;
	ProduitDAO produitDAO = new ProduitDAO();

	public EntrepriseView() {
		setTitle("Gesion D'inventaire");
		setSize(850, 400);

		setLocationRelativeTo(null);
		JTabbedPane tabbedPane = new JTabbedPane();
		createTabProduit(tabbedPane, "Produit");
		createTabClient(tabbedPane, "Client");
		createTabEmploye(tabbedPane, "Employe");
		createTabAchat(tabbedPane, "Achat");

		getContentPane().add(tabbedPane);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initializeButtonsEm() {
		addButtonEm = new JButton("Add");
		displayButtonEm = new JButton("Display");
		deleteButtonEm = new JButton("Delete");
	}

	private void initializeButtonsPr() {
		addButtonPr = new JButton("Add");
		displayButtonPr = new JButton("Display");
		deleteButtonPr = new JButton("Delete");
	}

	private void initializeButtonsCl() {
		addButtonCl = new JButton("Add");
		displayButtonCl = new JButton("Display");
		deleteButtonCl = new JButton("Delete");
		productListComboBox = new JComboBox<>();

	}
	private void initializeButtonsAc() {
		allachatsButton = new JButton("All Achats");
		achatpayButton = new JButton("Achats Paye");
		achatsnopButton = new JButton("Achats Non Paye");

	}

	private void createTabProduit(JTabbedPane tabbedPane, String tabName) {
		// Paneau
		P1 = new JPanel();
		P2 = new JPanel();
		P3 = new JPanel();
		PaneauPr = new JPanel();
		initializeButtonsPr();
		// Tabs
		te = new DefaultTableModel();
		// Labels
		nomPrlabel = new JLabel("Nom du Produit: ");
		prixPrlabel = new JLabel("Prix du Produit: ");
		NEmpPrLabel = new JLabel("Nom de l'employe qui l'a creer: ");
		// TextFiels
		nomPrField = new JTextField(6);
		prixPrField = new JTextField(6);
		NEmpPrField = new JTextField(6);
		// TAV
		Tab1 = new JTable(te);
		te.addColumn("Id");
		te.addColumn("Name");
		te.addColumn("Price");
		te.addColumn("Employe");
		// Ordonancement (GridLayout & add)
		P1.setLayout(new GridLayout(2, 1));
		P3.setLayout(new GridLayout(3, 2));
		PaneauPr.setLayout(new BorderLayout());
		P3.add(nomPrlabel);
		P3.add(nomPrField);
		P3.add(prixPrlabel);
		P3.add(prixPrField);
		P3.add(NEmpPrLabel);
		P3.add(NEmpPrField);
		P1.add(P3);
		P2.add(addButtonPr);
		P2.add(displayButtonPr);
		P2.add(deleteButtonPr);
		P1.add(P2);
		PaneauPr.add(new JScrollPane(Tab1), BorderLayout.CENTER);
		PaneauPr.add(P1, BorderLayout.NORTH);
		add(PaneauPr);

		tabbedPane.addTab(tabName, PaneauPr);
	}

	private void createTabClient(JTabbedPane tabbedPane, String tabName) {	
		// Paneau
		P4 = new JPanel();
		P5 = new JPanel();
		P6 = new JPanel();
		PaneauCl = new JPanel();
		te1 = new DefaultTableModel();
		initializeButtonsCl();

		// Labels
		nomCllabel = new JLabel("Nom de Client: ");
		prenomCllabel = new JLabel("Prenom de Client: ");
		emailCllabel = new JLabel("Email de Client: ");
		// TextFiels
		nomClField = new JTextField(6);
		prenomClField = new JTextField(6);
		emailClField = new JTextField(6);
		// TAV
		Tab2 = new JTable(te1);
		te1.addColumn("Id");
		te1.addColumn("Nom");
		te1.addColumn("Prenom");
		te1.addColumn("Email");

		// Ordonancement (GridLayout & add)
		P4.setLayout(new GridLayout(2, 1));
		P6.setLayout(new GridLayout(4, 2));
		PaneauCl.setLayout(new BorderLayout());
		P6.add(nomCllabel);
		P6.add(nomClField);
		P6.add(prenomCllabel);
		P6.add(prenomClField);
		P6.add(emailCllabel);
		P6.add(emailClField);
		P6.add(new JLabel("All Products:"));
		P6.add(productListComboBox);
		P4.add(P6);
		P5.add(addButtonCl);
		P5.add(displayButtonCl);
		P5.add(deleteButtonCl);
		P4.add(P5);
		PaneauCl.add(new JScrollPane(Tab2), BorderLayout.CENTER);
		PaneauCl.add(P4, BorderLayout.NORTH);
		add(PaneauCl);

		tabbedPane.addTab(tabName, PaneauCl);
	}

	private void createTabEmploye(JTabbedPane tabbedPane, String tabName) {
		// Paneau
		P7 = new JPanel();
		P8 = new JPanel();
		P9 = new JPanel();
		PaneauEm = new JPanel();
		initializeButtonsEm();
		te2 = new DefaultTableModel();

		// Labels
		nomEmLabel = new JLabel("Nom de l'Employe: ");
		prenomEmLabel = new JLabel("Prenom de l'Employe: ");
		salaireEmLabel = new JLabel("Salaire de l'Employe: ");
		// TextFiels
		nomEmField = new JTextField(6);
		prenomEmField = new JTextField(6);
		salaireEmField = new JTextField(6);
		// TAV
		Tab3 = new JTable(te2);
		te2.addColumn("Id");
		te2.addColumn("Nom");
		te2.addColumn("Prenom");
		te2.addColumn("Salaire");

		// Ordonancement (GridLayout & add)
		P7.setLayout(new GridLayout(2, 1));
		P9.setLayout(new GridLayout(3, 2));
		PaneauEm.setLayout(new BorderLayout());
		P9.add(nomEmLabel);
		P9.add(nomEmField);
		P9.add(prenomEmLabel);
		P9.add(prenomEmField);
		P9.add(salaireEmLabel);
		P9.add(salaireEmField);
		P7.add(P9);
		P8.add(addButtonEm);
		P8.add(displayButtonEm);
		P8.add(deleteButtonEm);
		P7.add(P8);
		PaneauEm.add(new JScrollPane(Tab3), BorderLayout.CENTER);
		PaneauEm.add(P7, BorderLayout.NORTH);
		add(PaneauEm);

		tabbedPane.addTab(tabName, PaneauEm);
	}

	private void createTabAchat(JTabbedPane tabbedPane, String tabName) {
		// Paneau
		P10 = new JPanel();
		P11 = new JPanel();
		PaneauAc = new JPanel();
		initializeButtonsAc();
		te3 = new DefaultTableModel();

		// TAV
		Tab4 = new JTable(te3);
		te3.addColumn("Id");
		te3.addColumn("Nom de Client");
		te3.addColumn("Nom de Produit");
		te3.addColumn("Status");
		te3.addColumn("Date");

		// Ordonancement (GridLayout & add)
		P10.setLayout(new GridLayout(2, 1));
		PaneauAc.setLayout(new BorderLayout());
		P11.add(allachatsButton);
		P11.add(achatpayButton);
		P11.add(achatsnopButton);
		P10.add(P11);
		PaneauAc.add(new JScrollPane(Tab4), BorderLayout.CENTER);
		PaneauAc.add(P10, BorderLayout.NORTH);
		add(PaneauAc);

		tabbedPane.addTab(tabName, PaneauAc);
	}

	public JButton getaddButtonPr() {
		return addButtonPr;
	}

	public JButton getaddButtonEm() {
		return addButtonEm;
	}

	public JButton getaddButtonCl() {
		return addButtonCl;
	}

	public JButton getdisplayButtonEm() {
		return displayButtonEm;
	}

	public JButton getdisplayButtonPr() {
		return displayButtonPr;
	}

	public JButton getdisplayButtonCl() {
		return displayButtonCl;
	}

	public JButton getdeleteButtonEm() {
		return deleteButtonEm;
	}

	public JButton getdeleteButtonPr() {
		return deleteButtonPr;
	}

	public JButton getdeleteButtonCl() {
		return deleteButtonCl;
	}
	public JButton getallachatButoon() {
		return allachatsButton;
	}

	public JButton getnopachatButton() {
		return achatsnopButton;
	}

	public JButton getpayachatButton() {
		return achatpayButton;
	}

	public JTable getTableProduit() {
		return Tab1;
	}

	public JTable getTableClient() {
		return Tab2;
	}

	public JTable getTableEmploye() {
		return Tab3;
	}

	public JTextField getnomProduitField() {
		return nomPrField;
	}

	public JTextField getprixProduitField() {
		return prixPrField;
	}

	public JTextField getNEmployeProduitField() {
		return NEmpPrField;
	}

	public JTextField getnomClientField() {
		return nomClField;
	}

	public JTextField getprenomClientField() {
		return prenomClField;
	}

	public JTextField getemailClientField() {
		return emailClField;
	}

	public JTextField getnomEmployeField() {
		return nomEmField;
	}

	public JTextField getprenomEmployeField() {
		return prenomEmField;
	}

	public JTextField getsalaireEmployeField() {
		return salaireEmField;
	}

	// function to cleartext
	public void clearTextFieldsProduit() {
		nomPrField.setText("");
		prixPrField.setText("");
		NEmpPrField.setText("");
	}

	public void clearTextFieldsEmloye() {
		nomEmField.setText("");
		prenomEmField.setText("");
		salaireEmField.setText("");
	}
	public void clearTextFieldsClient() {
		nomClField.setText("");
		prenomClField.setText("");
		emailClField.setText("");
	}

	public void displayProducts(List<Produit> products) {
		te.setRowCount(0); // Clear existing rows

		for (Produit produit : products) {
			String nom = produit.getNom();
			String prix = produit.getPrix();
			int id = produit.getId();
			String empn = produit.getEmployeName();
			Object[] rowData = { id, nom, prix, empn };
			te.addRow(rowData);
		}
	}

	public void displayEmployes(List<Employe> employes) {
		te2.setRowCount(0); // Clear existing rows

		for (Employe employe : employes) {
			String nom = employe.getNom();
			String prenom = employe.getPrenom();
			int id = employe.getId();
			String salaire = employe.getSalaire();
			Object[] rowData = { id, nom, prenom, salaire };
			te2.addRow(rowData);
		}
	}

	public void displayClients(List<Client> clients) {
		te1.setRowCount(0); // Clear existing rows

		for (Client client : clients) {
			String nom = client.getNom();
			String prenom = client.getPrenom();
			int id = client.getId();
			String email = client.getEmail();
			Object[] rowData = { id, nom, prenom, email };
			te1.addRow(rowData);
		}
	}

	public void displayAchats(List<Achat> achats) {
		te3.setRowCount(0); // Clear existing rows

		for (Achat achat : achats) {
			String nomcl = achat.getNameClient();
			String produitcl = achat.getIdProduit();
			int id = achat.getId();
			String status = achat.getStatus();
			String date = achat.getDateachat();
			Object[] rowData = { id, nomcl, produitcl, date , status};
			te3.addRow(rowData);
		}
	}

	// Add a new method to update the product list combo box
	public void updateProductListComboBox() {
		List<String> productNames = produitDAO.getAllProductNames();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(productNames.toArray(new String[0]));
		productListComboBox.setModel(model);
	}
	public String getSelectedProductFromComboBox() {
        // Get the selected item from the JComboBox
        Object selectedObject = productListComboBox.getSelectedItem();

        // Convert the selected item to a String (replace with the actual type if needed)
        return (selectedObject != null) ? selectedObject.toString() : null;
    }

}
