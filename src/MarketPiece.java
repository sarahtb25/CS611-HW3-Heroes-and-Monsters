// A Monsters and Heroes game piece that is used to represent a cell that has a market
public class MarketPiece extends MHPiece {
    public static final String NAME = "Market";
    public static final String ID = "M";
    public static final String PLAYER_ID = "M*";
    private Market market = new Market();

    public MarketPiece() {
        super(NAME, ID);
    }

    public void beforeEnteringMarket() {
        setId(PLAYER_ID);
    }

    public boolean market(MHPlayer player) {
        String userInput = getUserInput(player);

        // if true, exit game
        return leaveOrQuitMarket(userInput);
    }

    public void leaveMarket() {
        setId(ID);
    }

    public boolean leaveOrQuitMarket(String quit) {
        System.out.println("Exiting Market...");

        // exiting market only, not the game
        if (quit.equals("x")) {
            return false;
        }

        // exiting game
        return true;
    }

    public String getUserInput(MHPlayer player) {
        // x (to exit market) or q (to quit the game)
        return market.getUserInput(player);
    }
}
