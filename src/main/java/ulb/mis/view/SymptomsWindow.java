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
    

    int a = 1;
    int b = 1;
    boolean checkString = true;
    Patient patientLog = null;
    Sickness sickness = null;
    
    List<String> stringBoxes = new ArrayList<>();
    /**
     * Creates new form symp
     */
    
    public SymptomsWindow(Patient patient) {
        patientLog = patient;
        initComponents();
        
        
        
        setLayout(null); // Utiliser le null layout
        
        for(int i =0; i < sicknesses.size(); i++){
            
            stringBoxes = searchStringBoxes();
            for (int x = 0; x < stringBoxes.size(); x++){
                if (stringBoxes.get(x).equals(sicknesses.get(i).getSymptom1())){
                    checkString = false;
                    break;
                }
            }
            if(checkString){
                JCheckBox checkBox1 = new javax.swing.JCheckBox(sicknesses.get(i).getSymptom1());           
                addBoxPannel(checkBox1);
            }
            checkString = true;
            
            stringBoxes = searchStringBoxes();
            for (int x = 0; x < stringBoxes.size(); x++){
                if (stringBoxes.get(x).equals(sicknesses.get(i).getSymptom2())){
                    checkString = false;
                    break;
                }
            }
            if(checkString){
                JCheckBox checkBox2 = new javax.swing.JCheckBox(sicknesses.get(i).getSymptom2());           
                addBoxPannel(checkBox2);
            }
            checkString = true;
            
            stringBoxes = searchStringBoxes();
            for (int x = 0; x < stringBoxes.size(); x++){
                if (stringBoxes.get(x).equals(sicknesses.get(i).getSymptom3())){
                    checkString = false;
                    break;
                }
            }
            if(checkString){
                JCheckBox checkBox3 = new javax.swing.JCheckBox(sicknesses.get(i).getSymptom3());           
                addBoxPannel(checkBox3);
            }
            checkString = true;
            
            stringBoxes = searchStringBoxes();
            for (int x = 0; x < stringBoxes.size(); x++){
                if (stringBoxes.get(x).equals(sicknesses.get(i).getSymptom4())){
                    checkString = false;
                    break;
                }
            }
            if(checkString){
                JCheckBox checkBox4 = new javax.swing.JCheckBox(sicknesses.get(i).getSymptom4());           
                addBoxPannel(checkBox4);
            }
            checkString = true;
            
            
        }
        
        JButton button = new JButton("Confirm");
        button.setBounds(650, 655, 75, 40); // Position et taille du bouton
        button.setBackground(new Color(255, 204, 102));
        add(button);
        
        setSize(750, 750); // Définir la taille souhaitée pour la fenêtre
        setResizable(false); // Empêcher le redimensionnement de la fenêtre
        
        setPreferredSize(getSize()); // Définir la taille préférée pour la fenêtre
        
        pack();
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<JCheckBox> listBoxes = searchBoxes(); 
                sickness = findSickness(listBoxes);
                System.out.println(sickness);
                patient.setIdsickness(sickness);
                try {
                    patientCtrl.edit(patientLog);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(SymptomsWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
        });
        
        
        
    }
    
    private List<String> searchStringBoxes(){
        List<String> nameBoxesList = new ArrayList<>();
        
        Component[] components = getContentPane().getComponents();
        
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                nameBoxesList.add(checkBox.getText());             
            }
        }
        return nameBoxesList;
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
        Sickness sick = null;
        String strBox1 = listBoxes.get(0).getText();
        String strBox2 = listBoxes.get(1).getText();
        String strBox3 = listBoxes.get(2).getText();
        String strBox4 = listBoxes.get(3).getText();
        for (int i =0; i < sicknesses.size(); i++){
            if (strBox1.equals(sicknesses.get(i).getSymptom1())||strBox1.equals(sicknesses.get(i).getSymptom2())||strBox1.equals(sicknesses.get(i).getSymptom3())||strBox1.equals(sicknesses.get(i).getSymptom4())){
                if (strBox2.equals(sicknesses.get(i).getSymptom1())||strBox2.equals(sicknesses.get(i).getSymptom2())||strBox2.equals(sicknesses.get(i).getSymptom3())||strBox2.equals(sicknesses.get(i).getSymptom4())){
                   if (strBox3.equals(sicknesses.get(i).getSymptom1())||strBox3.equals(sicknesses.get(i).getSymptom2())||strBox3.equals(sicknesses.get(i).getSymptom3())||strBox3.equals(sicknesses.get(i).getSymptom4())){
                       if (strBox4.equals(sicknesses.get(i).getSymptom1())||strBox4.equals(sicknesses.get(i).getSymptom2())||strBox4.equals(sicknesses.get(i).getSymptom3())||strBox4.equals(sicknesses.get(i).getSymptom4())){
                           sick = sicknesses.get(i);
                       }
                    } 
                }
            }
        }
        
        return sick;
    }
    
    private void addBoxPannel(JCheckBox box){
        box.setBounds(50*a, 25*b, 100, 25); // Définissez les coordonnées et la taille de la checkbox
            add(box);
            if (b!=25){
                b= b+2;
            }
            else{
                b=1;
                a = a+3;
            }
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
