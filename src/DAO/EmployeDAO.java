package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Employe;

public class EmployeDAO  {
    private Connection connection = null;
	private PreparedStatement s2 = null;

	public EmployeDAO() {
		// Create a single DBConnection instance to be reused
		DBConnection connec = new DBConnection();
		connection = connec.getConnection();
	}

	// Methode 1
	public List<Employe> getById(int id) {
		List<Employe> employeList = new ArrayList<>();
		try {
			String query = "SELECT FROM employe WHERE id = ?";
			s2 = connection.prepareStatement(query);
			s2.setInt(1, id);
			ResultSet res = s2.executeQuery();
			while (res.next()) {
				int idd = res.getInt("id");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String salaire = res.getString("salaire");
				Employe employe = new Employe(idd, nom, prenom, salaire);
				employeList.add(employe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return employeList;
	}

	// Methode 2
	public List<Employe> getAll() {
		List<Employe> employeList = new ArrayList<>();

		try {
			String query = "SELECT * FROM employe";
			s2 = connection.prepareStatement(query);
			ResultSet res = s2.executeQuery();

			while (res.next()) {
				int id = res.getInt("id");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String salaire = res.getString("salaire");
				Employe employe = new Employe(id, nom, prenom, salaire);
				employeList.add(employe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return employeList;
	}

	// Methode 3
	public void insert(Employe entity) {
		try {
			String query = "INSERT INTO employe (nom, prenom, salaire) VALUES (?, ?, ?)";
			s2 = connection.prepareStatement(query);
			s2.setString(1, entity.getNom());
			s2.setString(2, entity.getPrenom());
			s2.setString(3, entity.getSalaire());
			s2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

	}

	// Methode 4
	public void update(Employe entity) {
		try {
			String query = "UPDATE employe SET nom=?, prenom=?, salaire=? WHERE id=?";
				s2 = connection.prepareStatement(query);
				s2.setString(1, entity.getNom());
				s2.setString(2, entity.getPrenom());
				s2.setString(3, entity.getSalaire());
				s2.setInt(4, entity.getId());
				s2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	// Methode 5
	public void delete(int id) {
		try {
			String query = "DELETE FROM employe WHERE id = ?";
			s2 = connection.prepareStatement(query);
			s2.setInt(1, id);
			s2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	private void closeResources() {
		try {
			if (s2 != null) {
				s2.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
