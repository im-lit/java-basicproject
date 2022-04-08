package lab211.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * This is comment, do not delete 2021.11.30
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class VehicleList extends ArrayList<Vehicle> implements I_List {

    private ArrayList<Vehicle> vehicleList = new ArrayList();
    private Scanner sc = new Scanner(System.in);

    public VehicleList() {
        loadData();
    }

    @Override
    public void loadData() {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bfr = null;
        try {

            fis = new FileInputStream("Vehicle.txt");
            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            bfr = new BufferedReader(reader);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Vehicle c = new Car();
                c.parse(line);
                Vehicle m = new Motorbike();
                m.parse(line);
                if (c.getPhanbiet().equalsIgnoreCase("Car")) {
                    vehicleList.add(c);
                }
                if (m.getPhanbiet().equalsIgnoreCase("Motorbike")) {
                    vehicleList.add(m);
                }
            }

        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException ex) {
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void addACar() {
        String type;
        int yearOfMf;
        String id = null;
        String name;
        String color;
        String brand;
        double price;
        int pos;

        do {
            id = Utils.getString("Input the car's Id: ");
            pos = searchVehiclePositionById(id);
            if (pos >= 0) {
                System.out.println("The Car id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Utils.getString("Input a car name: ");
        color = Utils.getString("Input the car's color: ");
        brand = Utils.getString("Input the car's brand: ");
        type = Utils.getString("Input the car's type: ");
        yearOfMf = Utils.getAnInteger("Input the car's year of manufactured: ", "Input the number!");
        price = Utils.getADouble("Input the car's price: ", "Input the number!");

        boolean check = vehicleList.add(new Car(yearOfMf, type, "Car", id, name, color, price, brand));
        if (check) {
            System.out.println("A Car's infomation is added sucessfully");
        } else {
            System.out.println("Loi roi");
        }
    }

    @Override
    public void addAMotorbike() {
        String license;
        int speed;
        String id = null;
        String name;
        String color;
        String brand;
        double price;
        int pos;

        do {
            id = Utils.getString("Input the motorbike's Id: ");
            pos = searchVehiclePositionById(id);
            if (pos >= 0) {
                System.out.println("The Motorbike id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Utils.getString("Input a motorbike's name: ");
        color = Utils.getString("Input the motorbike's color: ");
        brand = Utils.getString("Input the motorbike's brand: ");
        price = Utils.getADouble("Input the motorbike's price: ", "Input the number!");
        speed = Utils.getAnInteger("Input the motorbike's speed: ", "Input the number!");
        license = Utils.getString2("Input the motorbike's license (not Required/ required) :");
        if (license.equalsIgnoreCase("not required")) {
            vehicleList.add(new Motorbike(speed, false, "Motorbike", id, name, color, price, brand));
        } else if (license.equalsIgnoreCase("required")) {
            vehicleList.add(new Motorbike(speed, true, "Motorbike", id, name, color, price, brand));
        } else {

        }

        System.out.println("A Motorbike's infomation is added sucessfully");
    }

    @Override
    public void updateVehicleByID() {
        String id;
        String tmpName;
        String tmpColor;
        String tmpBrand;
        double tmpPrice;
        Vehicle x;
        id = Utils.getString("Input vehicle's Id: ");
        x = searchVehicleByID(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Vehicle doesn't exist!!!");
        } else {
            System.out.print("Input new name: ");
            tmpName = sc.nextLine();
            if (tmpName.isEmpty()) {
                tmpName = x.getName();
            }
            x.setName(tmpName);
            System.out.print("Input new color: ");
            tmpColor = sc.nextLine();
            if (tmpColor.isEmpty()) {
                tmpColor = x.getColor();
            }
            x.setColor(tmpColor);
            System.out.print("Input new brand: ");
            tmpBrand = sc.nextLine();
            if (tmpBrand.isEmpty()) {
                tmpBrand = x.getBrand();
            }
            x.setBrand(tmpBrand);
            tmpPrice = Utils.getADouble("Input new Price: ", "Input a number: ");
            x.setPrice(tmpPrice);
            System.out.println("The vehicle info is updated successfully!");
            System.out.println("The vehicle's information:");
            x.showProfile();
        }
    }

    @Override
    public void deleteVehicleByID() {
        String id;
        int pos;
        id = Utils.getString("Input Vehicle's Id: ");
        pos = searchVehiclePositionById(id);
        if (pos == -1) {
            System.out.println("Vehicle doesn't exist");
        } else {
            boolean check = Utils.confirmYesNo("Are u sure to delete this Vehicle: (Y/N): ");
            if (check) {
                vehicleList.remove(pos);
                System.out.println("The selected Vehicle is deleted successfully!");
            }
        }
    }

    @Override
    public void searchVehicleByName() {
        String tmpName;
        String msg;
        ArrayList<Vehicle> fakeList = new ArrayList();
        tmpName = Utils.getString("Input the name that you want to search: ");
        fakeList.removeAll(this);
        for (Vehicle x : vehicleList) {
            if (x.getName().contains(tmpName)) {
                fakeList.add(x);
            }
        }
        if (!fakeList.isEmpty()) {
            Comparator brandBalance = new Comparator<Vehicle>() {
                @Override
                public int compare(Vehicle v1, Vehicle v2) {
                    return v2.getBrand().compareToIgnoreCase(v1.getBrand());
                }
            };
            Collections.sort(fakeList, brandBalance);
            System.out.println("----------------------------------------");
            System.out.println("Here is the result of searching's list descending by brand");
            msg = String.format("|%-15s|%6s|%-15s|%6s|%6s|%6s|%6s|%10s|", "Vehicle", "ID", "NAME", "COLOR", "PRICE", "BRAND", "   SPEED/Type", "LICENSE/YearofMf");
            System.out.println(msg);
            System.out.println("--------------------------------------------------------------------------------------------");
            for (int i = 0; i < fakeList.size(); i++) {
                fakeList.get(i).showProfile();
            }
        } else {
            System.out.println("Can Match the name u wanted to search");
        }

    }

    @Override
    public void searchVehicleByID() {
        String id;
        Vehicle x;
        id = Utils.getString("Input Vehicle's Id: ");
        x = searchVehicleByID(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("The vehicle doesn't exist!");
        } else {
            System.out.println("Here is the Vehicle "
                    + "that you want to search");
            x.showProfile();
        }
    }

    @Override
    public void showVehicles() {
        String msg;
        msg = String.format("|%-15s|%6s|%-15s|%6s|%6s|%6s|%6s|%10s|", "Vehicle", "ID", "NAME", "COLOR", "PRICE", "BRAND", "   SPEED/Type", "LICENSE/YearofMf");
        System.out.println(msg);
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Vehicle x : vehicleList) {
            x.showProfile();
        }
    }

    @Override
    public void showVehiclesByPrice() {
        String msg;
        ArrayList<Vehicle> fakeList = new ArrayList();
        fakeList = (ArrayList<Vehicle>) vehicleList.clone();
        if (fakeList.isEmpty()) {
            System.out.println("Sorry, the Showroom is empty. You must add atleast 1 vehicle before using this feature!");
        }
        Comparator priceBalance = new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return Double.compare(v2.getPrice(), v1.getPrice());
            }
        };
        Collections.sort(fakeList, priceBalance);
        System.out.println("----------------------------------------");
        System.out.println("Here is the Vehicle list descending by price");
        msg = String.format("|%-15s|%6s|%-15s|%6s|%6s|%6s|%6s|%10s|", "Vehicle", "ID", "NAME", "COLOR", "PRICE", "BRAND", "   SPEED/Type", "LICENSE/YearofMf");
        System.out.println(msg);
        System.out.println("--------------------------------------------------------------------------------------------");
        for (int i = 0; i < fakeList.size(); i++) {
            fakeList.get(i).showProfile();
            fakeList.get(i).makeSound();
        }
    }

    public int searchVehiclePositionById(String vehicleID) {
        if (vehicleList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getId().equalsIgnoreCase(vehicleID)) {
                return i;
            }
        }
        return -1;
    }

    public Vehicle searchVehicleByID(String vehicleId) {
        if (vehicleList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getId().equalsIgnoreCase(vehicleId)) {
                return vehicleList.get(i);
            }
        }
        return null;
    }

    @Override
    public void storeData() {
        FileOutputStream fos = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("Vehicle.txt", false);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (Vehicle x : vehicleList) {
                String line = x.getFileLine();
                pw.write(line);
            }
            System.out.println("Save to file successfully!");
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        }
    }
}
