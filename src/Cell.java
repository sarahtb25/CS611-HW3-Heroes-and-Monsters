// Represents a cell in a board
public class Cell {
    private String cellType;
    private Piece piece;
    private Boolean isOccupied;

    public Cell(String cellType, Piece piece) {
        this.cellType = cellType;
        this.piece = piece;
        isOccupied = false;
    }

    public Cell() {
        this.cellType = "none";
        this.piece = new Piece();
        isOccupied = false;
    }

    public String getCellType() {
        return cellType;
    }

    public void setCellType(String cellType) {
        this.cellType = cellType;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }
}
