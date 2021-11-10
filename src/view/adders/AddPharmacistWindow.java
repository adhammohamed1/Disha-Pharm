package view.adders;

import controller.filehandling.PharmacistFileHandler;
import controller.financial.FinancialFactors;
import controller.management.personnel.PharmacistHandler;
import model.personnel.Pharmacist;
import system.exceptions.EmptyFieldException;
import system.exceptions.IllegalNegativeNumberException;
import system.general.DateAndTime;
import view.components.Table;
import view.optionpanes.CustomOptionPane;

import javax.swing.*;
import java.awt.*;

public class AddPharmacistWindow extends javax.swing.JFrame {

    JTable pharmacistTable = null;

    public AddPharmacistWindow() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 3 - getWidth() / 3, size.height / 3 - getHeight() / 3);

        this.getRootPane().setDefaultButton(addButton);

        dateLabel.setText(DateAndTime.currentDay + " / " + DateAndTime.currentMonth + " / " + DateAndTime.currentYear);
    }

    public AddPharmacistWindow(JTable pharmacistTable) {
        initComponents();
        this.pharmacistTable = pharmacistTable;
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 3 - getWidth() / 3, size.height / 3 - getHeight() / 3);

        this.getRootPane().setDefaultButton(addButton);

        dateLabel.setText(DateAndTime.currentDay + " / " + DateAndTime.currentMonth + " / " + DateAndTime.currentYear);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        headerLabel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        passwordLabel2 = new javax.swing.JLabel();
        dayComboBox = new javax.swing.JComboBox<>();
        monthComboBox = new javax.swing.JComboBox<>();
        yearComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        salaryField = new javax.swing.JTextField();
        inventoryAccessCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Pharmacist");
        setMaximumSize(new java.awt.Dimension(566, 404));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        headerLabel.setBackground(new java.awt.Color(220, 220, 220));
        headerLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/logo/default2.png"))); // NOI18N

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dateLabel.setText("dd / mm / yyyy");

        javax.swing.GroupLayout headerLabelLayout = new javax.swing.GroupLayout(headerLabel);
        headerLabel.setLayout(headerLabelLayout);
        headerLabelLayout.setHorizontalGroup(
                headerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLabelLayout.createSequentialGroup()
                                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addContainerGap())
        );
        headerLabelLayout.setVerticalGroup(
                headerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLabelLayout.createSequentialGroup()
                                .addGroup(headerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(headerLabelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(30, 30, 30)))
                                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(224, 224, 224));

        nameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameFieldMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                nameFieldMousePressed(evt);
            }
        });
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordFieldMousePressed(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        usernameLabel.setText("Name");

        passwordLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        passwordLabel.setText("Password");

        addButton.setText("Add Pharmacist");
        addButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        timeLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Add Pharmacist");
        timeLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        passwordLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        passwordLabel1.setText("Birth Date");

        passwordLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        passwordLabel2.setText("Salary");

        dayComboBox.setMaximumRowCount(31);
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));

        monthComboBox.setMaximumRowCount(12);
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));

        yearComboBox.setMaximumRowCount(121);
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
        yearComboBox.setSelectedIndex(90);

        jLabel1.setText(String.valueOf(FinancialFactors.PREFERRED_CURRENCY));

        jLabel2.setText("/ month");

        errorLabel.setForeground(new java.awt.Color(255, 0, 51));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        salaryField.setText("0.00");
        salaryField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                salaryFieldFocusGained(evt);
            }
        });

        inventoryAccessCheckBox.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        inventoryAccessCheckBox.setText("Has inventory access");
        inventoryAccessCheckBox.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(inventoryAccessCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(99, 99, 99))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(passwordLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(passwordLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                                                        .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel2))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                                                        .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING)))
                                                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(usernameLabel)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addComponent(inventoryAccessCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorLabel)
                                .addGap(18, 18, 18)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed

    }//GEN-LAST:event_nameFieldActionPerformed

    private void nameFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameFieldMousePressed

    }//GEN-LAST:event_nameFieldMousePressed

    private void nameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldMouseClicked

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed

    }//GEN-LAST:event_passwordFieldActionPerformed

    private void passwordFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMousePressed

    }//GEN-LAST:event_passwordFieldMousePressed

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.setCursor(Cursor.WAIT_CURSOR);
        try {
            PharmacistHandler.inputName = nameField.getText();
            PharmacistHandler.inputPassword = passwordField.getText();
            PharmacistHandler.inputSalary = Double.parseDouble(salaryField.getText());
            PharmacistHandler.inputBirthDay = dayComboBox.getSelectedIndex() + 1;
            PharmacistHandler.inputBirthMonth = monthComboBox.getSelectedIndex() + 1;
            PharmacistHandler.inputBirthYear = yearComboBox.getSelectedIndex() + 1900;
            PharmacistHandler.inputInventoryAccess = inventoryAccessCheckBox.isSelected();

            int newID = new PharmacistHandler().addToSystem();
            new PharmacistFileHandler().saveToFile();

            CustomOptionPane.showMessageDialog("Pharmacist added successfully !"
                    + "\n\n" + "Pharmacist ID: " + newID
                    + "\n");
            this.dispose();
            if (pharmacistTable != null) Table.loadPharmacistTable(pharmacistTable, Pharmacist.pharmacists);
        } catch (EmptyFieldException | NullPointerException e) {
            errorLabel.setText("Please fill all fields");
        } catch (IllegalNegativeNumberException | NumberFormatException e) {
            errorLabel.setText("Ineligible salary value");
        } finally {
            this.setCursor(Cursor.DEFAULT_CURSOR);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void salaryFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salaryFieldFocusGained
        if (salaryField.getText().equals("0.00")) {
            salaryField.setText("");
        }
    }//GEN-LAST:event_salaryFieldFocusGained

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddPharmacistWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPharmacistWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPharmacistWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPharmacistWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPharmacistWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JPanel headerLabel;
    private javax.swing.JCheckBox inventoryAccessCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JTextField salaryField;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}
