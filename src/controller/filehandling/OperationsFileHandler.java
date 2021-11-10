package controller.filehandling;

import controller.log.OperationManager;
import model.operations.Operation;

import java.io.*;
import java.util.StringTokenizer;

import static model.items.Pharmaceutical.CLASS_COSMETIC;

public class OperationsFileHandler implements FileHandler {

    public static final String OPERATIONS_DATA_FILE = "database\\operation data\\op-data.bat";

    @Override
    public void saveToFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OPERATIONS_DATA_FILE));
        bw.write("");
        for (int id : Operation.completedOperations.keySet()) {
            Operation.completedOperations.get(id).saveToFile(bw);
        }
        bw.close();
    }

    @Override
    public boolean loadFromFile() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(OPERATIONS_DATA_FILE));
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                StringTokenizer tok = new StringTokenizer(line, ",");
//                <type_check>
                switch (tok.nextToken()) {
                    case OperationManager.OPERATION_CLIENT_PURCHASE:
                        new ClientPurchaseFileHandler().loadInstance(tok.nextToken("\n"));
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
     * but has no effect in the {@code OperationsFileHandler} class context. Rather, it is implemented in all the
     * class's children
     **/
    @Override
    public void loadInstance(String line) {
    }

    /**
     * @author Adham Mohamed Aly
     * @deprecated This method is implemented due to the class's implementation of the {@code FileHandler} interface
     * but has no effect in the {@code OperationsFileHandler} class context. Rather, it is implemented in all the
     * class's children
     **/
    @Override
    public void saveInstance(Object object, BufferedWriter writer) {

    }

}
