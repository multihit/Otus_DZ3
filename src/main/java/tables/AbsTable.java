package tables;

import db.IDBConnector;
import db.MySQLConnector;
import objects.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbsTable {
    protected String tableName;
    protected Map<String, String> columns;
    protected IDBConnector db = new MySQLConnector();

    public AbsTable(String tableName) {
        this.tableName = tableName;
    }

    public void create() {
        String sqlRequest = String.format("CREATE TABLE IF NOT EXISTS %s (%s)",
                this.tableName, convertMapColumnsToString());
        db.executeRequest(sqlRequest);
    }

    private String convertMapColumnsToString() {
        return columns.entrySet().stream()
                .map((Map.Entry entry) -> String.format("%s %s", entry.getKey(),
                        entry.getValue()))
                .collect(Collectors.joining(", "));
    }

    public ArrayList<Student> select(String query) {
        final String sqlRequest = String.format(query, tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        // Количество колонок в результирующем запросе
        try {
            int columns = rs.getMetaData().getColumnCount();
            // Перебор строк с данными
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
