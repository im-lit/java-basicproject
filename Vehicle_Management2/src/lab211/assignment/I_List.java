package lab211.assignment;


/* Interface for a group of objects
 */

/**
 *
 * @author Hoa Doan
 */
public interface I_List { 
  public void loadData();
  public void storeData();
  public void addACar();
  public void addAMotorbike();
  public void updateVehicleByID();
  public void deleteVehicleByID();
  public void searchVehicleByName();
  public void searchVehicleByID();
  public void showVehicles();
  public void showVehiclesByPrice();
}
