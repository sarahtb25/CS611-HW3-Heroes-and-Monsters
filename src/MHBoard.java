public class MHBoard extends Board {
    public static final int numberOfRowsAndCols = 8;
    public static final double proportionOfInvalid = 0.2; // 20% Invalid
    public static final int numberOfInvalid = (int) (proportionOfInvalid * numberOfRowsAndCols * numberOfRowsAndCols);
    public static final double proportionOfMarket = 0.3; // 30% Market
    public static final int numberOfMarket = (int) (proportionOfMarket * numberOfRowsAndCols * numberOfRowsAndCols);

    public MHBoard() {
        super(numberOfRowsAndCols);
        MHCell[][] board = getMHBoard();
        for (int i = 0; i < numberOfInvalid; i++) {
            int row = (int) (Math.random() * numberOfRowsAndCols);
            int col = (int) (Math.random() * numberOfRowsAndCols);

            if (!board[row][col].getOccupied()) {
                board[row][col].setPiece(new InvalidPiece());
                board[row][col].setOccupied(true);
            }
        }

        for (int i = 0; i < numberOfMarket; i++) {
            int row = (int) (Math.random() * numberOfRowsAndCols);
            int col = (int) (Math.random() * numberOfRowsAndCols);

            if (!board[row][col].getOccupied()) {
                board[row][col].setPiece(new MarketPiece());
                board[row][col].setOccupied(true);
            }
        }

        for (int row = 0; row < numberOfRowsAndCols; row++) {
            for (int col = 0; col < numberOfRowsAndCols; col++) {
                if (!board[row][col].getOccupied()) {
                    board[row][col].setPiece(new CommonPiece());
                    board[row][col].setOccupied(true);
                }
            }
        }
    }

    public MHCell[][] getMHBoard() {
        return (MHCell[][]) getBoard();
    }
}
