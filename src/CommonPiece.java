import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonPiece extends MHPiece {
    public static final String name = "Common";
    public static final String id = "C";
    public static final String playerId = "C*";
    private int numberOfHeroes = 0;
    private int numberOfHeroesWin = 0;
    private Monsters monsters = new Monsters();
    private boolean haveBattle = false;

    private Heroes heroesAlive = new Heroes();

    public CommonPiece() {
        super(name, id);
    }

    public int getNumberOfHeroes() {
        return numberOfHeroes;
    }

    public void setNumberOfHeroes(int numberOfHeroes) {
        this.numberOfHeroes = numberOfHeroes;
    }

    public void  checkNumberOfHeroesStillAlive(MHPlayer player) {
        for (int i = 0; i < player.getHeroes().getHeroes().size(); i++) {
            if (!player.getHeroes().getHeroes().get(i).isUnconscious()) {
                numberOfHeroes++;
                heroesAlive.addHero(player.getHeroes().getHeroes().get(i));
            }
        }
    }

    public boolean isHaveBattle() {
        return haveBattle;
    }

    public boolean enterCommon(MHPlayer player) {
        boolean hasQuit = false;
        // Represents that a player is in the common area
        setId(playerId);
        List<Integer> startingHP = new ArrayList<>();
        List<Integer> startingMana = new ArrayList<>();
        List<Integer> monsterLevel = new ArrayList<>();

        boolean haveMonster = haveMonsters();
//        System.out.println("\nHave Monsters? " + haveMonster);
       if (haveMonster) {
           haveBattle = true;
           checkNumberOfHeroesStillAlive(player);
           monsters = getMonsters();

           for (int i = 0; i < numberOfHeroes; i++) {
               Hero hero = heroesAlive.getHeroes().get(i);
               Monster monster = monsters.getMonsters().get(i);

               startingHP.add(hero.getHitPoints());
               startingMana.add(hero.getMana());
               monsterLevel.add(monster.getLevel());

               Fighters fighters = setFighters(hero, monster);
               Battle battle = new Battle(fighters);
               String result = battle.fight();
               if (result.equals("q")) {
                   hasQuit = true;
                   break;
               } else {
                   if (result.equals("hero")) {
                       numberOfHeroesWin++;
                   }
               }
           }

           if (!hasQuit) {
               /* Check if the number of heroes who won is more than the number of monsters,
               which is the same as the number of heroes. Revive heroes if true.
                */
               if ((double) numberOfHeroesWin >= (double) numberOfHeroes / 2) {
                   for (int i = 0; i < numberOfHeroes; i++) {
                       Hero hero = player.getHeroes().getHeroFromId(heroesAlive.getHeroes().get(i).getId());
                       hero.revive(startingHP.get(i), startingMana.get(i));
                   }
               }
           }
       }

       return hasQuit;
    }

    public void leaveCommon() {
        setId(id);
        System.out.println("Exiting Common area...");
    }

    public boolean haveMonsters() {
        Random random = new Random();

        return random.nextBoolean();
    }

    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }

    public Monsters getMonsters() {
        GenerateMonsters gm = new GenerateMonsters(numberOfHeroes);

        return gm.getMonsters();
    }

    public Fighters setFighters(Hero hero, Monster monster) {
        Fighters fighters = new Fighters(hero, monster);

        return fighters;
    }
}
