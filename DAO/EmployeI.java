package DAO;

import java.util.List;

import Model.Employe;
import Model.Employe.Poste;
import Model.Employe.Role;

public interface EmployeI {
	
List<Employe> findAll();
void add(Employe E);
void update(Employe E,int id);
void delete(int id);



}