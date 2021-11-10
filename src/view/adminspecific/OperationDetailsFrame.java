/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.adminspecific;

import controller.financial.FinancialFactors;
import controller.management.personnel.PersonnelHandler;
import model.items.Product;
import model.operations.ClientPurchase;
import model.operations.Operation;
import model.personnel.Pharmacist;
import view.components.ProductsRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * A frame that contains all relevant details of a specific operation
 *
 * @author Adham Mohamed Aly
 */
public class OperationDetailsFrame extends javax.swing.JFrame {

    public static Operation displayedOp;

    /**
     * Creates new form OperationDetailsFrame
     */
    public OperationDetailsFrame() {
        initComponents();

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 3 - getWidth() / 3, size.height / 3 - getHeight() / 3);

        setupData();
        try {
            invoice.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/graphics_and_icons/invoices/#" + String.valueOf(displayedOp.getOperationID()) + ".png"))));
        } catch (NullPointerException e) {
            invoice.setText("< Invoice unavailable >");
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

        header = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        operationNumber = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        operationType = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        operationTime = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        operationBalance = new javax.swing.JLabel();
        operationSubtotal = new javax.swing.JLabel();
        operationTaxes = new javax.swing.JLabel();
        deliveryFeesCollected = new javax.swing.JLabel();
        deliveryFeesCollected1 = new javax.swing.JLabel();
        invoice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Operation Details");
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/logo/cover.png"))); // NOI18N
        logo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        label.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label.setText("OPERATION #");

        operationNumber.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        operationNumber.setText(String.valueOf(displayedOp.getOperationID()));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Operation type:");

        operationType.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        operationType.setText("<opType>");

        label2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label2.setText("Responsible personnel:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText(displayedOp.getPharmacist().getName() + " #" + displayedOp.getPharmacist().getId());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Operation time:");

        operationTime.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        operationTime.setText(String.valueOf(displayedOp.getOperationDate().getTime()));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(headerLayout.createSequentialGroup()
                                                .addComponent(label)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(operationNumber))
                                        .addGroup(headerLayout.createSequentialGroup()
                                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(headerLayout.createSequentialGroup()
                                                                .addComponent(operationType)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel2)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(operationTime)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                                .addContainerGap(254, Short.MAX_VALUE)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250))
        );
        headerLayout.setVerticalGroup(
                headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(operationNumber))
                                .addGap(18, 18, 18)
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(operationType)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(operationTime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(jLabel3)))
        );

        label3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label3.setText("Operation Balance :");

        label4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label4.setText("Subtotal Income :");

        label5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label5.setText("Tax Income :");

        label6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label6.setText("Delivery Fees :");

        label7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        label7.setText("Total expenses :");

        operationBalance.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        operationBalance.setText(FinancialFactors.PREFERRED_CURRENCY + String.format("%.2f", displayedOp.getOperationBalance()));

        operationSubtotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        operationSubtotal.setText(FinancialFactors.PREFERRED_CURRENCY + "0.00");

        operationTaxes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        operationTaxes.setText(FinancialFactors.PREFERRED_CURRENCY + "0.00");

        deliveryFeesCollected.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        deliveryFeesCollected.setText(FinancialFactors.PREFERRED_CURRENCY + "0.00");

        deliveryFeesCollected1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        deliveryFeesCollected1.setText(FinancialFactors.PREFERRED_CURRENCY + "0.00");

        invoice.setBackground(new java.awt.Color(70, 70, 70));
        invoice.setForeground(new java.awt.Color(255, 255, 255));
        invoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invoice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        invoice.setOpaque(true);

        itemList.setBackground(new java.awt.Color(204, 204, 204));
        itemList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        itemList.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        itemList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemList.setCellRenderer(new ProductsRenderer());
        itemList.setFocusable(false);
        jScrollPane2.setViewportView(itemList);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Items included in the deal:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(7, 7, 7)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(operationBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(operationSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(operationTaxes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(deliveryFeesCollected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(deliveryFeesCollected1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(invoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(invoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label3)
                                                        .addComponent(operationBalance))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label4)
                                                        .addComponent(operationSubtotal))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label5)
                                                        .addComponent(operationTaxes))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label6)
                                                        .addComponent(deliveryFeesCollected))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label7)
                                                        .addComponent(deliveryFeesCollected1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupData() {
        DefaultListModel<Product> listModel = new DefaultListModel<>();
        if (displayedOp instanceof ClientPurchase) {
            operationType.setText("Client Purchase");
            ClientPurchase cp = (ClientPurchase) displayedOp;

            operationSubtotal.setText(FinancialFactors.PREFERRED_CURRENCY + String.format("%.2f", cp.getSubTotal()));
            deliveryFeesCollected.setText(FinancialFactors.PREFERRED_CURRENCY + String.format("%.2f", cp.getDelivery()));
            operationTaxes.setText(FinancialFactors.PREFERRED_CURRENCY + String.format("%.2f", cp.getTax()));

            if (displayedOp.getPharmacist().getId() == Pharmacist.INVALID_PHARMACIST_ID) {
                jLabel3.setText(displayedOp.getPharmacist().getName() + " #[ID USED AT THE TIME IS NO LONGER AVAILABLE]");
            } else if (displayedOp.getPharmacist().getId() == PersonnelHandler.PHARMACIST_BASE_ID) {
                jLabel3.setText(displayedOp.getPharmacist().getName() + " #[System Admin]");
            }
            for (Product p : cp.getSoldProducts()) {
                listModel.addElement(p);
            }
            itemList.setModel(listModel);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(OperationDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperationDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperationDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperationDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperationDetailsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deliveryFeesCollected;
    private javax.swing.JLabel deliveryFeesCollected1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel invoice;
    private javax.swing.JList<Product> itemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel operationBalance;
    private javax.swing.JLabel operationNumber;
    private javax.swing.JLabel operationSubtotal;
    private javax.swing.JLabel operationTaxes;
    private javax.swing.JLabel operationTime;
    private javax.swing.JLabel operationType;
    // End of variables declaration//GEN-END:variables
}
