package ru.geekbrains.DB.HomeWork;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoursesDB {
    //Создайте базу данных (например, SchoolDB).
//        В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
//        Настройте Hibernate для работы с вашей базой данных.
//        Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
//        Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
//        Убедитесь, что каждая операция выполняется в отдельной транзакции.
        static  Session session;

    public CoursesDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1";
        Connection connection = DriverManager.getConnection(url,user,password);
        createDataBase(connection);
        useDataBase(connection);
        createTable(connection);
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }

    public void createCourse(){
        Course course = Course.createCourse();
    }

    public  void addCourseToDB(Course course){
        session.beginTransaction();
        session.save(course);
        System.out.println("Курс: " + course.getTitle() + " был сохранен");

    }
    public Course readDateCourse() {
        Course cours =  session.get(Course.class,13);
        return cours;
    }
    public void updateDataCourse(int id){
        session.beginTransaction();
       Course course =  session.get(Course.class,id);
        course.updateCourse();
        session.save(course);
        session.getTransaction().commit();
    }
    public void deleteDataCourse(int id){
        session.beginTransaction();
        Course course = session.get(Course.class,id);
        session.delete(course);
        session.getTransaction().commit();
    }
    // region Вспомогательные методы, CREATE TABLE,BASE и USEBASE
        private  static void createTable(Connection connection) throws SQLException{
        String createTableSQL = "CREATE TABLE IF NOT EXISTS courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)){
            statement.execute();
        }
    }
//    private static void setSession(){
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Course.class)
//                .buildSessionFactory();
//        session = sessionFactory.getCurrentSession();
//        session.getTransaction();
//    }
    private static void useDataBase(Connection connection) throws SQLException{
        String useDataBaseSQL = "USE CoursesDB";
        try (PreparedStatement statement = connection.prepareStatement(useDataBaseSQL)){
            statement.execute();
        }
    }
    private static void createDataBase(Connection connection) throws SQLException {
        String createDataBase = "CREATE DATABASE IF NOT EXISTS CoursesDB";
        try (PreparedStatement statement = connection.prepareStatement(createDataBase)){
            statement.execute();
        }
    }
    //endregion
}
