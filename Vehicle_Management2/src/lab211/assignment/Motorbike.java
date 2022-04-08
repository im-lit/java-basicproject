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
public class Motorbike extends Vehicle {

    private int speed;
    private boolean license;
    String tmpLicense;

    public Motorbike() {
    }

    public Motorbike(int speed, boolean license, String phanbiet, String id, String name, String color, double price, String brand) {
        super(phanbiet, id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return phanbiet + "," + id + "," + name + "," + color + "," + price + "," + brand + "," + speed + "," + license;
    }

    @Override
    public void showProfile() {
        String msg;
        msg = String.format("|%-15s|%6s|%-15s|%6s|%6.1f|%6s|%13d|%16s|", phanbiet, id, name, color, price, brand, speed, license);
        System.out.println(msg);
    }

    @Override
    public void makeSound() {
        System.out.println("Tin Tin Tin");
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
            speed = Integer.parseInt(params[6]);
            if (params[7].equalsIgnoreCase("false") || params[7].equalsIgnoreCase("true")) {
                license = Boolean.parseBoolean(params[7]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        } finally {
        }
    }

    @Override
    public String getFileLine() {
        return phanbiet + "," + id + "," + name + "," + color + "," + price + "," + brand + "," + speed + "," + license + "," + "\n";
    }

}
