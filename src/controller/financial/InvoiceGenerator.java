package controller.financial;

import model.items.Product;
import model.operations.ClientPurchase;
import view.pharmacistspecific.CheckoutWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * This class is an invoice factory. It is responsible for creating invoices from scratch, printing them and
 * saving them in the appropriate locations to be utilized later by any other class
 * @author Adham Mohamed Aly
 */
public class InvoiceGenerator extends javax.swing.JFrame {

    Double bHeight = 0.0;
    public static BufferedImage bufferedImage;
    public static ClientPurchase op;
    static int invoiceWidth, invoiceHeight;
    public static ImageIcon icon;
    public static PrinterJob pj;
    public static PageFormat pageFormat;

    /**
     * Prints the invoice
     * @author Adham Mohamed Aly
     */
    public void printInvoice() {
        try {
            pj.print();
        } catch (PrinterException e) {
            System.out.println("Error printing invoice: " + e.getMessage());
        }
    }

    /**
     * Generates the invoice for current items in the shopping cart
     * @author Adham Mohamed Aly
     */
    public void generateInvoice() {
        bHeight = (double) ShoppingCart.shoppingCartItems.size();
        icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/graphics_and_icons/logo/logo.png")));

        if (pj == null) {
            pj = PrinterJob.getPrinterJob();
        }
        pageFormat = getPageFormat(pj);
        pj.setPrintable(new PrintableBill(), pageFormat);
    }

    private PageFormat getPageFormat(PrinterJob printerJob) {

        PageFormat pf = printerJob.defaultPage();
        Paper paper = pf.getPaper();

        double bodyHeight = bHeight;
        double headerHeight = 8.0;
        double footerHeight = 5.0;
        double width = cm_to_pp(8);
        double height = cm_to_pp(headerHeight + bodyHeight + footerHeight);
        invoiceWidth = (int) Math.ceil(width);
        invoiceHeight = (int) Math.ceil(height);
        bufferedImage = new BufferedImage(invoiceWidth, invoiceHeight, BufferedImage.TYPE_INT_RGB);
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height - cm_to_pp(1));

        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);

        return pf;
    }

    private static double cm_to_pp(double cm) {
        return toPPI(cm * 0.393600787);
    }

    private static double toPPI(double inch) {
        return inch * 72d;
    }

    private class PrintableBill implements Printable {

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {

            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {

                pageFormat.getImageableWidth();
                graphics.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

                drawInvoice((Graphics2D) graphics);

                result = PAGE_EXISTS;
            }
            return result;
        }
    }

    public void saveInvoiceImage() {
        bufferedImage.createGraphics().setColor(Color.white);
        bufferedImage.createGraphics().fillRect(0, 0, invoiceWidth, invoiceHeight);
        bufferedImage.createGraphics().setColor(Color.black);
        drawInvoice(bufferedImage.createGraphics());

        String filename = TransactionManager.getOperationID(op);
        try {
            ImageIO.write(bufferedImage, "png", new File("src/graphics_and_icons/invoices/#" + filename + ".png"));
        } catch (IOException e) {
            System.out.println("Error saving invoice: " + e.getMessage());
        }

    }

    private void drawInvoice(Graphics2D g2d) {
        try {
            int y = 20;
            int yShift = 10;
            int headerRectHeight = 15;

            g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
            g2d.setColor(Color.BLACK);
            g2d.drawImage(icon.getImage(), 80, 17, 60, 40, rootPane);
            y += yShift + 30;
            g2d.drawString("-------------------------------------", 12, y);
            y += yShift;
            g2d.drawString("             Disha  Pharm           ", 12, y);
            y += yShift;
            g2d.drawString("           WE  HAVE  IT  ALL        ", 12, y);
            y += yShift;
            g2d.drawString("  Afgar saydaleya fe darb el tebbana ", 12, y);
            y += yShift;
            g2d.drawString("           Dr. Mostafa Nabil         ", 12, y);
            y += yShift;
            g2d.drawString("           +20 111 994 8685         ", 12, y);
            y += yShift;
            g2d.drawString("-------------------------------------", 12, y);
            y += yShift;
            g2d.drawString("          Operation #" + op.getOperationID(), 12, y);
            y += headerRectHeight;

            g2d.drawString(" Item Name               Total Price ", 10, y);
            y += yShift;
            g2d.drawString("-------------------------------------", 10, y);
            y += headerRectHeight;

            for (Product item : op.getSoldProducts()) {
                g2d.drawString(" " + item.getBrandName() + "                            ", 10, y);
                y += yShift;
                g2d.drawString("    " + FinancialFactors.PREFERRED_CURRENCY + item.getSellingPrice() + " x " + item.getQuantityInStock(), 10, y);
                g2d.drawString(FinancialFactors.PREFERRED_CURRENCY + (item.getQuantityInStock() * item.getSellingPrice()), 150, y);
                y += yShift;

            }

            g2d.drawString("-------------------------------------", 10, y);
            y += yShift;
            g2d.drawString(" Subtotal      :               " + String.format("%.2f", ShoppingCart.subTotal) + "   ", 10, y);
            y += yShift;
            g2d.drawString(" Taxes         :               " + String.format("%.2f", ShoppingCart.taxes) + "   ", 10, y);
            y += yShift;
            g2d.drawString(" Delivery fees :               " + String.format("%.2f", ShoppingCart.deliveryFees) + "   ", 10, y);
            y += yShift;
            g2d.drawString("-------------------------------------", 10, y);
            y += yShift;
            g2d.drawString(" Total amount :               " + String.format("%.2f", ShoppingCart.totalSum) + "   ", 10, y);
            y += yShift;
            g2d.drawString("-------------------------------------", 10, y);
            y += yShift;
            g2d.drawString(" Cash      :                 " + String.format("%.2f", CheckoutWindow.amountPaid) + "   ", 10, y);
            y += yShift;
            g2d.drawString("-------------------------------------", 10, y);
            y += yShift;
            g2d.drawString(" Change    :                 " + String.format("%.2f", CheckoutWindow.change) + "   ", 10, y);
            y += yShift;

            g2d.drawString("*************************************", 10, y);
            y += yShift;
            g2d.drawString("       THANK YOU COME AGAIN ;)         ", 10, y);
            y += yShift;
            g2d.drawString("*************************************", 10, y);
            y += yShift;
            g2d.drawString("      SOFTWARE BY: AM PRODUCTIONS      ", 10, y);
            y += yShift;
            g2d.drawString("  CONTACT:  a.mohamed191100@gmail.com  ", 10, y);

        } catch (Exception e) {
            System.out.println("Error creating invoice: " + e.getMessage());
        }
    }
}

