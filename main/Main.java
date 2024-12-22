package Main;

import DAO.EmployeImpl;
import Model.EmployeModel;
import View.EmployeView;
import controller.EmployeController;

public class Main {

	public static void main(String[] args) {
		EmployeView View = new EmployeView();
		EmployeImpl DAO =new EmployeImpl();
		EmployeModel Model = new EmployeModel(DAO);
		new EmployeController(Model,View);
		
		View.setVisible(true);
		
	}

}