package view.loginframes;

import controller.authentication.user.PharmacistAuthenticator;
import system.exceptions.EmptyFieldException;
import system.exceptions.NoSuchUsernameException;
import system.exceptions.WrongPasswordException;
import system.general.DateAndTime;
import view.general.HomePage;
import view.pharmacistspecific.PharmacistHome;

import javax.swing.*;
import java.awt.*;

public class PharmacistLoginWindow extends javax.swing.JFrame {

    public PharmacistLoginWindow() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        dateLabel.setText(DateAndTime.currentDay + " / " + DateAndTime.currentMonth + " / " + DateAndTime.currentYear);
        errorLabel.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        headerPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        timeLabel1 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(220, 220, 220));
        headerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/logo/default2.png"))); // NOI18N

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dateLabel.setText("dd / mm / yyyy");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addComponent(logoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(logoLabel)
                                        .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(dateLabel)))
                                .addContainerGap())
        );

        usernameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameTextFieldFocusGained(evt);
            }
        });

        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        usernameLabel.setText("ID");

        passwordLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        passwordLabel.setText("Password");

        loginButton.setText("Log in");
        loginButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        timeLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        timeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel1.setText("Pharmacist Login");

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        errorLabel.setText("*error message*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addGap(117, 117, 117))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(timeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(usernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                        .addComponent(passwordField)
                                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(usernameLabel)
                                                        .addComponent(passwordLabel))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(88, 88, 88))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(timeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addGap(0, 57, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(passwordLabel)
                                .addGap(18, 18, 18)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorLabel)
                                .addGap(14, 14, 14)
                                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        this.setCursor(Cursor.WAIT_CURSOR);

        PharmacistAuthenticator.inputID = usernameTextField.getText().trim();
        PharmacistAuthenticator.inputPassword = passwordField.getText();

        try {
            PharmacistAuthenticator adminAuthenticator = new PharmacistAuthenticator();

            if (adminAuthenticator.authenticateUser()) {

                this.dispose();
                new PharmacistHome().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "An error has occurred", "Error", JOptionPane.ERROR_MESSAGE);
                usernameTextField.setText("");
                passwordField.setText("");

            }

        } catch (NoSuchUsernameException e) {
            errorLabel.setText("User does not exist");
        } catch (WrongPasswordException e) {
            errorLabel.setText("Incorrect Password");
        } catch (EmptyFieldException | NullPointerException e) {
            errorLabel.setText("Please fill all fields");
        } finally {
            this.setCursor(Cursor.DEFAULT_CURSOR);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void usernameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFieldFocusGained
        errorLabel.setText("");
        this.getRootPane().setDefaultButton(loginButton);
    }//GEN-LAST:event_usernameTextFieldFocusGained

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        errorLabel.setText("");
        this.getRootPane().setDefaultButton(loginButton);
    }//GEN-LAST:event_passwordFieldFocusGained

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PharmacistLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmacistLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmacistLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmacistLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmacistLoginWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel timeLabel1;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
