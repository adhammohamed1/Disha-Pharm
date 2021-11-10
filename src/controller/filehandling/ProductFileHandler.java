package controller.filehandling;

import model.items.Product;

import java.io.*;
import java.util.StringTokenizer;

import static model.items.Pharmaceutical.CLASS_COSMETIC;
import static model.items.Pharmaceutical.CLASS_MEDICINE;

public class ProductFileHandler implements FileHandler {

    public static final String PRODUCTS_DATA_FILE = "database\\item data\\prod-data.bat";

    @Override
    public void saveToFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(PRODUCTS_DATA_FILE));
        bw.write("");
        for (int id : Product.productInventory.keySet()) {
            Product.productInventory.get(id).saveToFile(bw);
        }
        bw.close();
    }

    @Override
    public boolean loadFromFile() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(PRODUCTS_DATA_FILE));
            while ((line = br.readLine()) != null) {
                StringTokenizer tok = new StringTokenizer(line, ",");
//                <type_check>
                switch (tok.nextToken()) {
                    case CLASS_MEDICINE:
                        new MedicineFileHandler().loadInstance(tok.nextToken("\n"));
                        break;
                    case CLASS_COSMETIC:
                        //TODO: Insert code here
                        break;
                }
//                </type_check>
            }
            br.close();
        } catch (IOException ignored) {
            return false;
        }
        return true;
    }

    /**
     * @author Adham Mohamed Aly
     * @deprecated This method is implemented due to the class's implementation of the {@code FileHandler} interface
     * but has no effect in the {@code ProductFileHandler} class context. Rather, it is implemented in all the
     * class's children
     **/
    @Override
    public void loadInstance(String line) {
    }

    /**
     * @author Adham Mohamed Aly
     * @deprecated This method is implemented due to the class's implementation of the {@code FileHandler} interface
     * but has no effect in the {@code ProductFileHandler} class context. Rather, it is implemented in all the
     * class's children
     **/
    @Override
    public void saveInstance(Object object, BufferedWriter writer) {

    }

}
