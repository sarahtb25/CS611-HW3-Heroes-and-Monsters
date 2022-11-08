# CS611-HW3
## Legends: Monsters and Heroes
---------------------------------------------------------------------------
Sarah Taaher Bonna
sbonna@bu.edu
U86084310

## Files
---------------------------------------------------------------------------
1. Armor.java: Represents an armor, a type of Equippable item
2. ArmorFactory.java: Represents all possible armors
3. Battle.java: An interface that contains the method that is needed in all battles
4. Board.java: Represents a board used in a board game
5. BoardGame.java: An abstract class that defines what a Board Game in general needs
6. Cell.java: Represents a cell in a board
7. CommonPiece.java: A Monsters and Heroes game piece that is used to represent a cell as a Common Area,
   where a battle may take place depending on the player's luck
8. ConsumableItem.java: Represents an item that can be consumed, such as a potion or a spell.
   Consumable items cannot be sold.
9. Dragon.java: Represents a dragon, a type of Monster
10. DragonFactory.java: Represents all possible dragons
11. EquippableItem.java: Represents items that can be worn or carried, such as a weapon or an armor
12. Exoskeleton.java: Represents an exoskeleton, a type of Monster
13. ExoskeletonFactory.java: Represents all possible exoskeletons
14. Fighters.java: Represents the fighters (Monster and Hero) in a battle
15. FireSpell.java: Represents a fire spell, a type of spell
16. Game.java: An interface that represents the behaviour of a game
17. GenerateHeroes.java: This class generates heroes in a balanced manner according to the number of heroes wanted by player
18. GenerateMonsters.java: This class generates monsters as needed for a cell
19. Help.java: An interface that contains expected behaviour for a game help
20. Hero.java: Represents a hero, a type of NonPlayerCharacter (a character that is not a player) of Monsters and Heroes
21. Heroes.java: Represents a list of heroes
22. HeroFactory.java: An interface that represents the expected behaviour of factories that will generate the various types of heroes 
    e.g. Warrior, Sorcerer and Paladin
23. IceSpell.java: Represents a fire spell, a type of spell
24. InvalidPiece.java: A Monsters and Heroes game piece that is used to represent a cell is invalid
25. Inventory.java: Represents a hero's inventory, which keeps track of the weapons, armors, potions and spells a hero has
26. Item.java: Represents an item that a hero can use in battle, e.g. weapon, armor, spell and potion
27. ItemFactory.java: An interface that contains the expected behaviour for all item factories e.g. WeaponFactory, etc.
28. LightningSpell.java: Represents a Lightning Spell, a type of spell
29. Main.java: The game launcher
30. Market.java: Represents a market
31. MarketPiece.java: A Monsters and Heroes game piece that is used to represent a cell that has a market
32. MHBattle.java: Represents a battle between a hero and a monster in the Monsters and Heroes game
33. MHBoard.java: Represents the board used in Monsters and Heroes
34. MHBoardGame.java: Represents the Monsters and Heroes game logic
35. MHHelp.java: Outlines the rules and help for Monsters and Heroes
36. MHPiece.java: Represents a Monsters and Heroes game piece
37. MHPlayer.java: Represents a Monster and Hero Player, a type of game player
38. MHRoundHistory.java: To display the scores of a round of Monsters and Heroes
39. MHStatistics.java: To display the scores of each round after a player chooses to quit the game
40. MHUtility.java: Contains methods that are used across different classes in the game
41. Monster.java: Represents a monster, a type of NonPlayerCharacter (a character that is not a player) of Monsters and Heroes
42. MonsterFactory.java: An interface that represents the expected behaviour of factories that will generate the various types of monsters
    e.g. Dragon, Exoskeleton and Spirit
43. Monsters.java: Represents monsters in a common piece
44. NonPlayerCharacter: This class represents any character that is not a player.
    e.g. in Monsters and Heroes, Monsters and Heroes are the non player characters
45. Paladin.java: Represents a paladin, a type of Hero
46. PaladinFactory.java: Represents all possible paladins
47. Piece.java: Represents a game piece
48. Player.java: Represents a general game player
49. Potion.java: Represents a potion, a type of ConsumableItem
50. PotionFactory.java: Represents all possible potions
51. RoundHistory.java: An interface that contains the expected behaviour of what a class implementing RoundHistory should do 
    i.e. what methods are needed to keep track of the scores in each round
52. Sorcerer.java: Represents a sorcerer, a type of Hero
53. SorcererFactory.java: Represents all possible sorcerers
54. Spell.java: Represents a spell, a type of ConsumableItem
55. SpellFactory.java: Represents all possible spells
56. Spirit.java: Represents a spirit, a type of Monster
57. SpiritFactory.java: Represents all possible spirits
58. Statistics.java: An interface that contains the expected behaviour of how the scores of each round should be handled
59. Utility.java: An interface containing the method that is used often
60. Warrior.java: Represents a warrior, a type of Hero
61. WarriorFactory.java: Represents all possible warriors
62. Weapon.java: Represents a weapon, a type of EquippableItem
63. WeaponFactory.java: Represents all possible weapons

## Notes
---------------------------------------------------------------------------
1. Bonus Done
   (a) Potions and Spells are multi-use items.
   (b) Monsters and Heroes can be played for multiple rounds. 
2. Please maximize terminal screen before playing. This game has been developed and tested using Java 8.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "HW3" after unzipping the files
2. Run the following instructions:
   javac -d out src/*.java
   java -cp out Main

## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>
e.g.:
Output:
Welcome to Tic-Tac-Toe!
Please enter player 1's name:
Input: Alex
Output:
Please enter player 2's name:
Input: Bob
Output:
Please enter the size of the board:
Input: 3
Output:
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
Alex please make a move:
Input: 1,2
Output:
+--+--+--+
|  |  |  |
+--+--+--+
|X |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
.
.
.
+--+--+--+
|X |  |  |
+--+--+--+
|X |O |  |
+--+--+--+
|X |O |  |
+--+--+--+
Alex wins! Would you like to play again?
Input: no
Output:
Thank you for playing!
Alex won 1 time.
Bob won 0 times.
There were 0 stalemates.