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

    public Group(long idGroup, String groupName, long idCurator) {
        this.idGroup = idGroup;
        this.groupName = groupName;
        this.idCurator = idCurator;

    }

    public long getId() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
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