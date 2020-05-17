 > **Nikita Kozino**   
 >    
 >  __Mars__   
 >  
 >  A little game I wrote as a final project for Software Patterns and Design class. The goal of the game is to be "the last man standing" and be the sole ruler of Mars. I thought it can be an interesting experience for some during the lockdown, and I sure enjoyed creating it.
 > 
 >  I implemented a momento pattern, which allows to restore the state of an object, and acts as a sort of a checkpoint or save mechanic in the game. I implemented it in FederationOriginator, FederationMemento, and FederationCaretaker classes. Any time a player's state changes (player lost food or water), it records it in a memento, which can be later restored and updated.
> 
>   Another pattern that made my work a little easier is a strategy pattern, which allowed me to create interfaces of behavior, which allowed me, and would allow me in the future, shall I decide to work on the game some more, to alter the behavior of the application without changing it's architecture. I implemented the strategy pattern in ScavengeBehavior, AttackBehavior, and TradeBehavior interfaces. The strategy pattern would allow me to add more functionality to the program, without me having to create many subclasses and duplicate the code. Also, I can change the of an algorithm, without changing the Computer class.
