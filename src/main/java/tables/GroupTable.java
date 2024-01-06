package tables;

import objects.Group;

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
        columns.put("groupName", "VARCHAR(50)");
        columns.put("idCurator", "int");
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
        final String sqlRequest = String.format("INSERT INTO %s (id, groupName, idCurator) " +
                        "VALUES (%d, '%s', '%d')",
                tableName,
                group.getId(),
                group.getGroupName(),
                group.getIdCurator());
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
                                rs.getString("groupName"),
                                rs.getLong("idCurator")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return result;
        }
        return result;
    }

    public void updateIdByName(String groupName, int idCurator, String tableName) {
        String sqlQuery = String.format("UPDATE %s SET idCurator=%s WHERE groupName='%s'", tableName,
                idCurator, groupName);
        db.executeRequest(sqlQuery);
    }

    public void selectAllGroupsWithCurators() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Все группы с кураторами:");
        final String sqlQuery = "SELECT group1.idCurator, curator.curatorName, group1.groupName \n" +
                "FROM group1 \n" +
                "JOIN curator \n" +
                "ON group1.idCurator=curator.id;";
        select(sqlQuery);
    }
}
