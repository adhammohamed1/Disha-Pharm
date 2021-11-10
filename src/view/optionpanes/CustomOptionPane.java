/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.optionpanes;

import javax.swing.*;

/**
 * @author drogo
 */
public class CustomOptionPane {

    public static boolean done = false;
    public static final String CANCELED = "__OPTION_PANE_CANCELED_BY_USER__";

    public static int showChooseItemDialog() {
        new ChooseItemDialog(null, true).setVisible(true);
        int selection = ChooseItemDialog.selectedItem;
        ChooseItemDialog.selectedItem = -1;
        return selection;
    }

    public static int showRemoveFromCartDialog() {
        new RemoveFromCartDialog(null, true).setVisible(true);
        int selection = RemoveFromCartDialog.inputQuantity;
        RemoveFromCartDialog.inputQuantity = -1;
        return selection;
    }

    public static void showComingSoonDialog() {
        new ComingSoonDialog(null, true).setVisible(true);
    }

    public static String showPasswordDialog() {
        new PasswordDialog(null, true).setVisible(true);
        String input = PasswordDialog.inputString;
        PasswordDialog.inputString = null;
        return input;
    }

    public static int showLogoutDialog() {
        new LogoutDialog(null, true).setVisible(true);
        int choice = LogoutDialog.selectedOption;
        LogoutDialog.selectedOption = -1;
        return choice;
    }

    public static void showPurchaseLoadingDialog() {
        new PurchaseLoadingDialog(null, true).setVisible(true);
    }

    public static void showMessageDialog(String message) {
        ImageIcon icon = new ImageIcon(CustomOptionPane.class.getResource("/graphics_and_icons/logo/logo.png"));
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public static void showMessageDialog(String message, String title) {
        ImageIcon icon = new ImageIcon(CustomOptionPane.class.getResource("/graphics_and_icons/logo/logo.png"));
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, icon);
    }

    public static String showInputDialog(String message) {
        new InputDialog(null, true, message).setVisible(true);
        String input = InputDialog.getInput();
        InputDialog.setInput(CANCELED);
        return input;
    }

    public static String showInputDialog(String message, String initialValue) {
        new InputDialog(null, true, message, initialValue).setVisible(true);
        String input = InputDialog.getInput();
        InputDialog.setInput(CANCELED);
        return input;
    }
}
