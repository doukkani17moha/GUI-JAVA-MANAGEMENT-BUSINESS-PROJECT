package DAO;

import java.util.List;

interface IGenericDAOInterface <T> {
	//Methode de Recuperer une entite par son id
	 List <T> getById(int id);
	//Methode de recuperer tous les entites
	 List <T> getAll();
	//Methode pour l'ajoutation de l'entite
	 void insert (T entity);
	//Methode pour mise a jour l'entite
	 void update(T entity);
	//Methode pour supprimer l'entite par son id
	 void delete (int id);
}
