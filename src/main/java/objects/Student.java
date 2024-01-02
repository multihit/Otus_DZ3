package objects;

public class Student {
    private long id;
    private String fullName, sex;
    private int idGroup;


    @Override
    public String toString() {
        return "Студенты{" +
                +id +
                ", '" + fullName + '\'' +
                ",'" + sex + '\'' +
                ", idGroup='" + idGroup + '\'' +
                '}';
    }


    public Student(Long id, String fullName, String sex, int idGroup) {
        this.id = id;
        this.fullName = fullName;
        this.sex = sex;
        this.idGroup = idGroup;
    }


    public Student(String full_name, String sex, int idGroup) {
        this.fullName = full_name;
        this.sex = sex;
        this.idGroup = idGroup;
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

    public void setFullName(String type) {
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
