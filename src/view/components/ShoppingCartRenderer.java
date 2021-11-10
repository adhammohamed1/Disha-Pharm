package view.components;

import model.items.Medicine;
import model.items.Product;

import javax.swing.*;
import java.awt.*;

public class ShoppingCartRenderer extends DefaultListCellRenderer {

    /**
     * Creates a new instance of OperationsRenderer
     */
    public ShoppingCartRenderer() {
    }

    public Component getListCellRendererComponent(JList list,
                                                  Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Product p = (Product) value;
        setText(p.toShoppingCartRepresentation());

        if(p instanceof Medicine && ((Medicine) p).needsPrescription()) {

            if(((Medicine) p).getPolicy().equals(Medicine.PRESCRIBED)) setForeground(new Color(110,60,0));
            else if(((Medicine) p).getPolicy().equals(Medicine.SCHEDULED)) setForeground(new Color(70,0,0));

        }
        return this;
    }
}
