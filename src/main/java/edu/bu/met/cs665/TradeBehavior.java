/**
 * Final Project. TradeBehavior encapsulated trde behaviors
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */

package edu.bu.met.cs665;

public interface TradeBehavior {
  public void trade();
}

class BanditsTrade implements TradeBehavior {
  public void trade() {
    if (FactionsResources.banditsWater <= 40
        && FactionsResources.outcastsWater > 50
        && FactionsResources.banditsTroops > 0
        && FactionsResources.banditsWater > 0) {
      System.out.println("\nOur watchtowers spotted Bandit's trading caravan heading to Outcasts");
      FactionsResources.banditsWater += 5;
      FactionsResources.banditsFood -= 20;
      FactionsResources.outcastsWater -= 5;
      FactionsResources.outcastsFood += 20;
    } else if (FactionsResources.banditsFood <= 399
        && FactionsResources.outcastsFood >= 199
        && FactionsResources.banditsTroops > 0
        && FactionsResources.banditsWater > 0) {
      System.out.println("\nOur watchtowers spotted Bandit's trading caravan heading to Outcasts");
      FactionsResources.banditsWater -= 5;
      FactionsResources.banditsFood += 20;
      FactionsResources.outcastsWater += 5;
      FactionsResources.outcastsFood -= 20;
    } else if (FactionsResources.banditsTroops <= 0) {
    
    }
  }
}

class OutcastsTrade implements TradeBehavior {
  public void trade() {
    if (FactionsResources.outcastsFood <= 200
        && FactionsResources.banditsWater >= 50
        && FactionsResources.outcastsTroops > 0
        && FactionsResources.outcastsWater > 0) {
      System.out.println("\nOur watchtowers spotted Outcasts' trading caravan heading to Bandits");
      FactionsResources.banditsWater += 5;
      FactionsResources.banditsFood -= 20;
      FactionsResources.outcastsWater -= 5;
      FactionsResources.outcastsFood += 20;
    } else if (FactionsResources.outcastsWater <= 49
        && FactionsResources.banditsWater >= 59
        && FactionsResources.outcastsTroops > 0
        && FactionsResources.outcastsWater > 0) {
      System.out.println("\nOur watchtowers spotted Outcasts' trading caravan heading to Bandits");
      FactionsResources.banditsWater -= 5;
      FactionsResources.banditsFood += 20;
      FactionsResources.outcastsWater += 5;
      FactionsResources.outcastsFood -= 20;
    } else if (FactionsResources.outcastsTroops <= 0) {
    
    }
  }
}

class WealthyTrade implements TradeBehavior {
  public void trade() {}
}
