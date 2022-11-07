// Help for Monsters and Heroes
public class MHHelp implements Help {
    @Override
    public void printIntroduction() {
        String introduction = "#########################################################################\n" +
                "|                          MONSTERS AND HEROES                          |\n" +
                "#########################################################################\n" +
                "\n" +
                "A long time ago, the villagers of Lockwood were living a peaceful when one day, their village was overtaken by\n" +
                "monsters. The monsters were tyrants and destroyed their village. With nowhere to go, they retreated into the pockets of\n" +
                "magical forest that stood even after the monsters' attacked. The forest gave them protection, with its magic hiding the\n" +
                "villagers from the monsters. The invalid areas in the map represent the pockets of magical forest, which keeps out\n" +
                "everything and everyone. However, they are not safe. The monsters have been slowly weakening the magical forest,\n" +
                "with the aim of eradicating every single villager.\n" +
                "\n" +
                "Will you rise up to the challenge and help the villagers of Lockwood free themselves from the monsters' tyranny? Will\n" +
                "you help protect the magical forest from its slow death? If you and your heroes defeat all 100 monsters,\n" +
                "you will succeed.\n" +
                "\n" +
                "Good luck!";

        System.out.println(introduction);
    }

    @Override
    public void printHelp() {
        String helpHeader = "---------------------------------------------------------------------------\n" +
                "|                                   HELP                                  |\n" +
                "---------------------------------------------------------------------------";

        System.out.println(helpHeader);
        printHelpMap();
        printHelpMarket();
        printHelpBattle();
    }

    public void printHelpBattle() {
        String help = "\n********************\n" +
                "|   Battle Help    |\n" +
                "********************\n" +
                    "\n" +
                    "A battle can occur in a common space. Depending on your luck, you may or may not have to\n" +
                    "fight monsters.\n" +
                    "\n" +
                    "Commands allowed in battle (Not case-sensitive):\n" +
                    "    1. Change <Weapon or Armor ID>: To update the weapon or armor a hero is or\n" +
                    "                                    is not carrying/wearing e.g. R0 change B0\n" +
                    "    2. Hit: To hit the monster with the weapon the hero is carrying\n" +
                    "    3. Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0\n" +
                    "    4. I/i: To view the details of the hero and the monster engaged in battle\n" +
                    "    5. Q/q: To quit the game\n" +
                    "    6. H/h: To view possible commands for battle\n" +
                    "    7. R/r: To view the rules of Monsters and Heroes\n";

        System.out.println(help);
    }

    public void printHelpMarket() {
        String help = "\n********************\n" +
                "|   Market Help    |\n" +
                "********************\n" +
                "\n" +
                "Commands allowed in the market (Not case-sensitive):\n" +
                "    1. View Market: To view the items in the market\n" +
                "    2. <Hero ID> buy <Item ID>: To buy an item for a hero e.g. R0 buy B0\n" +
                "    3. <Hero ID> sell <Item ID>: To sell an item that a hero has e.g. R0 sell B0\n" +
                "    4. I/i: To view all the heroes you have\n" +
                "    5. Hero <Hero ID>: To view the details of a hero\n" +
                "    6. Q/q: To quit the game\n" +
                "    7. H/h: To view possible commands for Market\n" +
                "    8. R/r: To view the rules of Monsters and Heroes\n" +
                "    9. X/x: To exit the market and go back to the map\n";

        System.out.println(help);
    }

    public void printHelpMap() {
        String help = "\n****************\n" +
                "|   Map Help   |\n" +
                "****************\n" +
                "\n" +
                "Commands allowed on the map (Not case-sensitive):\n" +
                "    1. W/w: Move up\n" +
                "    2. A/a: Move left\n" +
                "    3. S/s: Move down\n" +
                "    4. D/d: Move right\n" +
                "    5. Q/q: Quit game\n" +
                "    6. I/i: Show information about the heroes\n" +
                "    7. M/m: When in a place that has a Market, use M/m to go to the market\n" +
                "    8. H/h: To view possible commands while using the map\n" +
                "    9. R/r: To view the rules of Monsters and Heroes\n" +
                "    10. View Map: To view the map\n" +
                "    11. <Hero ID> Inventory: To view the inventory of a hero e.g. R0 Inventory\n" +
                "    12. <Hero ID> drink <Potion ID>: To get a hero to consume a potion e.g. R0 drink P0\n" +
                "    13. Hero <Hero ID>: To view the e.g. Hero R0\n" +
                "    14. Regenerate Map: To create a new map e.g. if you are stuck, or just don't like the map you have\n" +
                "    15. <Hero ID> change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing\n" +
                "    e.g. R0 change B0";

        System.out.println(help);
    }

