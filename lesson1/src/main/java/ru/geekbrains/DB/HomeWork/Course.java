package ru.geekbrains.DB.HomeWork;
import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Course {
    private static String [] courses = new String[]{"Math","Philosophy","History","Geography","Programming"};
    private static Random random = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;


    //region methods
    public void updateCourse(){
        title = courses[random.nextInt(courses.length)];
    }
    public static Course createCourse(){
        return new Course(courses[random.nextInt(courses.length)],random.nextInt(1,5));
    }
    //endregion

    //region getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
    public String[] getCourses() {
        return courses;
    }
    //endregion
    //region seters
    public void setTitle(String title) {
        this.title = title;
    }

    public Course() {
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setCourses(String[] courses) {
        this.courses = courses;
    }
    public void setId(int id) {
        this.id = id;
    }
    //endregion
    //region Конструкторы
    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course(int id, String title, int duration, String[] courses) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.courses = courses;
    }
    //endregion
    //region toString
    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
    //endregion
}
