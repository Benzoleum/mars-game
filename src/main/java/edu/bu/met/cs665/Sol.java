/**
 * Final Project. Sol class, where with method for the player turn, scavenge mechanics, trade
 * mechanics, attack, and reckon mechanics
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

import static edu.bu.met.cs665.Game.characterName;
import static edu.bu.met.cs665.Game.federationCaretaker;
import static edu.bu.met.cs665.Game.federationMemento;
import static edu.bu.met.cs665.Game.federationOriginator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sol {
  static FactionsResources fr = new FactionsResources();
  static Random rnd = new Random();
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static int turnChoiceI;
  static int attackedW;
  private static int factionChoiceI;

  // Method which initiates player turn
  public static void playerTurn() throws InterruptedException {
    System.out.println("\n\n What do you want to do: ");
    System.out.println("\n1) Scavenging");
    System.out.println("\n2) Trade");
    System.out.println("\n3) Attack");
    System.out.println("\n4) Reckon (-2 water, -10 food)");
    System.out.println("\nYour choice: ");
    try { // try catch to ensure correct input
      String turnChoiceS = reader.readLine();
      turnChoiceI = Integer.parseInt(turnChoiceS);
      if (turnChoiceI == 1) {
        scavenge();
      } else if (turnChoiceI == 2) {
        System.out.println("\nWho do you want to trade with?");
        System.out.println("1) Bandits\n2) Outcasts\n3) Ultra wealthy");
        System.out.println("Your choice: ");
        String tradeChoiceS = reader.readLine(); // reads input
        int tradeChoiceI = Integer.parseInt(tradeChoiceS);
        factionChoiceI = tradeChoiceI; // stores the choice of the faction for trading
        if (tradeChoiceI == 1 && FactionsResources.banditsTroops > 0) {
          System.out.println(
              "\n\nYou command to dispatch a caravan to  "
                  + factionChoice(factionChoiceI)
                  + "' settlement");
          TimeUnit.SECONDS.sleep(3);
          System.out.println("\nAIVA: Trading caravan is sent, Commander, standby..");
          TimeUnit.SECONDS.sleep(6);
          System.out.println(
              "\nCaravan Leader: We've reached the bandit's camp, Commander "
                  + Game.characterName
                  + ".");
          TimeUnit.SECONDS.sleep(4);
          System.out.println("\nCaravan Leader: Connecting you to the bandits' leader");
          TimeUnit.SECONDS.sleep(3);
          System.out.println("\nBandit Leader: Speak.");
          TimeUnit.SECONDS.sleep(3);
          tradeB(); // calls trade to ensure the player is finished with trading
        } else if (tradeChoiceI == 1 && FactionsResources.banditsTroops <= 0) {
          System.out.println(
              "\nAIVA: You've destroyed the Bandits, commander, there's no one left to trade with.");
          TimeUnit.SECONDS.sleep(3);
        } else if (tradeChoiceI == 2 && FactionsResources.outcastsTroops > 0) {
          System.out.println(
              "\n\nYou command to dispatch a caravan to  "
                  + factionChoice(factionChoiceI)
                  + "' settlement");
          TimeUnit.SECONDS.sleep(3);
          System.out.println("\nAIVA: Trading caravan is sent, Commander, standby..");
          TimeUnit.SECONDS.sleep(6);
          System.out.println(
              "\nCaravan Leader: We've reached the Outcasts' camp, Commander "
                  + Game.characterName
                  + ".");
          TimeUnit.SECONDS.sleep(4);
          System.out.println("\nCaravan Leader: Connecting you to the outcasts' leader");
          TimeUnit.SECONDS.sleep(3);
          System.out.println("\nOutcasts' Leader: What do you want " + Game.characterName + "?");
          tradeO();
        } else if (tradeChoiceI == 2 && FactionsResources.outcastsTroops <= 0) {
          System.out.println(
              "\nAIVA: You've destroyed the Outcasts, commander, there's no one left to trade with.");
        } else if (tradeChoiceI == 3) {
          System.out.println(
              "\n\nYou command to dispatch a caravan to  "
                  + factionChoice(factionChoiceI)
                  + "' settlement");
          TimeUnit.SECONDS.sleep(6);
          System.out.println("\nAIVA: Trading caravan is sent, Commander, standby..");
          TimeUnit.SECONDS.sleep(6);
          System.out.println("\nYour caravan reaches the gates of the Ultra Wealthy territory.");
          TimeUnit.SECONDS.sleep(6);
          System.out.println(
              "\nCaravan Leader: No one is answering, Commander "
                  + characterName
                  + " "
                  + "I am afraid we have to return before the sol ends");
          TimeUnit.SECONDS.sleep(6);
        }
      } else if (turnChoiceI == 4) {
        reckon(); // calling reckon method
      } else if (turnChoiceI == 3) {
        System.out.println("\nWho do you want to attack?");
        System.out.println("1) Bandits\n2) Outcasts\n3) Ultra wealthy");
        System.out.println("Your choice: ");
        String attackChoiceS = reader.readLine();
        int attackChoiceI = Integer.parseInt(attackChoiceS);
        if (attackChoiceI == 1 && FactionsResources.banditsTroops > 0) {
          attackB(); // calling attack method for bandits
        } else if (attackChoiceI == 2 && FactionsResources.outcastsTroops > 0) {
          attackO(); // calling attack method for outcasts
        } else if (attackChoiceI == 3) {
          attackW(); // calling attack method for the ultra wealthy
        }
      }
    } catch (Exception e) {
      System.out.println("Please write your choice in numeric form");
      playerTurn();
    }
  }

  public static void reckon() throws IOException, InterruptedException {
    System.out.println("\nWho do you want to reckon on?");
    System.out.println("1) Bandits\n2) Outcasts\n3) Ultra wealthy");
    System.out.println("Your choice: ");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String reckonChoiceS = reader.readLine();
    factionChoiceI = Integer.parseInt(reckonChoiceS);
    System.out.println(
        "\n\nYou command to dispatch a reckon party to spy on "
            + factionChoice(factionChoiceI)
            + ".");
    TimeUnit.SECONDS.sleep(4);
    System.out.println("\nReckon party is gathering intel");
    TimeUnit.SECONDS.sleep(10);
    System.out.println("\nCommander, here's what the reckon party found: ");
    System.out.println(
        "\nThe "
            + factionChoice(factionChoiceI)
            + " have "
            + intelW(factionChoiceI)
            + " units of water, "
            + intelF(factionChoiceI)
            + " units of food, and "
            + intelT(factionChoiceI)
            + " units of troops.");
    // records the decrement of water and food of federation and stores it in the memento
    federationOriginator.setWater(federationOriginator.getWater() - 2);
    federationOriginator.setFood(federationOriginator.getFood() - 10);
    federationMemento = federationOriginator.saveToMemento();
    federationCaretaker.addMemento(federationMemento);
    TimeUnit.SECONDS.sleep(6);
    System.out.println("\nYou've used 2 units of water\nYou've used 10 units of food.");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "\nYou now have "
            + federationOriginator.getWater()
            + " units of water, and "
            + federationOriginator.getFood()
            + " units of food.");
  }

  // method to return faction names
  public static String factionChoice(int a) {
    if (a == 1) {
      return fr.factionNameB;
    } else if (a == 2) {
      return fr.factionNameO;
    } else {
      return fr.factionNameU;
    }
  }

  // method to return water of the faction
  public static int intelW(int a) {
    if (a == 1) {
      return fr.banditsWater;
    } else if (a == 2) {
      return fr.outcastsWater;
    } else {
      return fr.wealthyWater;
    }
  }

  // method to return food of the faction
  public static int intelF(int a) {
    if (a == 1) {
      return fr.banditsFood;
    } else if (a == 2) {
      return fr.outcastsFood;
    } else {
      return fr.wealthyFood;
    }
  }

  // method to return the troops of the faction
  public static int intelT(int a) {
    if (a == 1) {
      return fr.banditsTroops;
    } else if (a == 2) {
      return fr.outcastsTroops;
    } else {
      return fr.wealthyTroops;
    }
  }

  // method for scavenging
  public static void scavenge() throws InterruptedException {
    System.out.println("You sent out a scavenging party of 5 guards");
    TimeUnit.SECONDS.sleep(5);
    // Variables to store randomly generated values
    int guardsAttacked = rnd.nextInt(2);
    int foodGathered = rnd.nextInt(50);
    int waterGathered = rnd.nextInt(10);
    int guardsLost = rnd.nextInt(3) + 1;
    if (guardsAttacked == 0) {
      System.out.println("\nYour guards safely returned");
      TimeUnit.SECONDS.sleep(5);
      System.out.println("\nHere's what they've brought: ");
      TimeUnit.SECONDS.sleep(5);
      System.out.println("Food: " + foodGathered + "\nWater: " + waterGathered);
      federationOriginator.setWater(federationOriginator.getWater() + waterGathered);
      federationOriginator.setFood(federationOriginator.getFood() + foodGathered);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
      TimeUnit.SECONDS.sleep(5);
      System.out.println(
          "\nYou now have "
              + federationOriginator.getWater()
              + " units of water, and "
              + federationOriginator.getFood()
              + " units of food.");
      TimeUnit.SECONDS.sleep(5);
    } else if (guardsAttacked == 1) {
      System.out.println(
          "AIVA: Someone attacked and robbed your guards, some were killed, "
              + " but some could escape");
      TimeUnit.SECONDS.sleep(5);
      System.out.println(
          "AIVA: You've lost " + guardsLost + " guards."); // random number of guards lost
      TimeUnit.SECONDS.sleep(5);
      System.out.println("\nAIVA: Here's what the rest brought: ");
      TimeUnit.SECONDS.sleep(5);
      System.out.println(
          "Food: "
              + foodGathered
              + "\nWater: "
              + waterGathered); // random number of food and water gathered
      federationOriginator.setWater(federationOriginator.getWater() + waterGathered);
      federationOriginator.setFood(federationOriginator.getFood() + foodGathered);
      federationOriginator.setTroops(federationOriginator.getTroops() - guardsLost);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
      System.out.println(
          "\nYou now have "
              + federationOriginator.getWater()
              + " units of water, and "
              + federationOriginator.getFood()
              + " units of food, "
              + "and "
              + federationOriginator.getTroops()
              + " units of troops.");
      TimeUnit.SECONDS.sleep(5);
    } else {
      System.out.println("None of your guards returned");
      federationOriginator.setTroops(federationOriginator.getTroops() - 5);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
      System.out.println("\nAIVA: We lost 5 guards, Commander...");
    }
  }

  // method to trade with bandits
  public static void tradeB() throws IOException {
    System.out.println("\nWhat do you want to offer: ");
    System.out.println("1) Offer food in exchange for water");
    System.out.println("2) Offer water in exchange for food");
    System.out.println("3) End the trade");
    try {
      String tradeItemsS = reader.readLine();
      int tradeItemsI = Integer.parseInt(tradeItemsS);
      if (tradeItemsI == 1) {
        System.out.println("\nYou have " + federationOriginator.getFood() + " units of food");
        System.out.println("How much you want to offer: ");
        String tradeFoodS = reader.readLine();
        int tradeFoodI = Integer.parseInt(tradeFoodS);
        // if bandits have more than 400 food the will not trade
        if (FactionsResources.banditsFood >= 400) {
          System.out.println("\nBandit leader shakes his head. It seem's they have plenty of food");
          tradeB();
        } else if (FactionsResources.banditsFood < 400 && tradeFoodI >= 30) {
          System.out.println("\nBandit leader: We'll offer you 5 units of water for it.");
          System.out.println("1) Confirm\n2) Decline");
          String tradeFoodDecS = reader.readLine();
          int tradeFoodDecI = Integer.parseInt(tradeFoodDecS);
          if (tradeFoodDecI == 1) {
            federationOriginator.setFood(federationOriginator.getFood() - tradeFoodI);
            federationOriginator.setWater(federationOriginator.getWater() + 5);
            federationMemento = federationOriginator.saveToMemento();
            federationCaretaker.addMemento(federationMemento);
            FactionsResources.banditsFood += tradeFoodI;
            FactionsResources.banditsWater -= 5;
            System.out.println("\nBandit Leader: It's a deal then");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(
                "\nYou now have "
                    + federationOriginator.getWater()
                    + " units of water, and "
                    + federationOriginator.getFood()
                    + " units of food.");
            tradeB();
          } else if (tradeFoodDecI == 2) {
            tradeB();
          }
        } else if (tradeFoodI < 29) {
          System.out.println(
              "\nBandit Leader: Don't waste my time "
                  + Game.characterName
                  + ". I wouldn't even talk with you for that amount.");
          TimeUnit.SECONDS.sleep(5);
          tradeB();
        }
      } else if (tradeItemsI == 2) {
        System.out.println("\nYou have " + federationOriginator.getWater() + " units of water");
        System.out.println("How much you want to offer: ");
        String tradeWaterS = reader.readLine();
        int tradeWaterI = Integer.parseInt(tradeWaterS);
        if (tradeWaterI >= 5) {
          System.out.println("\nBandit leader: We'll offer you 50 units of food for it.");
          TimeUnit.SECONDS.sleep(5);
          System.out.println("1) Confirm\n2) Decline");
          String tradeWaterDecS = reader.readLine();
          int tradeWaterDecI = Integer.parseInt(tradeWaterDecS);
          if (tradeWaterDecI == 1) {
            federationOriginator.setFood(federationOriginator.getFood() + 50);
            federationMemento = federationOriginator.saveToMemento();
            federationCaretaker.addMemento(federationMemento);
            federationOriginator.setWater(federationOriginator.getWater() - tradeWaterI);
            federationMemento = federationOriginator.saveToMemento();
            federationCaretaker.addMemento(federationMemento);
            FactionsResources.banditsWater += tradeWaterI;
            FactionsResources.banditsFood -= 50;
            System.out.println("\nBandit Leader: Deal then");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(
                "\nYou now have "
                    + federationOriginator.getWater()
                    + " units of water, and "
                    + federationOriginator.getFood()
                    + " units of food.");
            tradeB();
          } else if (tradeWaterDecI == 2) {
            tradeB();
          }
        } else if (tradeWaterI < 5) {
          System.out.println(
              "\nBandit Leader: Don't waste my time "
                  + Game.characterName
                  + ". I wouldn't even talk with you for that amount.");
          tradeB();
        }
      } else if (tradeItemsI == 3) {
        System.out.println("\nBandit Leader: You can show yourself out");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("\nYour caravan is heading back to the Federation territory");
        TimeUnit.SECONDS.sleep(8);
      }
    } catch (Exception e) {
      System.out.println("\nPlease input your choice in numeric format and use only integers");
      tradeB();
    }
  }

  public static void tradeO() throws IOException {
    System.out.println("\nWhat do you want to offer: ");
    System.out.println("1) Offer food in exchange for water");
    System.out.println("2) Offer water in exchange for food");
    System.out.println("3) End the trade");
    try {
      String tradeItemsS = reader.readLine();
      int tradeItemsI = Integer.parseInt(tradeItemsS);
      if (tradeItemsI == 1) {
        System.out.println("\nYou have " + federationOriginator.getFood() + " units of food");
        System.out.println("How much you want to offer: ");
        String tradeFoodS = reader.readLine();
        int tradeFoodI = Integer.parseInt(tradeFoodS);
        if (FactionsResources.outcastsFood > 300) {
          System.out.println(
              "\nOutcasts' leader shakes his head. It seem's they have plenty of food");
          TimeUnit.SECONDS.sleep(5);
        } else if (FactionsResources.outcastsFood < 300 && tradeFoodI >= 20) {
          System.out.println("\nOutcasts' leader: We'll offer you 3 units of water for it.");
          TimeUnit.SECONDS.sleep(5);
          System.out.println("1) Confirm\n2) Decline");
          String tradeFoodDecS = reader.readLine();
          int tradeFoodDecI = Integer.parseInt(tradeFoodDecS);
          if (tradeFoodDecI == 1) {
            federationOriginator.setFood(federationOriginator.getFood() - tradeFoodI);
            federationOriginator.setWater(federationOriginator.getWater() + 3);
            federationMemento = federationOriginator.saveToMemento();
            federationCaretaker.addMemento(federationMemento);
            FactionsResources.outcastsFood += tradeFoodI;
            FactionsResources.outcastsWater -= 3;
            System.out.println("\nOutcasts' Leader: Deal.");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(
                "\nYou now have "
                    + federationOriginator.getWater()
                    + " units of water, and "
                    + federationOriginator.getFood()
                    + " units of food.");
            tradeO();
          } else if (tradeFoodDecI == 2) {
            tradeO();
          }
        } else if (tradeFoodI < 19) {
          System.out.println(
              "\nOutcasts Leader: Don't waste my time "
                  + Game.characterName
                  + ". I wouldn't even talk with you for that amount.");
          TimeUnit.SECONDS.sleep(5);
          tradeO();
        }
      } else if (tradeItemsI == 2) {
        System.out.println("\nYou have " + federationOriginator.getWater() + " units of water");
        System.out.println("How much you want to offer: ");
        String tradeWaterS = reader.readLine();
        int tradeWaterI = Integer.parseInt(tradeWaterS);
        if (tradeWaterI >= 3) {
          System.out.println("\nOutcasts' Leader: We'll offer you 30 units of food for it.");
          TimeUnit.SECONDS.sleep(5);
          System.out.println("1) Confirm\n2) Decline");
          String tradeWaterDecS = reader.readLine();
          int tradeWaterDecI = Integer.parseInt(tradeWaterDecS);
          if (tradeWaterDecI == 1) {
            federationOriginator.setFood(federationOriginator.getFood() + 30);
            federationOriginator.setWater(federationOriginator.getWater() - tradeWaterI);
            federationMemento = federationOriginator.saveToMemento();
            federationCaretaker.addMemento(federationMemento);
            FactionsResources.outcastsWater += tradeWaterI;
            FactionsResources.outcastsFood -= 30;
            System.out.println("\nOutcasts' Leader: Deal.");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(
                "\nYou now have "
                    + federationOriginator.getWater()
                    + " units of water, and "
                    + federationOriginator.getFood()
                    + " units of food.");
            tradeO();
          } else if (tradeWaterDecI == 2) {
            tradeO();
          }
        } else if (tradeWaterI < 3) {
          System.out.println(
              "\nOutcasts Leader: Don't waste my time "
                  + Game.characterName
                  + ". I wouldn't even talk with you for that amount.");
          TimeUnit.SECONDS.sleep(5);
          tradeO();
        }
      } else if (tradeItemsI == 3) {
        System.out.println("\nOutcasts' Leader: Get out then");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("\nYour caravan is heading back to the Federation territory");
        TimeUnit.SECONDS.sleep(8);
      }
    } catch (Exception e) {
      System.out.println("\nPlease input your choice in numeric format and use only integers");
      tradeO();
    }
  }

  public static void attackB() throws IOException, InterruptedException {
    System.out.println(
        "\nYou have "
            + federationOriginator.getTroops()
            + ". "
            + "How many guards you want to send?");
    String troopsSendS = reader.readLine();
    int troopsSendI = Integer.parseInt(troopsSendS);
    System.out.println("\nYou send " + troopsSendI + " guards to attack the Bandits...");
    TimeUnit.SECONDS.sleep(5);
    if (troopsSendI < FactionsResources.banditsTroops) {
      System.out.println("\nYour Guard Corps was destroyed");
      TimeUnit.SECONDS.sleep(5);
      federationOriginator.setTroops(federationOriginator.getTroops() - troopsSendI);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
      FactionsResources.banditsTroops -= troopsSendI / 2;
      System.out.println(
          "\nYou now have " + federationOriginator.getTroops() + " units of guards at your base.");
      TimeUnit.SECONDS.sleep(5);
    } else if (troopsSendI > FactionsResources.banditsTroops) {
      System.out.println("\nYou've successfully attacked the Bandits base and destroyed it.");
      TimeUnit.SECONDS.sleep(5);
      System.out.println("\nYou've lost " + troopsSendI / 3 + " guards in the attack.");
      TimeUnit.SECONDS.sleep(5);
      System.out.println("\nYou've recovered some of the Bandit's resources");
      TimeUnit.SECONDS.sleep(5);
      int troopsLost = (int) (troopsSendI / 3);
      federationOriginator.setTroops(federationOriginator.getTroops() - troopsLost);
      federationOriginator.setWater(
          federationOriginator.getWater() + FactionsResources.banditsWater / 3);
      federationOriginator.setFood(
          federationOriginator.getFood() - FactionsResources.banditsFood / 2);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
      FactionsResources.banditsTroops = 0;
      System.out.println(
          "\nYou now have "
              + federationOriginator.getWater()
              + " units of water, and "
              + federationOriginator.getFood()
              + " units of food, and "
              + federationOriginator.getTroops()
              + " units of guards.");
      TimeUnit.SECONDS.sleep(5);
    } else if (troopsSendI >= federationOriginator.getTroops()) {
      System.out.println(
          "\nYou've sent your entire guard corps to attack, while they were away "
              + "you were overrun. You've lost your people and resources.");
      TimeUnit.SECONDS.sleep(5);
      federationOriginator.setTroops(0);
      federationOriginator.setFood(0);
      federationOriginator.setWater(0);
    } else if (Game.accept == 1
        && FactionsResources.banditsTroops > federationOriginator.getTroops()) {
      System.out.println("\nYou successfully raided and destroyed the Bandits.");
      FactionsResources.banditsTroops = 0;
    }
  }

  public static void attackO() throws IOException, InterruptedException {
    System.out.println(
        "\nYou have "
            + federationOriginator.getTroops()
            + ". "
            + "How many guards you want to send?");
    String troopsSendS = reader.readLine();
    int troopsSendI = Integer.parseInt(troopsSendS);
    System.out.println("\nYou send " + troopsSendI + " guards to attack the Outcasts...");
    TimeUnit.SECONDS.sleep(5);
    if (troopsSendI < FactionsResources.outcastsTroops) {
      System.out.println("\nYour troops were destroyed");
      TimeUnit.SECONDS.sleep(5);
      federationOriginator.setTroops(federationOriginator.getTroops() - troopsSendI);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
      FactionsResources.outcastsTroops -= troopsSendI / 2;
      System.out.println(
          "\nYou now have " + federationOriginator.getTroops() + " units of guards at your base.");
      TimeUnit.SECONDS.sleep(5);
    } else if (troopsSendI > FactionsResources.outcastsTroops) {
      System.out.println("\nYou've successfully attacked the Outcasts base and destroyed it.");
      TimeUnit.SECONDS.sleep(5);
      System.out.println("\nYou've lost " + troopsSendI / 4 + " guards in the attack.");
      TimeUnit.SECONDS.sleep(5);
      System.out.println("\nYou've recovered some of the Outcasts' resources");
      TimeUnit.SECONDS.sleep(5);
      int troopsLost = (int) (troopsSendI / 4);
      federationOriginator.setTroops(federationOriginator.getTroops() - troopsLost);
      federationOriginator.setWater(
          federationOriginator.getWater() + FactionsResources.outcastsWater / 3);
      federationOriginator.setFood(
          federationOriginator.getFood() - FactionsResources.outcastsFood / 2);
      federationMemento = federationOriginator.saveToMemento();
      federationCaretaker.addMemento(federationMemento);
      FactionsResources.outcastsTroops = 0;
      System.out.println(
          "\nYou now have "
              + federationOriginator.getWater()
              + " units of water, and "
              + federationOriginator.getFood()
              + " units of food, and "
              + federationOriginator.getTroops()
              + " units of guards.");
      TimeUnit.SECONDS.sleep(5);
    } else if (troopsSendI > federationOriginator.getTroops()) {
      System.out.println(
          "\nYou've sent your entire guard corps to attack, while they were away "
              + "you were overrun. You've lost your people and resources.");
      federationOriginator.setTroops(0);
      federationOriginator.setFood(0);
      federationOriginator.setWater(0);
    }
  }

  public static void attackW() throws IOException, InterruptedException {
    System.out.println(
        "\nYou have "
            + federationOriginator.getTroops()
            + ". "
            + "How many guards you want to send?");
    String troopsSendS = reader.readLine();
    int troopsSendI = Integer.parseInt(troopsSendS);
    System.out.println("\nYou send " + troopsSendI + " guards to attack the Ultra Wealthy...");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "Your guards were destroyed even before they could reach the gates of the Ultra Wealthy territory");
    TimeUnit.SECONDS.sleep(5);
    federationOriginator.setTroops(federationOriginator.getTroops() - troopsSendI);
    federationMemento = federationOriginator.saveToMemento();
    federationCaretaker.addMemento(federationMemento);
    System.out.println(
        "\nYou now have " + federationOriginator.getTroops() + " units of guards at your base.");
    TimeUnit.SECONDS.sleep(5);
    attackedW = 1;
  }
}
