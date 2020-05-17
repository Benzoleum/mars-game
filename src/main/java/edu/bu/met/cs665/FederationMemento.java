/**
 * Final Project. FederationMemento, which stores the current memento state
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

public class FederationMemento {
  private String factionName;
  private int water;
  private int food;
  private int troops;

  public FederationMemento(String factionName, int water, int food, int troops) {
    this.factionName = factionName;
    this.water = water;
    this.food = food;
    this.troops = troops;
  }

  public String getFactionName() {
    return factionName;
  }

  public int getWater() {
    return water;
  }

  public int getFood() {
    return food;
  }

  public int getTroops() {
    return troops;
  }

  @Override
  public String toString() {
    String str =
        "Current Memento State"
            + this.getFactionName()
            + " , "
            + this.getWater()
            + " , "
            + this.getFood()
            + " , "
            + this.getTroops();
    return str;
  }
}
