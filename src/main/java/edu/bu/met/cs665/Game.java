/**
 * Final Project. Game class, where the actual game takes place
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Game extends IntroTutorial {
  protected static String characterName;
  static FederationOriginator federationOriginator =
      new FederationOriginator("Federation", 40, 600, 50);
  static FederationMemento federationMemento = federationOriginator.saveToMemento();
  static FederationCaretaker federationCaretaker = new FederationCaretaker();
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static int accept;
  static Sol s = new Sol();

  public static void main(String[] args) throws IOException, InterruptedException {
    TradeBehavior bt = new BanditsTrade();
    TradeBehavior ot = new OutcastsTrade();
    TradeBehavior ut = new WealthyTrade();
    ScavengeBehavior bs = new BanditsScavenge();
    ScavengeBehavior os = new OutcastsScavenge();
    ScavengeBehavior us = new WealthyScavenge();
    AttackBehavior ba = new BanditsAttack();
    AttackBehavior oa = new OutcastsAttack();
    AttackBehavior ua = new WealthyAttack();
    Computer bandits = new Bandits(bs, bt, ba);
    Computer outcasts = new Outcasts(os, ot, oa);
    Computer wealthy = new UltraWealthy(us, ut, ua);
    intro();
    bandits.scavenge();
    outcasts.trade();
    System.out.println(
        "\nAIVA: Now that I've reminded you the basics, you can try and overtake the Wasteland, Commander");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nAIVA: Couple advice before you proceed: remember not to attack a settlement if they have more troops then you are about to send.");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nAIVA: If you decide to send your Guard Corps to attack someone, be sure not to "
            + "send everyone at once, if there are no guards to protect our people, or there are too few, we'll be overrun and destroyed.");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "\nAIVA: If you loose all your food or water, your people will suffer the consequences.");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nAIVA: One last piece of advise, don't bother yourself with talking to the Ultra Wealthy, they haven't been willing to talk all these years,"
            + "I doubt they will start a dialogue now.");
    TimeUnit.SECONDS.sleep(5);
    while (federationOriginator.getWater() != 0
        || federationOriginator.getFood() != 0
        || federationOriginator.getTroops() != 0) {
      s.playerTurn();
      if (FactionsResources.banditsTroops > 0) {
        bandits.attack();
        bandits.trade();
        bandits.scavenge();
      }
      if (FactionsResources.outcastsTroops > 0) {
        outcasts.attack();
        outcasts.trade();
        outcasts.scavenge();
      }
      wealthy.attack();
      if (federationOriginator.getTroops() <= 45
          && federationOriginator.getTroops() > 0
          && Sol.attackedW <= 0) {
        System.out.println(
            "\nAIVA: Commander, we have a delegation from the Ultra Wealthy, it seems they have some proposition for you");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nAIVA: Do you want to hear it out?\n1) Yes\n2) No");
        System.out.println("\nYour choice: ");
        String wealthyAcceptS = reader.readLine();
        int wealthyAccept = Integer.parseInt(wealthyAcceptS);
        if (wealthyAccept == 1) {
          TimeUnit.SECONDS.sleep(4);
          System.out.println(
              "\nDelegation Leader: Good to see you, Commander " + characterName + ".");
          TimeUnit.SECONDS.sleep(4);
          System.out.println("\nDelegation Leader: We have a proposition for you.");
          TimeUnit.SECONDS.sleep(4);
          System.out.println(
              "\nDelegation Leader: We are willing to provide you with 45 of our finest fighters.");
          TimeUnit.SECONDS.sleep(4);
          System.out.println("\nDelegation Leader: In exchange you need to destroy the Bandits...");
          TimeUnit.SECONDS.sleep(4);
          System.out.println("\nDelegation Leader: Do you accept our offer?");
          TimeUnit.SECONDS.sleep(4);
          System.out.println("\nAccept:\n1) Yes\n2) No");
          System.out.println("Your choice: ");
          String acceptS = reader.readLine();
          accept = Integer.parseInt(acceptS);
          if (accept == 1) {
            System.out.println("\nDelegation Leader: Wise choice Commander, we will talk soon");
            TimeUnit.SECONDS.sleep(4);
            federationOriginator.setTroops(federationOriginator.getTroops() + 45);
            federationMemento = federationOriginator.saveToMemento();
            federationCaretaker.addMemento(federationMemento);
            System.out.println(
                "\nYou now have " + federationOriginator.getTroops() + " units of troops.");
            TimeUnit.SECONDS.sleep(4);
          } else {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("\nDelegation Leader: You had your chance, Commander...");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("\nThe delegation leaves the Federation territory");
          }
        } else {
          TimeUnit.SECONDS.sleep(4);
          System.out.println("\nDelegation Leader: You had your chance, Commander...");
          TimeUnit.SECONDS.sleep(4);
          System.out.println("\nThe delegation leaves the Federation territory");
        }
      }
      if (federationOriginator.getWater() <= 0) {
        System.out.println(
            "\nAIVA: You lost all your water, Commander. People are dying of famine...");
        TimeUnit.SECONDS.sleep(4);
        break;
      } else if (federationOriginator.getFood() <= 0) {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nAIVA: We've lost all our food, Commander, people are starving...");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nAIVA: Your settlement starved to death");
        break;
      } else if (federationOriginator.getTroops() <= 0) {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nAIVA: You lost all your guards, Commander...");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nThere were no one to protect your resources and people...");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nYou were overrun and destroyed...");
        break;
      }
    }
  }

  public static void firstTurn() throws IOException, InterruptedException {
    System.out.println("\nWho do you want to reckon on?");
    System.out.println("1) Bandits");
    System.out.println("Your choice: ");
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String turn1 = reader.readLine();
      int turn1i = Integer.parseInt(turn1);
      while (turn1i != 1) {
        System.out.println("Please choose the Bandits, Commander");
        System.out.println("\nWho do you want to reckon on?");
        System.out.println("1) Bandits");
        System.out.println("Your choice: ");
        turn1 = reader.readLine();
        turn1i = Integer.parseInt(turn1);
      }
    } catch (Exception e) {
      System.out.println("Please choose Bandits ");
      firstTurn();
    }
    System.out.println("\n\nYou command to dispatch a reckon party to spy on Bandits.");
    TimeUnit.SECONDS.sleep(3);
    System.out.println("\nReckon party is gathering intel");
    TimeUnit.SECONDS.sleep(10);
    System.out.println("\nCommander, here's what the reckon party found: ");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nThe Bandits have "
            + FactionsResources.banditsFood
            + " units "
            + "of food, "
            + FactionsResources.banditsWater
            + " units "
            + "of water, and "
            + FactionsResources.banditsTroops
            + " units of troops.");
    federationOriginator.setWater(federationOriginator.getWater() - 2);
    federationOriginator.setFood(federationOriginator.getFood() - 10);
    federationMemento = federationOriginator.saveToMemento();
    federationCaretaker.addMemento(federationMemento);
    System.out.println("\nYou've used 2 units of water\nYou've used 10 units of food.");
    System.out.println(
        "\nYou now have "
            + federationOriginator.getWater()
            + " units of water, and "
            + federationOriginator.getFood()
            + " units of food.");
    TimeUnit.SECONDS.sleep(4);
    System.out.println(
        "\nAIVA: Good, this tells us that the Bandits are much more powerful than us, so "
            + "it would be unwise to attack them. However, they are short on food and water, so we "
            + "can use that information to our advantage. Notice, that you've lost some amount of "
            + "your precious resources, but not to worry, reckon plays essential part in overcoming"
            + " your rivals.");
    TimeUnit.SECONDS.sleep(10);
    System.out.println("\nAIVA: That's all we can do in one sol.");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nAIVA: We have watchtowers located across the Wasteland, they will spot the activity of rival factions");
    TimeUnit.SECONDS.sleep(4);
    System.out.println("\nAIVA: Let's wait and see what others did with their time");
  }
}
