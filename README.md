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

When you feel that you are done, depending on how much time you have, you may continue to implement tests until you have
good coverage or look through the TODO in the code (Alt+6 in IntelliJ).
Reflect on which of these TODO hints will now be easier to address compared with before your refactoring work, then try
to implement those features.

Example Data for use in Test cases
----------------------------------

At present the only kind of enemy supported is a RareMob.
This kind of target has one Buff with a soakModifier of 5.0.

Example equipment:

| Where      | What                        | Base Damage | Damage Modifier | Soak |
|------------|-----------------------------|-------------|-----------------|------|
| right hand | Signe's Sonorous Scramaseax | 18          | 3.5             |      |
| left hand  | Harp of the Sanguine Court  | 15          | 3.7             |      |
| head       | Vision of Demonic Synergy   |             |                 | 11   |
| chest      | High Torturer's Smock       |             |                 | 12   |
| feet       | Sandals of Sacred Symmetry  |             |                 | 16   |
| neck       | Charm of Eternal Winter     |             | 2.9             |      |

A character with these items and 18 strength will deal 431 damage to a rare mob wearing a mail armor with 21 soak.

After equipping 2 rings, the damage output will increase to 599.

| Where  | What                     | Base Damage | Damage Modifier | Soak |
|--------|--------------------------|-------------|-----------------|------|
| ring 1 | Miniature Breaking Wheel |             | 2.7             |      |
| ring 2 | Sworn Oath of the Nine   |             | 2.4             |      |
