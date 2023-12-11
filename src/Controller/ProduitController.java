package Controller;

import java.awt.event.*;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.ProduitDAO;
import Model.Produit;
import View.EntrepriseView;

public class ProduitController {
    // Attributs
    private ProduitDAO produitDAO;
    private EntrepriseView view;

    // Constructor
    public ProduitController(ProduitDAO pD, EntrepriseView vi) {
        this.produitDAO = pD;
        this.view = vi;

        view.getaddButtonPr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                int id = 0;
                String nom = view.getnomProduitField().getText();
                String prix = view.getprixProduitField().getText();
                String employen = view.getNEmployeProduitField().getText();
                Produit produit = new Produit(id, nom, prix, employen);
                produitDAO.insert(produit);
                view.getdisplayButtonPr().doClick();
                view.clearTextFieldsProduit();

            }
        });

        view.getdisplayButtonPr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                view.updateProductListComboBox();
                List<Produit> products = produitDAO.getAll();
                view.displayProducts(products);
                view.clearTextFieldsProduit();
            }
        });

        view.getTableProduit().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && view.getTableProduit().getSelectedRow() != -1) {
                    int selectedRow = view.getTableProduit().getSelectedRow();
                    int id = (Integer) view.getTableProduit().getValueAt(selectedRow, 0);
                    view.getdeleteButtonPr().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent args0) {
                            produitDAO.delete(id);
                            view.getdisplayButtonPr().doClick();
                            view.clearTextFieldsProduit();
                        }
                    });
                    view.getTableProduit().addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                String nom = (String) view.getTableProduit().getValueAt(selectedRow, 1);
                                String prix = (String) view.getTableProduit().getValueAt(selectedRow, 2);
                                String employen = (String) view.getTableProduit().getValueAt(selectedRow, 3);

                                Produit updatedProduit = new Produit(id, nom, prix, employen);

                                produitDAO.update(updatedProduit);
                                view.getdisplayButtonPr().doClick();
                                view.clearTextFieldsProduit();
                            }
                        }
                    });

                }
            }
        });

    }
}
