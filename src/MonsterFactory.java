public interface MonsterFactory <T extends Monster> {
    void generateMonsters();
    T getAMonster(int index);
    int getNumberOfMonsters();
}
