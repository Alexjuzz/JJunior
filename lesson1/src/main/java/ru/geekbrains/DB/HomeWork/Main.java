package ru.geekbrains.DB.HomeWork;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

//Создайте базу данных (например, SchoolDB).
//        В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
//        Настройте Hibernate для работы с вашей базой данных.
//        Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
//        Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
//        Убедитесь, что каждая операция выполняется в отдельной транзакции.
public class Main {
    public static void main(String[] args) throws SQLException {
    CoursesDB coursesDB = new CoursesDB();
    coursesDB.addCourseToDB(Course.createCourse());
        System.out.println(coursesDB.readDateCourse());
    }
}
