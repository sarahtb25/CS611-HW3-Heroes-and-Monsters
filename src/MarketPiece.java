public class MarketPiece extends MHPiece {
    public static final String name = "Market";
    public static final String id = "M";
    public static final String playerId = "X";
    private Market market = new Market();
    private MHPlayer player;

    public MarketPiece() {
        super(name, id);
    }

    public void enterMarket(MHPlayer player) {
        setId(playerId);
        String userInput = getUserInput();

        if (userInput.equals("x")) {
            leaveMarket(userInput);
        }
    }

    public boolean leaveMarket(String leaveOrQuit) {
        System.out.println("Exiting Market");
        setId(id);

        // exiting market only, not the game
        if (leaveOrQuit.equals("x")) {
            return false;
        }

        // exiting game
        return true;
    }

    public String getUserInput() {
        // x (to exit market) or q (to quit the game)
        String userInput = market.getUserInput(player);

        return userInput;
    }
}
