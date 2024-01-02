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
        columns.put("fullName", "varchar(100)");
        columns.put("sex", "varchar(10)");
        columns.put("idGroup", "int");
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
                        rs.getString("fullName"),
                        rs.getString("sex"),
                        rs.getInt("idGroup")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public void insert(Student student) {

        String sqlQuery = String.format("INSERT INTO %s (fullName, sex, idGroup) " +
                        "VALUES ( '%s', '%s', '%d')",
                tableName,
                student.getFullName(),
                student.getSex(),
                student.getIdGroup());
        db.executeRequest(sqlQuery);

    }

}
