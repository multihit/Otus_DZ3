package objects;

public class Curator {
    private long id;
    private String curatorName;


    @Override
    public String toString() {
        return "Кураторы{" +
                "id=" + id +
                ", curatorName='" + curatorName + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public Curator(long id, String groupName) {
        this.id = id;
        this.curatorName = groupName;
    }

    public Curator(String curatorName) {
        this.curatorName = curatorName;


    }
}
