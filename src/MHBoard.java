import java.util.Arrays;
import java.util.List;

// Represents the board used in Monsters and Heroes
public class MHBoard extends Board {
    public static final int NUMBER_OF_ROWS_AND_COLS = 8;
    public static final double PROPORTION_OF_INVALID = 0.2; // 20% Invalid
    public static final int NUMBER_OF_INVALID = (int) (PROPORTION_OF_INVALID * NUMBER_OF_ROWS_AND_COLS * NUMBER_OF_ROWS_AND_COLS);
    public static final double PROPORTION_OF_MARKET = 0.3; // 30% Market
    public static final int NUMBER_OF_MARKET = (int) (PROPORTION_OF_MARKET * NUMBER_OF_ROWS_AND_COLS * NUMBER_OF_ROWS_AND_COLS);

    public MHBoard() {
        super(NUMBER_OF_ROWS_AND_COLS);
        Cell[][] board = getMHBoard();

        for (int i = 0; i < NUMBER_OF_INVALID; i++) {
            int row = (int) (Math.random() * NUMBER_OF_ROWS_AND_COLS);
            int col = (int) (Math.random() * NUMBER_OF_ROWS_AND_COLS);

            if (!board[row][col].getOccupied()) {
                board[row][col].setPiece(new InvalidPiece());
                board[row][col].setOccupied(true);
            }
        }

        for (int i = 0; i < NUMBER_OF_MARKET; i++) {
            int row = (int) (Math.random() * NUMBER_OF_ROWS_AND_COLS);
            int col = (int) (Math.random() * NUMBER_OF_ROWS_AND_COLS);

            if (!board[row][col].getOccupied()) {
                board[row][col].setPiece(new MarketPiece());
                board[row][col].setOccupied(true);
            }
        }

        for (int row = 0; row < NUMBER_OF_ROWS_AND_COLS; row++) {
            for (int col = 0; col < NUMBER_OF_ROWS_AND_COLS; col++) {
                if (!board[row][col].getOccupied()) {
                    board[row][col].setPiece(new CommonPiece());
                    board[row][col].setOccupied(true);
                }
            }
        }

        setBoard(board);
    }

    public Cell[][] getMHBoard() {
        return getBoard();
    }

    public Cell getMHBoardCell(int row, int column) {
        return getMHBoard()[row][column];
    }

    /* When player first starts playing, place the player in a random cell
    that is either a common space or has a market
     */
    public Cell getRandomMarketCell() {
        Cell cellWanted;

        do {
            int rowIndex = (int) (Math.random() * (NUMBER_OF_ROWS_AND_COLS - 1));
            int columnIndex = (int) (Math.random() * (NUMBER_OF_ROWS_AND_COLS - 1));
            cellWanted = getMHBoard()[rowIndex][columnIndex];
        } while(!(cellWanted.getPiece() instanceof MarketPiece));

        return cellWanted;
    }

    @Override
    public void printBoard() {
        int rows = NUMBER_OF_ROWS_AND_COLS + 1;
        Cell[][] board = getMHBoard();
        System.out.println("\n");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS_AND_COLS; j++) {
                System.out.print("+----");
            }
            System.out.println("+");

