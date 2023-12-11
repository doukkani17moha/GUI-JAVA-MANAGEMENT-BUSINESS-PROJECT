package Controller;

import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;


import DAO.EmployeDAO;
import Model.Employe;
import View.EntrepriseView;

public class EmployeController {
    
      // Attributs
    private EmployeDAO employeDAO;
    private EntrepriseView view;

    // Constructor
    public EmployeController(EmployeDAO pD, EntrepriseView vi) {
        this.employeDAO = pD;
        this.view = vi;

        view.getaddButtonEm().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                int id = 0;
                String nom = view.getnomEmployeField().getText();
                String prenom = view.getprenomEmployeField().getText();
                String salaire = view.getsalaireEmployeField().getText();
                Employe employe = new Employe(id, nom, prenom, salaire);
                employeDAO.insert(employe);
                view.getdisplayButtonEm().doClick();
                view.clearTextFieldsEmloye();

            }
        });

        view.getdisplayButtonEm().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                List<Employe> employes = employeDAO.getAll();
                view.displayEmployes(employes);
                view.clearTextFieldsEmloye();
            }
        });

        view.getTableEmploye().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && view.getTableEmploye().getSelectedRow() != -1) {
                    int selectedRow = view.getTableEmploye().getSelectedRow();
                    int id = (Integer) view.getTableEmploye().getValueAt(selectedRow, 0);
                    view.getdeleteButtonEm().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent args0) {
                            employeDAO.delete(id);
                            view.getdisplayButtonEm().doClick();
                            view.clearTextFieldsEmloye();
                        }
                    });
                    view.getTableEmploye().addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                String nom = (String) view.getTableEmploye().getValueAt(selectedRow, 1);
                                String prenom = (String) view.getTableEmploye().getValueAt(selectedRow, 2);
                                String salaire = (String) view.getTableEmploye().getValueAt(selectedRow, 3);

                                Employe updatedEmploye = new Employe(id, nom, prenom, salaire);

                                employeDAO.update(updatedEmploye);
                                view.getdisplayButtonEm().doClick();
                                view.clearTextFieldsEmloye();
                            }
                        }
                    });

                }
            }
        });

    }
}
