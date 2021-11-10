package controller.filehandling;

import controller.authentication.user.AdminAuthenticator;
import controller.management.personnel.AdminHandler;
import model.personnel.Admin;

import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * {@code Admin}-related implementation of the {@code FileHandler} interface.
 * This implementation provides all the necessary operations related to saving and loading {@code Admin} data.
 *
 * @author Adham Mohamed Aly
 **/
public class AdminFileHandler implements FileHandler {

    protected static final String ADMIN_DATA_FILE = "database\\personnel data\\ad-data.bat";
    protected static final String ADMIN_NOTES_FILE = "database\\personnel data\\ad-notes.bat";

    /**
     * This method saves all {@code Admin}-related data to the path "<i>database\personnel data\ad-data.bat</i>".
     * <p>
     * First line contains the boolean value {@code useDefault}: value which
     * specifies whether the {@code AdminAuthenticator} will validate default {@code Admin} credentials or not.
     * </p><p>
     * Second line contains login credentials (login username & login password).
     * </p><p>
     * Third line contains basic info such as name, date of birth, etc.
     * </p><p>
     * Prints prompt in the terminal in case of IOException.
     * </p>
     *
     * @implNote This method overwrites all data on the file. Use it at your discretion.
     * @author Adham Mohamed Aly
     **/
    @Override
    public void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ADMIN_DATA_FILE));
            new AdminAuthenticator().encryptUserDate(Admin.currentAdmin);
            bw.write(AdminAuthenticator.useDefault
                    + "\n" + Admin.currentAdmin.getUserName() + "," + Admin.currentAdmin.getPassword()
                    + "\n" + Admin.currentAdmin.getName() + ","
                    + Admin.currentAdmin.getBirthDate().get(Calendar.DAY_OF_MONTH) + ","
                    + Admin.currentAdmin.getBirthDate().get(Calendar.MONTH) + ","
                    + Admin.currentAdmin.getBirthDate().get(Calendar.YEAR)
                    + "\n");
            bw.close();
        } catch (IOException e) {
            System.out.println("\033[31mError saving admin data: " + e.getMessage() + "\033[0m");
        }
    }

    /**
     * This method loads all {@code Admin}-related data from the path "<i>database\personnel data\ad-data.bat</i>".
     * <p>
     * The method reads the first line in the file to check for the {@code useDefault} boolean value.
     * If true, default admin credentials will be used and the method will terminate. Otherwise, proceed
     * with the loading process.
     * </p><p>
     * Method reads login credentials from the second line and basic info from the third line.
     * </p>
     *
     * @implNote If admin data used in the system differs from the data in the file, then using this method will
     * overwrite all  data currently in the system with the data from the file. Use it at your discretion.
     * @author Adham Mohamed Aly
     **/
    @Override
    public boolean loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(ADMIN_DATA_FILE));
            String line = br.readLine();
            if (line != null) {
                AdminAuthenticator.useDefault = line.equalsIgnoreCase("TRUE");
                if (AdminAuthenticator.useDefault) {
                    AdminHandler.setDefaultValues();
                    br.close();
                    return true;
                }
                StringTokenizer tok = new StringTokenizer(br.readLine(), ",");
                Admin.currentAdmin.setUserName(tok.nextToken());
                Admin.currentAdmin.setPassword(tok.nextToken());
                tok = new StringTokenizer(br.readLine(), ",");
                Admin.currentAdmin.setName(tok.nextToken());
                new AdminAuthenticator().decryptUserData(Admin.currentAdmin);
            }
            br.close();
        } catch (FileNotFoundException e) {
            AdminHandler.setDefaultValues();
            saveToFile();
        } catch (IOException e) {
            System.out.println("\033[31mError loading admin data: " + e.getMessage() + "\033[0m");
            return false;
        }
        return true;
    }

    /**
     * @author Adham Mohamed Aly
     * @deprecated This method is implemented due to the class's implementation of the {@code FileHandler} interface
     * but has no effect in the {@code AdminFileHandler} class context.
     **/
    @Override
    public void loadInstance(String line) {
    }

    /**
     * @param object {@code Admin} instance to be saved.
     * @param writer {@code BufferedWriter} instance responsible for writing in a certain file.
     * @author Adham Mohamed Aly
     * @deprecated This method is implemented due to the class's implementation of the {@code FileHandler} interface
     * but has no effect in the {@code AdminFileHandler} class context.
     */
    @Override
    public void saveInstance(Object object, BufferedWriter writer) {

    }

    /**
     * Saves the given admin notes in the file: <i>database\personnel data\ad-notes.bat</i>
     *
     * @param notes String value of notes entered by the admin in the notes text area
     * @author Adham Mohamed Aly
     */
    public void saveAdminNotes(String notes) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ADMIN_NOTES_FILE));
            bw.write(notes);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error saving admin notes: " + e.getMessage() + "\033[0m");
        }
    }

    /**
     * @return String representation of admin notes saved  in the database file
     * @author Adham Mohamed Aly
     */
    public String loadAdminNotes() {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        try {
            BufferedReader br = new BufferedReader(new FileReader(ADMIN_NOTES_FILE));
            while ((temp = br.readLine()) != null) {
                stringBuilder.append(temp).append("\n");
            }
            return stringBuilder.toString().trim();
        } catch (IOException e) {
            System.out.println("Error loading admin notes: " + e.getMessage() + "\033[0m");
        }
        return null;
    }

}
