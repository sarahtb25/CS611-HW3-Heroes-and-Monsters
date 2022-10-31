// Represents a board
public class Board {
    private int numberOfRows;
    private int numberOfColumns;
    private Cell[][] board;

    public Board(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        board = new Cell[numberOfRows][numberOfColumns];
    }

    public Board(int numberOfRowsAndColumns) {
        this(numberOfRowsAndColumns, numberOfRowsAndColumns);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public void updateCellInBoard(int row, int column, Piece piece) {
        board[row][column].setPiece(piece);
    }

    public void printBoard() {
        int rows = numberOfRows + 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print("+---");
            }
            System.out.println("+");

            if (i < numberOfRows) {
                for (int k = 0; k < numberOfColumns; k++) {
                    String pieceId = board[i][k].getPiece().getId();
                    System.out.print("| " + pieceId + " ");
                }
                System.out.println("|");
            }
        }
    }
}
