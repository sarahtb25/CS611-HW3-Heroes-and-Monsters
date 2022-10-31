// This class represents a game piece
public class Piece {
    private String name;
    private String id;

    public Piece() {
        this.name = "none";
        this.id = " ";
    }
    public Piece(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
