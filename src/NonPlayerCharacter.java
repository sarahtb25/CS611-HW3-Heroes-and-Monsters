import java.util.Objects;

/* This class represents any character that is not a player.
e.g. in Monsters and Heroes, Monsters and Heroes are the non player characters
 */
public class NonPlayerCharacter {
    private String name;
    private String id;

    public NonPlayerCharacter() {

    }

    public NonPlayerCharacter(String name, String id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NonPlayerCharacter)) return false;
        NonPlayerCharacter that = (NonPlayerCharacter) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
