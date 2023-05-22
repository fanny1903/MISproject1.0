/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ulb.mis.view;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ulb.mis.controller.DoctorJpaController;
import ulb.mis.controller.PatientJpaController;
import ulb.mis.controller.exceptions.IllegalOrphanException;
import ulb.mis.controller.exceptions.NonexistentEntityException;
import ulb.mis.model.Doctor;
import ulb.mis.model.Patient;
//import ulb.mis.view.PatientChoices


/**
 *
 * @author fanny
 */
public class DoctorChoices extends javax.swing.JFrame {
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("MISproject_PU");
    private final DoctorJpaController doctorCtrl = new DoctorJpaController(emfac);
    private final PatientJpaController patientCtrl = new PatientJpaController(emfac);
    
    private static final Logger LOGGER = LogManager.getLogger(DoctorChoices.class.getName());
    
    Doctor doctor = null;
    //Patient patient = null;
    /**
     * Creates new form DoctorChoices
     */
    public DoctorChoices() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        deleteDoctorAccountButton = new javax.swing.JButton();
        doctorActivePatients = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsList = new javax.swing.JList<>();
        AddSicknessButton = new javax.swing.JButton();

        jButton1.setText("Approvals");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApprovalsActionPerformed(evt);
            }
        });

        titleLabel.setBackground(new java.awt.Color(255, 204, 102));
        titleLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(102, 102, 102));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Doctor interface");
        titleLabel.setToolTipText("");
        titleLabel.setOpaque(true);

        deleteDoctorAccountButton.setBackground(new java.awt.Color(255, 153, 153));
        deleteDoctorAccountButton.setText("Delete my account");
        deleteDoctorAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDoctorAccountButtonActionPerformed(evt);
            }
        });

        doctorActivePatients.setText("My active patients");
        doctorActivePatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorActivePatientsActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(itemsList);

        AddSicknessButton.setText("add sickness");
        AddSicknessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSicknessButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(58, 58, 58)
                        .addComponent(AddSicknessButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(doctorActivePatients, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteDoctorAccountButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorActivePatients, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddSicknessButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteDoctorAccountButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ApprovalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApprovalsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApprovalsActionPerformed

    private void refreshDoctorList(){
        List doctors = doctorCtrl.findDoctorEntities();
        EntityListModel<Patient> model = new EntityListModel(doctors);
    }
    
    private void deleteDoctorAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDoctorAccountButtonActionPerformed
        this.doctor = doctor;
        int selectedDoctorId = doctor.getIddoctor();
        
         try {
            LOGGER.debug("Deleting patient with id: " + selectedDoctorId);
            doctorCtrl.destroy(selectedDoctorId);
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            LOGGER.error("Failed to delete patient", ex);
        }
        
        refreshDoctorList();
        
    }//GEN-LAST:event_deleteDoctorAccountButtonActionPerformed

    private void doctorActivePatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActivePatientsActionPerformed
        
        List<Patient> Patients = patientCtrl.findPatientEntities();
        List<Patient> activePatients = null ; 
        
        //List patients = patientCtrl.findPatientEntities();
        EntityListModel<Patient> model = new EntityListModel(activePatients);
        
        for(int i =0; i < Patients.size(); i++){
            if((Patients.get(i).getIdsickness()) != null) {
                activePatients.add(Patients.get(i));  
                itemsList.setModel(model);
            } 
            
        }
    }//GEN-LAST:event_doctorActivePatientsActionPerformed

    private void AddSicknessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSicknessButtonActionPerformed
        addSickness addSicknessPopup = new addSickness();
        addSicknessPopup.setVisible(true);
    }//GEN-LAST:event_AddSicknessButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSicknessButton;
    private javax.swing.JButton deleteDoctorAccountButton;
    private javax.swing.JButton doctorActivePatients;
    private javax.swing.JList<String> itemsList;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
