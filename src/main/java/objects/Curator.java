package objects;

public class Curator {
    private long id;
    private String curator_name;


    @Override
    public String toString() {
        return "Кураторы{" +
                "id=" + id +
                ", curator_name='" + curator_name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurator_name() {
        return curator_name;
    }

    public void setCurator_name(String curator_name) {
        this.curator_name = curator_name;
    }

    public Curator(long id, String group_name) {
        this.id = id;
        this.curator_name = group_name;
    }

    public Curator(String curator_name) {
        this.curator_name = curator_name;


    }
}
