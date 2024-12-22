package controller;



import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.EmployeImpl;
import Model.Employe;
import Model.Employe.Poste;
import Model.Employe.Role;

import Model.EmployeModel;
import View.EmployeView;

public class EmployeController {
private EmployeModel model;
private EmployeView view;

public EmployeController(EmployeModel model,EmployeView view) {
	this.model=model;
	this.view=view;
	
	this.view.btnAjouter.addActionListener(e->addEmploye());
	this.view.btnModifier.addActionListener(e->updateEmploye());
	this.view.btnAfficher.addActionListener(e -> afficherEmploye());
	this.view.btnSupprimer.addActionListener(e -> supprimerEmploye());
	


}
//Méthode pour ajouter un employé
private void addEmploye() {
	String nom=view.getNom();
	String prenom=view.getPrenom();
	String email=view.getEmail();
	String telephone=view.getTelephone();
	double salaire =view.getSalaire();
	Poste poste=view.getPoste();
	Role role=view.getRole();
	

	boolean addEmploye=model.addEmploye(nom, prenom, email, telephone,salaire, role, poste);
    afficherEmploye();

	if(addEmploye) JOptionPane.showMessageDialog(null, "Employé Ajouté avec succès !");
	else JOptionPane.showMessageDialog(null, "Echec d'ajout d'employe !!!!!");
}

//Méthode pour modifier un employé
private void updateEmploye() {
	int selectedRow = view.table.getSelectedRow();

    int id = (int) view.table.getValueAt(selectedRow, 0);
	
	String nom=view.getNom();
	String prenom=view.getPrenom();
	String email=view.getEmail();
	String telephone=view.getTelephone();
	double salaire =view.getSalaire();
	Poste poste=view.getPoste();
	Role role=view.getRole();
	
	  Employe employe = new Employe(nom, prenom, email, telephone, salaire, role, poste);
	    EmployeImpl employeImpl = new EmployeImpl();

	    employeImpl.update(employe,id);
        afficherEmploye();

	    JOptionPane.showMessageDialog(null, "Employé modifié avec succès !");
	}

// Méthode pour afficher tous les employés dans la table
public void afficherEmploye() {
 EmployeImpl employeImpl = new EmployeImpl();
	    List<Employe> employes = employeImpl.findAll();

	   DefaultTableModel model = (DefaultTableModel) view.table.getModel();
	    model.setRowCount(0);

	    for (Employe employe : employes) {
	        model.addRow(new Object[]{
	        	employe.getId(),
	            employe.getNom(),
	            employe.getPrenom(),
	            employe.getEmail(),
	            employe.getTelephone(),
	            employe.getSalaire(),
	            employe.getRole(),
	            employe.getPoste()
	        });
	    }
	}

//Méthode pour supprimer un employé
public void supprimerEmploye() {
int selectedRow = view.table.getSelectedRow();
    if (selectedRow == -1) {
    
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un employé à supprimer !");
   
    }
    int id =view.getId(view.table);
    EmployeImpl employeImpl = new EmployeImpl();

  
        employeImpl.delete(id);
        afficherEmploye();
        JOptionPane.showMessageDialog(null, "Employé supprimé avec succès !");
      
        
        }  
}
