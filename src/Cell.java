// Represents a cell in a board
public class Cell {
    private String cellType;
    private Piece piece;
    private Boolean isOccupied = false;

    public Cell(String cellType, Piece piece) {
        this.cellType = cellType;
        this.piece = piece;
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
