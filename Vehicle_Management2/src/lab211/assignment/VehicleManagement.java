/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.assignment;


/**
 *
 * @author DELL
 */
public class VehicleManagement {

    public static void main(String[] args) {
        I_Menu menu = new Menu();
        menu.addItem("-----Add new Vehicle        -----");
        menu.addItem("-----Update a Vehicle by ID -----");
        menu.addItem("-----Delete a Vehicle by ID -----");
        menu.addItem("-----Search a Vehicle       -----");
        menu.addItem("-----Show Vehicles          -----");
        menu.addItem("-----Store data to file     -----");
        menu.addItem("-----Quit-----");

        I_Menu menuAdd = new Menu();
        menuAdd.addItem("Add a new Car");
        menuAdd.addItem("Add a new Motorbike");

        I_Menu menuSearch = new Menu();
        menuSearch.addItem("Search by Name");
        menuSearch.addItem("Search by ID");

        I_Menu menuShow = new Menu();
        menuShow.addItem("Show all vehicle");
        menuShow.addItem("Show all vehicle by descending price");

        int choice, choice01, choice02, choice03;
        boolean cont = false;
        VehicleList vList = new VehicleList();
        do {
            System.out.println("---------------------------");
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    menuAdd.showMenu();
                    choice01 = menuAdd.getChoice();
                    if (choice01 == 1) {
                        vList.addACar();
                        boolean check;
                        while (check = menu.confirmYesNo("Do you want add more Car ? (Y/N): ")) {
                            vList.addACar();
                        }
                    } else {
                        vList.addAMotorbike();
                        boolean check;
                        while (check = menu.confirmYesNo("Do you want add more Motorbike ? (Y/N): ")) {
                            vList.addAMotorbike();
                        }
                    }
                    break;
                case 2:
                    System.out.println("You are required to input "
                            + "a vehicle id to update");
                    vList.updateVehicleByID();
                    break;

                case 3:
                    System.out.println("You are required to input "
                            + "a vehicle id to delete");
                    vList.deleteVehicleByID();
                    break;
                case 4:
                    menuSearch.showMenu();
                    choice02 = menuSearch.getChoice();
                    if (choice02 == 1) {
                        vList.searchVehicleByName();
                    } else {
                        vList.searchVehicleByID();
                    }
                    break;

                case 5:
                    menuShow.showMenu();
                    choice03 = menuShow.getChoice();
                    if (choice03 == 1) {
                        vList.showVehicles();
                    } else { 
                        vList.showVehiclesByPrice();
                    }
                    break;
                case 6:
                    vList.storeData();
                    break;
                case 7:
                    cont = menu.confirmYesNo("Do you want to quit? (Y/N)");
                    break;
            }
        } while (!cont);
    }
}
