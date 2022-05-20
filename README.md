# Disha-Pharm
Pharmacy System using Java Swing

## Table of Contents
* [Project Description](#project-description)
* [Features](#features)
  - [Summary of Features in Admin Mode](#summary-of-features-in-admin-mode)
  - [Features in Pharmacist Mode](#summary-of-features-in-pharmacist-mode)
  - [Miscellaneous Features](#miscellaneous-features)
* [Deployment](#deployment)
* [Tools, Libraries & Implementations](#tools-libraries--implementations)
* [Sample Run](#sample-run)

## Project Description
This is a comprehensive system meant for a pharmacy that can handle multi-layer access levels, contains an invoice system, a data analysis section and more.
JavaDoc is used to document method functionalities and descriptions for classes, interfaces and global variables. The GUI is designed mainly using javax.swing. In fact, this particular project has helped me become highly proficient in using javax.swing

First off, we have the Admin which is the owner of the place or the person with the absolute highest authority.
An admin can control everything from finances to personnel and can even sell items throught the pharmacist mode.

Next, we have the Pharmacist.
A pharmacist can sell items with varying levels of restriction (over the counter, prescribed or scheduled)
medicines with higher levels of restriction require additional procedures for the purchase to be completed.
A pharmacist with inventory access can also add to the inventory.

## Features
### Summary of Features in Admin Mode:
  1. Viewing and managing inventory  (add/delete/restock products) 
  2. A settings menu where the admin can modify multiple variables in the system like the preferred currency, taxes, base delivery fees, login credentials, and more.
  3. Manage all personnel like deliverers, pharmacists and managers with their different configuring settings (vehicle type for deliverers, inventory access for pharmacists, etc.)
  4. Sell products (through pharmacist mode)
  5. Keep notes
  6. See all performed transactions with immense detail (date, time, vendor, number of items, items involved, type of transaction)
  7. View net monthly balance
  8. View data analytics on the past three months (A graph chart for numerical data and a page for non-numerical data) **(Planned but still not implemented)** 
  9. View and manage customer profiles **(Planned but still not implemented)** 

### Summary of Features in Pharmacist Mode:
  1. Viewing inventory
  2. Sell products
  3. Manage inventory (add/delete/restock products) **(If admin gives them inventory access)**
  4. View and manage customer profiles **(Planned but still not implemented)** 

### Miscellaneous Features:
  1. Every purchase generates a paper invoice containing all relevant details. The invoice is a printable bill.
  2. Toast message with warnings or recommendations appears from the 'i' icon in the bottom left.
  3. Highly customizable settings (currency, base delivery fees, etc.)
  4. Notifications panel with warnings or recommendations from the system **(incomplete)**
  5. Carefully designed user-friendly GUI for a simple but powerful experience

## Deployment
To run the program, run the ***system\general\Main.java*** class

## Tools, Libraries & Implementations
1. IntelliJ IDEA & Netbeans (IDEs)
2. Java Swing (most of the GUI)
4. JavaDoc
5. Graphic libraries like java.awt, javax.imagio, and more.
6. Implemented using Model View Controller in addition to multiple design patterns
7. Mostly maintained S.O.L.I.D principles

## Sample Run
**The following are some of the windows you  may see when using the system:**

![Screenshot (65)](https://user-images.githubusercontent.com/90573502/141642455-80c76476-73ea-47c5-9c81-8b73d6032326.png)

***Initial loading screen***

![Screenshot (66)](https://user-images.githubusercontent.com/90573502/141642463-468a796f-c079-4013-a063-ac4b79000dd9.png)

![Screenshot (68)](https://user-images.githubusercontent.com/90573502/141642467-834cd014-cc1f-47ab-8be1-f36db04f6f6b.png)

![Screenshot (69)](https://user-images.githubusercontent.com/90573502/141642470-9a1cbd4f-ec83-465c-adde-79f4a44e5f18.png)

***Admin Home***

![Screenshot (70)](https://user-images.githubusercontent.com/90573502/141642475-16ad6dd4-89f0-46c8-b6b9-93921e8a6e83.png)

![Screenshot (71)](https://user-images.githubusercontent.com/90573502/141642484-cc77c9de-97d4-4fc9-b558-75f296940246.png)

***By clicking on an operation from the list in the financial tab***

![Screenshot (72)](https://user-images.githubusercontent.com/90573502/141642503-0ecb8e4c-1def-4bd4-a882-a862e8f7e2fb.png)

![Screenshot (73)](https://user-images.githubusercontent.com/90573502/141642511-3597746e-91c3-4ae4-a38b-25d09e18e71e.png)

![Screenshot (74)](https://user-images.githubusercontent.com/90573502/141642517-1d4fa435-98e1-4c8b-b6c7-a32fe75bea2b.png)

![Screenshot (75)](https://user-images.githubusercontent.com/90573502/141642519-253e8392-6591-467c-818c-1fa56676883c.png)

![Screenshot (79)](https://user-images.githubusercontent.com/90573502/141642541-7f199381-ae4c-4a69-9b6b-c9fb61db906b.png)

![Screenshot (80)](https://user-images.githubusercontent.com/90573502/141642544-6f6a5db5-729e-4cd6-b309-2b844ee514e6.png)

![Screenshot (96)](https://user-images.githubusercontent.com/90573502/141642550-bb075ed6-d9ac-4b73-bbd5-d94478f81cf3.png)

![Screenshot (97)](https://user-images.githubusercontent.com/90573502/141642555-0c0c4e51-8a65-4dda-b104-a05895977c15.png)

![Screenshot (98)](https://user-images.githubusercontent.com/90573502/141642659-0844c681-78ba-41a6-ad82-a2e161283145.png)

![Screenshot (99)](https://user-images.githubusercontent.com/90573502/141642664-6ccf68cc-e19b-40f6-97d4-44d8f2cc7703.png)

![Screenshot (100)](https://user-images.githubusercontent.com/90573502/141642674-3a0e2bf4-0605-48f6-a156-ad1a466998f5.png)

![Screenshot 2021-11-11 172314](https://user-images.githubusercontent.com/90573502/141642766-23bf26b9-134a-4fab-86b6-1a7ee4c7fb11.jpg)

![Screenshot (102)](https://user-images.githubusercontent.com/90573502/141642867-1fb78702-b2bb-4b06-b758-7c41c60116a2.png)

![Screenshot (103)](https://user-images.githubusercontent.com/90573502/141642838-d88606b2-f3f6-453d-8b3a-bb5c0925a41f.png)

![Screenshot 2021-11-13 135249](https://user-images.githubusercontent.com/90573502/141643880-92079c57-d67c-4669-9ece-5b7bf81056a2.jpg)
