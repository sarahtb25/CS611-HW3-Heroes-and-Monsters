public class MarketPiece extends MHPiece {
    public static final String name = "Market";
    public static final String id = "M";

    public MarketPiece() {
        super(name, id);
    }

    // To be used when a player decides to move their hero(es) into the market
    public MarketPiece(String playerId) {
        super(name, playerId);
    }
}
