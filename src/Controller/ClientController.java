package Controller;

import java.util.List;
import java.awt.event.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.AchatDAO;
import DAO.ClientDAO;
import Model.Achat;
import Model.Client;
import View.EntrepriseView;

public class ClientController {
    // Attributs
    private ClientDAO clientDAO;
    private AchatDAO achatDAO;
    private EntrepriseView view;

    // Constructor
    public ClientController(ClientDAO pD, EntrepriseView vi, AchatDAO achatDAO) {
        this.clientDAO = pD;
        this.view = vi;
        this.achatDAO = achatDAO;
        

        view.getaddButtonCl().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                int id = 0;
                String nom = view.getnomClientField().getText();
                String prenom = view.getprenomClientField().getText();
                String email = view.getemailClientField().getText();
                String selectedProduct = view.getSelectedProductFromComboBox();
                Client client = new Client(id, nom, prenom, email);
                int idCli = client.getId();
                System.out.println(idCli);
                System.out.println(selectedProduct);
                clientDAO.insert(client);
                Achat achat = new Achat(id, idCli, selectedProduct);
                achatDAO.insert(achat);
                view.getdisplayButtonCl().doClick();
                view.clearTextFieldsClient();

            }
        });

        view.getdisplayButtonCl().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                view.updateProductListComboBox();
                List<Client> clients = clientDAO.getAll();
                view.displayClients(clients);
                view.clearTextFieldsClient();
            }
        });

        view.getTableClient().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && view.getTableClient().getSelectedRow() != -1) {
                    int selectedRow = view.getTableClient().getSelectedRow();
                    int id = (Integer) view.getTableClient().getValueAt(selectedRow, 0);
                    view.getdeleteButtonCl().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent args0) {
                            clientDAO.delete(id);
                            view.getdisplayButtonCl().doClick();
                            view.clearTextFieldsClient();
                        }
                    });
                    view.getTableClient().addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                String nom = (String) view.getTableClient().getValueAt(selectedRow, 1);
                                String prenom = (String) view.getTableClient().getValueAt(selectedRow, 2);
                                String email = (String) view.getTableClient().getValueAt(selectedRow, 3);

                                Client updatedClient = new Client(id, nom, prenom, email);

                                clientDAO.update(updatedClient);
                                view.getdisplayButtonCl().doClick();
                                view.clearTextFieldsClient();
                            }
                        }
                    });

                }
            }
        });

    }
}
