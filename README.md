![Test Status](../../workflows/test/badge.svg)

Fantasy Battle Kata
===============================

This code is part of a larger fantasy battle game. 
Players in the game will fight monsters using the equipment they are wearing. 
The type of equipment will affect how much damage they do to the monsters. 
Monsters also vary according to what armour and equipment they are wearing. 
This part of the code is concerned with calculating how much damage the player is doing to a monster when they fight.

The kata is designed to teach you something about the [Law of Demeter](https://en.wikipedia.org/wiki/Law_of_Demeter). 
The 'Player' class perhaps doesn't follow this law very well.

Try to write a test for the method 'calculateDamage' on the Player class, without changing any of the production code. 
Use the description below to help you design a test scenario. 
Note there are two example test cases to start from. 
Choose the one you prefer. 
Give yourself a time box of 10 minutes, then reflect on why this method is hard to test.

When you have reflected, you should refactor the 'calculateDamage' method to better follow the Law of Demeter. 
Also add test cases to cover the functionality in the Player class.

When you feel that you are done, depending on how much time you have, you may continue to implement tests until you have good coverage or look through the TODO in the code (Alt+6 in IntelliJ). 
Reflect on which of these TODO hints will now be easier to address compared with before your refactoring work, then try to implement those features.

Example Data for use in Test cases
----------------------------------

Example equipment:

| Where      | What                        | Base Damage | Damage Modifier |
|------------|-----------------------------|-------------|-----------------|
| right hand | Signe's Sonorous Scramaseax | 10          | 1.0             |
| left hand  | Harp of the Sanguine Court  | 0           | 1.4             |
| feet       | Sandals of Sacred Symmetry  | 0           | 0.1             |
| head       | Vision of Demonic Synergy   | 0           | 1.2             |
| chest      | High Torturer's Smock       | 0           | 1.4             |

At present the only kind of enemy supported is a SimpleEnemy. 
This kind of target has one Buff with a soakModifier of 1.0 and damage modifier of 1.0. 
It wears an Armor with a Damage Soak of 5.