    public void printRules() {
        String rulesHeader = "---------------------------------------------------------------------------\n" +
                "|                                   RULES                                  |\n" +
                "---------------------------------------------------------------------------";

        System.out.println(rulesHeader);
        printRulesMap();
        printRulesBattle();
        printRulesMarket();
    }

    public void printRulesMap() {
        String rules = "\n*****************\n" +
                "|   Map Rules   |\n" +
                "*****************\n" +
                "\n" +
                "1.  The map contains three types of spaces:\n" +
                "    (a) Inaccessible spaces, which the heroes cannot enter\n" +
                "    (b) Market spaces, where items can be bought or sold\n" +
                "    (c) Common spaces, where battles can occur\n" +
                "        - There is a chance that your heroes will engage in a battle in this space with the monsters\n" +
                "        - Battles are always 1-on-1\n" +
                "        - You will only know if there will be a battle once you enter a Common space\n" +
                "        - Only heroes who are alive i.e. have hit points > 0 will have to battle a monster\n" +
                "        - The monsters the heroes will have to fight will be completely random, and does not depend on the hero's level\n" +
                "2.  The game ends if:\n" +
                "    (1) all heroes are unconscious, or\n" +
                "    (2) all the heroes were able to defeat 100 monsters\n" +
                "3.  You can provide the following commands (Not case-sensitive):\n" +
                "    (1) W/w: Move up\n" +
                "    (2) A/a: Move left\n" +
                "    (3) S/s: Move down\n" +
                "    (4) D/d: Move right\n" +
                "    (5) Q/q: Quit game\n" +
                "    (6) I/i: Show information about the heroes\n" +
                "    (7) M/m: When in a place that has a Market, use M/m to go to the market\n" +
                "    (8) H/h: To view possible commands while using the map\n" +
                "    (9) R/r: To view the rules of the map\n" +
                "    (10) View Map: To view the map\n" +
                "    (11) <Hero ID> Inventory: To view the inventory of a hero e.g. R0 Inventory\n" +
                "    (12) <Hero ID> drink <Potion ID>: To get a hero to consume a potion e.g. R0 drink P0\n" +
                "    (13) Hero <Hero ID>: To view the e.g. Hero R0\n" +
                "    (14) Regenerate Map: To create a new map e.g. if you are stuck, or just don't like the map you have\n" +
                "    (15) <Hero ID> change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing\n" +
                "        e.g. R0 change B0";

        System.out.println(rules);
    }

