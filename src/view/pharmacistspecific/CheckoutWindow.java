/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pharmacistspecific;

import controller.financial.FinancialFactors;
import controller.financial.ShoppingCart;
import controller.management.items.ProductHandler;
import model.items.Product;
import model.personnel.Pharmacist;
import system.general.Constants;
import system.general.DataEntryChecker;
import system.general.DateAndTime;
import view.optionpanes.CustomOptionPane;

import java.awt.*;

/**
 * @author Adham Mohamed Aly
 */
public class CheckoutWindow extends javax.swing.JFrame {

    public static double amountPaid = 0, change = 0;

    /**
     * Creates new form CheckoutWindow
     */
    public CheckoutWindow() {
        ProductHandler.checkMedsForPrescriptionRequirement();

        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        displayFinalShoppingCart();
        deliveryLabel.setText("0.00");
        ShoppingCart.updateTotalSum();
        totalSumLabel.setText(String.format("Total amount to be  paid: "
                + FinancialFactors.PREFERRED_CURRENCY + "%.2f", ShoppingCart.totalSum));

        dateLabel.setText(DateAndTime.currentDay + " / " + DateAndTime.currentMonth + " / " + DateAndTime.currentYear);
    }

    private void displayFinalShoppingCart() {
        String[] contents = ShoppingCart.getShoppingCartContentsAsStrings();
        for (int i = 0; i < contents.length - 1; i++) {
            finalShoppingCart.append(contents[i] + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        finalShoppingCart = new javax.swing.JTextArea();
        tax = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deliveryLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        totalSumLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        subTotal = new javax.swing.JLabel();
        modeComboBox = new javax.swing.JComboBox<>();
        checkBox = new javax.swing.JCheckBox();
        enableButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        amountPaidField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        changeField = new javax.swing.JTextField();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Checkout");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        headerPanel.setBackground(new java.awt.Color(220, 220, 220));
        headerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/logo/default2.png"))); // NOI18N
        logoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dateLabel.setText("dd / mm / yyyy");

        cancelButton.setText("Cancel");
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(cancelButton)))
                                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(13, 13, 13)
                                                .addComponent(cancelButton)))
                                .addContainerGap())
        );

        finalShoppingCart.setEditable(false);
        finalShoppingCart.setBackground(new java.awt.Color(245, 245, 245));
        finalShoppingCart.setColumns(20);
        finalShoppingCart.setRows(5);
        finalShoppingCart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        finalShoppingCart.setFocusable(false);
        jScrollPane1.setViewportView(finalShoppingCart);

        tax.setText(String.valueOf(String.format("%.2f", (ShoppingCart.subTotal * FinancialFactors.TAX_FACTOR))));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Delivery Fees: " + FinancialFactors.PREFERRED_CURRENCY);

        deliveryLabel.setText("0.00");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Tax(" + String.format("%.2f", FinancialFactors.TAX_FACTOR * 100) + "%) :" + FinancialFactors.PREFERRED_CURRENCY);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHECKOUT");

        totalSumLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        totalSumLabel.setText(String.format("Total amount to be  paid: " + FinancialFactors.PREFERRED_CURRENCY + "%.2f", ShoppingCart.totalSum));
        totalSumLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Subtotal: " + FinancialFactors.PREFERRED_CURRENCY);

        subTotal.setText(String.format("%.2f", ShoppingCart.subTotal));

        modeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"On-Site", "Delivered"}));
        modeComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modeComboBox.setFocusable(false);
        modeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeComboBoxActionPerformed(evt);
            }
        });

        checkBox.setSelected(!ProductHandler.purchaseNeedsPrescription());
        checkBox.setText("Checked prescription");
        checkBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkBox.setEnabled(false);

        enableButton.setText("Enable");
        enableButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enableButton.setEnabled(ProductHandler.purchaseNeedsPrescription());
        enableButton.setFocusable(false);
        enableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setText("Amount Paid:");

        amountPaidField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                amountPaidFieldCaretUpdate(evt);
            }
        });
        amountPaidField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountPaidFieldKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Change:");

        changeField.setEditable(false);
        changeField.setFocusable(false);

        doneButton.setBackground(new java.awt.Color(51, 153, 0));
        doneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/icon/tools/tick-icon.png"))); // NOI18N
        doneButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doneButton.setFocusable(false);
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(checkBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(modeComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enableButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(amountPaidField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tax, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(deliveryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(totalSumLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tax)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deliveryLabel)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(subTotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalSumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(modeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel10)
                                                        .addComponent(amountPaidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(checkBox)
                                                        .addComponent(jLabel11)
                                                        .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(enableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(doneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        ShoppingCart.emptyTheCart();
        new PharmacistHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void modeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeComboBoxActionPerformed
        if (modeComboBox.getSelectedIndex() == Constants.DELIVERED) {
            deliveryLabel.setText(String.valueOf(FinancialFactors.DELIVERY_FEE));
            ShoppingCart.deliveryFees = FinancialFactors.DELIVERY_FEE;
        } else if (modeComboBox.getSelectedIndex() == Constants.ON_SITE) {
            ShoppingCart.deliveryFees = 0.0;
            deliveryLabel.setText("0.00");
        }
        ShoppingCart.updateTotalSum();
        updateChangeField();
        totalSumLabel.setText(String.format("Total amount to be  paid: " + FinancialFactors.PREFERRED_CURRENCY + "%.2f", ShoppingCart.totalSum));
    }//GEN-LAST:event_modeComboBoxActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        if (!checkBox.isSelected()) {
            String medsThatNeedPrescription = "";
            for (Product product : ShoppingCart.scheduledMedsInCart) {
                medsThatNeedPrescription += "- " + product.getBrandName() + " (scheduled)\n";
            }
            for (Product product : ShoppingCart.prescriptionMedsInCart) {
                medsThatNeedPrescription += "- " + product.getBrandName() + " (prescribed)\n";
            }
            CustomOptionPane.showMessageDialog(
                    "Prescription needed for:\n" + medsThatNeedPrescription, "Check prescription!");
            return;
        }
        if (amountPaidField.getText().isEmpty()) {
            CustomOptionPane.showMessageDialog("Please enter amount paid", "No payment received");
            return;
        }
        try {
            if ((amountPaid = Double.parseDouble(amountPaidField.getText())) < ShoppingCart.totalSum) {
                CustomOptionPane.showMessageDialog(
                        FinancialFactors.PREFERRED_CURRENCY
                                + String.format("%.2f", ShoppingCart.totalSum - amountPaid) + " left to complete purchase",
                        "Not enough paid");
                return;
            }
        } catch (NumberFormatException e) {
            CustomOptionPane.showMessageDialog("Invalid entry", "Input error");
            return;
        }
        CustomOptionPane.showPurchaseLoadingDialog();
        this.dispose();
    }//GEN-LAST:event_doneButtonActionPerformed

    private void enableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableButtonActionPerformed
        try {
            String password = CustomOptionPane.showPasswordDialog();

            if (password.trim().equals(Pharmacist.activePharmacist.getPassword())) {
                checkBox.setEnabled(true);
                enableButton.setEnabled(false);
            } else {
                CustomOptionPane.showMessageDialog("Wrong password", "Access denied");
            }
        } catch (NullPointerException ignored) {
        }
    }//GEN-LAST:event_enableButtonActionPerformed

    private void amountPaidFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_amountPaidFieldCaretUpdate
        try {
            amountPaid = Double.parseDouble(amountPaidField.getText());
            updateChangeField();
        } catch (NumberFormatException e) {
            changeField.setText("");
        }
    }//GEN-LAST:event_amountPaidFieldCaretUpdate

    private void updateChangeField() {
        change = amountPaid - ShoppingCart.totalSum;
        String format = String.format("%.2f", change);
        if (change > 0) {
            changeField.setText(format);
        } else {
            changeField.setText("");
        }
    }

    private void amountPaidFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountPaidFieldKeyReleased
        amountPaidField.setText(DataEntryChecker.fixDoubleInput(amountPaidField.getText()));
    }//GEN-LAST:event_amountPaidFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckoutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckoutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckoutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckoutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckoutWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountPaidField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField changeField;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel deliveryLabel;
    private javax.swing.JButton doneButton;
    private javax.swing.JButton enableButton;
    private javax.swing.JTextArea finalShoppingCart;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JComboBox<String> modeComboBox;
    private javax.swing.JLabel subTotal;
    private javax.swing.JLabel tax;
    private javax.swing.JLabel totalSumLabel;
    // End of variables declaration//GEN-END:variables
}
