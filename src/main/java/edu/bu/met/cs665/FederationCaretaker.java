/**
 * Final Project. FederationCaretaker class for the Memento pattern, which gets and adds the memento
 *
 * @author Nikita Kozino
 * @email kozino@bu.edu
 * @version 1.0
 * @since 2020-04-15
 */
package edu.bu.met.cs665;

import java.util.ArrayDeque;
import java.util.Deque;

public class FederationCaretaker {
  final Deque<FederationMemento> mementos = new ArrayDeque<>();

  public FederationMemento getMemento() {
    FederationMemento federationMemento = mementos.pop();
    return federationMemento;
  }

  public void addMemento(FederationMemento memento) {
    mementos.push(memento);
  }
}
