// Represents a cell in Monsters and Heroes board
public class MHCell extends Cell {
    /* There is no cell type for Monsters and Heroes. The game pieces control whether the cell is invalid,
    a common space or has a market (MarketPiece contains the market)
     */
    public static final String MHCellType = "none";

    public MHCell(MHPiece piece) {
        super(MHCellType, piece);
    }
}
