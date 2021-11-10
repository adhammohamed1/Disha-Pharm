package controller.filehandling;

import controller.authentication.user.PharmacistAuthenticator;
import controller.management.personnel.PersonnelHandler;
import model.personnel.Pharmacist;

import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * {@code Pharmacist}-related implementation of the {@code FileHandler} interface.
 * This implementation provides all the necessary operations related to saving and loading {@code Pharmacist} data.
 *
 * @author Adham Mohamed Aly
 **/
public class PharmacistFileHandler implements FileHandler {

    protected static final String PHARMACIST_DATA_FILE = "database\\personnel data\\ph-data.bat";

    /**
     * This method saves all {@code Pharmacist}-related data to the path "<i>database\ph-data.bat</i>".
     * All data saved is strictly encrypted.
     *
     * <p>
     * All instances stored in the {@code pharmacists} {@code HashMap} are saved into the file
     * sequentially as string lines.
     * This method calls {@code PharmacistAuthenticator}'s <i>{@code encryptUserData()}</i> instance method.
     * Then with every iteration over {@code pharmacists} {@code HashMap},
     * each instance's <i>{@code toString()}</i> method is called to save all objects in constant format.
     * </p>
     * <p>
     * Prints prompt in the terminal in case of IOException.
     * </p>
     *
     * @implNote This method overwrites all data on the file. Use it at your discretion.
     * @author Adham Mohamed Aly
     **/
    @Override
    public void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PHARMACIST_DATA_FILE));
            for (int i : Pharmacist.pharmacists.keySet()) {
                Pharmacist pharmacist = Pharmacist.pharmacists.get(i);
                new PharmacistAuthenticator().encryptUserDate(pharmacist);
                bw.write(pharmacist + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("\033[31mError saving pharmacist data: " + e.getMessage() + "\033[0m");
        }
    }

    /**
     * This method loads all {@code Pharmacist}-related data from the path "<i>database\ph-data.bat</i>".
     * <p>
     * The method iterates over all lines in the file. {@code StringTokenizer} instance is used to tokenize the
     * loaded line and instantiate {@code Pharmacist} object in the following order:
     * <blockquote><pre>
     *     1. Pharmacist ID
     *     2. Pharmacist name
     *     3. Pharmacist password
     *     4. Pharmacist salary
     *     5. Pharmacist day of birth
     *     6. Pharmacist month of birth
     *     6. Pharmacist year of birth
     * </pre></blockquote>
     *
     * @implNote 1. ID  used in the {@code pharmacists} {@code HashMap} is not the loaded code. Rather:
     * <blockquote><pre>loadedID - <i>PHARMACIST_BASE_ID</i></pre></blockquote>
     * 2. If any pharmacist data used in the system differs from the data in the file, then using this method will
     * overwrite all  data currently in the system with the data from the file. Use it at your discretion.
     * @author Adham Mohamed Aly
     **/
    @Override
    public boolean loadFromFile() {
        String line;
        int day, month, year;
        try {
            BufferedReader br = new BufferedReader(new FileReader(PHARMACIST_DATA_FILE));
            while ((line = br.readLine()) != null) {
                Pharmacist pharmacist = new Pharmacist();
                StringTokenizer tok = new StringTokenizer(line, ",");

                pharmacist.setId(Integer.parseInt(tok.nextToken()));
                pharmacist.setName(tok.nextToken());
                pharmacist.setPassword(tok.nextToken());
                pharmacist.setSalary(Double.parseDouble(tok.nextToken()));

                day = Integer.parseInt(tok.nextToken());
                month = Integer.parseInt(tok.nextToken());
                year = Integer.parseInt(tok.nextToken());
                Calendar cal = Calendar.getInstance();
                cal.clear();
                cal.set(year, month - 1, day);
                pharmacist.setBirthDate(cal);

                pharmacist.setInventoryAccess(Boolean.parseBoolean(tok.nextToken()));
                Pharmacist.pharmacists.put(pharmacist.getId() - PersonnelHandler.PHARMACIST_BASE_ID, pharmacist);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("\033[31mError loading pharmacist data: " + e.getMessage() + "\033[0m");
        }
        return false;
    }

    @Override
    public void loadInstance(String line) {
    }

    @Override
    public void saveInstance(Object object, BufferedWriter writer) {

    }
}
