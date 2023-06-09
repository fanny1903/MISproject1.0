/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.view;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ulb.mis.controller.PatientJpaController;
import ulb.mis.controller.PersonJpaController;
import ulb.mis.model.Patient;
import ulb.mis.model.Person;

/**
 *
 * @author indra
 */
public class LoginPatient extends javax.swing.JFrame {
    
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("MISproject_PU");
    private final PatientJpaController patientCtrl = new PatientJpaController(emfac);
    private final PersonJpaController personCtrl = new PersonJpaController(emfac);
    Patient patient = null;
    Person person = null;
    List<Patient> patientList = patientCtrl.findPatientEntities();
    List<Person> personList = personCtrl.findPersonEntities();

    /**
     * Creates new form LoginnPatient
     */
   public LoginPatient() {
        initComponents();

        this.setLocationRelativeTo(null);
        firstnameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (firstnameTextField.getText().equals("Name")) {
                    firstnameTextField.setText("");
                }
            }
        });

        firstnameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (firstnameTextField.getText().isEmpty()) {
                    firstnameTextField.setText("Name");
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        firstnameTextField = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        OkButtondoctor = new javax.swing.JButton();
        CanceldoctorButton = new javax.swing.JButton();
        jLabelcreatedoctoraccount = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setAutoscrolls(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        jLabel2.setText("First name");

        jLabel3.setText("Password");

        firstnameTextField.setText("Name");
        firstnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameTextFieldActionPerformed(evt);
            }
        });

        OkButtondoctor.setBackground(new java.awt.Color(255, 204, 102));
        OkButtondoctor.setText("Login");
        OkButtondoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtondoctorActionPerformed(evt);
            }
        });

        CanceldoctorButton.setBackground(new java.awt.Color(255, 204, 102));
        CanceldoctorButton.setText("Cancel");
        CanceldoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanceldoctorButtonActionPerformed(evt);
            }
        });

        jLabelcreatedoctoraccount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelcreatedoctoraccount.setForeground(new java.awt.Color(0, 153, 153));
        jLabelcreatedoctoraccount.setText("create a new account");
        jLabelcreatedoctoraccount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelcreatedoctoraccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelcreatedoctoraccountMouseClicked(evt);
            }
        });

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstnameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(PasswordField)))
                    .addComponent(jLabelcreatedoctoraccount, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(CanceldoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(OkButtondoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 67, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CanceldoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OkButtondoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelcreatedoctoraccount)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkButtondoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtondoctorActionPerformed
        validateLogin();
        if (patient != null) {
            // Les informations d'identification sont valides, vous pouvez ouvrir la page d'accueil ou effectuer d'autres actions nécessaires
            PatientChoices patientChoicesAddPopup = new PatientChoices(patient);
            patientChoicesAddPopup.setVisible(true);
            patientChoicesAddPopup.pack();
            patientChoicesAddPopup.setLocationRelativeTo(null);
        } else {
            // Les informations d'identification sont incorrectes, affichez un message d'erreur ou effectuez une action appropriée
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_OkButtondoctorActionPerformed

    private void CanceldoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanceldoctorButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CanceldoctorButtonActionPerformed

    private void jLabelcreatedoctoraccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelcreatedoctoraccountMouseClicked
        CreatePatientAccount patientAddPopup = new CreatePatientAccount();
        patientAddPopup.setVisible(true);
        patientAddPopup.pack();
        patientAddPopup.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabelcreatedoctoraccountMouseClicked

    private void firstnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameTextFieldActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CanceldoctorButton;
    private javax.swing.JButton OkButtondoctor;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField firstnameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelcreatedoctoraccount;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void validateLogin(){
        for (int i =0; i < personList.size(); i++){
            if (firstnameTextField.getText().equals(personList.get(i).getFirstname()) && PasswordField.getText().equals(personList.get(i).getPersonpassword()) ){
                person = personList.get(i);
                for(int x=0; x<patientList.size(); x++){
                    if(patientList.get(x).getIdperson().equals(person)){
                        patient = patientList.get(x);
                    }
                }
                break;    
            }
        }
    }
}
