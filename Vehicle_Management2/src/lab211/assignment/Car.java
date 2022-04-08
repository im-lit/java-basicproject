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
public class Car extends Vehicle {

    private String type;
    private int yearOfMf;

    public Car() {
    }

    public Car(int yearOfMf, String type, String phanbiet, String id, String name, String color, double price, String brand) {
        super(phanbiet, id, name, color, price, brand);
        this.type = type;
        this.yearOfMf = yearOfMf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfMf() {
        return yearOfMf;
    }

    public void setYearOfMf(int yearOfMf) {
        this.yearOfMf = yearOfMf;
    }

    @Override
    public String toString() {
        return phanbiet + "," + id + "," + name + "," + color + "," + price + "," + brand + "," + type + "," + yearOfMf;
    }
    @Override
    public void showProfile() {
        String msg;
        msg = String.format("|%-15s|%6s|%-15s|%6s|%6.1f|%6s|%13s|%16d|", phanbiet,id, name, color, price, brand, type, yearOfMf);
        System.out.println(msg);
    }
    
    @Override
    public void parse(String line) {
        String[] params = line.split(",");
        try {
            phanbiet = params[0];
            id = params[1];
            name = params[2];
            color = params[3];
            price = Double.parseDouble(params[4]);
            brand = params[5];
            yearOfMf = Integer.parseInt(params[6]);
            type = params[7];
            
        } catch (ArrayIndexOutOfBoundsException e) {
        } finally {
        }
    }

    @Override
    public String getFileLine() {
        return phanbiet + "," + id + "," + name + "," + color + "," + price + "," + brand + "," + yearOfMf + "," + type + "," + "\n";
    }

    @Override
    public void makeSound() {
    }

}
