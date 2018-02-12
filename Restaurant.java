/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RestaurantSelector2;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

/**
 *
 * @author Tarzan
 */
public class Restaurant {
  private String name;
  private String cuisine;
  private String neighborhood;
  private String priceLevel;
  
  private static Map<String, Restaurant> restoMap = new TreeMap<>();
  private static List<Restaurant> restoList = new ArrayList<>();
  
  private Restaurant(String name, String cuisine, String neighborhood, String priceLevel) {
    this.name = name;
    this.cuisine = cuisine;
    this.neighborhood = neighborhood;
    this.priceLevel = priceLevel;
  }
  public String getName() {return this.name;}
  public String getCuisine() {return this.cuisine;}
  public String getNeighborhood() {return this.neighborhood;}
  public String getPriceLevel() {return this.priceLevel;}
  
  public void setCuisine(String cuisine) {this.cuisine = cuisine;}
  public void setNeighborhood(String neighborhood) {this.neighborhood = neighborhood;}
  public void setPriceLevel(String priceLevel) {this.priceLevel = priceLevel;}
  
  public static List<Restaurant> getRestaurantList(String cuisine, String neighborhood, String priceLevel){
    List<Restaurant> returnList = new ArrayList<>();
    //Map<String, Restaurant> cuisineMap = new TreeMap<>();
    for (Restaurant maybe: restoList){
      if (maybe.getCuisine().equals(cuisine) & maybe.getNeighborhood().equals(neighborhood) & maybe.getPriceLevel().equals(priceLevel) )
        returnList.add(maybe);
    }
    return returnList;
  }
  public static Restaurant getsRandomRestaurant(String cuisine, String neighborhood, String priceLevel){
    Restaurant resultRestaurant = null;
    List<Restaurant> candidates = getRestaurantList(cuisine, neighborhood, priceLevel);
    //resultRestaurant = candidates.get(Math.random(candidates.size())*100);
    Random random = new Random();
    return candidates.get(random.nextInt(candidates.size()));
    //return list.get(random.nextInt(list.size()));
    //return resultRestaurant;
  }
  public static Restaurant getRestaurant (String name) {
    return restoMap.get(name);
  }
  
  public static Restaurant createRestaurant (String name, String cuisine, String neighborhood, String priceLevel) {
    Restaurant restaurant = restoMap.get(name);
    if (restaurant!=null) {
      return restaurant;
    }
    else {
      restaurant = new Restaurant (name, cuisine, neighborhood, priceLevel);
    }
    restoMap.put(name, restaurant);
    restoList.add(restaurant);
    return restaurant;
  }
  
}