    public void printRulesBattle() {
        String rules = "\n********************\n" +
                "|   Battle Rules   |\n" +
                "********************\n" +
                "\n" +
                "1.  This is a turn-based battle, where the heroes make a move first, followed by the monster\n" +
                "2.  The battle is 1-on-1 i.e. one hero vs one monster\n" +
                "3.  The battle ends when\n" +
                "    (1) the hero runs out of hit points, or\n" +
                "    (2) the monster runs out of hit points\n" +
                "4.  Possible commands to use in battle (Not case-sensitive):\n" +
                "    (1) Change <Weapon or Armor ID>: To update the weapon or armor a hero is or is not carrying/wearing e.g. R0 change B0\n" +
                "    (2) Hit: To hit the monster with the weapon the hero is carrying\n" +
                "    (3) Cast <Spell ID>: To cast a spell on the monster e.g. Cast F0\n" +
                "    (4) I/i: To view the details of the hero and the monster engaged in battle (Will not lose a turn)\n" +
                "    (5) Q/q: To quit the game\n" +
                "    (6) H/h: To view possible commands for battle (Will not lose a turn)\n" +
                "    (7) R/r: To view the rules of battle (Will not lose a turn)\n" +
                "5.  Commands that do not have (Will not lose a turn) means that if the item ID given does not exist,\n" +
                "    the hero loses a turn.\n" +
                "6.  The monsters will only attack the heroes, as they do not have items or spells to use.\n" +
                "7.  Heroes have a dodge chance that will allow them to occasionally avoid taking damage from a monster’s attack.\n" +
                "    If the dodge chance >= monster's attack, then the monster's attack is dodged. Otherwise, the hero gets the full\n" +
                "    brunt of the monster's attack - defence provided by the hero's armor (if any).\n" +
                "\n" +
                "    Hero's dodge chance = hero's agility * 0.2\n" +
                "\n" +
                "8.  Similarly, monsters also have a dodge chance that will allow them to occasionally avoid taking damage from\n" +
                "    a hero’s attack. If the dodge chance >= hero's attack, then the hero's attack is dodged. Otherwise, the monster\n" +
                "    gets the full brunt of the hero's attack - monster's defence.\n" +
                "\n" +
                "    Monster's dodge points = monster's dodge chance * 0.1\n" +
                "\n" +
                "9.  When a monster is unable to dodge the hero's spell, the monster faces a loss in skill. The skill affected\n" +
                "    depends on the type of spell used.\n" +
                "    The types of spell and their effects are:\n" +
                "    (1) Ice spell: reduces the amount of damage the monster can cause\n" +
                "    (2) Fire spell: reduces the defense of the monster\n" +
                "    (3) Lightning spell: reduces the dodge chance of the monster\n" +
                "\n" +
                "    Skill left after getting hit by spell = (damage or defence or dodge chance, depending on type of spell) * 0.9\n" +
                "\n" +
                "10. If a hero wins the battle, the hero gains 10% of their starting hit point and mana. They also get money and\n" +
                "    experience points.\n" +
                "\n" +
                "    Money gained = Monster level * 100\n" +
                "    Experience gained = 2 * number of monster in battle, which is 1\n" +
                "\n" +
                "11. Heroes are able to level up. Once they level up, their hit points, mana and experience level increases.\n" +
                "    When a hero levels up all of their skills increase by 5% and their favored skills increase by an extra 5%.\n" +
                "\n" +
                "    Experience points needed to level up = Hero's current level * 10\n" +
                "    Hero's hit point = hero's current level * 100\n" +
                "    Hero's mana after level up = Hero's mana before level up * 1.1\n" +
                "    Hero's experience level after level up = Hero's experience level before level up + 1\n" +
                "\n" +
                "12. After all the heroes who were able to battle have battled a monster, if the number of heroes who won is more\n" +
                "    than the number of monsters, then heroes who fainted in battle are revived. They gain back 50% of\n" +
                "    their starting hit points and their mana. However, they do not get any gold or experience.\n" +
                "\n" +
                "--------------\n" +
                "|   Heroes   |\n" +
                "--------------\n" +
                "\n" +
                "1. A hero has several attributes:\n" +
                "   (1) A name\n" +
                "   (2) A level with an amount of experience points\n" +
                "   (3) HP (hit points, the hero’s in battle)\n" +
                "   (4) MP (mana or magic points, for casting spells)\n" +
                "   (5) A strength value\n" +
                "   (6) A dexterity value\n" +
                "   (7) An agility value\n" +
                "   (8) An amount of gold\n" +
                "   (9) An inventory of items\n" +
                "   (10) The weapon and/or armor they have on them\n" +
                "\n" +
                "2.  A hero has a level, representing how strong (or not) that hero is. Experience points determine the hero’s level.\n" +
                "    A hero levels up after accumulating enough experience points. A hero’s skills increase when the hero levels up.\n" +
                "    A hero never loses experience. It accumulates over the course of the game.\n" +
                "3.  HP (hot point): HP is the hero’s current health. The initial HP value is determined by hero’s level.\n" +
                "\n" +
                "    Hero's hit points = Hero's current level * 100\n" +
                "\n" +
                "    When a hero levels up, they have their HP set according to the same formula.\n" +
                "\n" +
                "4.  MP: MP (or mana) is used to cast spells.\n" +
                "5.  Strength: A hero’s strength increases the amount of damage they deal when using a weapon.\n" +
                "6.  Dexterity: A hero’s dexterity increases the amount of damage they deal when casting a spell.\n" +
                "7.  Agility: A hero’s agility increases their chance to dodge a monster’s attack.\n" +
                "8.  Money: Money is for use in the market.\n" +
                "9.  Inventory. A hero has a collection of items that they have bought during the game. At the\n" +
                "    start of the game, the inventory is empty. There is no maximum size of the inventory.\n" +
                "10. There are three types of heroes, each with their own balance of skills:\n" +
                "    (1) Warriors are favored on strength and agility.\n" +
                "    (2) Sorcerers are favored on dexterity and agility.\n" +
                "    (3) Paladins are favored on strength and dexterity.\n" +
                "\n" +
                "----------------\n" +
                "|   Monsters   |\n" +
                "----------------\n" +
                "\n" +
                "1.  A monster has several attributes:\n" +
                "    (1) A name\n" +
                "    (2) A level\n" +
                "    (3) HP\n" +
                "    (4) A base damage value\n" +
                "    (5) A defense value\n" +
                "    (6) A dodge ability\n" +
                "\n" +
                "2.  Base damage. This is a monster’s attack damage.\n" +
                "3.  Defense. Monsters don’t wear armor, relying on their natural hides and carapaces to\n" +
                "    protect them from the heroes’ attacks. This value reduces the amount of damage a monster\n" +
                "    takes from a hero’s attack or spell.\n" +
                "4.  Dodge ability. This represents how well a monster can avoid a hero’s attack. It functions in a\n" +
                "    similar way to the hero’s agility.\n" +
                "5.  There are three kinds of monsters, each with a favored attribute:\n" +
                "    (1) Dragons have increased base damage.\n" +
                "    (2) Exoskeletons have increased defense.\n" +
                "    (3) Spirits have increased dodge ability.";

        System.out.println(rules);
    }

