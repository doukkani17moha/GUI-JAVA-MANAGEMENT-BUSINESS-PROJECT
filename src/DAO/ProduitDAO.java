package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Produit;

public class ProduitDAO  {
	private Connection connection = null;
	private PreparedStatement s1 = null;

	public ProduitDAO() {
		// Create a single DBConnection instance to be reused
		DBConnection connec = new DBConnection();
		connection = connec.getConnection();
	}

	// Methode 1
	public List<Produit> getById(int id) {
		List<Produit> productList = new ArrayList<>();
		try {
			String query = "SELECT FROM produit WHERE id = ?";
			s1 = connection.prepareStatement(query);
			s1.setInt(1, id);
			ResultSet res = s1.executeQuery();
			while (res.next()) {
				int idd = res.getInt("id");
				String nom = res.getString("nom");
				String prix = res.getString("prix");
				String Employen = res.getString("employe_name");
				Produit produit = new Produit(idd, nom, prix, Employen);
				productList.add(produit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return productList;
	}

	// Methode 2
	public List<Produit> getAll() {
		List<Produit> productList = new ArrayList<>();

		try {
			String query = "SELECT * FROM produit";
			s1 = connection.prepareStatement(query);
			ResultSet res = s1.executeQuery();

			while (res.next()) {
				int id = res.getInt("id");
				String name = res.getString("nom");
				String price = res.getString("prix");
				String Employen = res.getString("employe_name");
				Produit produit = new Produit(id, name, price, Employen);
				productList.add(produit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return productList;
	}

	// Methode 3
	public void insert(Produit entity) {
		try {
			String query = "INSERT INTO produit (nom, prix, employe_name) VALUES (?, ?, ?)";
			s1 = connection.prepareStatement(query);
			s1.setString(1, entity.getNom());
			s1.setString(2, entity.getPrix());
			s1.setString(3, entity.getEmployeName());
			s1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

	}

	// Methode 4
	public void update(Produit entity) {
		try {
			String query = "UPDATE produit SET nom=?, prix=?, employe_name=? WHERE id=?";
			s1 = connection.prepareStatement(query);
			s1.setString(1, entity.getNom());
			s1.setString(2, entity.getPrix());
			s1.setString(3, entity.getEmployeName());
			s1.setInt(4, entity.getId());
			s1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	// Methode 5
	public void delete(int id) {
		try {
			String query = "DELETE FROM produit WHERE id = ?";
			s1 = connection.prepareStatement(query);
			s1.setInt(1, id);
			s1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	// Inside ProduitDAO
	public List<String> getAllProductNames() {
		List<String> productNames = new ArrayList<>();
		try {
			String query = "SELECT nom FROM produit";
			s1 = connection.prepareStatement(query);
			ResultSet res = s1.executeQuery();

			while (res.next()) {
				String productName = res.getString("nom");
				productNames.add(productName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return productNames;
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
