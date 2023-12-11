package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Achat;

public class AchatDAO {
    private Connection connection = null;
	private PreparedStatement s1 = null;

	public AchatDAO() {
		// Create a single DBConnection instance to be reused
		DBConnection connec = new DBConnection();
		connection = connec.getConnection();
	}

    	// Methode 2
	public List<Achat> getAllAchats() {
		List<Achat> AahatList = new ArrayList<>();

		try {
			String query = "SELECT * FROM achat_view";
			s1 = connection.prepareStatement(query);
			ResultSet res = s1.executeQuery();

			while (res.next()) {
				int idd = res.getInt("id_achat");
				String clientname = res.getString("client_full_name");
				String productname = res.getString("product_name");
				String status = res.getString("status");
                String dateachat = res.getString("dateachat");
				Achat achat = new Achat(idd, clientname, productname, dateachat, status);
				AahatList.add(achat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return AahatList;
	}

    	// Methode 2
	public List<Achat> geAchatsNomPay() {
		List<Achat> AahatList = new ArrayList<>();

		try {
			String query = "SELECT * FROM achat_view where status != 'Payment Received'";
			s1 = connection.prepareStatement(query);
			ResultSet res = s1.executeQuery();

			while (res.next()) {
				int idd = res.getInt("id_achat");
				String clientname = res.getString("client_full_name");
				String productname = res.getString("product_name");
				String status = res.getString("status");
                String dateachat = res.getString("dateachat");
				Achat achat = new Achat(idd, clientname, productname, dateachat, status);
				AahatList.add(achat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return AahatList;
	}

    	// Methode 2
	public List<Achat> getAchatsPay() {
		List<Achat> AahatList = new ArrayList<>();

		try {
			String query = "SELECT * FROM achat_view where status = 'Payment Received'";
			s1 = connection.prepareStatement(query);
			ResultSet res = s1.executeQuery();

			while (res.next()) {
				int idd = res.getInt("id_achat");
				String clientname = res.getString("client_full_name");
				String productname = res.getString("product_name");
				String status = res.getString("status");
                String dateachat = res.getString("dateachat");
				Achat achat = new Achat(idd, clientname, productname, dateachat, status);
				AahatList.add(achat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return AahatList;
	}

	// Methode 3
	public void insert(Achat entity) {
		int idd=0, idd2=0;
		try {
			String query2 = "SELECT * FROM Client ORDER BY id DESC LIMIT 1";
			s1 = connection.prepareStatement(query2);
			ResultSet res = s1.executeQuery();
			while (res.next()) {
			   idd = res.getInt("id");
			}
			String query3 = "SELECT id FROM produit where nom = ?";
			s1 = connection.prepareStatement(query3);
			s1.setString(1, entity.getIdProduit());
			ResultSet res2 = s1.executeQuery();
			while (res2.next()) {
			   idd2 = res2.getInt("id");
			}
			String query = "INSERT INTO achat (idClient, idProduit) VALUES (?, ?)";
			s1 = connection.prepareStatement(query);
			s1.setInt(1, idd);
			s1.setInt(2, idd2);
			s1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

    private void closeResources() {
		try {
			if (s1 != null) {
				s1.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}
