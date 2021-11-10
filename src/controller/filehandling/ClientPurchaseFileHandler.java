package controller.filehandling;

import controller.log.OperationManager;
import model.items.Medicine;
import model.items.Product;
import model.operations.ClientPurchase;
import model.operations.Operation;
import model.personnel.Pharmacist;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static model.items.Pharmaceutical.CLASS_COSMETIC;
import static model.items.Pharmaceutical.CLASS_MEDICINE;

/**
 * {@code ClientPurchase}-related implementation of the {@code FileHandler} interface.
 * This implementation provides all the necessary operations related to saving and loading {@code ClientPurchase} data.
 *
 * @author Adham Mohamed Aly
 **/
public class ClientPurchaseFileHandler implements FileHandler {

    protected static final String CLIENT_PURCHASE_DATA_FILE = "database\\operation data\\cp-data1.bat";

    /**
     * This method saves all {@code ClientPurchase}-related data to the path "<i>database\cp-data1.bat</i>".
     * All data saved is strictly encrypted.
     *
     * <p>
     * All {@code ClientPurchase} instances stored in the {@code completedOperations} {@code HashMap} are saved
     * into the file sequentially as {@code String} lines.
     * This method calls {@code OperationAuthenticator}'s <i>{@code encryptItemData()}</i> instance method.
     * Then with every iteration over {@code completedOperations} {@code HashMap},
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(CLIENT_PURCHASE_DATA_FILE));
            for (int id : Operation.completedOperations.keySet()) {
                if (Operation.completedOperations.get(id) instanceof ClientPurchase) {
                    bw.write((ClientPurchase) Operation.completedOperations.get(id) + "\n");
                }
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("\033[31mError saving operation data: " + e.getMessage() + "\033[0m");
        } finally {
            System.out.println(Operation.completedOperations.keySet());
        }
    }

    /**
     * This method loads all {@code ClientPurchase}-related data from the path "<i>database\cp-data1.bat</i>".
     * <p>
     * The method iterates over all lines in the file. The private method {@code tokenizeLine()} is used to tokenize the
     * loaded line and assign attributes to a new {@code ClientPurchase} instance. Read more about how tokenizeLine() works
     * here:
     * {@link #tokenizeLine(String, ClientPurchase)}
     *
     * @implNote If any medicine data used in the system differs from the data in the file, then using this method will
     * overwrite all  data currently in the system with the data from the file. Use it at your discretion.
     * @author Adham Mohamed Aly
     **/
    @Override
    public boolean loadFromFile() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(CLIENT_PURCHASE_DATA_FILE));
            while ((line = br.readLine()) != null) {
                loadInstance(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("\033[31mError loading ClientPurchase data: " + e.getMessage() + "\033[0m");
            return false;
        }
        return true;
    }

    @Override
    public void loadInstance(String line) {
        ClientPurchase clientPurchase = new ClientPurchase();
        tokenizeLine(line, clientPurchase);
        Operation.completedOperations.put(clientPurchase.getOperationID(), clientPurchase);
    }

    @Override
    public void saveInstance(Object operation, BufferedWriter writer) {
        if (!(operation instanceof ClientPurchase)) return;
        try {
            writer.append(OperationManager.OPERATION_CLIENT_PURCHASE + ",").append(String.valueOf((ClientPurchase) operation)).append("\n");
        } catch (IOException e) {
            System.out.println("\033[31mError saving ClientPurchase instance (operation #"
                    + ((ClientPurchase) operation).getOperationID() + "): " + e.getMessage() + "\033[0m");
        }
    }

    /**
     * This is the {@code Operation} version of the <i>tokenizeLine()</i> method. This method takes String line
     * from the user, tokenizes it and stores values in their respective attributes in the following order:
     * <blockquote><pre>
     *          1. Operation ID
     *          2. Operation Balance
     *          3. Operation Date
     *          4. Operation pharmacist ID
     *          5. Operation pharmacist name
     *          6. Operation items
     * </pre></blockquote>
     *
     * @author Adham Mohamed Aly
     **/
    public void tokenizeLine(String line, ClientPurchase clientPurchase) {
        int day, month, year, pharmacistID, itemCount;
        ArrayList<Product> soldProducts = new ArrayList<>();
        StringTokenizer tok = new StringTokenizer(line, ",");

        clientPurchase.setOperationID(Integer.parseInt(tok.nextToken()));
        clientPurchase.setOperationBalance(Double.parseDouble(tok.nextToken()));

        clientPurchase.setSubTotal(Double.parseDouble(tok.nextToken()));
        clientPurchase.setTax(Double.parseDouble(tok.nextToken()));
        clientPurchase.setDelivery(Double.parseDouble(tok.nextToken()));

        pharmacistID = Integer.parseInt(tok.nextToken());
        String pharmacistName = tok.nextToken();
        setClientPurchasePharmacist(clientPurchase, pharmacistID, pharmacistName);

        clientPurchase.setOperationDate(tok.nextToken());

        itemCount = Integer.parseInt(tok.nextToken());
        for (int i = 0; i < itemCount; i++) {
            switch (tok.nextToken(",*")) {
                case CLASS_MEDICINE:
                    Medicine medicine = new Medicine();
                    new MedicineFileHandler().tokenizeLine(tok.nextToken("*"), medicine);
                    soldProducts.add(medicine);
                    break;
                case CLASS_COSMETIC:
                    //TODO: Add handling code here
                    break;
            }
        }
        clientPurchase.setSoldProducts(soldProducts);

    }

    public void setClientPurchasePharmacist(ClientPurchase clientPurchase, int pharmacistID, String pharmacistName) {
        Pharmacist p = Pharmacist.pharmacists.get(pharmacistID);
        if (p == null || !p.getName().equals(pharmacistName)) {
            p = new Pharmacist();
            p.setName(pharmacistName);
            p.setId(Pharmacist.INVALID_PHARMACIST_ID);
        }
        clientPurchase.setPharmacist(p);
    }
}
