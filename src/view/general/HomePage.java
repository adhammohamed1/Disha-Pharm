package view.general;

import model.personnel.Admin;
import view.loginframes.AdminLoginWindow;
import view.loginframes.PharmacistLoginWindow;

import java.awt.*;

public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        Admin.adminActive = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pharmacistButton = new javax.swing.JButton();
        adminButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("\\graphics_and_icon\\logo\\logo.png"));

        jPanel1.setBackground(new java.awt.Color(230, 230, 230));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/logo/cover.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pharmacistButton.setBackground(new java.awt.Color(0, 153, 153));
        pharmacistButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        pharmacistButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/icon/login/pharmacist-icon-1.png"))); // NOI18N
        pharmacistButton.setText("Login as pharmacist");
        pharmacistButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));
        pharmacistButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pharmacistButton.setFocusPainted(false);
        pharmacistButton.setFocusable(false);
        pharmacistButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pharmacistButton.setMaximumSize(new java.awt.Dimension(230, 230));
        pharmacistButton.setMinimumSize(new java.awt.Dimension(220, 220));
        pharmacistButton.setPreferredSize(new java.awt.Dimension(230, 230));
        pharmacistButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pharmacistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pharmacistButtonActionPerformed(evt);
            }
        });

        adminButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        adminButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/icon/login/admin-icon-3.png"))); // NOI18N
        adminButton.setText("Login as admin");
        adminButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));
        adminButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminButton.setFocusPainted(false);
        adminButton.setFocusable(false);
        adminButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        adminButton.setMaximumSize(new java.awt.Dimension(230, 230));
        adminButton.setMinimumSize(new java.awt.Dimension(220, 220));
        adminButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adminButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pharmacistButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pharmacistButton, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        this.dispose();
        new AdminLoginWindow().setVisible(true);
    }//GEN-LAST:event_adminButtonActionPerformed

    private void pharmacistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pharmacistButtonActionPerformed
        this.dispose();
        new PharmacistLoginWindow().setVisible(true);
    }//GEN-LAST:event_pharmacistButtonActionPerformed

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pharmacistButton;
    // End of variables declaration//GEN-END:variables
}
