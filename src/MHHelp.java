// Help for Monsters and Heroes
public class MHHelp implements Help {
    @Override
    public void printIntroduction() {

    }

    @Override
    public void printHelp() {
        printHelpMap();
        printHelpMarket();
        printHelpMarket();
    }

    public void printHelpBattle() {
        String help = "***************\n" +
                    "|   Battle    |\n" +
                    "***************\n" +
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
                    "    6. H/h: To view possible commands for battle";

        System.out.println(help);
    }

    public void printHelpMarket() {
        String help = "***************\n" +
                "|   Market    |\n" +
                "***************\n" +
                "\n" +
                "Commands allowed in the market (Not case-sensitive):\n" +
                "    1. View Market: To view the items in the market\n" +
                "    2. <Hero ID> buy <Item ID>: To buy an item for a hero e.g. R0 buy B0\n" +
                "    3. <Hero ID> sell <Item ID>: To sell an item that a hero has e.g. R0 sell B0\n" +
                "    4. View Heroes: To view all the heroes you have\n" +
                "    5. <Hero ID>: To view the details of a hero\n" +
                "    6. Q/q: To quit the game\n" +
                "    7. H/h: To view possible commands for Market";

        System.out.println(help);
    }

    public void printHelpMap() {
        String help = "************\n" +
                "|   Map    |\n" +
                "************\n" +
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
                "    9. View Map: To view the map\n" +
                "    10. <Hero ID> Inventory: To view the inventory of a hero e.g. R0 Inventory\n" +
                "    11. <Hero ID> drink <Potion ID>: To get a hero to consume a potion e.g. R0 drink P0\n" +
                "    12. Hero <Hero ID>: To view the e.g. Hero R0\n" +
                "    13. Regenerate Map: To create a new map e.g. if you are stuck, or just\n" +
                "                        don't like the map you have\n" +
                "    14. <Hero ID> change <Weapon or Armor ID>: To update the weapon or armor a hero is or\n" +
                "                                                is not carrying/wearing e.g. R0 change B0";

        System.out.println(help);
    }
}
