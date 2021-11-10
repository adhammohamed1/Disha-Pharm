# Disha-Pharm
Pharmacy System using Java Swing

This is a comprehensive system meant for a pharmacy that can handle multi-layer access levels, contains an invoice system, a data analysis section and more.
The GUI is designed using javax.swing. In fact, this particular project has helped become highly proficient in using javax.swing

First off, we have the Admin which is the owner of the place or the person with the absolute highest authority.
An admin can control everything from finances to personnel and can even sell items throught the pharmacist mode.

Summary of features in the admin mode:
1. Viewing and managing inventory
2. A settings menu where the admin can modify multiple variables in the system like the preferred currency, taxes, base delivery fees, login credentials, and more.
3. Manage all personnel like deliverers, pharmacists and managers with their different configuring settings (vehicle type for deliverers, inventory access for pharmacists, etc.)
4. Sell medicine (pharmacist mode)
5. See all performed transactions with immense detail (date, time, vendor, number of items, items involved, type of transaction)
6. View net monthly balance and data analytics on the past three months (A graph chart for numerical data and a page for non-numerical data)

Next, we have the Pharmacist.
A pharmacist can sell items with varying levels of restriction (over the counter, prescribed or scheduled)
medicines with higher levels of restriction require additional procedures for the purchase to be completed.
A pharmacist with inventory access can also add to the inventory.

Every purchase generates a paper invoice containing all relevant details. The invoice is a printable bill.
