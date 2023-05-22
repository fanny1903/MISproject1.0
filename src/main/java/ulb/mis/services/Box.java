/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.services;

/**
 *
 * @author fanny
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Box extends JFrame {

    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

    public Box() {
        setTitle("Exemple de Checkbox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Ajout de JCheckBox à la liste
        JCheckBox checkBox1 = new JCheckBox("Checkbox 1");
        checkBoxes.add(checkBox1);
        
        JCheckBox checkBox2 = new JCheckBox("Checkbox 2");
        checkBoxes.add(checkBox2);
        
        // Configuration du gestionnaire de disposition (layout)
        setLayout(new FlowLayout());
        
        // Ajout des JCheckBox au JFrame
        for (JCheckBox checkBox : checkBoxes) {
            add(checkBox);
        }
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Box();
        });
    }
}
