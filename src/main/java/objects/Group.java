package objects;


public class Group {
    private long id_group;
    private String group_name;
    private long id_curator;

    @Override
    public String toString() {
        return "Группы{" +
                "id_group=" + id_group +
                ", group_name='" + group_name + '\'' +
                ", id_curator='" + id_curator + '\'' +
                '}';
    }

    public Group(long id_group, String group_name, long id_curator) {
        this.id_group = id_group;
        this.group_name = group_name;
        this.id_curator = id_curator;

    }

    public long getId() {
        return id_group;
    }

    public void setId(long id_group) {
        this.id_group = id_group;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Long getId_curator() {
        return id_curator;
    }

    public void setId_curator(long id_curator) {
        this.id_curator = id_curator;
    }

}