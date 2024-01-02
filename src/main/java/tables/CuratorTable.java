package tables;


import objects.Curator;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CuratorTable extends AbsTable {
    private final static String TABLE_NAME = "curator";

    public CuratorTable() {
        super(TABLE_NAME);
        columns = new HashMap<>();
        columns.put("id", "bigint");
        columns.put("curator_name", "varchar(100)");
        create();
    }

    public ArrayList<Curator> selectAll() {
        //Сделать запрос на выборку
        final String sqlRequest = String.format("SELECT * FROM %s", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        return resultSetToArray(rs);
    }


    public void insert(Curator curator) {
        //Сделать запрос на добавление
        final String sqlRequest = String.format("INSERT INTO %s (id, curator_name) " +
                        "VALUES (%d, '%s')",
                tableName, curator.getId(), curator.getCurator_name());
        db.executeRequest(sqlRequest);

    }

    private ArrayList<Curator> resultSetToArray(ResultSet rs) {
        ArrayList<Curator> result = new ArrayList<>();
        //Обработать ответ по строчно
        try {
            // Перебор строк с данными
            while (rs.next()) {
                //Создать объект устройство и добавление его в результирующий массив
                result.add(
                        new Curator(
                                rs.getLong("id"),
                                rs.getString("curator_name")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

