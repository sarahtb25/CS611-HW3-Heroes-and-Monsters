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
17. GenerateHeroes.java: This class generates heroes in a balanced manner according to the number of heroes
    wanted by player
18. GenerateMonsters.java: This class generates monsters as needed for a cell
19. Help.java: An interface that contains expected behaviour for a game help
20. Hero.java: Represents a hero, a type of NonPlayerCharacter (a character that is not a player) of
    Monsters and Heroes
21. Heroes.java: Represents a list of heroes
22. HeroFactory.java: An interface that represents the expected behaviour of factories that will generate
    the various types of heroes e.g. Warrior, Sorcerer and Paladin
23. IceSpell.java: Represents a fire spell, a type of spell
24. InvalidPiece.java: A Monsters and Heroes game piece that is used to represent a cell is invalid
25. Inventory.java: Represents a hero's inventory, which keeps track of the weapons, armors, potions and spells
    a hero has
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
41. Monster.java: Represents a monster, a type of NonPlayerCharacter (a character that is not a player) of
    Monsters and Heroes
42. MonsterFactory.java: An interface that represents the expected behaviour of factories that will generate
    the various types of monsters e.g. Dragon, Exoskeleton and Spirit
43. Monsters.java: Represents monsters in a common piece
44. NonPlayerCharacter: This class represents any character that is not a player.
    e.g. in Monsters and Heroes, Monsters and Heroes are the non player characters
45. Paladin.java: Represents a paladin, a type of Hero
46. PaladinFactory.java: Represents all possible paladins
47. Piece.java: Represents a game piece
48. Player.java: Represents a general game player
49. Potion.java: Represents a potion, a type of ConsumableItem
50. PotionFactory.java: Represents all possible potions
51. RoundHistory.java: An interface that contains the methods needed to keep track of the scores in each round
52. Sorcerer.java: Represents a sorcerer, a type of Hero
53. SorcererFactory.java: Represents all possible sorcerers
54. Spell.java: Represents a spell, a type of ConsumableItem
55. SpellFactory.java: Represents all possible spells
56. Spirit.java: Represents a spirit, a type of Monster
57. SpiritFactory.java: Represents all possible spirits
58. Statistics.java: An interface that contains the expected behaviour of how the scores of each round
    should be handled
59. Utility.java: An interface containing the method that is used often
60. Warrior.java: Represents a warrior, a type of Hero
61. WarriorFactory.java: Represents all possible warriors
62. Weapon.java: Represents a weapon, a type of EquippableItem
63. WeaponFactory.java: Represents all possible weapons
64. ConsoleColours.java: To modify the colours of command prompt/terminal when printing
    Obtained from: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

## Notes
---------------------------------------------------------------------------
1. Bonus Done
   (a) Potions and Spells are multi-use items.
   (b) Monsters and Heroes can be played for multiple rounds.
   (c) The number of battles and the number of monsters by each hero in each round is tracked and printed
       when the player quits the game.
   (d) Added colours to board to distinguish the different types of pieces and messages shows to player.
   (e) Used Singleton Pattern for the Monsters and Heroes game logic.
   (f) Used Factory Design Pattern for generating the various monsters and heroes.
   (g) Player can regenerate the map if they are not happy with their current map at any point.
