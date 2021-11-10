package controller.searching;

import controller.management.personnel.PersonnelHandler;
import model.items.Product;
import model.personnel.Deliverer;
import model.personnel.Pharmacist;

import javax.swing.*;
import java.util.ArrayList;

import static model.items.Product.productInventory;

public class Searcher extends Thread {

    public void updateProgressBar(JProgressBar progressBar, int val, int timeInMillis, int finalSleepTime) {

        try {
            if (progressBar == null) {
                return;
            }
            for (int i = progressBar.getValue(); i <= val; i++) {
                progressBar.setValue(i);
                Thread.sleep(timeInMillis);
            }
            Thread.sleep(finalSleepTime);
        } catch (InterruptedException ignored) {
        }
    }

    public synchronized ArrayList<Product> getProductSearchResults(int itemID, JProgressBar progressBar, JLabel statusLabel) {
        progressBar.setValue(0);
        ArrayList<Product> searchResults = new ArrayList<>();
        updateProgressBar(progressBar, 10, 1, 0);
        for (int id : Product.productInventory.keySet()) {
            Product p = productInventory.get(id).clone();
            if (String.valueOf(p.getItemID()).startsWith(String.valueOf(itemID))) {
                searchResults.add(p);
            }
        }
        updateProgressBar(progressBar, 40, 1, 0);
        statusLabel.setText("Found: " + searchResults.size() + " results");
        for (int id : Product.productInventory.keySet()) {
            Product p = productInventory.get(id).clone();
            if (!String.valueOf(p.getItemID()).startsWith(String.valueOf(itemID))
                    && String.valueOf(p.getItemID()).contains(String.valueOf(itemID))) {
                searchResults.add(p);
            }
        }
        updateProgressBar(progressBar, 100, 1, 0);
        statusLabel.setText("Found: " + searchResults.size() + " results");
        return searchResults;
    }

    public synchronized ArrayList<Product> getProductSearchResults(String stringValue, JProgressBar progressBar, JLabel statusLabel) {
        progressBar.setValue(0);
        ArrayList<Product> searchResults = new ArrayList<>();
        updateProgressBar(progressBar, 10, 1, 0);
        for (int id : Product.productInventory.keySet()) {
            Product p = productInventory.get(id);
            if (!searchResults.contains(p)) {
                if (p.getBrandName().startsWith(stringValue)) {
                    searchResults.add(p);
                } else if (p.getActiveConstituent().startsWith(stringValue)) {
                    searchResults.add(p);
                }
            }
        }
        for (int id : Product.productInventory.keySet()) {
            Product p = productInventory.get(id);
            if (!searchResults.contains(p)) {
                if (!p.getBrandName().startsWith(stringValue)
                        && p.getBrandName().contains(stringValue)) {
                    searchResults.add(p);
                } else if (!p.getActiveConstituent().startsWith(stringValue)
                        && p.getActiveConstituent().contains(stringValue)) {
                    searchResults.add(p);
                }
            }
        }
        updateProgressBar(progressBar, 40, 1, 0);
        statusLabel.setText("Found: " + searchResults.size() + " results");
        updateProgressBar(progressBar, 100, 2, 0);
        statusLabel.setText("Found: " + searchResults.size() + " results");
        return searchResults;
    }

    public synchronized ArrayList<Pharmacist> getPharmacistSearchResults(int ID, JProgressBar progressBar, JLabel statusLabel) {
        progressBar.setValue(0);
        String idString = String.valueOf(ID);
        ArrayList<Pharmacist> searchResults = new ArrayList<>();
        updateProgressBar(progressBar, 10, 1, 0);
        for (int id : Pharmacist.pharmacists.keySet()) {
            Pharmacist p = Pharmacist.pharmacists.get(id);

            if (p.getId() == PersonnelHandler.PHARMACIST_BASE_ID) continue;
            if (String.valueOf(p.getId()).startsWith(idString)) {
                searchResults.add(p);
            }
        }
        for (int id : Pharmacist.pharmacists.keySet()) {
            Pharmacist p = Pharmacist.pharmacists.get(id);
            if (p.getId() == PersonnelHandler.PHARMACIST_BASE_ID) continue;
            if (!searchResults.contains(p) && String.valueOf(p.getId()).contains(idString)) {
                searchResults.add(p);
            }
            statusLabel.setText("Found: " + searchResults.size() + " results");
        }
        updateProgressBar(progressBar, 100, 2, 0);
        return searchResults;
    }

    public synchronized ArrayList<Pharmacist> getPharmacistSearchResults(String stringValue, JProgressBar progressBar, JLabel statusLabel) {
        progressBar.setValue(0);
        stringValue = stringValue.toLowerCase();
        ArrayList<Pharmacist> searchResults = new ArrayList<>();
        updateProgressBar(progressBar, 10, 1, 0);
        for (int id : Pharmacist.pharmacists.keySet()) {
            Pharmacist p = Pharmacist.pharmacists.get(id);
            if (p.getId() == PersonnelHandler.PHARMACIST_BASE_ID) continue;
            if (p.getName().toLowerCase().startsWith(stringValue)) {
                searchResults.add(p);
            }
        }
        for (int id : Pharmacist.pharmacists.keySet()) {
            Pharmacist p = Pharmacist.pharmacists.get(id);
            if (p.getId() == PersonnelHandler.PHARMACIST_BASE_ID) continue;
            if (!searchResults.contains(p) && p.getName().toLowerCase().contains(stringValue)) {
                searchResults.add(p);
            }
            statusLabel.setText("Found: " + searchResults.size() + " results");
        }
        updateProgressBar(progressBar, 100, 2, 0);
        return searchResults;
    }


    public synchronized ArrayList<Deliverer> getDelivererSearchResults(int ID, JProgressBar progressBar, JLabel statusLabel) {
        progressBar.setValue(0);
        String idString = String.valueOf(ID);
        ArrayList<Deliverer> searchResults = new ArrayList<>();
        updateProgressBar(progressBar, 10, 1, 0);
        for (int id : Deliverer.deliverers.keySet()) {
            Deliverer d = Deliverer.deliverers.get(id);
            if (String.valueOf(d.getId()).startsWith(idString)) {
                searchResults.add(d);
            }
        }
        for (int id : Deliverer.deliverers.keySet()) {
            Deliverer d = Deliverer.deliverers.get(id);
            if (!searchResults.contains(d) && String.valueOf(d.getId()).contains(idString)) {
                searchResults.add(d);
            }
            statusLabel.setText("Found: " + searchResults.size() + " results");
        }
        updateProgressBar(progressBar, 100, 2, 0);
        return searchResults;
    }

    public synchronized ArrayList<Deliverer> getDelivererSearchResults(String stringValue, JProgressBar progressBar, JLabel statusLabel) {
        progressBar.setValue(0);
        stringValue = stringValue.toLowerCase();
        ArrayList<Deliverer> searchResults = new ArrayList<>();
        updateProgressBar(progressBar, 10, 1, 0);
        for (int id : Deliverer.deliverers.keySet()) {
            Deliverer d = Deliverer.deliverers.get(id);
            if (d.getName().toLowerCase().startsWith(stringValue)) {
                searchResults.add(d);
            }
        }
        for (int id : Deliverer.deliverers.keySet()) {
            Deliverer d = Deliverer.deliverers.get(id);
            if (!searchResults.contains(d) && d.getName().toLowerCase().contains(stringValue)) {
                searchResults.add(d);
            }
            statusLabel.setText("Found: " + searchResults.size() + " results");
        }
        updateProgressBar(progressBar, 100, 2, 0);
        return searchResults;
    }

    @Override
    public void run() {

    }
}
