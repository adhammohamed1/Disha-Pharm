package view.components;

import controller.financial.FinancialFactors;
import model.items.Product;
import model.personnel.Deliverer;
import model.personnel.Pharmacist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Table {

    public static boolean isSelected(JTable table) {
        return table.getSelectedRow() > -1;
    }

    public static synchronized void clearTable(DefaultTableModel tableModel) {
        int rows = tableModel.getRowCount();
        for (int j = 0; j < rows; j++)
            tableModel.removeRow(0);
    }

    public static synchronized void loadItemTable(JTable table, HashMap<Integer, Product> productInventory) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            String quantity;
            clearTable(tableModel);
            for (int id : productInventory.keySet()) {
                Product product = productInventory.get(id);

                if (product.getQuantityInStock() == 0) quantity = "OUT OF STOCK";
                else quantity = Integer.toString(product.getQuantityInStock());

                Object[] dataRow = {
                        id,
                        product.getBrandName(),
                        product.getActiveConstituent(),
                        FinancialFactors.PREFERRED_CURRENCY + product.getSellingPrice(),
                        quantity,
                        product.getExpiryDate().get(Calendar.DAY_OF_MONTH) + " / " +
                                (product.getExpiryDate().get(Calendar.MONTH) + 1) + " / " +
                                product.getExpiryDate().get(Calendar.YEAR)
                };
                tableModel.addRow(dataRow);
            }
        } catch (Exception ignored) {
        }
    }

    public static synchronized void loadItemTable(JTable table, ArrayList<Product> productInventory) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            String quantity;
            clearTable(tableModel);
            for (Product product : productInventory) {

                if (product.getQuantityInStock() == 0) quantity = "OUT OF STOCK";
                else quantity = Integer.toString(product.getQuantityInStock());

                Object[] dataRow = {
                        product.getItemID(),
                        product.getBrandName(),
                        product.getActiveConstituent(),
                        FinancialFactors.PREFERRED_CURRENCY + product.getSellingPrice(),
                        quantity,
                        product.getExpiryDate().get(Calendar.DAY_OF_MONTH) + " / " +
                                (product.getExpiryDate().get(Calendar.MONTH) + 1) + " / " +
                                product.getExpiryDate().get(Calendar.YEAR)
                };
                tableModel.addRow(dataRow);
            }
        } catch (Exception ignored) {
        }
    }

    public static synchronized void loadSearchTable(JTable table, HashMap<Integer, Product> productInventory) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            String quantity;
            clearTable(tableModel);
            for (int id : productInventory.keySet()) {
                Product product = productInventory.get(id);

                if (product.getQuantityInStock() == 0) quantity = "OUT OF STOCK";
                else quantity = Integer.toString(product.getQuantityInStock());

                Object[] dataRow = {
                        id,
                        product.getBrandName(),
                        FinancialFactors.PREFERRED_CURRENCY + product.getSellingPrice(),
                        product.getActiveConstituent(),
                        quantity};
                tableModel.addRow(dataRow);
            }
        } catch (Exception ignored) {
        }
    }

    public static synchronized void loadSearchTable(JTable table, ArrayList<Product> productInventory) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            String quantity;
            clearTable(tableModel);
            for (Product product : productInventory) {

                if (product.getQuantityInStock() == 0) quantity = "OUT OF STOCK";
                else quantity = Integer.toString(product.getQuantityInStock());

                Object[] dataRow = {
                        String.valueOf(product.getItemID()),
                        product.getBrandName(),
                        FinancialFactors.PREFERRED_CURRENCY + product.getSellingPrice(),
                        product.getActiveConstituent(),
                        quantity};
                tableModel.addRow(dataRow);
            }
        } catch (Exception ignored) {
        }
    }

    public static synchronized void loadPharmacistTable(JTable table, HashMap<Integer, Pharmacist> pharmacists) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            clearTable(tableModel);
            for (int id : pharmacists.keySet()) {
                if (id == 0) continue;
                Pharmacist pharmacist = pharmacists.get(id);
                Object[] dataRow = {
                        String.valueOf(pharmacist.getId()),
                        pharmacist.getName(),
                        FinancialFactors.PREFERRED_CURRENCY + pharmacist.getSalary(),
                };
                tableModel.addRow(dataRow);
            }
        } catch (Exception ignored) {
        }
    }

    public static synchronized void loadPharmacistTable(JTable table, ArrayList<Pharmacist> pharmacists) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            clearTable(tableModel);
            for (Pharmacist pharmacist : pharmacists) {
                Object[] dataRow = {
                        String.valueOf(pharmacist.getId()),
                        pharmacist.getName(),
                        FinancialFactors.PREFERRED_CURRENCY + pharmacist.getSalary(),
                };
                tableModel.addRow(dataRow);
            }
        } catch (Exception ignored) {
        }
    }

    public static synchronized void loadDelivererTable(JTable table, HashMap<Integer, Deliverer> deliverers) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            clearTable(tableModel);
            for (int id : deliverers.keySet()) {
                Deliverer deliverer = deliverers.get(id);
                Object[] dataRow = {
                        String.valueOf(deliverer.getId()),
                        deliverer.getName(),
                        FinancialFactors.PREFERRED_CURRENCY + deliverer.getSalary(),
                };
                tableModel.addRow(dataRow);
            }
        } catch (Exception ignored) {
        }
    }

    public static synchronized void loadDelivererTable(JTable table, ArrayList<Deliverer> deliverers) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            clearTable(tableModel);
            for (Deliverer deliverer : deliverers) {
                Object[] dataRow = {
                        String.valueOf(deliverer.getId()),
                        deliverer.getName(),
                        FinancialFactors.PREFERRED_CURRENCY + deliverer.getSalary(),
                };
                tableModel.addRow(dataRow);
            }
        } catch (Exception ignored) {
        }
    }
}
