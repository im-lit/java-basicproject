/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211.assignment;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public abstract class Vehicle implements Serializable, Comparable<Vehicle> {
    protected String phanbiet;
    protected String id;
    protected String name;
    protected String color;
    protected double price;
    protected String brand;

    public Vehicle() {
    }

    public Vehicle(String phanbiet, String id, String name, String color, double price, String brand) {
        this.phanbiet = phanbiet;
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getPhanbiet() {
        return phanbiet;
    }

    public void setPhanbiet(String phanbiet) {
        this.phanbiet = phanbiet;
    }

 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public abstract String getFileLine();
    public abstract void showProfile();
    public abstract void makeSound();
 
    public abstract void parse(String line);
//      String[] params = line.split(",");
//        try {
//            phanbiet = params[0];
//            id = params[1];
//            name = params[2];
//            color = params[3];
//            price = Double.parseDouble(params[4]);
//            brand = params[5];
//        } catch (ArrayIndexOutOfBoundsException e) {
//        }finally{    
//        }
    

    @Override
    public String toString() {
        return  phanbiet + "," + id + "," + name + "," + color + "," + price + "," + brand +",";
    }

    @Override
    public int compareTo(Vehicle that) {
        return id.compareToIgnoreCase(that.id);
    }
}
