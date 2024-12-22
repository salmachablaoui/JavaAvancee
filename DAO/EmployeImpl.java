package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Employe.Role;

import Model.Employe;
import Model.Employe.Poste;


public class EmployeImpl implements EmployeI {
    private Connection conn;

    public EmployeImpl() {
        this.conn = connexion.getConnexion();
    }
    
    // Ajouter un nouvel employé dans la base de données
    @Override
    public void add(Employe E) {
        String Query = "INSERT INTO Employee(nom, prenom, email, telephone, salaire, role, poste) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(Query)) {
            stmt.setString(1, E.getNom());
            stmt.setString(2, E.getPrenom());
            stmt.setString(3, E.getEmail());
            stmt.setString(4, E.getTelephone());
            stmt.setDouble(5, E.getSalaire());
            stmt.setString(6, E.getRole().name());
            stmt.setString(7, E.getPoste().name());
            stmt.executeUpdate();
            System.out.println("Employé ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'employé !");
             
            
        }
    }
    
  
    // Récupérer la liste de tous les employés dans la base de données    
    @Override
	public List<Employe> findAll() {
	    List<Employe> employes = new ArrayList<>();
	    String query = "SELECT * FROM Employee";
	    try (Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {
	        while (rs.next()) {
	            employes.add(new Employe(
	            	rs.getInt("id"),
	                rs.getString("nom"),
	                rs.getString("prenom"),
	                rs.getString("email"),
	                rs.getString("telephone"),
	                rs.getDouble("salaire"),
	                Employe.Role.valueOf(rs.getString("role")),
	                Poste.valueOf(rs.getString("poste"))
	            ));
	        }
	    } catch (SQLException e) {
	        System.out.println("Erreur lors de la récupération de tous les employés !!!!!");
	       
	    }
	    return employes;
	}

 // Mettre à jour les informations d'un employé existant
@Override
public void update(Employe E, int id) {
    String query = "UPDATE Employee SET nom = ?, prenom = ?, email = ?, telephone = ?, salaire = ?, role = ?, poste = ? WHERE id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
    	
        stmt.setString(1, E.getNom());
        stmt.setString(2, E.getPrenom());
        stmt.setString(3, E.getEmail());
        stmt.setString(4, E.getTelephone());
        stmt.setDouble(5, E.getSalaire());
        stmt.setString(6, E.getRole().name());
        stmt.setString(7, E.getPoste().name());
        stmt.setInt(8, id);
        stmt.executeUpdate();
        
        System.out.println("Employe modifier avec succès !");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la modefication de l'employe !!!!!");
        
    }
}

// Supprimer un employé de la base de données par son ID
@Override
public void delete(int id) {
    String query = "DELETE FROM Employee WHERE id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Employe supprimé avec succès !");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression de l'employe !!!!");
      
    }
}



}