    public void printRulesMarket() {
        String rules = "\n********************\n" +
                "|   Market Rules   |\n" +
                "********************\n" +
                "\n" +
                "1.  The heroes can buy and sell items at any market. Items that are sold at every market are:\n" +
                "    (1) Armors\n" +
                "    (2) Potions\n" +
                "    (3) Spells\n" +
                "    (4) Weapons\n" +
                "2.  Each hero has a private wallet (their gold amount) and does not share money with the other heroes.\n" +
                "    Likewise, each hero has their own inventory of items that they do not share with their fellow heroes.\n" +
                "3.  A hero can sell an item that is not consumable i.e. potions and spells cannot be sold.\n" +
                "\n" +
                "    Money earned by hero after a successful sale = 0.5 * the item's cost\n" +
                "\n" +
                "    The item will be removed from the player's inventory.\n" +
                "4.  A successful purchase will reduce the amount of money the hero has, and the item will be transferred to\n" +
                "    the hero’s inventory.\n" +
                "5.  All items have a name, a price, and a level. A hero cannot buy:\n" +
                "    (1) an item that costs more than the money they have, or\n" +
                "    (2) an item that is a higher level than they are.\n" +
                "6.  You can provide the following commands (Not case-sensitive):\n" +
                "    (1) View Market: To view the items in the market\n" +
                "    (2) <Hero ID> buy <Item ID>: To buy an item for a hero e.g. R0 buy B0\n" +
                "    (3) <Hero ID> sell <Item ID>: To sell an item that a hero has e.g. R0 sell B0\n" +
                "    (4) I/i: To view all the heroes you have\n" +
                "    (5) Hero <Hero ID>: To view the details of a hero\n" +
                "    (6) Q/q: To quit the game\n" +
                "    (7) H/h: To view possible commands for Market\n" +
                "    (8) R/r: To view the rules of the market\n" +
                "    (9) X/x: To exit the market and go back to the map\n" +
                "\n" +
                "----------------\n" +
                "|  Item Types  |\n" +
                "----------------\n" +
                "\n" +
                "1.  Armor: Armor reduces the incoming damage from a monster’s attack. A piece of armor has\n" +
                "    a name, a price, a level, and a damage reduction value. When equipped, armor will reduce\n" +
                "    the damage taken by the hero by its damage reduction value. A hero can equip at most one\n" +
                "    piece of armor at a time.\n" +
                "2.  Potions: Potions can be used by a hero in order to increase one of their statistics by some\n" +
                "    amount. Potions are multi-use items, and each potion can be consumed a different number of times.\n" +
                "    Potions have a name, a price, a level, and an effect amount. Using the potion should\n" +
                "    increase the given statistic by the effect amount. There are potions for increasing hit points, mana,\n" +
                "    strength, dexterity, and agility.\n" +
                "3.  Spells. A spell represents a magic attack performed by a hero. A spell has a name, a price, a\n" +
                "    level, a damage value, a mana cost, and a spell type. A hero will require at least the mana\n" +
                "    cost amount of mana to cast the spell. Therefore, if a hero has no mana, that hero cannot cast\n" +
                "    any spells. The damage value is used along with the hero’s dexterity value to calculate the\n" +
                "    damage dealt during a spell cast move in a battle.\n" +
                "\n" +
                "    Hero’s spell damage = spell_base_damage + (dexterity/10000) * spell_base_damage\n" +
                "\n" +
                "    After casting a spell, the mana cost is deducted from the hero’s mana.\n" +
                "    Spells also have an additional effect besides their damage.\n" +
                "\n" +
                "    The types of spell and their effects are:\n" +
                "    (1) Ice spell: reduces the amount of damage the target can cause\n" +
                "    (2) Fire spell: reduces the defense of the target\n" +
                "    (3) Lightning spell: reduces the dodge chance of the target\n" +
                "\n" +
                "4.  Weapons: A weapon is used by a hero to attack a monster. A weapon has a name, a price, a\n" +
                "    level, a damage value, and the number of hands required to use it. A weapon must be\n" +
                "    equipped by the hero before it can be used. The damage value is used to calculate the\n" +
                "    damage dealt during an attack move in a battle.\n" +
                "\n" +
                "    Hero's attack damage with weapon= (hero's strength + weapon_damage) * 0.05";

        System.out.println(rules);
    }
}
