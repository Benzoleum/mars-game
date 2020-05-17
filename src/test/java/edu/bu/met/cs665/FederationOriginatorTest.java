/**
 * Final Project. FederationOriginatorTest for testing the memento pattern
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

import org.junit.Test;

public class FederationOriginatorTest {

  @Test
  public void testMemento() throws Exception {
    FederationOriginator federationOriginator = new FederationOriginator("Federation", 40, 600, 50);

    FederationMemento federationMemento = federationOriginator.saveToMemento();
    FederationCaretaker federationCaretaker = new FederationCaretaker();
    federationCaretaker.addMemento(federationMemento);
    System.out.println("\nOriginal FederationOriginator");
    federationOriginator.printInfo();

    System.out.println("\nFederationOriginator after updating water units: ");
    federationOriginator.setWater(60);
    federationMemento = federationOriginator.saveToMemento();
    federationCaretaker.addMemento(federationMemento);
    federationOriginator.printInfo();

    System.out.println("\nFederationOriginator after updating troops units: ");
    federationOriginator.setTroops(45);
    federationMemento = federationOriginator.saveToMemento();
    federationCaretaker.addMemento(federationMemento);
    federationOriginator.printInfo();

    System.out.println("\nFederationOriginator after undoing troops units update");
    federationMemento = federationCaretaker.getMemento();
    federationOriginator.undoFromMemento(federationMemento);
    federationMemento = federationCaretaker.getMemento();
    federationOriginator.undoFromMemento(federationMemento);
    federationOriginator.printInfo();

    System.out.println("\nOriginal FederationOriginator after undoing water units update");
    federationMemento = federationCaretaker.getMemento();
    federationOriginator.undoFromMemento(federationMemento);
    federationOriginator.printInfo();
  }
}
