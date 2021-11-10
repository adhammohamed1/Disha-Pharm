package view.components;

import model.operations.ClientPurchase;
import model.operations.Operation;
import model.operations.StockUpOperation;

import javax.swing.*;
import java.awt.*;

public class OperationsRenderer extends DefaultListCellRenderer {

    /**
     * Creates a new instance of OperationsRenderer
     */
    public OperationsRenderer() {
    }

    public Component getListCellRendererComponent(JList list,
                                                  Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Operation op = (Operation) value;
        if (value instanceof ClientPurchase) {
            op = (ClientPurchase) value;
            setForeground(new Color(0,55,0));
        } else if(value instanceof StockUpOperation) {
            op = (StockUpOperation) value;
            setForeground(new Color(55,0,0));
        }
        setText(op.toDescriptiveString());
        return this;
    }
}
