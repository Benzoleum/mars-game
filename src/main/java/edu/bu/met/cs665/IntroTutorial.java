/**
 * Final Project. IntroTutorial class, which introduces a player to the game story and it's
 * mechanics.
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

public class IntroTutorial {

  public static void intro() throws IOException, InterruptedException {
    System.out.println("Mars");
    TimeUnit.SECONDS.sleep(3);
    System.out.println();
    System.out.println("A game by Nikita Kozino");
    TimeUnit.SECONDS.sleep(3);
    System.out.println();
    System.out.println(
        "Distant future. The Earth has been destroyed and abandoned long ago. A handful of lucky "
            + "colonizers known as the Federation inhabited Mars. "
            + "They lived in peace for some time, but as time went by, groups of people started to "
            + "separate themselves from the Federation and establishing their own communities. "
            + "The Federation was separated into 4 groups, the event that was called The Great Divide. "
            + "You are the leader of one of the factions: ");
    TimeUnit.SECONDS.sleep(15);
    System.out.println(
        "\n\n 1) Federation:\nWhat's left of once great, vast colony that first inhabited the Mars. "
            + "Brightest minds, capable of farming in the harsh environment of the planet. Natural born "
            + "diplomats and engineers. But aren't properly armed and are lacking security.");
    TimeUnit.SECONDS.sleep(15);
    System.out.println(
        "\n\n 2) Outcasts: \nMarginals whose views did not coincide with the views of the leaders"
            + " of the late Federation. People who were among the first to separate from the Federation."
            + " Some say anarchists, some say terrorists. They believed that in order to survive the Federation "
            + "needed to be a dictatorship with strict rules and harsh punishments. They are smart, armed, "
            + "and follow a strict chain of command.");
    TimeUnit.SECONDS.sleep(15);
    System.out.println(
        "\n\n 3) Bandits: \nSince the very inception of the human race, there are those who "
            + "cannot and will not abide by the rules. Escaping the Federation prison, ex-inmates "
            + "founded their own community on the outskirts of Federation territory. Armed, fearless,"
            + " and not very keen on dialogue.");
    TimeUnit.SECONDS.sleep(15);
    System.out.println(
        "\n\n 4) Ultra wealthy: \nWhen you have virtually infinite amount of wealth, "
            + "you tend to stick with people of your social status. The wealthy founded their own little"
            + " paradise on Mars. Living basically next to the water refinery, the Ultra-Wealthy posses "
            + "the most important resource of all on Mars - water. Guarded by security, enjoying"
            + " delicacies and vintage wines, these people will talk only if you have something "
            + "to offer.");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    TimeUnit.SECONDS.sleep(20);
    System.out.println(
        "\n\nChoose the faction you want to play for: "
            + "\n\n 1) Federation: "
            + "\n Perks: Farms (provide food), diplomats (other factions will trade with you for "
            + "less)"
            + "\n Drawback: Very few troops."
            + "\n Unique perk: Reckon (spy on how other factions are doing)"
            + "\n\n 2) Outcasts: "
            + "\n Perks: Strategists (higher chance of successful attacks), armed (weapons)"
            + "\n Drawback: Lacking resources (food and water)."
            + "\n Unique perk: Infiltrate (can steal resources from other factions unnoticed)"
            + "\n\n 3) Bandits: "
            + "\n Perks: Heavily armed and protected."
            + "\n Drawback: Lacking diplomacy skills."
            + "\n Unique perk: Fearless (higher chance of successful attack)"
            + "\n\n 4) Ultra wealthy: "
            + "\n Perks: Abundant resources (food and water), guarded (prone to attacks)."
            + "\n Drawbacks: Bad strategists (lower chance of successful attacks and resource "
            + "acquisition)."
            + "\n Unique perk: Water plant (+50 water immediately when it falls below 10)");
    System.out.println(
        "\n\n Press 1 to play as Federation"
            + "\n Press 2 to play as Outcasts"
            + "\n Press 3 to play as Bandits"
            + "\n Press 4 to play as Ultra wealthy");
    System.out.println("\nYour choice: ");
    try {
      String factionS = reader.readLine();
      int faction = Integer.parseInt(factionS);
      while (faction != 1) {
        System.out.println("Sorry, you can only play as the Federation right now");
        factionS = reader.readLine();
        faction = Integer.parseInt(factionS);
      }
    } catch (Exception e) {
      System.out.println("Please enter your choice in numeric form");
      intro();
    }
    System.out.println("You chose to play as Federation");
    System.out.println("Choose a name for your character: ");
    String characterNames = reader.readLine();
    Game.characterName = characterNames;
    IntroTutorial.introFederation();
    IntroTutorial.fedTutorial();
  }

  public static void introFederation() throws InterruptedException {
    System.out.println("\nAIVA: Welcome to Mars, Commander " + Game.characterName + ".");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "AIVA: I am Automated Interplanetary Virtual Assistant. "
            + "AIVA. I'll help you get up to date with the current situation on Mars.");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "\nAIVA: As you know, resources are everything on Mars, "
            + "those who posses the most resources will control the planet.");
    TimeUnit.SECONDS.sleep(5);
    System.out.println("\nThe most important resource of all is water.");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nAIVA: Federation currently holds "
            + Game.federationOriginator.getWater()
            + " units of water.");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "\nAIVA: Our warehouses are stocked with food, thanks to our farms. The federation currently holds "
            + Game.federationOriginator.getFood()
            + " units of food in it's warehouses.");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "\nEach day our food supplies will grow by additional 10 tons thanks to our farms.");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "\nAIVA: But we do not have access to water refinery plant controlled by the ultra wealthy, "
            + "which is the biggest problem for the Federation.");
    TimeUnit.SECONDS.sleep(5);
    System.out.println(
        "\nAIVA: Next most important thing on Mars are armed forces. The Federation can provide you with "
            + Game.federationOriginator.getTroops()
            + " units of guards.");
    TimeUnit.SECONDS.sleep(6);
    System.out.println(
        "\nAIVA: You can send the guards to acquire resources and attack other settlements. Remember, "
            + "to choose your targets wisely, some of them are much better armed and trained, so a "
            + "dialogue may be a better option.");
    TimeUnit.SECONDS.sleep(7);
    System.out.println(
        "\nAIVA: Remember, if either of these resources falls below zero, the colony will starve to death "
            + "or it will be attacked and destroyed.");
    TimeUnit.SECONDS.sleep(7);
  }

  public static void fedTutorial() throws InterruptedException, IOException {
    System.out.println(
        "\nAIVA: Commander, as you know, what we used to call day on Earth"
            + " is called sol here on Mars, and  being your assistant, I will guide you through "
            + "each sol and present you with different actions that you can take that will impact "
            + "the Federation.");
    TimeUnit.SECONDS.sleep(8);
    System.out.println("\nLet me show you how it works...");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nAIVA: Each sol you and the leaders of other factions are presented with choices: ");
    TimeUnit.SECONDS.sleep(3);
    System.out.println("\n1) Scavenging");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nIf you choose scavenging, some of the guards will leave the territory "
            + "of the colony and go gather resources. They may bring water, food, and sometimes "
            + "weapons left behind by other scavengers. Sometimes your guards might be attacked and "
            + "they won't return at all.");
    TimeUnit.SECONDS.sleep(15);
    System.out.println("\n2) Trade");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nIf you choose trade, you can choose with which faction you want to trade"
            + " with. After you chose the faction, a guarded caravan will depart from the colony. "
            + "As soon as they arrive at their destination, you will be connected with the leader of"
            + " the faction and discuss the terms of the barter. Be wise about who you are trying "
            + "to trade with, some of them aren't that willing to talk, and might harm or destroy your "
            + "caravan.");
    TimeUnit.SECONDS.sleep(15);
    System.out.println("\n3) Attack");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nThe Federation lost it's firepower after the Great Divide, but there are "
            + "still those who would blindly follow your orders. Shall you decide that it is time "
            + "to attack other factions, you will have to determine how many guards to send to attack "
            + "others. Remember, they are guards after all, they are not trained in warfare arts, so "
            + "be extra careful.");
    TimeUnit.SECONDS.sleep(15);
    System.out.println("\n4) Reckon");
    TimeUnit.SECONDS.sleep(3);
    System.out.println(
        "\nAlthough, our colony isn't as powerful as it used to be, other factions "
            + "have no idea that we have a special reckon team that can spy unnoticed on other factions. "
            + "Should you choose that option, you will be presented with a choice on which faction to spy."
            + " After that, a reckon party will be sent to gather intel on the faction, providing "
            + "us with information about their resources and firepower. It will be especially useful "
            + "shall you wish to attack other factions.");
    TimeUnit.SECONDS.sleep(15);
    System.out.println(
        "\n\nAIVA: Let's start this sol with the latter. Send a reckon party to gather "
            + "intel about the bandits.");
    Game.firstTurn();
  }
}
