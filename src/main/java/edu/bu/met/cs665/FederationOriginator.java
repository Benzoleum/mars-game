/**
 * Final Project. FederationOriginator, which holds the attributes of the federation and saves to
 * memento
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

public class FederationOriginator {
  // fields to hold the state of FederationOriginator
  private String factionName;
  private int water;
  private int food;
  private int troops;

  public FederationOriginator(String factionName, int water, int food, int troops) {
    this.factionName = factionName;
    this.water = water;
    this.food = food;
    this.troops = troops;
  }

  public String getFactionName() {
    return factionName;
  }

  public void setFactionName(String factionName) {
    this.factionName = factionName;
  }

  public int getWater() {
    return water;
  }

  public void setWater(int water) {
    this.water = water;
  }

  public int getFood() {
    return food;
  }

  public void setFood(int food) {
    this.food = food;
  }

  public int getTroops() {
    return troops;
  }

  public void setTroops(int troops) {
    this.troops = troops;
  }

  public FederationMemento saveToMemento() {
    FederationMemento federationMemento =
        new FederationMemento(this.factionName, this.water, this.food, this.troops);
    return federationMemento;
  }

  public void undoFromMemento(FederationMemento memento) {

    this.factionName = memento.getFactionName();
    this.water = memento.getWater();
    this.food = memento.getFood();
    this.troops = memento.getTroops();
  }

  public void printInfo() {

    System.out.println("Faction name: " + this.factionName);
    System.out.println("Units of water: " + this.water);
    System.out.println("Units of food: " + this.food);
    System.out.println("Units of troops: " + this.troops);
  }
}
