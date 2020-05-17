/**
 * Final Project. AttackBehavior encapsulated attack behaviors
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

import static edu.bu.met.cs665.Game.federationCaretaker;
import static edu.bu.met.cs665.Game.federationMemento;
import static edu.bu.met.cs665.Game.federationOriginator;

import java.util.concurrent.TimeUnit;

public interface AttackBehavior {
  public void attack() throws InterruptedException;
}

class BanditsAttack implements AttackBehavior {

  public void attack() {
    if (FactionsResources.outcastsTroops <= 30
        && FactionsResources.banditsTroops >= 40
        && FactionsResources.outcastsTroops > 0
        && FactionsResources.banditsTroops > 0) {
      System.out.println(
          "\nOur watchtower spotted Bandits' war party heading towards the Outcasts");
      FactionsResources.outcastsTroops -= 20;
    } else if (federationOriginator.getTroops() <= 30
        && FactionsResources.banditsTroops >= 40
        && federationOriginator.getTroops() > 0
        && FactionsResources.banditsTroops > 0) {
      System.out.println("\nCommander, Bandits' war party is headed here, prepare for the attack");
      federationOriginator.setTroops(federationOriginator.getTroops() - 10);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
      FactionsResources.banditsTroops -= 5;
      System.out.println("\nYou've lost 10 units of guards, commander");
      System.out.println(
          "\nThe Federation currently has: "
              + federationOriginator.getTroops()
              + " units of guards.");
    } else if (FactionsResources.banditsTroops <= 0) {

    }
  }
}

class OutcastsAttack implements AttackBehavior {
  public void attack() {
    if (FactionsResources.banditsTroops < 30
        && FactionsResources.outcastsTroops > FactionsResources.banditsTroops
        && FactionsResources.banditsTroops > 0) {
      System.out.println("\nOutcasts attacked Bandits");
      FactionsResources.banditsTroops -= 20;
    } else if (FactionsResources.wealthyTroops < 40) {
      System.out.println("\nOutcasts attacked Ultra Wealthy");
      FactionsResources.wealthyTroops -= 20;
    } else if (federationOriginator.getTroops() < 30
        && FactionsResources.outcastsTroops > 40
        && federationOriginator.getTroops() > 0) {
      System.out.println("\nOutcasts attacked you");
      federationOriginator.setTroops(federationOriginator.getTroops() - 10);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
    } else if (FactionsResources.outcastsTroops <= 0) {

    }
  }
}

class WealthyAttack implements AttackBehavior {
  public void attack() throws InterruptedException {
    if (Game.accept == 1
        && FactionsResources.banditsTroops <= 0
        && FactionsResources.outcastsTroops <= 0) {
      System.out.println(
          "\nAIVA: Commander, we spotted an Ultra Wealthy war party heading towards us, prepare for the attack");
      TimeUnit.SECONDS.sleep(5);
      System.out.println("\nIt appears the wealthy outplayed everyone...");
      TimeUnit.SECONDS.sleep(5);
      System.out.println(
          "\nYou've been attacked by the Ultra Wealthy, they've captured your people, and "
              + "made them slaves...");
      TimeUnit.SECONDS.sleep(5);
      System.out.println(
          "\nYou spent your days in the cage dying, while the wealthy feasted and "
              + "rejoiced...");
      TimeUnit.SECONDS.sleep(5);
      federationOriginator.setTroops(0);
      federationOriginator.setWater(0);
      federationOriginator.setFood(0);
    }
  }
}
