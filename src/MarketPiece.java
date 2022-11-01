public class MarketPiece extends MHPiece {
    public static final String name = "Market";
    public static final String id = "M";
    private Market market = new Market();
    private MHPlayer player;

    public MarketPiece() {
        super(name, id);
    }

    // To be used when a player decides to move their hero(es) into the market
    public MarketPiece(String playerId, MHPlayer player) {
        super(name, playerId);
        this.player = player;
    }

    public String getUserInput() {
        // x (to exit market) or q (to quit the game)
        String userInput = market.getUserInput(player);

        return userInput;
    }
}
