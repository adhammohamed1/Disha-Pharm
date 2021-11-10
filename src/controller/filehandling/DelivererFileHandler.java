package controller.filehandling;

import controller.authentication.user.DelivererAuthenticator;
import controller.management.personnel.PersonnelHandler;
import model.personnel.Deliverer;

import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;

public class DelivererFileHandler implements FileHandler {

    protected static final String DELIVERER_DATA_FILE = "database\\personnel data\\del-data.bat";

    @Override
    public void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DELIVERER_DATA_FILE));
            for (int i : Deliverer.deliverers.keySet()) {
                Deliverer deliverer = Deliverer.deliverers.get(i);
                new DelivererAuthenticator().encryptUserDate(deliverer);
                bw.write(deliverer.toString() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("\033[31mError saving deliverer data: " + e.getMessage() + "\033[0m");
        }
    }


    @Override
    public boolean loadFromFile() {

        String line;
        int day, month, year;
        try {
            BufferedReader br = new BufferedReader(new FileReader(DELIVERER_DATA_FILE));
            while ((line = br.readLine()) != null) {
                Deliverer deliverer = new Deliverer();
                StringTokenizer tok = new StringTokenizer(line, ",");

                deliverer.setId(Integer.parseInt(tok.nextToken()));
                deliverer.setName(tok.nextToken());
                deliverer.setVehicle(tok.nextToken());
                deliverer.setVehicleType(tok.nextToken());
                deliverer.setSalary(Double.parseDouble(tok.nextToken()));

                day = Integer.parseInt(tok.nextToken());
                month = Integer.parseInt(tok.nextToken());
                year = Integer.parseInt(tok.nextToken());
                Calendar cal = Calendar.getInstance();
                cal.clear();
                cal.set(year, month - 1, day);

                deliverer.setBirthDate(cal);
                Deliverer.deliverers.put(deliverer.getId() - PersonnelHandler.DELIVERER_BASE_ID, deliverer);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("\033[31mError loading deliverer data: " + e.getMessage() + "\033[0m");
        }

        return true;
    }

    @Override
    public void loadInstance(String line) {
    }

    @Override
    public void saveInstance(Object object, BufferedWriter writer) {

    }
}
