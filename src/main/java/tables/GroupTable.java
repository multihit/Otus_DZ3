package tables;

import objects.Group;
import objects.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupTable extends AbsTable {
    private final static String TABLE_NAME = "group1";

    public GroupTable() {
        super(TABLE_NAME);
        columns = new HashMap<>();
        columns.put("id", "bigint");
        columns.put("group_name", "VARCHAR(50)");
        columns.put("id_curator", "int");
        create();
    }

    public ArrayList<Group> selectAll() {
        //Сделать запрос на выборку
        final String sqlRequest = String.format("SELECT * FROM %s", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        return resultSetToArray(rs);
    }


    public void insert(Group group) {
        //Сделать запрос на добавление
        final String sqlRequest = String.format("INSERT INTO %s (id, group_name, id_curator) " +
                        "VALUES (%d, '%s', '%d')",
                tableName,
                group.getId(),
                group.getGroup_name(),
                group.getId_curator());
        db.executeRequest(sqlRequest);

    }

    private ArrayList<Group> resultSetToArray(ResultSet rs) {
        ArrayList<Group> result = new ArrayList<>();
        //Обработать ответ по строчно
        try {
            // Перебор строк с данными
            while (rs.next()) {
                //Создать объект устройство и добавление его в результирующий массив
                result.add(
                        new Group(
                                rs.getLong("id"),
                                rs.getString("group_name"),
                                rs.getLong("id_curator")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

            return result;
        }
        return result;
    }


    public void updateId( int id_curator){

        String sqlQuery = String.format("UPDATE %s SET id_curator=%s", tableName, id_curator );
        db.executeRequest(sqlQuery);

    }


    public void updateIdByName(String groupName, int idCurator, String tableName){

        String sqlQuery = String.format("UPDATE %s SET id_curator=%s WHERE group_name='%s'", tableName,
                idCurator,groupName );
        db.executeRequest(sqlQuery);

    }


}
