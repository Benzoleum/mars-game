/**
 * Final Project. ScavengeBehavior encapsulated scavenge behaviors
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

public interface ScavengeBehavior {
  public void scavenge();
}

class BanditsScavenge implements ScavengeBehavior {
  public void scavenge() {
    if (FactionsResources.banditsWater < 70 || FactionsResources.banditsFood < 500) {
      System.out.println("\nOur watchtowers spotted Bandit's Scavengers in the wasteland");
      FactionsResources.banditsWater += 1;
      FactionsResources.banditsFood += 10;
      FactionsResources.banditsTroops -= 1;
    }
  }
}

class OutcastsScavenge implements ScavengeBehavior {
  public void scavenge() {
    if (FactionsResources.outcastsFood <= 300 || FactionsResources.outcastsWater <= 50) {
      System.out.println("\nOur watchtowers spotted Outcasts' Scavengers in the wasteland");
      FactionsResources.outcastsWater += 2;
      FactionsResources.outcastsFood += 5;
      FactionsResources.outcastsTroops -= 1;
    }
  }
}

class WealthyScavenge implements ScavengeBehavior {
  public void scavenge() {}
}
