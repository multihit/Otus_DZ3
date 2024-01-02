package objects;


public class Group {
    private long idGroup;
    private String groupName;
    private long idCurator;

    @Override
    public String toString() {
        return "Группы{" +
                "idGroup=" + idGroup +
                ", groupName='" + groupName + '\'' +
                ", idCurator='" + idCurator + '\'' +
                '}';
    }

    public Group(long id_group, String group_name, long id_curator) {
        this.idGroup = id_group;
        this.groupName = group_name;
        this.idCurator = id_curator;

    }

    public long getId() {
        return idGroup;
    }

    public void setId(long id_group) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getIdCurator() {
        return idCurator;
    }

    public void setIdCurator(long idCurator) {
        this.idCurator = idCurator;
    }

}