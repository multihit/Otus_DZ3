import db.MySQLConnector;
import objects.Curator;
import objects.Group;
import objects.Student;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.util.ArrayList;

public class Main {

    private static final String groupSearch = "оптика";

    public static void main(String[] args) {
        try {

            StudentTable studentTable = new StudentTable();
            GroupTable groupTable = new GroupTable();
            CuratorTable curatorTable = new CuratorTable();
            ArrayList<Student> students = studentTable.selectAll();

            if (students.size() < 15) {
                studentTable.insert(new Student("Иванов Иван Петрович", "м", 4453));
                studentTable.insert(new Student("Сидоров Инакентий Арестархович", "м", 1154));
                studentTable.insert(new Student("Вакуленко Мария Игнатьевна", "ж", 2256));
                studentTable.insert(new Student("Петрова Жанна Эдуардовна", "ж", 2256));
                studentTable.insert(new Student("Павлова Лариса Викторовна", "ж", 2256));
                studentTable.insert(new Student("Ахмерова Ирина Олеговна", "ж", 1154));
                studentTable.insert(new Student("Лебедев Игнат Альбертович", "м", 2256));
                studentTable.insert(new Student("Зайцев Илья Владимирович", "м", 2256));
                studentTable.insert(new Student("Руденко Алла Вячеславовна", "ж", 11564));
                studentTable.insert(new Student("Кузьмин Борис Васильевич", "м", 4453));
                studentTable.insert(new Student("Волков Алексей Иванович", "м", 4453));
                studentTable.insert(new Student("Белова Ольга Игоревна", "ж", 4453));
                studentTable.insert(new Student("Смирнова Анна Алексеевна", "ж", 4453));
                studentTable.insert(new Student("Кирьянов Константин Сергеевич", "м", 2256));
                studentTable.insert(new Student("Кравчук Сергей Валентинович", "м", 2256));
            }

            students = studentTable.selectAll();
            System.out.println("----------------------------------------------------------");

            for (Student tmp : students) {
                System.out.println(tmp.toString());
            }

            System.out.println("----------------------------------------------------------");
            ArrayList<Group> groups = groupTable.selectAll();
            if (groups.size() < 3) {
                groupTable.insert(new Group(4453, "физика", 23423));
                groupTable.insert(new Group(2256, "механика", 23476));
                groupTable.insert(new Group(1154, "оптика", 476));
            }


            groups = groupTable.selectAll();
            System.out.println("----------------------------------------------------------");

            for (Group tm : groups) {
                System.out.println(tm.toString());
            }
            System.out.println("----------------------------------------------------------");

            ArrayList<Curator> curators = curatorTable.selectAll();
            if (curators.size() < 4) {
                curatorTable.insert(new Curator(23423, "Буянов Петр Ильич"));
                curatorTable.insert(new Curator(23476, "Сидоренко Павел Александрович"));
                curatorTable.insert(new Curator(23476, "Жиглов Олег Георгиевич"));
                curatorTable.insert(new Curator(476, "Ушакова Василиса Евгеньевна"));
            }

            System.out.println("----------------------------------------------------------");
            curators = curatorTable.selectAll();

            for (Curator tmpe : curators) {
                System.out.println(tmpe.toString());
            }

            //меняем id куратора
            groupTable.updateIdByName("оптика", 23423, "group1");

            System.out.println("----------------------------------------------------------");
            System.out.print("Всего студентов:");
            studentTable.select("SELECT COUNT(*) FROM students %s");
            System.out.println("----------------------------------------------------------");

            System.out.println("Все студентки:");
            studentTable.select("SELECT full_name FROM students WHERE sex='ж'");
            System.out.println("----------------------------------------------------------");

            System.out.println("Все группы с кураторами:");
            studentTable.select("SELECT group1.id_curator, curator.curator_name, group1.group_name \n" +
                    "FROM group1 \n" +
                    "JOIN curator \n" +
                    "ON group1.id_curator=curator.id;");
            System.out.println("----------------------------------------------------------");

            System.out.println("Все группы с кураторами и студентами:");
            studentTable.select("SELECT students.id, students.full_name, students.sex, " +
                    "group1.group_name, curator.curator_name" +
                    " FROM students JOIN group1 ON students.id_group=group1.id" +
                    " JOIN curator ON group1.id_curator=curator.id ORDER BY students.id ASC;");
            System.out.println("----------------------------------------------------------");

            System.out.println("Все студенты из заданой группы:");
            studentTable.select("SELECT full_name " +
                    "FROM students WHERE id_group=(SELECT id FROM group1 WHERE group_name='" + groupSearch + "')");
            System.out.println("----------------------------------------------------------");

        } finally {
            MySQLConnector.close();
        }
    }
}
