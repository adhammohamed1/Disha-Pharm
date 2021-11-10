package controller.filehandling;

import model.items.Medicine;
import model.items.Product;

import java.io.*;
import java.util.StringTokenizer;

import static model.items.Pharmaceutical.CLASS_MEDICINE;

/**
 * {@code Medicine}-related implementation of the {@code FileHandler} interface.
 * This implementation provides all the necessary operations related to saving and loading {@code Medicine} data.
 *
 * @author Adham Mohamed Aly
 **/
public class MedicineFileHandler implements FileHandler {

    protected static final String MEDICINE_DATA_FILE = "database\\item data\\med-data1.bat";

    /**
     * This method saves all {@code Medicine}-related data to the path "<i>database\med-data1.bat</i>".
     * All data saved is strictly encrypted.
     *
     * <p>
     * All {@code Medicine} instances stored in the {@code productInventory} {@code HashMap} are saved
     * into the file sequentially as {@code String} lines.
     * This method calls {@code ProductAuthenticator}'s <i>{@code encryptItemData()}</i> instance method.
     * Then with every iteration over {@code productInventory} {@code HashMap},
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(MEDICINE_DATA_FILE));
            for (int id : Product.productInventory.keySet()) {
                if (Product.productInventory.get(id) instanceof Medicine) {
                    bw.write((Medicine) Product.productInventory.get(id) + "\n");
                }
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("\033[31mError saving medicine data: " + e.getMessage() + "\033[0m");
        }
    }

    /**
     * This method loads all {@code Medicine}-related data from the path "<i>database\med-data1.bat</i>".
     * <p>
     * The method iterates over all lines in the file. The private method {@code tokenizeLine()} is used to tokenize the
     * loaded line and assign attributes to a new {@code Medicine} instance. Read more about how tokenizeLine() works
     * here:
     * {@link #tokenizeLine(String, Medicine)}
     *
     * @implNote If any medicine data used in the system differs from the data in the file, then using this method will
     * overwrite all  data currently in the system with the data from the file. Use it at your discretion.
     * @author Adham Mohamed Aly
     **/
    @Override
    public boolean loadFromFile() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(MEDICINE_DATA_FILE));
            while ((line = br.readLine()) != null) {
                Medicine medicine = new Medicine();
                tokenizeLine(line, medicine);
                Product.productInventory.put(medicine.getItemID(), medicine);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("\033[31mError loading medicine data: " + e.getMessage() + "\033[0m");
            return false;
        }
        return true;
    }

    @Override
    public void loadInstance(String line) {
        Medicine medicine = new Medicine();
        tokenizeLine(line, medicine);
        Product.productInventory.put(medicine.getItemID(), medicine);
        Product.productSearchTree.insert(medicine.getItemID());
        Medicine.medicineCount++;
    }

    @Override
    public void saveInstance(Object product, BufferedWriter writer) {
        if (!(product instanceof Medicine)) return;
        try {
            writer.append(CLASS_MEDICINE + ",").append(String.valueOf((Medicine) product)).append("\n");
        } catch (IOException e) {
            System.out.println("\033[31mError saving medicine instance (itemID: " + ((Medicine) product).getItemID() + ")\033[0m");
        }
    }

    /**
     * This is the {@code Medicine} version of the <i>tokenizeLine()</i> method. This method takes String line
     * from the user, tokenizes it and stores values in their respective attributes in the following order:
     * <blockquote><pre>
     *          1. Medicine ID
     *          2. Medicine brand name
     *          3. Medicine active constituent
     *          4. Medicine quantity in stock
     *          5. Medicine selling price
     *          6. Medicine selling policy
     *          7. Medicine type
     *          8. Medicine expiry day
     *          9. Medicine expiry month
     *
     * </pre></blockquote>
     *
     * @author Adham Mohamed Aly
     **/
    public void tokenizeLine(String line, Medicine medicine) {
        int day, month, year;
        StringTokenizer tok = new StringTokenizer(line, ",");

        medicine.setItemID(Integer.parseInt(tok.nextToken()));
        medicine.setBrandName(tok.nextToken());
        medicine.setActiveConstituent(tok.nextToken());
        medicine.setQuantityInStock(Integer.parseInt(tok.nextToken()));
        medicine.setSellingPrice(Double.parseDouble(tok.nextToken()));
        medicine.setPolicy(tok.nextToken());
        medicine.setType(tok.nextToken());
        day = Integer.parseInt(tok.nextToken());
        month = Integer.parseInt(tok.nextToken());
        year = Integer.parseInt(tok.nextToken());
        medicine.setExpiryDate(day, month, year);
    }
}
