package Controller;

import java.util.List;

import java.awt.event.*;
import DAO.AchatDAO;
import Model.Achat;
import View.EntrepriseView;

public class AchatController {
      // Attributs
    private AchatDAO achatDAO;
    private EntrepriseView view;

    // Constructor
    public AchatController(AchatDAO pD, EntrepriseView vi) {
        this.achatDAO = pD;
        this.view = vi;

    view.getallachatButoon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                List<Achat> achats = achatDAO.getAllAchats();
                view.displayAchats(achats);
            }
        });

     view.getpayachatButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                List<Achat> achats = achatDAO.getAchatsPay();
                view.displayAchats(achats);
            }
        });
    
     view.getnopachatButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent args0) {
                List<Achat> achats = achatDAO.geAchatsNomPay();
                view.displayAchats(achats);
            }
        });
    }
    
}
