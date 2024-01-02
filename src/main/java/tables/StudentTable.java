package tables;


import objects.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentTable extends AbsTable {

    public StudentTable() {
        super("students");
        columns = new HashMap<>();
        columns.put("id", "INT NOT NULL AUTO_INCREMENT PRIMARY KEY");
        columns.put("full_name", "varchar(100)");
        columns.put("sex", "varchar(10)");
        columns.put("id_group", "int");
        create();
    }

    public ArrayList<Student> selectAll() {
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }


    private ArrayList<Student> selectByQuery(String sqlQuery) {
        ArrayList<Student> students = new ArrayList<>();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            // Перебор строк с данными
            while (rs.next()) {
                //Создать объект устройство и добавление его в результирующий массив
                students.add(new Student(
                        rs.getLong("id"),
                        rs.getString("full_name"),
                        rs.getString("sex"),
                        rs.getInt("id_group")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public void insert(Student student) {

        String sqlQuery = String.format("INSERT INTO %s (full_name, sex, id_group) " +
                        "VALUES ( '%s', '%s', '%d')",
                tableName,
                student.getFull_name(),
                student.getSex(),
                student.getId_group());
        db.executeRequest(sqlQuery);

    }

}
