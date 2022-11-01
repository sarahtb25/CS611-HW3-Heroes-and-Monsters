public interface HeroFactory <T extends Hero> {
    void generateHeroes();
    T getAHero(int index);
    int getNumberOfHeroes();
}
