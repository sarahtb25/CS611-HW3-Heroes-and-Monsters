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
        boolean quit = false;

        if (userInput.equals("x")) {
            quit = leaveMarket(userInput);
        }

        // if true, exit game
        return quit;
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

    public String getUserInput(MHPlayer player) {
        // x (to exit market) or q (to quit the game)
        String userInput = market.getUserInput(player);

        return userInput;
    }
}
