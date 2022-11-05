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

    public MHCell getMHBoardCell(int row, int column) {
        return getMHBoard()[row][column];
    }

    /* When player first starts playing, place the player in a random cell
    that is either a common space or has a market
     */
    public MHCell getRandomMarketCell() {
        MHCell cellWanted;

        do {
            int rowIndex = (int) (Math.random() * (numberOfRowsAndCols - 1));
            int columnIndex = (int) (Math.random() * (numberOfRowsAndCols - 1));
            cellWanted = getMHBoard()[rowIndex][columnIndex];
        } while(!(cellWanted.getPiece() instanceof MarketPiece));

        return cellWanted;
    }

    @Override
    public void printBoard() {
        int rows = numberOfRowsAndCols + 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numberOfRowsAndCols; j++) {
                System.out.print("+-----");
            }
            System.out.println("+");

            if (i < numberOfRowsAndCols) {
                for (int k = 0; k < numberOfRowsAndCols; k++) {
                    String pieceId = getBoard()[i][k].getPiece().getId();
                    if (pieceId.length() == 2) {
                        System.out.print("| " + pieceId + " ");
                    } else {
                        System.out.print("| " + pieceId + "  ");
                    }
                }
                System.out.println("|");
            }
        }
        System.out.println("*: You are here\t\tI: Invalid Area\t\tM: Market\t\tC: Common Area");
    }

    public int[] getRowAndColumnIndex() {
        int[] rowAndColumnIndex = {-1, -1};

        for (int i = 0; i < numberOfRowsAndCols; i++) {
            for (int j = 0; j < numberOfRowsAndCols; j++) {
                if (rowAndColumnIndex[0] != -1 && rowAndColumnIndex[1] != -1) {
                    break;
                } else {
                    if (getMHBoardCell(i, j).getPiece().getId().contains("*")) {
                        rowAndColumnIndex[0] = i;
                        rowAndColumnIndex[j] = j;
                        break;
                    }
                }
            }
        }

        return rowAndColumnIndex;
    }
}