2. Please maximize terminal screen before playing. This game has been developed and tested using Java 8.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "HW3" after unzipping the files
2. Run the following instructions:
   javac -d out src/*.java
   java -cp out Main

## Input/Output Example
---------------------------------------------------------------------------
Output:
#########################################################################
|                          MONSTERS AND HEROES                          |
#########################################################################

A long time ago, the villagers of Lockwood were living a peaceful when one day, their village was overtaken by
monsters. The monsters were tyrants and destroyed their village. With nowhere to go, they retreated into the pockets of
magical forest that stood even after the monsters attacked. The forest gave them protection, with its magic hiding the
villagers from the monsters. The invalid areas in the map represent the pockets of magical forest, which keeps out
everything and everyone. However, they are not safe. The monsters have been slowly weakening the magical forest,
with the aim of eradicating every single villager.

Will you rise up to the challenge and help the villagers of Lockwood free themselves from the monsters' tyranny? Will
you help protect the magical forest from its slow death? If you and your heroes defeat all 100 monsters,
you will succeed.

Good luck!

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
---------------------------------------------------------------------------
|                                   RULES                                  |
---------------------------------------------------------------------------

*****************
|   Map Rules   |
*****************

1.  The map contains three types of spaces:
    (a) Inaccessible spaces, which the heroes cannot enter
    (b) Market spaces, where items can be bought or sold
    (c) Common spaces, where battles can occur
        - There is a chance that your heroes will engage in a battle in this space with the monsters
        - Battles are always 1-on-1
        - You will only know if there will be a battle once you enter a Common space
        - Only heroes who are alive i.e. have hit points > 0 will have to battle a monster
        - The monsters the heroes will have to fight will be completely random, and does not depend on the hero's level
2.  The game ends if:
    (1) all heroes are unconscious, or
    (2) all the heroes are able to defeat 100 monsters
3.  You can provide the following commands (Not case-sensitive):
    (1) W/w: Move up
    (2) A/a: Move left
    (3) S/s: Move down
    (4) D/d: Move right
    (5) Q/q: Quit game
    (6) I/i: Show information about the heroes
    (7) M/m: When in a place that has a Market, use M/m to go to the market
    (8) H/h: To view possible commands while using the map
    (9) R/r: To view the rules of the map
    (10) View Map: To view the map
    (11) <Hero ID> Inventory: To view the inventory of a hero e.g. R0 Inventory
    (12) <Hero ID> drink <Potion ID>: To get a hero to consume a potion e.g. R0 drink P0
    (13) Hero <Hero ID>: To view the e.g. Hero R0
    (14) Regenerate Map: To create a new map e.g. if you are stuck, or just don't like the map you have
    (15) <Hero ID> change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing
    e.g. R0 change B0
    To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
    comma-separated manner e.g. R0 change B0,E0


[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Battle Rules   |
********************

1.  This is a turn-based battle, where the heroes make a move first, followed by the monster
2.  The battle is 1-on-1 i.e. one hero vs one monster
3.  The battle ends when
    (1) the hero runs out of hit points, or
    (2) the monster runs out of hit points
4.  Possible commands to use in battle (Not case-sensitive):
    (1) Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
        The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
        the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
        inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
        comma-separated manner e.g. R0 change B0,E0
    (2) Hit: To hit the monster with the weapon the hero is carrying
    (3) Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    (4) I/i: To view the details of the hero and the monster engaged in battle (Will not lose a turn)
    (5) Q/q: To quit the game
    (6) H/h: To view possible commands for battle (Will not lose a turn)
    (7) R/r: To view the rules of battle (Will not lose a turn)
5.  Commands that do not have (Will not lose a turn) means that if the item ID given does not exist,
    the hero loses a turn.
6.  The monsters will only attack the heroes, as they do not have items or spells to use.
7.  Heroes have a dodge chance that will allow them to occasionally avoid taking damage from a monster's attack.
    If the dodge chance >= monster's attack, then the monster's attack is dodged. Otherwise, the hero gets the full
    brunt of the monster's attack - defence provided by the hero's armor (if any).

    Hero's dodge chance = hero's agility * 0.2

8.  Similarly, monsters also have a dodge chance that will allow them to occasionally avoid taking damage from
    a hero's attack. If the dodge chance >= hero's attack, then the hero's attack is dodged. Otherwise, the monster
    gets the full brunt of the hero's attack - monster's defence.

    Monster's dodge points = monster's dodge chance * 0.1

9.  When a monster is unable to dodge the hero's spell, the monster faces a loss in skill. The skill affected
    depends on the type of spell used.
    The types of spell and their effects are:
    (1) Ice spell: reduces the amount of damage the monster can cause
    (2) Fire spell: reduces the defense of the monster
    (3) Lightning spell: reduces the dodge chance of the monster

    Skill left after getting hit by spell = (damage or defence or dodge chance, depending on type of spell) * 0.9

10. If a hero wins the battle, the hero gains 10% of their starting hit point and mana. They also get money and
    experience points.

    Money gained = Monster level * 100
    Experience gained = 20 * number of monster in battle, which is 1

11. Heroes are able to level up. Once they level up, their hit points, mana and experience level increases.
    When a hero levels up all of their skills increase by 5% and their favored skills increase by an extra 5%.

    Experience points needed to level up = Hero's current level * 10
    Hero's hit point = hero's current level * 100
    Hero's mana after level up = Hero's mana before level up * 1.1
    Hero's experience level after level up = Hero's experience level before level up + 1

12. After all the heroes who were able to battle have battled a monster, if the number of heroes who won is more
    than the number of monsters, then heroes who fainted in battle are revived. They gain back 50% of
    their starting hit points and their mana. However, they do not get any gold or experience.
    Those who did not faint gain back 10% of their starting hit points and mana.



[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
--------------
|   Heroes   |
--------------

1. A hero has several attributes:
   (1) A name
   (2) A level with an amount of experience points
   (3) HP (hit points, the hero's in battle)
   (4) MP (mana or magic points, for casting spells)
   (5) A strength value
   (6) A dexterity value
   (7) An agility value
   (8) An amount of gold
   (9) An inventory of items
   (10) The weapon and/or armor they have on them

2.  A hero has a level, representing how strong (or not) that hero is. Experience points determine the hero's level.
    A hero levels up after accumulating enough experience points. A hero's skills increase when the hero levels up.
    A hero never loses experience. It accumulates over the course of the game.
3.  HP (hot point): HP is the hero's current health. The initial HP value is determined by hero's level.

    Hero's hit points = Hero's current level * 100

    When a hero levels up, they have their HP set according to the same formula.

4.  MP: MP (or mana) is used to cast spells.
5.  Strength: A hero's strength increases the amount of damage they deal when using a weapon.
6.  Dexterity: A hero's dexterity increases the amount of damage they deal when casting a spell.
7.  Agility: A hero's agility increases their chance to dodge a monster's attack.
8.  Money: Money is for use in the market.
9.  Inventory. A hero has a collection of items that they have bought during the game. At the
    start of the game, the inventory is empty. There is no maximum size of the inventory.
10. There are three types of heroes, each with their own balance of skills:
    (1) Warriors are favored on strength and agility.
    (2) Sorcerers are favored on dexterity and agility.
    (3) Paladins are favored on strength and dexterity.



[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
----------------
|   Monsters   |
----------------

1.  A monster has several attributes:
    (1) A name
    (2) A level
    (3) HP
    (4) A base damage value
    (5) A defense value
    (6) A dodge ability

2.  Base damage. This is a monster's attack damage.
3.  Defense. Monsters don't wear armor, relying on their natural hides and carapaces to
    protect them from the heroes' attacks. This value reduces the amount of damage a monster
    takes from a hero's attack or spell.
4.  Dodge ability. This represents how well a monster can avoid a hero's attack. It functions in a
    similar way to the hero's agility.
5.  There are three kinds of monsters, each with a favored attribute:
    (1) Dragons have increased base damage.
    (2) Exoskeletons have increased defense.
    (3) Spirits have increased dodge ability.

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Market Rules   |
********************

1.  The heroes can buy and sell items at any market. Items that are sold at every market are:
    (1) Armors
    (2) Potions
    (3) Spells
    (4) Weapons
2.  Each hero has a private wallet (their gold amount) and does not share money with the other heroes.
    Likewise, each hero has their own inventory of items that they do not share with their fellow heroes.
3.  A hero can sell an item that is not consumable i.e. potions and spells cannot be sold.

    Money earned by hero after a successful sale = 0.5 * the item's cost

    The item will be removed from the player's inventory.
4.  A successful purchase will reduce the amount of money the hero has, and the item will be transferred to
    the hero's inventory.
5.  All items have a name, a price, and a level. A hero cannot buy:
    (1) an item that costs more than the money they have, or
    (2) an item that is a higher level than they are.
6.  You can provide the following commands (Not case-sensitive):
    (1) View Market: To view the items in the market
    (2) <Hero ID> buy <Item ID>: To buy an item for a hero e.g. R0 buy B0
        To buy multiple items, include the IDs in a comma-separated manner e.g. R0 buy B0,E0
        HOARDING IS NOT ALLOWED. If a hero already has an item, the hero cannot buy another of the same
        item, until the item is sold (for weapons and armors) or the item has been completely consumed (for potions and spells)
    (3) <Hero ID> sell <Item ID>: To sell an item that a hero has e.g. R0 sell B0
        To sell multiple items, include the IDs in a comma-separated manner e.g. R0 sell B0,E0
    (4) I/i: To view all the heroes you have
    (5) Hero <Hero ID>: To view the details of a hero
    (6) Q/q: To quit the game
    (7) H/h: To view possible commands for Market
    (8) R/r: To view the rules of the market
    (9) X/x: To exit the market and go back to the map



[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
----------------
|  Item Types  |
----------------

1.  Armor: Armor reduces the incoming damage from a monster's attack. A piece of armor has
    a name, a price, a level, and a damage reduction value. When equipped, armor will reduce
    the damage taken by the hero by its damage reduction value. A hero can equip at most one
    piece of armor at a time.
2.  Potions: Potions can be used by a hero in order to increase one of their statistics by some
    amount. Potions are multi-use items, and each potion can be consumed a different number of times.
    Potions have a name, a price, a level, and an effect amount. Using the potion should
    increase the given statistic by the effect amount. There are potions for increasing hit points, mana,
    strength, dexterity, and agility.
3.  Spells. A spell represents a magic attack performed by a hero. A spell has a name, a price, a
    level, a damage value, a mana cost, and a spell type. A hero will require at least the mana
    cost amount of mana to cast the spell. Therefore, if a hero has no mana, that hero cannot cast
    any spells. The damage value is used along with the hero's dexterity value to calculate the
    damage dealt during a spell cast move in a battle.

    Hero's spell damage = spell_base_damage + (dexterity/10000) * spell_base_damage

    After casting a spell, the mana cost is deducted from the hero's mana.
    Spells also have an additional effect besides their damage.

    The types of spell and their effects are:
    (1) Ice spell: reduces the amount of damage the target can cause
    (2) Fire spell: reduces the defense of the target
    (3) Lightning spell: reduces the dodge chance of the target

4.  Weapons: A weapon is used by a hero to attack a monster. A weapon has a name, a price, a
    level, a damage value, and the number of hands required to use it. A weapon must be
    equipped by the hero before it can be used. The damage value is used to calculate the
    damage dealt during an attack move in a battle.

    Hero's attack damage with weapon = (hero's strength + weapon_damage) * 0.05

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
---------------------------------------------------------------------------
|                                   HELP                                  |
---------------------------------------------------------------------------

****************
|   Map Help   |
****************

Commands allowed on the map (Not case-sensitive):
    1. W/w: Move up
    2. A/a: Move left
    3. S/s: Move down
    4. D/d: Move right
    5. Q/q: Quit game
    6. I/i: Show information about the heroes
    7. M/m: When in a place that has a Market, use M/m to go to the market
    8. H/h: To view possible commands while using the map
    9. R/r: To view the rules of Monsters and Heroes
    10. View Map: To view the map
    11. <Hero ID> Inventory: To view the inventory of a hero e.g. R0 Inventory
    12. <Hero ID> drink <Potion ID>: To get a hero to consume a potion e.g. R0 drink P0
    13. Hero <Hero ID>: To view the e.g. Hero R0
    14. Regenerate Map: To create a new map e.g. if you are stuck, or just don't like the map you have
    15. <Hero ID> change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing
    e.g. R0 change B0
    To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
    comma-separated manner e.g. R0 change B0,E0


[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Market Help    |
********************

Commands allowed in the market (Not case-sensitive):
    1. View Market: To view the items in the market
    2. <Hero ID> buy <Item ID>: To buy an item for a hero e.g. R0 buy B0
       To buy multiple items, include the IDs in a comma-separated manner e.g. R0 buy B0,E0
       HOARDING IS NOT ALLOWED. If a hero already has an item, the hero cannot buy another of the same
       item, until the item is sold (for weapons and armors) or the item has been completely consumed (for potions and spells)
    3. <Hero ID> sell <Item ID>: To sell an item that a hero has e.g. R0 sell B0
       To sell multiple items, include the IDs in a comma-separated manner e.g. R0 sell B0,E0
    4. I/i: To view all the heroes you have
    5. Hero <Hero ID>: To view the details of a hero
    6. Q/q: To quit the game
    7. H/h: To view possible commands for Market
    8. R/r: To view the rules of Monsters and Heroes
    9. X/x: To exit the market and go back to the map


[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes

[INPUT] Please enter player name:
Input: Sarah
Output: [INPUT] Please input the number of heroes (minimum 1 and maximum 3):
Input: 2
Output:
[GAME MESSAGE] Generating 2 Heroes...

[GAME MESSAGE] 2 Heroes generated!

------------------------------------------------------------------------------------------------------------------------------------
|                                                               HEROES                                                             |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID                  NAME            TYPE      HIT POINT    MANA    MONEY    EXPERIENCE      STRENGTH    AGILITY    DEXTERITY
------------------------------------------------------------------------------------------------------------------------------------
     H5             Caliber_Heist       Paladin        800        800     8000         8            400         400        400
     G4                   Kalabar      Sorcerer        600        600     6000         6            850         400        600
-------------------------------------------------------------------------------------------------------------------------------------


+----+----+----+----+----+----+----+----+
| M  | I  | C  | I  | I  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | M  | C  | I  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | M  | C  | C  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | C  | C  | I  | M  | I  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | C  | I  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M* | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| I  | I  | M  | C  | M  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

[INPUT] Please provide a valid map command:
Input: m
Output:
#############################################################################################
|                                   MARKET                                                  |
#############################################################################################



---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B0         Sword         500          1            1           800
          B1           Bow         300          2            2           500
          B2        Scythe        1000          6            2          1100
          B3           Axe         550          5            1           850
          B4       TSwords        1400          8            2          1600
          B5        Dagger         200          1            1           250
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E0      Platinum_Shield         150          1             200
          E1          Breastplate         350          3             600
          E2      Full_Body_Armor        1000          8            1100
          E3        Wizard_Shield        1200         10            1500
          E4       Guardian_Angel        1000         10            1000
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P1      Strength_Potion     200       1            15                       75                                      strength
   P2         Magic_Potion     350       2            10                      100                                          mana
   P3          Luck_Elixir     500       4             4                       65                                       agility
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
   P5             Ambrosia    1000       8             1                      150    health, mana, strength, dexterity, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     F0            Fire           Flame_Tornado       700        300            4                   4                  850
     F1            Fire          Breath_of_Fire       350        100            1                  10                  450
     F2            Fire               Heat_Wave       450        150            2                   7                  600
     F3            Fire              Lava_Comet       800        550            7                   1                 1000
     F4            Fire              Hell_Storm       600        600            3                   5                  950
     C0             Ice             Snow_Cannon       500        250            2                   4                  650
     C1             Ice               Ice_Blade       250        100            1                   6                  450
     C2             Ice          Frost_Blizzard       750        350            5                   2                  850
     C3             Ice            Arctic_Storm       700        300            6                   1                  800
     L0       Lightning        Lightning_Dagger       400        150            1                   1                  500
     L1       Lightning           Thunder_Blast       750        400            4                   4                  950
     L2       Lightning         Electric_Arrows       550        200            5                   5                  650
     L3       Lightning           Spark_Needles       500        200            2                   2                  600
------------------------------------------------------------------------------------------------------------------------------------




********************
|   Market Help    |
********************

Commands allowed in the market (Not case-sensitive):
    1. View Market: To view the items in the market
    2. <Hero ID> buy <Item ID>: To buy an item for a hero e.g. R0 buy B0
       To buy multiple items, include the IDs in a comma-separated manner e.g. R0 buy B0,E0
       HOARDING IS NOT ALLOWED. If a hero already has an item, the hero cannot buy another of the same
       item, until the item is sold (for weapons and armors) or the item has been completely consumed (for potions and spells)
    3. <Hero ID> sell <Item ID>: To sell an item that a hero has e.g. R0 sell B0
       To sell multiple items, include the IDs in a comma-separated manner e.g. R0 sell B0,E0
    4. I/i: To view all the heroes you have
    5. Hero <Hero ID>: To view the details of a hero
    6. Q/q: To quit the game
    7. H/h: To view possible commands for Market
    8. R/r: To view the rules of Monsters and Heroes
    9. X/x: To exit the market and go back to the map



[INPUT] Please provide a valid market command:
Input: i
Output:
------------------------------------------------------------------------------------------------------------------------------------
|                                                               HEROES                                                             |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID                  NAME            TYPE      HIT POINT    MANA    MONEY    EXPERIENCE      STRENGTH    AGILITY    DEXTERITY
------------------------------------------------------------------------------------------------------------------------------------
     H5             Caliber_Heist       Paladin        800        800     8000         8            400         400        400
     G4                   Kalabar      Sorcerer        600        600     6000         6            850         400        600
-------------------------------------------------------------------------------------------------------------------------------------


[INPUT] Please provide a valid market command:
Input: h5 buy b4,e2,p0,p4,p5,f3,l1
Output:
[MARKET MESSAGE] Added weapon B4 to hero H5's inventory

[MARKET MESSAGE] Added armor E2 to hero H5's inventory

[MARKET MESSAGE] Added potion P0 to hero H5's inventory

[MARKET MESSAGE] Added potion P4 to hero H5's inventory

[MARKET MESSAGE] Added potion P5 to hero H5's inventory

[MARKET MESSAGE] Added spell F3 to hero H5's inventory

[MARKET MESSAGE] Added spell L1 to hero H5's inventory


[INPUT] Please provide a valid market command:
Input: g4 buy b2,e1,p0,p4,c3,f4
Output:
[MARKET MESSAGE] Added weapon B2 to hero G4's inventory

[MARKET MESSAGE] Added armor E1 to hero G4's inventory

[MARKET MESSAGE] Added potion P0 to hero G4's inventory

[MARKET MESSAGE] Added potion P4 to hero G4's inventory

[MARKET MESSAGE] Added spell C3 to hero G4's inventory

[MARKET MESSAGE] Added spell F4 to hero G4's inventory


[INPUT] Please provide a valid market command:
Input: x
Output:
[MARKET MESSAGE] Exiting Market...


+----+----+----+----+----+----+----+----+
| M  | I  | C  | I  | I  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | M  | C  | I  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | M  | C  | C  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | C  | C  | I  | M  | I  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | C  | I  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M* | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| I  | I  | M  | C  | M  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

[INPUT] Please provide a valid map command:
Input: h5 change b4,e2
Output:
[GAME MESSAGE] You are currently armed with:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B4       TSwords        1400          8            2          1600
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E2      Full_Body_Armor        1000          8            1100
----------------------------------------------------------------------------------------------

[INPUT] Please provide a valid map command:
Input: g4 change b2,e1
Output:
[GAME MESSAGE] You are currently armed with:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B2        Scythe        1000          6            2          1100
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E1          Breastplate         350          3             600
----------------------------------------------------------------------------------------------

[INPUT] Please provide a valid map command:
Input: view map
Output:

+----+----+----+----+----+----+----+----+
| M  | I  | C  | I  | I  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | M  | C  | I  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | M  | C  | C  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | C  | C  | I  | M  | I  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | C  | I  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M* | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| I  | I  | M  | C  | M  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

[INPUT] Please provide a valid map command:
Input: w
Output:
[GAME MESSAGE] Generating 2 monsters...

[GAME MESSAGE] 2 monsters generated

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
HERO Caliber_Heist :
        ID: H5
        Type: Paladin
        Hit Points:800
        Mana: 800
        Strength: 400
        Agility: 400
        Dexterity: 400
        Money: 1950
        Experience: 8
        Experience Gained: 0 / 80
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B4       TSwords        1400          8            2          1600
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E2      Full_Body_Armor        1000          8            1100
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:

#########################################################################################

|                                        Inventory                                      |

#########################################################################################


---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
   P5             Ambrosia    1000       8             1                      150    health, mana, strength, dexterity, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     F3            Fire              Lava_Comet       800        550            7                   1                 1000
     L1       Lightning           Thunder_Blast       750        400            4                   4                  950
------------------------------------------------------------------------------------------------------------------------------------




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER Venom :
        ID: K10
        Type: Exoskeleton
        Hit Points: 600
        Level: 6
        Damage: 600
        Defense: 600
        DodgeChance: 55

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Venom was hit by Hero Caliber_Heist and lost 400 hitpoints!


[BATTLE MESSAGE] Hero Caliber_Heist has successfully defended against Monster Venom's attack!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Venom was hit by Hero Caliber_Heist and has been defeated!

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Kalabar :
        ID: G4
        Type: Sorcerer
        Hit Points:600
        Mana: 600
        Strength: 850
        Agility: 400
        Dexterity: 600
        Money: 2250
        Experience: 6
        Experience Gained: 0 / 60
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B2        Scythe        1000          6            2          1100
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E1          Breastplate         350          3             600
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:

#########################################################################################

|                                        Inventory                                      |

#########################################################################################


---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     C3             Ice            Arctic_Storm       700        300            6                   1                  800
     F4            Fire              Hell_Storm       600        600            3                   5                  950
------------------------------------------------------------------------------------------------------------------------------------




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER Chronepsish :
        ID: K5
        Type: Exoskeleton
        Hit Points: 600
        Level: 6
        Damage: 650
        Defense: 750
        DodgeChance: 60

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Chronepsish was hit by Hero Kalabar and lost 225 hitpoints!


[BATTLE MESSAGE] Hero Kalabar was hit by Monster Chronepsish and lost 50 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Chronepsish was hit by Hero Kalabar and lost 225 hitpoints!


[BATTLE MESSAGE] Hero Kalabar was hit by Monster Chronepsish and lost 50 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Chronepsish was hit by Hero Kalabar and has been defeated!

[GAME MESSAGE] Reviving heroes...


+----+----+----+----+----+----+----+----+
| M  | I  | C  | I  | I  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | M  | C  | I  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | M  | C  | C  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | C  | C  | I  | M  | I  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C* | C  | I  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| I  | I  | M  | C  | M  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

[INPUT] Please provide a valid map command:
Input: w
Output:
[GAME MESSAGE] Generating 2 monsters...

[GAME MESSAGE] 2 monsters generated

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Caliber_Heist :
        ID: H5
        Type: Paladin
        Hit Points:880
        Mana: 880
        Strength: 400
        Agility: 400
        Dexterity: 400
        Money: 2550
        Experience: 8
        Experience Gained: 20 / 80
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B4       TSwords        1400          8            2          1600
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E2      Full_Body_Armor        1000          8            1100
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:

#########################################################################################

|                                        Inventory                                      |

#########################################################################################


---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
   P5             Ambrosia    1000       8             1                      150    health, mana, strength, dexterity, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     F3            Fire              Lava_Comet       800        550            7                   1                 1000
     L1       Lightning           Thunder_Blast       750        400            4                   4                  950
------------------------------------------------------------------------------------------------------------------------------------




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER Rakkshasass :
        ID: N8
        Type: Spirit
        Hit Points: 900
        Level: 9
        Damage: 550
        Defense: 600
        DodgeChance: 35

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: h5 change b6,e5
Output:
[BATTLE MESSAGE] You are currently armed with:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------


[BATTLE MESSAGE] Hero Caliber_Heist was hit by Monster Rakkshasass and lost 450 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Rakkshasass has successfully defended against Hero Caliber_Heist's attack!


[BATTLE MESSAGE] Hero Caliber_Heist was hit by Monster Rakkshasass and has been defeated!

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Kalabar :
        ID: G4
        Type: Sorcerer
        Hit Points:660
        Mana: 660
        Strength: 850
        Agility: 400
        Dexterity: 600
        Money: 2850
        Experience: 6
        Experience Gained: 20 / 60
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B2        Scythe        1000          6            2          1100
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E1          Breastplate         350          3             600
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:

#########################################################################################

|                                        Inventory                                      |

#########################################################################################


---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     C3             Ice            Arctic_Storm       700        300            6                   1                  800
     F4            Fire              Hell_Storm       600        600            3                   5                  950
------------------------------------------------------------------------------------------------------------------------------------




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER BunsenBurner :
        ID: J2
        Type: Dragon
        Hit Points: 400
        Level: 4
        Damage: 400
        Defense: 500
        DodgeChance: 45

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: g4 change b6,e5
Output:
[BATTLE MESSAGE] You are currently armed with:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------


[BATTLE MESSAGE] Hero Kalabar was hit by Monster BunsenBurner and lost 300 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster BunsenBurner has successfully defended against Hero Kalabar's attack!


[BATTLE MESSAGE] Hero Kalabar was hit by Monster BunsenBurner and lost 300 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: cast f4
Output:
[BATTLE MESSAGE] Monster BunsenBurner has been defeated!

[GAME MESSAGE] Reviving heroes...


+----+----+----+----+----+----+----+----+
| M  | I  | C  | I  | I  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | M  | C  | I  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | M  | C  | C  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | C* | C  | I  | M  | I  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | C  | I  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| I  | I  | M  | C  | M  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

[INPUT] Please provide a valid map command:
Input: a
Output:
[GAME MESSAGE] Generating 2 monsters...

[GAME MESSAGE] 2 monsters generated

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Caliber_Heist :
        ID: H5
        Type: Paladin
        Hit Points:440
        Mana: 440
        Strength: 400
        Agility: 400
        Dexterity: 400
        Money: 2550
        Experience: 8
        Experience Gained: 20 / 80
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:

#########################################################################################

|                                        Inventory                                      |

#########################################################################################


---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B4       TSwords        1400          8            2          1600
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E2      Full_Body_Armor        1000          8            1100
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
   P5             Ambrosia    1000       8             1                      150    health, mana, strength, dexterity, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     F3            Fire              Lava_Comet       800        550            7                   1                 1000
     L1       Lightning           Thunder_Blast       750        400            4                   4                  950
------------------------------------------------------------------------------------------------------------------------------------




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER Melchiresas :
        ID: N6
        Type: Spirit
        Hit Points: 700
        Level: 7
        Damage: 350
        Defense: 150
        DodgeChance: 75

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Melchiresas was hit by Hero Caliber_Heist and lost 125 hitpoints!


[BATTLE MESSAGE] Hero Caliber_Heist was hit by Monster Melchiresas and lost 250 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Melchiresas was hit by Hero Caliber_Heist and lost 125 hitpoints!


[BATTLE MESSAGE] Hero Caliber_Heist was hit by Monster Melchiresas and has been defeated!

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Kalabar :
        ID: G4
        Type: Sorcerer
        Hit Points:726
        Mana: 726
        Strength: 850
        Agility: 400
        Dexterity: 600
        Money: 3250
        Experience: 6
        Experience Gained: 40 / 60
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:

#########################################################################################

|                                        Inventory                                      |

#########################################################################################


---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B2        Scythe        1000          6            2          1100
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E1          Breastplate         350          3             600
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     C3             Ice            Arctic_Storm       700        300            6                   1                  800
     F4            Fire              Hell_Storm       600        600            3                   4                  950
------------------------------------------------------------------------------------------------------------------------------------




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER Blinky :
        ID: N1
        Type: Spirit
        Hit Points: 100
        Level: 1
        Damage: 450
        Defense: 350
        DodgeChance: 35

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Blinky was hit by Hero Kalabar and has been defeated!

[GAME MESSAGE] Congratulations! Hero Kalabar has leveled up from Experience Level 6 to Experience Level 7!

[GAME MESSAGE] Reviving heroes...


+----+----+----+----+----+----+----+----+
| M  | I  | C  | I  | I  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | M  | C  | I  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | M  | C  | C  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C* | C  | C  | I  | M  | I  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | C  | I  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| I  | I  | M  | C  | M  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

[INPUT] Please provide a valid map command:
Input: w
Output:
[GAME MESSAGE] Generating 2 monsters...

[GAME MESSAGE] 2 monsters generated

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Caliber_Heist :
        ID: H5
        Type: Paladin
        Hit Points:220
        Mana: 220
        Strength: 400
        Agility: 400
        Dexterity: 400
        Money: 2550
        Experience: 8
        Experience Gained: 20 / 80
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:

#########################################################################################

|                                        Inventory                                      |

#########################################################################################


---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B4       TSwords        1400          8            2          1600
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E2      Full_Body_Armor        1000          8            1100
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
   P5             Ambrosia    1000       8             1                      150    health, mana, strength, dexterity, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     F3            Fire              Lava_Comet       800        550            7                   1                 1000
     L1       Lightning           Thunder_Blast       750        400            4                   4                  950
------------------------------------------------------------------------------------------------------------------------------------




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER St-Shargaas :
        ID: K7
        Type: Exoskeleton
        Hit Points: 500
        Level: 5
        Damage: 550
        Defense: 650
        DodgeChance: 55

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster St-Shargaas has successfully defended against Hero Caliber_Heist's attack!


[BATTLE MESSAGE] Hero Caliber_Heist was hit by Monster St-Shargaas and has been defeated!

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Kalabar :
        ID: G4
        Type: Sorcerer
        Hit Points:798
        Mana: 798
        Strength: 892
        Agility: 440
        Dexterity: 660
        Money: 3350
        Experience: 7
        Experience Gained: 0 / 70
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:

#########################################################################################

|                                        Inventory                                      |

#########################################################################################


---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B2        Scythe        1000          6            2          1100
----------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E1          Breastplate         350          3             600
----------------------------------------------------------------------------------------------



-----------------------------------------------------------------------------------------------------------------------------------
|                                                           POTIONS                                                               |
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
   ID            NAME         COST     LEVEL    # OF CONSUMPTIONS      INCREASE AMOUNT                               ATTRIBUTES
-----------------------------------------------------------------------------------------------------------------------------------
   P0       Healing_Potion     250       1            20                      100                                        health
   P4        Mermaid_Tears     850       5             3                      100               health, mana, strength, agility
------------------------------------------------------------------------------------------------------------------------------------



------------------------------------------------------------------------------------------------------------------------------------
|                                                             SPELLS                                                               |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID              TYPE               NAME          COST      MANA COST     LEVEL         # OF CONSUMPTIONS         DAMAGE
------------------------------------------------------------------------------------------------------------------------------------
     C3             Ice            Arctic_Storm       700        300            6                   1                  800
     F4            Fire              Hell_Storm       600        600            3                   4                  950
------------------------------------------------------------------------------------------------------------------------------------




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER BunsenBurner :
        ID: J2
        Type: Dragon
        Hit Points: 400
        Level: 4
        Damage: 400
        Defense: 500
        DodgeChance: 45

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster BunsenBurner was hit by Hero Kalabar and lost 21 hitpoints!


[BATTLE MESSAGE] Hero Kalabar was hit by Monster BunsenBurner and lost 300 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster BunsenBurner was hit by Hero Kalabar and lost 21 hitpoints!


[BATTLE MESSAGE] Hero Kalabar was hit by Monster BunsenBurner and lost 300 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster BunsenBurner was hit by Hero Kalabar and lost 21 hitpoints!


[BATTLE MESSAGE] Hero Kalabar was hit by Monster BunsenBurner and has been defeated!


+----+----+----+----+----+----+----+----+
| M  | I  | C  | I  | I  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | M  | C  | I  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | C* | M  | C  | C  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | C  | C  | I  | M  | I  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | C  | C  | I  | I  | M  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| M  | C  | C  | M  | C  | C  | M  | C  |
+----+----+----+----+----+----+----+----+
| I  | I  | M  | C  | M  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

There were 4 battles in this round.
        Hero Caliber_Heist defeated 1 monster(s).
        Hero Kalabar defeated 3 monster(s).



------------------------------------------------------------------------------------------------------------------------------------
|                                                               HEROES                                                             |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID                  NAME            TYPE      HIT POINT    MANA    MONEY    EXPERIENCE      STRENGTH    AGILITY    DEXTERITY
------------------------------------------------------------------------------------------------------------------------------------
     H5             Caliber_Heist       Paladin          0        220     2550         8            400         400        400
     G4                   Kalabar      Sorcerer          0        798     3350         7            892         440        660
-------------------------------------------------------------------------------------------------------------------------------------

You have failed to free the villagers of Lockwood from the monsters' tyranny! Would you like to try again? Y/N
Input: y
Output:
#########################################################################
|                          MONSTERS AND HEROES                          |
#########################################################################

A long time ago, the villagers of Lockwood were living a peaceful when one day, their village was overtaken by
monsters. The monsters were tyrants and destroyed their village. With nowhere to go, they retreated into the pockets of
magical forest that stood even after the monsters attacked. The forest gave them protection, with its magic hiding the
villagers from the monsters. The invalid areas in the map represent the pockets of magical forest, which keeps out
everything and everyone. However, they are not safe. The monsters have been slowly weakening the magical forest,
with the aim of eradicating every single villager.

Will you rise up to the challenge and help the villagers of Lockwood free themselves from the monsters' tyranny? Will
you help protect the magical forest from its slow death? If you and your heroes defeat all 100 monsters,
you will succeed.

Good luck!

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
---------------------------------------------------------------------------
|                                   RULES                                  |
---------------------------------------------------------------------------

*****************
|   Map Rules   |
*****************

1.  The map contains three types of spaces:
    (a) Inaccessible spaces, which the heroes cannot enter
    (b) Market spaces, where items can be bought or sold
    (c) Common spaces, where battles can occur
        - There is a chance that your heroes will engage in a battle in this space with the monsters
        - Battles are always 1-on-1
        - You will only know if there will be a battle once you enter a Common space
        - Only heroes who are alive i.e. have hit points > 0 will have to battle a monster
        - The monsters the heroes will have to fight will be completely random, and does not depend on the hero's level
2.  The game ends if:
    (1) all heroes are unconscious, or
    (2) all the heroes are able to defeat 100 monsters
3.  You can provide the following commands (Not case-sensitive):
    (1) W/w: Move up
    (2) A/a: Move left
    (3) S/s: Move down
    (4) D/d: Move right
    (5) Q/q: Quit game
    (6) I/i: Show information about the heroes
    (7) M/m: When in a place that has a Market, use M/m to go to the market
    (8) H/h: To view possible commands while using the map
    (9) R/r: To view the rules of the map
    (10) View Map: To view the map
    (11) <Hero ID> Inventory: To view the inventory of a hero e.g. R0 Inventory
    (12) <Hero ID> drink <Potion ID>: To get a hero to consume a potion e.g. R0 drink P0
    (13) Hero <Hero ID>: To view the e.g. Hero R0
    (14) Regenerate Map: To create a new map e.g. if you are stuck, or just don't like the map you have
    (15) <Hero ID> change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing
    e.g. R0 change B0
    To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
    comma-separated manner e.g. R0 change B0,E0


.
.
.

[INPUT] Please enter player name:
Input: Jane
Output:
[INPUT] Please input the number of heroes (minimum 1 and maximum 3):
Input: 2
Output:
[GAME MESSAGE] Generating 2 Heroes...

[GAME MESSAGE] 2 Heroes generated!

------------------------------------------------------------------------------------------------------------------------------------
|                                                               HEROES                                                             |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID                  NAME            TYPE      HIT POINT    MANA    MONEY    EXPERIENCE      STRENGTH    AGILITY    DEXTERITY
------------------------------------------------------------------------------------------------------------------------------------
     H1          Sehanine_Moonbow       Paladin        700        700     7000         7            750         700        700
     G4                   Kalabar      Sorcerer        600        600     6000         6            850         400        600
-------------------------------------------------------------------------------------------------------------------------------------


+----+----+----+----+----+----+----+----+
| C  | C  | M  | C  | C  | C  | C  | M  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | C  | C  | I  | I  | C  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | I  | C  | I  | C  | I  |
+----+----+----+----+----+----+----+----+
| I  | M  | C  | C  | C  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| I  | C  | C  | M  | I  | C  | C  | M  |
+----+----+----+----+----+----+----+----+
| C  | I  | M  | M  | C  | C  | C  | I  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M  | C  | M* | C  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | M  | C  | M  | M  | I  | M  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

[INPUT] Please provide a valid map command:
Input: w
Output:
[GAME MESSAGE] Generating 2 monsters...

[GAME MESSAGE] 2 monsters generated

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Sehanine_Moonbow :
        ID: H1
        Type: Paladin
        Hit Points:700
        Mana: 700
        Strength: 750
        Agility: 700
        Dexterity: 700
        Money: 7000
        Experience: 7
        Experience Gained: 0 / 70
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:
None



[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER Andromalius :
        ID: N2
        Type: Spirit
        Hit Points: 300
        Level: 3
        Damage: 550
        Defense: 450
        DodgeChance: 25

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Andromalius has successfully defended against Hero Sehanine_Moonbow's attack!


[BATTLE MESSAGE] Hero Sehanine_Moonbow was hit by Monster Andromalius and lost 450 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Andromalius has successfully defended against Hero Sehanine_Moonbow's attack!


[BATTLE MESSAGE] Hero Sehanine_Moonbow was hit by Monster Andromalius and has been defeated!

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

********************
|   Battle Help    |
********************

A battle can occur in a common space. Depending on your luck, you may or may not have to
fight monsters.

Commands allowed in battle (Not case-sensitive):
    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0
       The item must be in the hero's inventory. Once a hero is equipped with a weapon or armor,
       the hero can only replace the weapon with another weapon from the inventory, and an armor with another armor from the
       inventory. To update more than one equippable item i.e. change both weapon and armor, include the weapon and armor IDs in a
       comma-separated manner e.g. R0 change B0,E0
    2. Hit: To hit the monster with the weapon the hero is carrying
    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0
    4. I/i: To view the details of the hero and the monster engaged in battle
    5. Q/q: To quit the game
    6. H/h: To view possible commands for battle
    7. R/r: To view the rules of Monsters and Heroes




[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

HERO Kalabar :
        ID: G4
        Type: Sorcerer
        Hit Points:600
        Mana: 600
        Strength: 850
        Agility: 400
        Dexterity: 600
        Money: 6000
        Experience: 6
        Experience Gained: 0 / 60
[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Currently Equipped Items:

#########################################################################################

|                                   Currently Equipped Items                              |

#########################################################################################

---------------------------------------------------------------------------------------------
|                                   WEAPONS                                                 |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME         COST        LEVEL        HANDS       DAMAGE
---------------------------------------------------------------------------------------------
          B6         Fists           0          1            2           150
----------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
|                                   ARMORS                                                  |
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
          ID         NAME                 COST      LEVEL     DAMAGE REDUCTION
---------------------------------------------------------------------------------------------
          E5         Body_of_Hero           0          1             100
----------------------------------------------------------------------------------------------

[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:

        Inventory:
None



[GAME MESSAGE] Press ENTER to continue
Input: (Press ENTER)
Output:
MONSTER Andrealphus :
        ID: N0
        Type: Spirit
        Hit Points: 200
        Level: 2
        Damage: 600
        Defense: 500
        DodgeChance: 40

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: cast f0
Output:
[ERROR] Spell F0 does not exist in Kalabar's inventory! You just lost a turn.


[BATTLE MESSAGE] Hero Kalabar was hit by Monster Andrealphus and lost 500 hitpoints!

[INPUT] Please enter the action you would like to take (Change <Weapon or Armor ID>, Hit, Cast <Spell ID>, I/i, Q/q):
Input: hit
Output:
[BATTLE MESSAGE] Monster Andrealphus has successfully defended against Hero Kalabar's attack!


[BATTLE MESSAGE] Hero Kalabar was hit by Monster Andrealphus and has been defeated!


+----+----+----+----+----+----+----+----+
| C  | C  | M  | C  | C  | C  | C  | M  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | C  | C  | I  | I  | C  |
+----+----+----+----+----+----+----+----+
| C  | C  | C  | I  | C  | I  | C  | I  |
+----+----+----+----+----+----+----+----+
| I  | M  | C  | C  | C  | C  | C  | C  |
+----+----+----+----+----+----+----+----+
| I  | C  | C  | M  | I  | C  | C  | M  |
+----+----+----+----+----+----+----+----+
| C  | I  | M  | M  | C  | C* | C  | I  |
+----+----+----+----+----+----+----+----+
| C  | M  | C  | M  | C  | M  | C  | I  |
+----+----+----+----+----+----+----+----+
| C  | C  | M  | C  | M  | M  | I  | M  |
+----+----+----+----+----+----+----+----+
*: You are here         I: Invalid Area         M: Market               C: Common Area

There was 1 battle in this round.
        Hero Sehanine_Moonbow defeated 0 monster(s).
        Hero Kalabar defeated 0 monster(s).



------------------------------------------------------------------------------------------------------------------------------------
|                                                               HEROES                                                             |
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
     ID                  NAME            TYPE      HIT POINT    MANA    MONEY    EXPERIENCE      STRENGTH    AGILITY    DEXTERITY
------------------------------------------------------------------------------------------------------------------------------------
     H1          Sehanine_Moonbow       Paladin          0        700     7000         7            750         700        700
     G4                   Kalabar      Sorcerer          0        600     6000         6            850         400        600
-------------------------------------------------------------------------------------------------------------------------------------

You have failed to free the villagers of Lockwood from the monsters' tyranny! Would you like to try again? Y/N
Input: n
Output:
-----------------------
|       Round 1       |
-----------------------


There were 4 battles in this round.
        Hero Caliber_Heist defeated 1 monster(s).
        Hero Kalabar defeated 3 monster(s).

-----------------------
|       Round 2       |
-----------------------


There was 1 battle in this round.
        Hero Sehanine_Moonbow defeated 0 monster(s).
        Hero Kalabar defeated 0 monster(s).

[GAME MESSAGE] Quitting game...