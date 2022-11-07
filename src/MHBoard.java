import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

        setBoard(board);
    }

    public MHCell[][] getMHBoard() {
        return (MHCell[][]) getBoard();
    }

    public MHCell getMHBoardCell(int row, int column) {
        return (MHCell) getMHBoard()[row][column];
    }

    /* When player first starts playing, place the player in a random cell
    that is either a common space or has a market
     */
    public MHCell getRandomMarketCell() {
        MHCell cellWanted;

        do {
            int rowIndex = (int) (Math.random() * (numberOfRowsAndCols - 1));
            int columnIndex = (int) (Math.random() * (numberOfRowsAndCols - 1));
            cellWanted = (MHCell) getMHBoard()[rowIndex][columnIndex];
        } while(!(cellWanted.getPiece() instanceof MarketPiece));

        return cellWanted;
    }

    @Override
    public void printBoard() {
        int rows = numberOfRowsAndCols + 1;
        MHCell[][] board = (MHCell[][]) getMHBoard();
        System.out.println("\n");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numberOfRowsAndCols; j++) {
                System.out.print("+----");
            }
            System.out.println("+");

            if (i < numberOfRowsAndCols) {
                for (int k = 0; k < numberOfRowsAndCols; k++) {
                    String pieceId = board[i][k].getPiece().getId();

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
                        rowAndColumnIndex[1] = j;
                        break;
                    }
                }
            }
        }

        return rowAndColumnIndex;
    }

    public void leaveCell(int row, int column) {
        MHCell cell = (MHCell) getMHBoardCell(row, column);

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

        MHCell cell = (MHCell) getMHBoardCell(row, column);

        if (cell.getPiece() instanceof CommonPiece) {
            if (cell.getPiece().getId().equals("C")) {
                canEnter = true;
            }
        } else if (cell.getPiece() instanceof MarketPiece) {
            if (cell.getPiece().getId().equals("M")) {
                canEnter = true;
            }
        } else if (cell.getPiece().getId().equals("I")) {
            System.out.println("You are not allowed to come to an invalid area!");
        }

        return canEnter;
    }

    public List<Boolean> enterCell(int row, int column, MHPlayer player) {
        List<Boolean> hasQuitAndBattle = Arrays.asList(false, false);

        MHCell cell = (MHCell) getMHBoardCell(row, column);

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
            System.out.println("You cannot go outside the map!");
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
            System.out.println("You cannot go outside the map!");
        }

        return hasQuitAndBattle;
    }

    // S/s
    public List<Boolean> moveDown(MHPlayer player) {
        List<Boolean> hasQuitAndBattle = Arrays.asList(false, false);
        int[] rowAndColumnIndex = getRowAndColumnIndex();
        leaveCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);

        if (rowAndColumnIndex[0] + 1 < numberOfRowsAndCols) {
            rowAndColumnIndex[0] += 1;
            boolean canEnter = checkIfCanEnterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
//            System.out.println("Can Go DOWN? " + canEnter);
            if (canEnter) {
                hasQuitAndBattle = enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1], player);
                // leave previous cell
                leaveCell((rowAndColumnIndex[0] - 1), rowAndColumnIndex[1]);
            }
        } else {
            System.out.println("You cannot go outside the map!");
        }

        return hasQuitAndBattle;
    }

    // D/d
    public List<Boolean> moveRight(MHPlayer player) {
        List<Boolean> hasQuitAndBattle = Arrays.asList(false, false);
        int[] rowAndColumnIndex = getRowAndColumnIndex();

        if (rowAndColumnIndex[1] + 1 < numberOfRowsAndCols) {
            rowAndColumnIndex[1] += 1;
            boolean canEnter = checkIfCanEnterCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);
//            System.out.println("Can Go RIGHT? " + canEnter);
            if (canEnter) {
                hasQuitAndBattle = enterCell(rowAndColumnIndex[0], rowAndColumnIndex[1], player);
                // leave previous cell
                leaveCell(rowAndColumnIndex[0], (rowAndColumnIndex[1] - 1));
            }
        } else {
            System.out.println("You cannot go outside the map!");
        }

        return hasQuitAndBattle;
    }

    // M/m
    public boolean goToMarket(MHPlayer player) {
        boolean quit = false;
        int[] rowAndColumnIndex = getRowAndColumnIndex();
        MHCell cell = (MHCell) getMHBoardCell(rowAndColumnIndex[0], rowAndColumnIndex[1]);

        if (cell.getPiece() instanceof MarketPiece) {
            MarketPiece marketPiece = (MarketPiece) cell.getPiece();
            quit = marketPiece.market(player);
        }
        return quit;
    }
}
