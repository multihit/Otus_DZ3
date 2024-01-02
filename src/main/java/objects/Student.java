package objects;

public class Student {
    private long id;
    private String full_name, sex;
    private int id_group;


    @Override
    public String toString() {
        return "Студенты{" +
                +id +
                ", '" + full_name + '\'' +
                ",'" + sex + '\'' +
                ", id_group='" + id_group + '\'' +
                '}';
    }


    public Student(Long id, String full_name, String sex, int id_group) {
        this.id = id;
        this.full_name = full_name;
        this.sex = sex;
        this.id_group = id_group;
    }


    public Student(String full_name, String sex, int id_group) {
        this.full_name = full_name;
        this.sex = sex;
        this.id_group = id_group;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String type) {
        this.full_name = full_name;
    }


    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
