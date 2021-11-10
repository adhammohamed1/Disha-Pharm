package view.pharmacistspecific;

import controller.financial.FinancialFactors;
import controller.financial.ShoppingCart;
import controller.searching.Searcher;
import model.items.Product;
import model.personnel.Pharmacist;
import system.exceptions.IllegalNegativeNumberException;
import view.adminspecific.AdminHome;
import view.components.ShoppingCartRenderer;
import view.components.Table;
import view.general.HomePage;
import view.general.ViewInventory;
import view.optionpanes.CustomOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static model.personnel.Pharmacist.activePharmacist;

public class PharmacistHome extends javax.swing.JFrame {

    static Thread searcher;

    public PharmacistHome() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        Table.loadSearchTable(searchTable, Product.productInventory);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        mainTabbedPane = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        checkoutButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchBar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        addToCartButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        removeFromCartButton = new javax.swing.JButton();
        searchProgress = new javax.swing.JProgressBar();
        label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Label = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        shoppingCart = new javax.swing.JList<>();
        subTotalLabel = new javax.swing.JLabel();
        customersPanel = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        inventoryTab = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(220, 220, 220));
        headerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/logo/default2.png"))); // NOI18N
        logoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoLabelMouseClicked(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(51, 51, 51));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/icon/menuIcons/user-icon-4.png"))); // NOI18N
        nameLabel.setText(Pharmacist.activePharmacist.getName());
        nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        logOutButton.setText("Logout");
        logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutButton.setFocusable(false);
        logOutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
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
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logOutButton)))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logOutButton)))
                .addContainerGap())
        );

        mainTabbedPane.setBackground(new java.awt.Color(187, 207, 227));
        mainTabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainTabbedPane.setFocusable(false);
        mainTabbedPane.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        mainTabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainTabbedPaneMouseClicked(evt);
            }
        });

        checkoutButton.setBackground(new java.awt.Color(117, 142, 129));
        checkoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/icon/tools/proceed-icon-1.png"))); // NOI18N
        checkoutButton.setText("Checkout");
        checkoutButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        checkoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkoutButton.setEnabled(false);
        checkoutButton.setFocusable(false);
        checkoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkoutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(214, 224, 224));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchBar.setForeground(java.awt.Color.gray);
        searchBar.setText("Search in inventory (by item ID, name or active consituent)");
        searchBar.setFocusable(false);
        searchBar.setMargin(new java.awt.Insets(2, 4, 2, 2));
        searchBar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchBarCaretUpdate(evt);
            }
        });
        searchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchBarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchBarFocusLost(evt);
            }
        });
        searchBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchBarMousePressed(evt);
            }
        });

        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Commercial Name", "Price", "Active Constituent ", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(searchTable);

        addToCartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/icon/tools/add-to-cart-icon.png"))); // NOI18N
        addToCartButton.setText("   Add to cart");
        addToCartButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addToCartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToCartButton.setFocusPainted(false);
        addToCartButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addToCartButtonFocusLost(evt);
            }
        });
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        removeFromCartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics_and_icons/icon/menuIcons/Shopping-Return-Purchase-icon.png"))); // NOI18N
        removeFromCartButton.setText("  Remove from cart");
        removeFromCartButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        removeFromCartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeFromCartButton.setEnabled(false);
        removeFromCartButton.setFocusable(false);
        removeFromCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromCartButtonActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label.setText("Found: 0 results");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(removeFromCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(searchBar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addComponent(removeFromCartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addToCartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(214, 224, 224));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Label.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label.setText("Shopping Cart");

        shoppingCart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        shoppingCart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        shoppingCart.setToolTipText("");
        shoppingCart.setCellRenderer(new ShoppingCartRenderer());
        shoppingCart.setMinimumSize(new java.awt.Dimension(258, 206));
        shoppingCart.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                shoppingCartValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(shoppingCart);

        subTotalLabel.setBackground(new java.awt.Color(255, 255, 255));
        subTotalLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        subTotalLabel.setText(" Subtotal : $ 0.00");
        subTotalLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        subTotalLabel.setFocusable(false);
        subTotalLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        subTotalLabel.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Label, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(subTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        subTotalLabel.getAccessibleContext().setAccessibleParent(null);

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addComponent(checkoutButton)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainTabbedPane.addTab("Home", homePanel);

        jLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("This menu is currently under development!");

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                .addContainerGap())
        );
        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Customers", customersPanel);

        inventoryTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryTabMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inventoryTabLayout = new javax.swing.GroupLayout(inventoryTab);
        inventoryTab.setLayout(inventoryTabLayout);
        inventoryTabLayout.setHorizontalGroup(
            inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1133, Short.MAX_VALUE)
        );
        inventoryTabLayout.setVerticalGroup(
            inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        if(activePharmacist.hasInventoryAccess()) {
            mainTabbedPane.addTab("Inventory", inventoryTab);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTabbedPane))
        );

        mainTabbedPane.getAccessibleContext().setAccessibleName("Home\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoLabelMouseClicked(java.awt.event.MouseEvent evt) {
        //
    }

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        int choice = CustomOptionPane.showLogoutDialog();

        if (choice == 1) {
            this.dispose();
            new HomePage().setVisible(true);
        } else if (choice == 2) {
            this.dispose();
            new AdminHome().setVisible(true);
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
        new CheckoutWindow().setVisible(true);
        this.dispose();
        DefaultListModel<Product> listModel = new DefaultListModel<>();
        listModel.clear();
        shoppingCart.setModel(listModel);
    }//GEN-LAST:event_checkoutButtonActionPerformed

    public void updateShoppingCart() {
        DefaultListModel<Product> listModel = new DefaultListModel<>();
        for (Product product : ShoppingCart.shoppingCartItems) {
            listModel.addElement(product);
        }
        shoppingCart.setModel(listModel);
        checkoutButton.setEnabled(!ShoppingCart.shoppingCartItems.isEmpty());
        removeFromCartButton.setEnabled(false);
        Table.loadSearchTable(searchTable, Product.productInventory);
        ShoppingCart.updateSubtotal();
        subTotalLabel.setText(" Subtotal: " + FinancialFactors.PREFERRED_CURRENCY + String.format(" %.2f",ShoppingCart.subTotal));
    }

    private void addToCart(int selectedItem) throws ArrayIndexOutOfBoundsException, NumberFormatException {
        Product productInStore = Product.productInventory.get(selectedItem);
        int inputQuantity;
        switch (productInStore.getQuantityInStock()) {
            case 0:
                CustomOptionPane.showMessageDialog("\"" + productInStore.getBrandName() + "\" is out of stock");
                return;
            case 1:
                inputQuantity = 1;
                break;
            default:
                String input = CustomOptionPane.showInputDialog(
                        "Enter required quantity (" + productInStore.getQuantityInStock()
                                + " left in stock)", "1");
                if (input.equals(CustomOptionPane.CANCELED)) {
                    return;
                }
                inputQuantity = Integer.parseInt(input);
                break;
        }
        if (inputQuantity < 1) {
            throw new IllegalNegativeNumberException();
        } else if (inputQuantity > productInStore.getQuantityInStock()) {
            CustomOptionPane.showMessageDialog("Not enough in stock");
        } else {
            Product productInCart;
            productInStore.setQuantityInStock(productInStore.getQuantityInStock() - inputQuantity);
            if ((productInCart = ShoppingCart.newEntryInCart(productInStore)) == null) {
                productInCart = productInStore.clone();
                productInCart.setQuantityInStock(inputQuantity);
                ShoppingCart.shoppingCartItems.add(productInCart);
            } else {
                productInCart.setQuantityInStock(inputQuantity + productInCart.getQuantityInStock());
            }
            updateShoppingCart();
        }
    }

    private void addToCartButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed
        try {
            errorLabel.setText("");
            addToCart((int) searchTable.getValueAt(searchTable.getSelectedRow(), 0));
        } catch (NumberFormatException | IllegalNegativeNumberException e) {
            CustomOptionPane.showMessageDialog("Invalid entry");
        } catch (ArrayIndexOutOfBoundsException e) {
            errorLabel.setHorizontalAlignment(SwingConstants.TRAILING);
            errorLabel.setText("Please select an item to add to cart");
        }


    }//GEN-LAST:event_addToCartButtonActionPerformed

    private void searchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBarFocusLost
        searchBar.setFocusable(false);
        if (searchBar.getText().trim().isEmpty()) {
            searchBar.setForeground(java.awt.Color.GRAY);
            searchBar.setText("Search in inventory (by item ID, name or active consituent)");
        }
    }//GEN-LAST:event_searchBarFocusLost

    private void searchBarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBarFocusGained
        if (searchBar.getForeground() == Color.GRAY) {
            searchBar.setForeground(java.awt.Color.BLACK);
            searchBar.setText("");
        }
        if (label.getForeground() == Color.red) {
            label.setForeground(Color.black);
            label.setText("Found:   results");
        }
    }//GEN-LAST:event_searchBarFocusGained

    private void addToCartButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addToCartButtonFocusLost
        errorLabel.setText("");
    }//GEN-LAST:event_addToCartButtonFocusLost

    private void removeFromCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromCartButtonActionPerformed
        int input;
        Product selectedItem = shoppingCart.getSelectedValue();
        if (selectedItem.getQuantityInStock() == 1) {
            input = ShoppingCart.REMOVE_ALL;
        } else {
            ShoppingCart.selectedQuantity = selectedItem.getQuantityInStock();
            input = CustomOptionPane.showRemoveFromCartDialog();
        }
        if (input != -1) {
            try {
                ShoppingCart.removeFromCart(selectedItem, input);
                updateShoppingCart();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null, "Invalid entry", "Error", JOptionPane.WARNING_MESSAGE);
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
    }//GEN-LAST:event_removeFromCartButtonActionPerformed

    private void shoppingCartValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_shoppingCartValueChanged
        removeFromCartButton.setEnabled(true);
    }//GEN-LAST:event_shoppingCartValueChanged

    private void searchBarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchBarCaretUpdate
        if (searcher != null && searcher.isAlive()) {
            searcher.stop();
        }
        searcher = new Thread(this::getSearchResults);
        searcher.start();
    }//GEN-LAST:event_searchBarCaretUpdate

    private void searchBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBarMousePressed
        searchBar.setFocusable(true);
        searchBar.grabFocus();
    }//GEN-LAST:event_searchBarMousePressed

    private void inventoryTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTabMouseClicked
        ViewInventory.previousMenu = ViewInventory.PHARMACIST_MENU;
        this.dispose();
        new ViewInventory().setVisible(true);
    }//GEN-LAST:event_inventoryTabMouseClicked

    private void mainTabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTabbedPaneMouseClicked
        if (mainTabbedPane.getSelectedIndex() == 2) {
            inventoryTabMouseClicked(evt);
        }
    }//GEN-LAST:event_mainTabbedPaneMouseClicked

    private synchronized void getSearchResults() {
        int inputID = 0;
        ArrayList<Product> results;

        if (searchBar.getText().trim().isEmpty() || searchBar.getForeground() == Color.GRAY) {
            searchProgress.setValue(0);
            label.setText("Found: 0 results");
            Table.loadSearchTable(searchTable, Product.productInventory);
        } else {
            try {
                inputID = Integer.parseInt(searchBar.getText().trim());
                results = new Searcher().getProductSearchResults(inputID, searchProgress, label);
            } catch (NumberFormatException e) {
                results = new Searcher().getProductSearchResults(searchBar.getText().trim(), searchProgress, label);
            }
            if (results != null) {
                Table.loadSearchTable(searchTable, results);
            }
        }
    }

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PharmacistHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PharmacistHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PharmacistHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PharmacistHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmacistHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel inventoryTab;
    private javax.swing.JLabel jLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton removeFromCartButton;
    private javax.swing.JTextField searchBar;
    private javax.swing.JProgressBar searchProgress;
    private javax.swing.JTable searchTable;
    private javax.swing.JList<Product> shoppingCart;
    private javax.swing.JLabel subTotalLabel;
    // End of variables declaration//GEN-END:variables
}
