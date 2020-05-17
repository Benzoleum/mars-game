/**
 * Final Project. Abstract Computer class for specific computer players
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */

package edu.bu.met.cs665;

abstract class Computer {
	
	ScavengeBehavior scavengeBehavior;
	TradeBehavior tradeBehavior;
	AttackBehavior attackBehavior;
	
	public Computer(
			ScavengeBehavior scavengeBehavior,
			TradeBehavior tradeBehavior,
			AttackBehavior attackBehavior) {
		
		this.scavengeBehavior = scavengeBehavior;
		this.tradeBehavior = tradeBehavior;
		this.attackBehavior = attackBehavior;
	}
	
	public void scavenge() {
		scavengeBehavior.scavenge();
	}
	
	public void trade() {
		tradeBehavior.trade();
	}
	
	public void attack() throws InterruptedException {
		attackBehavior.attack();
	}
	
	public void setScavengeBehavior(ScavengeBehavior scavengeBehavior) {
		this.scavengeBehavior = scavengeBehavior;
	}
	
	public void setTradeBehavior(TradeBehavior tradeBehavior) {
		this.tradeBehavior = tradeBehavior;
	}
	
	public void setAttackBehavior(AttackBehavior attackBehavior) {
		this.attackBehavior = attackBehavior;
	}
	
	public abstract void display();
}
