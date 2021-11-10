package view.components;

import model.items.Cosmetic;
import model.items.Medicine;
import model.items.Product;

import javax.swing.*;
import java.awt.*;

public class ProductsRenderer extends DefaultListCellRenderer {

    /**
     * Creates a new instance of OperationsRenderer
     */
    public ProductsRenderer() {
    }

    public Component getListCellRendererComponent(JList list,
                                                  Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Product p = (Product) value;
        if (value instanceof Medicine) {
            p = (Medicine) value;
        } else if (value instanceof Cosmetic) {
            p = (Cosmetic) value;
        }
        setText(p.toDisplayableString());
        return this;
    }
}
