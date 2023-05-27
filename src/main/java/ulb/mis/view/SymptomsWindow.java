/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ulb.mis.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JCheckBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ulb.mis.controller.PatientJpaController;
import ulb.mis.controller.SicknessJpaController;
import ulb.mis.model.Patient;
import ulb.mis.model.Sickness;

/**
 *
 * @author fanny
 */
public class SymptomsWindow extends javax.swing.JFrame {
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("MISproject_PU");
    private final SicknessJpaController sicknessCtrl = new SicknessJpaController(emfac);
    private final PatientJpaController patientCtrl = new PatientJpaController(emfac);
    List<Sickness> sicknesses = sicknessCtrl.findSicknessEntities();
    
    private static final Logger LOGGER = LogManager.getLogger(CreatePatientAccount.class.getName());

    int a = 1;
    int b = 1;
    Patient patientLog = null;
    Sickness sickness = null;
    /**
     * Creates new form symp
     */
    
    public SymptomsWindow(Patient patient) {
        patientLog = patient;
        initComponents();
        
        
        
        setLayout(null); // Utiliser le null layout
        
        for(int i =0; i < sicknesses.size(); i++){
            javax.swing.JCheckBox checkBox = new javax.swing.JCheckBox(sicknesses.get(i).getSymptom1());           
            checkBox.setBounds(50*a, 25*b, 100, 25); // Définissez les coordonnées et la taille de la checkbox
            add(checkBox);
            if (b!=25){
                b= b+2;
            }
            else{
                b=1;
                a = a+3;
            }
            javax.swing.JCheckBox checkBox2 = new javax.swing.JCheckBox(sicknesses.get(i).getSymptom2());           
            checkBox2.setBounds(50*a, 25*b, 100, 25);
            add(checkBox2);
            if (b!=25){
                b= b+2;
            }
            else{
                b=1;
                a = a+3;
            }
            javax.swing.JCheckBox checkBox3 = new javax.swing.JCheckBox(sicknesses.get(i).getSymptom3());           
            checkBox3.setBounds(50*a, 25*b, 100, 25);
            add(checkBox3);
            if (b!=25){
                b= b+2;
            }
            else{
                b=1;
                a = a+3;
            }
            javax.swing.JCheckBox checkBox4 = new javax.swing.JCheckBox(sicknesses.get(i).getSymptom4());           
            checkBox4.setBounds(50*a, 25*b, 100, 25);
            add(checkBox4);
            if (b!=25){
                b= b+2;
            }
            else{
                b=1;
                a = a+3;
            }
        }
        // Ajouter d'autres checkboxes avec des positions personnalisées...
        
        JButton button = new JButton("Confirm");
        button.setBounds(450, 455, 75, 40); // Position et taille du bouton
        button.setBackground(new Color(255, 204, 102));
        add(button);
        
        setSize(550, 550); // Définir la taille souhaitée pour la fenêtre
        setResizable(false); // Empêcher le redimensionnement de la fenêtre
        
        setPreferredSize(getSize()); // Définir la taille préférée pour la fenêtre
        
        pack();
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<JCheckBox> listBoxes = searchBoxes(); 
                /*for (int i = 0; i<listBoxes.size();i++){
                    System.out.println(listBoxes.get(i).getText());
                }*/
                sickness = findSickness(listBoxes);
                System.out.println(sickness);
                patientLog.setIdsickness(sickness);
                try {
                    patientCtrl.edit(patientLog);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(SymptomsWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
    }
    
    private List<JCheckBox> searchBoxes(){
        List<JCheckBox> boxesList = new ArrayList<>();

        Component[] components = getContentPane().getComponents();
        
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                if (checkBox.isSelected()){
                    boxesList.add(checkBox);
                    
                }              
            }
        }
        return boxesList;
    }
    
    private Sickness findSickness(List<JCheckBox> listBoxes){
        Sickness sickness = null;
        String strBox1 = listBoxes.get(0).getText();
        String strBox2 = listBoxes.get(1).getText();
        String strBox3 = listBoxes.get(2).getText();
        String strBox4 = listBoxes.get(3).getText();
        for (int i =0; i < sicknesses.size(); i++){
            if (strBox1.equals(sicknesses.get(i).getSymptom1())||strBox1.equals(sicknesses.get(i).getSymptom2())||strBox1.equals(sicknesses.get(i).getSymptom3())||strBox1.equals(sicknesses.get(i).getSymptom4())){
                if (strBox2.equals(sicknesses.get(i).getSymptom1())||strBox2.equals(sicknesses.get(i).getSymptom2())||strBox2.equals(sicknesses.get(i).getSymptom3())||strBox2.equals(sicknesses.get(i).getSymptom4())){
                   if (strBox3.equals(sicknesses.get(i).getSymptom1())||strBox3.equals(sicknesses.get(i).getSymptom2())||strBox3.equals(sicknesses.get(i).getSymptom3())||strBox3.equals(sicknesses.get(i).getSymptom4())){
                       if (strBox4.equals(sicknesses.get(i).getSymptom1())||strBox4.equals(sicknesses.get(i).getSymptom2())||strBox4.equals(sicknesses.get(i).getSymptom3())||strBox4.equals(sicknesses.get(i).getSymptom4())){
                           sickness = sicknesses.get(i);
                       }
                    } 
                }
            }
        }
        
        return sickness;
    }
     
   
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
