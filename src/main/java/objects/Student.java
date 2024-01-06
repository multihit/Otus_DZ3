package objects;

public class Student {
    private long id;
    private String fullName, sex;
    private int idGroup;

    public Student(Long id, String fullName, String sex, int idGroup) {
        this.id = id;
        this.fullName = fullName;
        this.sex = sex;
        this.idGroup = idGroup;
    }

    public Student(String fullName, String sex, int idGroup) {
        this.fullName = fullName;
        this.sex = sex;
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "Студенты{" +
                id +
                ", '" + fullName + '\'' +
                ",'" + sex + '\'' +
                ", idGroup='" + idGroup + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
