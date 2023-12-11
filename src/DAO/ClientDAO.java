package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Client;

public class ClientDAO {
	private Connection connection = null;
	private PreparedStatement s1 = null;

	public ClientDAO() {
		// Create a single DBConnection instance to be reused
		DBConnection connec = new DBConnection();
		connection = connec.getConnection();
	}

	// Methode 1
	public List<Client> getById(int id) {
		List<Client> clientList = new ArrayList<>();
		try {
			String query = "SELECT FROM client WHERE id = ?";
			s1 = connection.prepareStatement(query);
			s1.setInt(1, id);
			ResultSet res = s1.executeQuery();
			while (res.next()) {
				int idd = res.getInt("id");
				String name = res.getString("nom");
				String prenom = res.getString("prenom");
				String email = res.getString("email");
				Client client = new Client(idd, name,prenom, email);
				clientList.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return clientList;
	}

	// Methode 2
	public List<Client> getAll() {
		List<Client> clientList = new ArrayList<>();

		try {
			String query = "SELECT * FROM client";
			s1 = connection.prepareStatement(query);
			ResultSet res = s1.executeQuery();

			while (res.next()) {
				int idd = res.getInt("id");
				String name = res.getString("nom");
				String prenom = res.getString("prenom");
				String email = res.getString("email");
				Client client = new Client(idd, name, prenom, email);
				clientList.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return clientList;
	}

	// Methode 3
	public void insert(Client entity) {
		try {
			String query = "INSERT INTO client (nom, prenom, email) VALUES (?, ?, ?)";
			s1 = connection.prepareStatement(query);
			s1.setString(1, entity.getNom());
			s1.setString(2, entity.getPrenom());
			s1.setString(3, entity.getEmail());
			s1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

	}

	// Methode 4
	public void update(Client entity) {
		try {
			String query = "UPDATE client SET nom=?, prenom=?, email=? WHERE id=?";
			s1 = connection.prepareStatement(query);
			s1.setString(1, entity.getNom());
			s1.setString(2, entity.getPrenom());
			s1.setString(3, entity.getEmail());
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
			String query2 = "DELETE FROM achat WHERE idclient = ?";
			s1 = connection.prepareStatement(query2);
			s1.setInt(1, id);
			s1.executeUpdate();
			String query = "DELETE FROM client WHERE id = ?";
			s1 = connection.prepareStatement(query);
			s1.setInt(1, id);
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
