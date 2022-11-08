/* An interface that represents the expected behaviour of factories that will generate the various types of monsters
e.g. Dragon, Exoskeleton and Spirit
 */
public interface MonsterFactory <T extends Monster> {
    void generateMonsters();
    T getAMonster(int index);
    int getNumberOfMonsters();
}