            if (i < NUMBER_OF_ROWS_AND_COLS) {
                for (int k = 0; k < NUMBER_OF_ROWS_AND_COLS; k++) {
                    String pieceId = board[i][k].getPiece().getId();

                    if (pieceId.length() == 2) { // Player is here
                        System.out.print("| " + ConsoleColours.YELLOW_BOLD + pieceId + ConsoleColours.RESET + " ");
                    } else {
                        switch (pieceId) {
                            case "M":
                                System.out.print("| " + ConsoleColours.CYAN + pieceId + ConsoleColours.RESET + "  ");
                                break;
                            case "C":
                                System.out.print("| " + ConsoleColours.YELLOW + pieceId + ConsoleColours.RESET + "  ");
                                break;
                            case "I":
                                System.out.print("| " + ConsoleColours.RED + pieceId + ConsoleColours.RESET + "  ");
                                break;
                        }
                    }
                }
                System.out.println("|");
            }
        }
        System.out.println(ConsoleColours.YELLOW_BOLD + "*: You are here\t\t" + ConsoleColours.RED + "I: Invalid Area\t\t" + ConsoleColours.CYAN + "M: Market\t\t" + ConsoleColours.YELLOW + "C: Common Area" + ConsoleColours.RESET);
    }

    public int[] getRowAndColumnIndex() {
        int[] rowAndColumnIndex = {-1, -1};

        for (int i = 0; i < NUMBER_OF_ROWS_AND_COLS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS_AND_COLS; j++) {
                if (getMHBoardCell(i, j).getPiece().getId().contains("*")) {
                    rowAndColumnIndex[0] = i;
                    rowAndColumnIndex[1] = j;
                    break;
                }
            }

            if (rowAndColumnIndex[0] != -1 && rowAndColumnIndex[1] != -1) {
                break;
            }
        }

        return rowAndColumnIndex;
    }

    public void leaveCell(int row, int column) {
        Cell cell = getMHBoardCell(row, column);

        if (cell.getPiece() instanceof CommonPiece) {
            CommonPiece commonPiece = (CommonPiece) cell.getPiece();
            if (cell.getPiece().getId().equals("C*")) {
                commonPiece.leaveCommon();
            }
        } else if (cell.getPiece() instanceof MarketPiece) {
            MarketPiece marketPiece = (MarketPiece) cell.getPiece();
            if (cell.getPiece().getId().equals("M*")) {
                marketPiece.leaveMarket();
            }
        }
    }

    public boolean checkIfCanEnterCell(int row, int column) {
        boolean canEnter = false;

        Cell cell = getMHBoardCell(row, column);

        if (cell.getPiece() instanceof CommonPiece) {
            if (cell.getPiece().getId().equals("C")) {
                canEnter = true;
            }
        } else if (cell.getPiece() instanceof MarketPiece) {
            if (cell.getPiece().getId().equals("M")) {
                canEnter = true;
            }
        } else if (cell.getPiece().getId().equals("I")) {
            System.out.println(ConsoleColours.RED + "\n[ERROR] You are not allowed to come to an invalid area!" + ConsoleColours.RESET);
        }

        return canEnter;
    }

    public List<Boolean> enterCell(int row, int column, MHPlayer player) {
        List<Boolean> hasQuitAndBattle = Arrays.asList(false, false);

        Cell cell = getMHBoardCell(row, column);

        if (cell.getPiece() instanceof CommonPiece) {
            CommonPiece commonPiece = (CommonPiece) cell.getPiece();
            if (cell.getPiece().getId().equals("C")) {
                hasQuitAndBattle.set(0, commonPiece.enterCommon(player));
                hasQuitAndBattle.set(1, commonPiece.isHaveBattle());
            }
        } else if (cell.getPiece() instanceof MarketPiece) {
            MarketPiece marketPiece = (MarketPiece) cell.getPiece();
            if (cell.getPiece().getId().equals("M")) {
                marketPiece.beforeEnteringMarket();
            }
        }

        return hasQuitAndBattle;
    }

    // W/w
    public List<Boolean> moveUp(MHPlayer player) {
        List<Boolean> hasQuitAndBattle = Arrays.asList(false, false);
        int[] rowAndColumnIndex = getRowAndColumnIndex();

        if (rowAndColumnIndex[0] - 1 >= 0) {
            rowAndColumnIndex[0] -= 1;
            boolean canEnter = checkIfCanEnterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
//            System.out.println("Can Go UP? " + canEnter);
            if (canEnter) {
                hasQuitAndBattle = enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1], player);
                // leave previous cell
                leaveCell((rowAndColumnIndex[0] + 1), rowAndColumnIndex[1]);
            }
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] You cannot go outside the map!" + ConsoleColours.RESET);
        }

        return hasQuitAndBattle;
    }

    // A/a
    public List<Boolean> moveLeft(MHPlayer player) {
        List<Boolean> hasQuitAndBattle = Arrays.asList(false, false);
        int[] rowAndColumnIndex = getRowAndColumnIndex();

        if (rowAndColumnIndex[1] - 1 >= 0) {
            rowAndColumnIndex[1] -= 1;
            boolean canEnter = checkIfCanEnterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
//            System.out.println("Can Go LEFT? " + canEnter);
            if (canEnter) {
                hasQuitAndBattle = enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1], player);
                // leave previous cell
                leaveCell(rowAndColumnIndex[0], (rowAndColumnIndex[1] + 1));
            }
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] You cannot go outside the map!" + ConsoleColours.RESET);
        }

        return hasQuitAndBattle;
    }

    // S/s
    public List<Boolean> moveDown(MHPlayer player) {
        List<Boolean> hasQuitAndBattle = Arrays.asList(false, false);
        int[] rowAndColumnIndex = getRowAndColumnIndex();

        if (rowAndColumnIndex[0] + 1 < NUMBER_OF_ROWS_AND_COLS) {
            rowAndColumnIndex[0] += 1;
            boolean canEnter = checkIfCanEnterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
//            System.out.println("Can Go DOWN? " + canEnter);
            if (canEnter) {
                hasQuitAndBattle = enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1], player);
                // leave previous cell
                leaveCell((rowAndColumnIndex[0] - 1), rowAndColumnIndex[1]);
            }
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] You cannot go outside the map!" + ConsoleColours.RESET);
        }

        return hasQuitAndBattle;
    }

    // D/d
    public List<Boolean> moveRight(MHPlayer player) {
        List<Boolean> hasQuitAndBattle = Arrays.asList(false, false);
        int[] rowAndColumnIndex = getRowAndColumnIndex();

        if (rowAndColumnIndex[1] + 1 < NUMBER_OF_ROWS_AND_COLS) {
            rowAndColumnIndex[1] += 1;
            boolean canEnter = checkIfCanEnterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
//            System.out.println("Can Go RIGHT? " + canEnter);
            if (canEnter) {
                hasQuitAndBattle = enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1], player);
                // leave previous cell
                leaveCell(rowAndColumnIndex[0], (rowAndColumnIndex[1] - 1));
            }
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] You cannot go outside the map!" + ConsoleColours.RESET);
        }

        return hasQuitAndBattle;
    }

    // M/m
    public boolean goToMarket(MHPlayer player) {
        boolean quit = false;
        int[] rowAndColumnIndex = getRowAndColumnIndex();
        Cell cell = getMHBoardCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);

        if (cell.getPiece() instanceof MarketPiece) {
            MarketPiece marketPiece = (MarketPiece) cell.getPiece();
            quit = marketPiece.market(player);
        } else {
            System.out.println(ConsoleColours.RED + "\n[ERROR] There is no market here!" + ConsoleColours.RESET);
        }

        return quit;
    }
}
