package Model;

import javax.swing.JOptionPane;

import DAO.EmployeImpl;
import Model.Employe.Poste;
import Model.Employe.Role;

public class EmployeModel {
  private EmployeImpl dao;

  public EmployeModel(EmployeImpl dao) {
	this.dao=dao;
}

//logique Metier
public boolean addEmploye(String nom,String pronom,String email,String telephone,double salaire,Role role,Poste poste) {
	// Vérifie si le salaire est inférieur ou égal à zéro
	if(salaire<=0) {
	    JOptionPane.showMessageDialog(null, "Salaire invalide il est infèrieure de zéro !!!!!!!");

	   return false;}
	
    // Vérifie si l'email est nul ou ne contient pas le caractère '@'
	if (email == null || !email.contains("@")) {
	    JOptionPane.showMessageDialog(null, "L'email n'est pas valide Ajouter '@' !!!!!!!");

		
        return false;
    }	
	
	Employe NvEmploye = new Employe(nom,pronom,email,telephone,salaire,role,poste);
	dao.add(NvEmploye);
return true;	

}}
