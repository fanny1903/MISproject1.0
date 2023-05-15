/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ulb.mis.view;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ulb.mis.controller.DoctorJpaController;
import ulb.mis.controller.PersonJpaController;
import ulb.mis.model.Doctor;

/**
 *
 * @author fanny
 */
public class CreateDoctorAccount extends javax.swing.JFrame {
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("infoh400_PU");
    private final DoctorJpaController doctorCtrl = new DoctorJpaController(emfac);
    private final PersonJpaController personCtrl = new PersonJpaController(emfac);
    
    private Doctor doctor = null;
    /**
     * Creates new form AddDoctorWindow
     */
    public CreateDoctorAccount() {
        initComponents();
    }
    
    public void setPatient(Doctor doctor){
        this.doctor = doctor;
        
        addPersonPanel1.setPerson(doctor.getIdperson());
        inamiTextField.setText(doctor.getInami());

    }
    
    public Doctor getDoctor(){
        updateDoctor();
                
        return doctor;
    }
    
    public void updateDoctor(){
        if( doctor == null ){
            doctor = new Doctor();
        }
        
        doctor.setIdperson(addPersonPanel1.getPerson());
        doctor.setInami(inamiTextField.getText());
<<<<<<< HEAD
=======
        //doctor.setSpeciality(specialityTextField.getText());
>>>>>>> 63419745ad41201affe9d1a14c974268509e912f
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inamiTextField = new javax.swing.JTextField();
        saveDoctorButton = new javax.swing.JButton();
        cancelDoctorButton = new javax.swing.JButton();
        addPersonPanel1 = new ulb.mis.view.AddPersonPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AddDoctor");

        jLabel2.setText("INAMI");

        inamiTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inamiTextFieldActionPerformed(evt);
            }
        });

        saveDoctorButton.setBackground(new java.awt.Color(255, 204, 102));
        saveDoctorButton.setText("Save");
        saveDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDoctorButtonActionPerformed(evt);
            }
        });

        cancelDoctorButton.setBackground(new java.awt.Color(255, 204, 102));
        cancelDoctorButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inamiTextField)
                        .addGap(98, 98, 98))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(saveDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addPersonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 98, Short.MAX_VALUE))
=======
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(saveDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cancelDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inamiTextField)))
                            .addComponent(addPersonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
>>>>>>> 63419745ad41201affe9d1a14c974268509e912f
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addPersonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inamiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
<<<<<<< HEAD
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
=======
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
>>>>>>> 63419745ad41201affe9d1a14c974268509e912f
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inamiTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inamiTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inamiTextFieldActionPerformed

    private void saveDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDoctorButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveDoctorButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ulb.mis.view.AddPersonPanel addPersonPanel1;
    private javax.swing.JButton cancelDoctorButton;
    private javax.swing.JTextField inamiTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
<<<<<<< HEAD
=======
    private javax.swing.JScrollPane jScrollPane1;
>>>>>>> 63419745ad41201affe9d1a14c974268509e912f
    private javax.swing.JButton saveDoctorButton;
    // End of variables declaration//GEN-END:variables

    void setDoctor(Doctor selected) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
