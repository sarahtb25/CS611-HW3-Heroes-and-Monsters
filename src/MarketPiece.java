// A Monsters and Heroes game piece that is used to represent a cell that has a market
public class MarketPiece extends MHPiece {
    public static final String name = "Market";
    public static final String id = "M";
    public static final String playerId = "M*";
    private Market market = new Market();

    public MarketPiece() {
        super(name, id);
    }

    public void beforeEnteringMarket() {
        setId(playerId);
    }

    public boolean market(MHPlayer player) {
        String userInput = getUserInput(player);

        // if true, exit game
        return leaveOrQuitMarket(userInput);
    }

    public void leaveMarket() {
        setId(id);
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
