package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Employe.Role;
import Model.Employe.Poste;

import java.awt.*;
import java.util.ArrayList;

public class EmployeView extends JFrame {
    
    // Déclaration des panneaux et composants de l'interface utilisateur
    private JPanel mainPanel, topPanel, centerPanel, bottomPanel;
    private JLabel lblNom, lblPrenom, lblEmail, lblTelephone, lblSalaire, lblPoste, lblRole;
    private JTextField txtNom, txtPrenom, txtEmail, txtTelephone, txtSalaire;
    private JComboBox<Poste> cbPoste;
    private JComboBox<Role> cbRole;
    public JTable table;
    public JButton btnAjouter;
	public JButton btnModifier;
	public JButton btnSupprimer;
	public JButton btnAfficher;

    public EmployeView() {
    	
        // Configuration de la fenêtre principale
        setTitle("Gestion des Employés");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

     // Initialisation des panneaux
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new GridLayout(8, 2, 10, 10)); 
        centerPanel = new JPanel(new BorderLayout()); 
        bottomPanel = new JPanel(new GridLayout(1, 4, 10, 10)); 

     // Initialisation des étiquettes
        lblNom = new JLabel("Nom:");
        lblPrenom = new JLabel("Prénom:");
        lblEmail = new JLabel("Email:");
        lblTelephone = new JLabel("Téléphone:");
        lblSalaire = new JLabel("Salaire:");
        lblPoste = new JLabel("Poste:");
        lblRole = new JLabel("Rôle:");

        // Initialisation des champs d'entrée
        txtNom = new JTextField();
        txtPrenom = new JTextField();
        txtEmail = new JTextField();
        txtTelephone = new JTextField();
        txtSalaire = new JTextField();

        // Initialisation des listes déroulantes
        cbRole = new JComboBox<>(Role.values());
        cbPoste = new JComboBox<>(Poste.values());
        
        

        // Initialisation du tableau avec les colonnes
        table = new JTable(new DefaultTableModel(new Object[]{"ID", "Nom", "Prénom", "Email", "Téléphone", "Salaire", "Poste", "Rôle"},0));
        JScrollPane scrollPane = new JScrollPane(table);

       
        // Initialisation des boutons
        btnAjouter = new JButton("Ajouter");
        btnModifier = new JButton("Modifier");
        btnSupprimer = new JButton("Supprimer");
        btnAfficher = new JButton("Afficher");

     // Ajout des composants au panneau supérieur
        topPanel.add(lblNom);
        topPanel.add(txtNom);
        topPanel.add(lblPrenom);
        topPanel.add(txtPrenom);
        topPanel.add(lblEmail);
        topPanel.add(txtEmail);
        topPanel.add(lblTelephone);
        topPanel.add(txtTelephone);
        topPanel.add(lblSalaire);
        topPanel.add(txtSalaire);
        topPanel.add(lblRole);
        topPanel.add(cbRole);
        topPanel.add(lblPoste);
        topPanel.add(cbPoste);
        topPanel.add(new JLabel("Liste des Employes :"));

        // Ajout du tableau au panneau central
        centerPanel.add(scrollPane, BorderLayout.CENTER);

     // Ajout des boutons au panneau inférieur
        bottomPanel.add(btnAjouter);
        bottomPanel.add(btnModifier);
        bottomPanel.add(btnSupprimer);
        bottomPanel.add(btnAfficher);

        // Organisation des panneaux dans le panneau principal

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Ajout du panneau principal à la fenêtre
        add(mainPanel);
        setVisible(true);
        }
    
 // Méthode pour obtenir l'ID de l'employé sélectionné dans le tableau
    public int getId(JTable table) {
        int selectedRow = table.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne !");
            return -1; 
        }
        return (int) table.getValueAt(selectedRow, 0);
        
    }
    
 // Méthodes pour récupérer les données des champs d'entrée
          public String getNom() {
    	     return txtNom.getText();
            }
          
          public String getPrenom() {
     	     return txtPrenom.getText();
             }
          public String getEmail() {
        	     return txtEmail.getText();
             }
          public String getTelephone() {
     	     return txtTelephone.getText();
             }
          public double getSalaire() {
     	     return Double.parseDouble(txtSalaire.getText());
             }
          public Role getRole() {
        	  Role r=(Role) cbRole.getSelectedItem();
      	     return r;
              }
          public Poste getPoste() {
        	  Poste p=(Poste) cbPoste.getSelectedItem();
       	     return p ;
               }
          
    public static void main(String[] args) {
        new EmployeView();
    }
}
