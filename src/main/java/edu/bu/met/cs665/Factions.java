/**
 * Final Project. Factions which extend the Computer class
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

class Bandits extends Computer {

  public Bandits(
      ScavengeBehavior scavengeBehavior,
      TradeBehavior tradeBehavior,
      AttackBehavior attackBehavior) {
    super(scavengeBehavior, tradeBehavior, attackBehavior);
  }

  public void display() {
    System.out.printf("\nBandits' sol: ");
  }
}

class Outcasts extends Computer {

  public Outcasts(
      ScavengeBehavior scavengeBehavior,
      TradeBehavior tradeBehavior,
      AttackBehavior attackBehavior) {
    super(scavengeBehavior, tradeBehavior, attackBehavior);
  }

  public void display() {
    System.out.printf("\nOutcasts sol: ");
  }
}

class UltraWealthy extends Computer {

  public UltraWealthy(
      ScavengeBehavior scavengeBehavior,
      TradeBehavior tradeBehavior,
      AttackBehavior attackBehavior) {
    super(scavengeBehavior, tradeBehavior, attackBehavior);
  }

  public void display() {
    System.out.printf("\nWealthy's sol: ");
  }
}
