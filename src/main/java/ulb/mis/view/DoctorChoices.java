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

        titleLabel = new javax.swing.JLabel();
        deleteDoctorAccountButton = new javax.swing.JButton();
        doctorActivePatients = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsList = new javax.swing.JList<>();
        AddSicknessButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientAdditionalRemTextArea = new javax.swing.JTextArea();
        DoctorPathPdfTextField = new javax.swing.JTextField();
        PathOkButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setBackground(new java.awt.Color(255, 204, 102));
        titleLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(102, 102, 102));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Your doctor profile");
        titleLabel.setToolTipText("");
        titleLabel.setOpaque(true);

        deleteDoctorAccountButton.setBackground(new java.awt.Color(255, 153, 153));
        deleteDoctorAccountButton.setText("Delete my account");
        deleteDoctorAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDoctorAccountButtonActionPerformed(evt);
            }
        });

        doctorActivePatients.setBackground(new java.awt.Color(255, 204, 102));
        doctorActivePatients.setText("My active patients");
        doctorActivePatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorActivePatientsActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(itemsList);

        AddSicknessButton.setBackground(new java.awt.Color(255, 204, 102));
        AddSicknessButton.setText("add sickness");
        AddSicknessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSicknessButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Patient's additionnal remarks");

        patientAdditionalRemTextArea.setColumns(20);
        patientAdditionalRemTextArea.setRows(5);
        jScrollPane2.setViewportView(patientAdditionalRemTextArea);

        DoctorPathPdfTextField.setText("Path to your PDF");
        DoctorPathPdfTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoctorPathPdfTextFieldActionPerformed(evt);
            }
        });

        PathOkButton.setBackground(new java.awt.Color(255, 204, 102));
        PathOkButton.setText("OK");
        PathOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PathOkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddSicknessButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doctorActivePatients, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteDoctorAccountButton)
                        .addGap(144, 144, 144)
                        .addComponent(DoctorPathPdfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PathOkButton)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doctorActivePatients, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(AddSicknessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoctorPathPdfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PathOkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteDoctorAccountButton))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshDoctorList(){
        List doctors = doctorCtrl.findDoctorEntities();
        EntityListModel<Doctor> model = new EntityListModel(doctors);
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

    private void refreshPatientList(){
        List patients = patientCtrl.findPatientEntities();
        EntityListModel<Patient> model = new EntityListModel(patients);
        
        itemsList.setModel(model);
    }
    
    private void doctorActivePatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActivePatientsActionPerformed
        refreshPatientList();
        
    }//GEN-LAST:event_doctorActivePatientsActionPerformed

    private void AddSicknessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSicknessButtonActionPerformed
        addSickness addSicknessPopup = new addSickness();
        addSicknessPopup.setVisible(true);
    }//GEN-LAST:event_AddSicknessButtonActionPerformed

    private void PathOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PathOkButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PathOkButtonActionPerformed

    private void DoctorPathPdfTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoctorPathPdfTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoctorPathPdfTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSicknessButton;
    private javax.swing.JTextField DoctorPathPdfTextField;
    private javax.swing.JButton PathOkButton;
    private javax.swing.JButton deleteDoctorAccountButton;
    private javax.swing.JButton doctorActivePatients;
    private javax.swing.JList<String> itemsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea patientAdditionalRemTextArea;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
