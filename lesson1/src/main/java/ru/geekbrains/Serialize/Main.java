package ru.geekbrains.Serialize;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("FILIPP",15,31);
        Student s2 = new Student("NIKOLAS",16,51);
        Student s3 = new Student("Roberto",13,25);
        SerializeStudent ss = new SerializeStudent();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println();
        ss.saveStudentToFiles(s1);
        ss.openStudentFile("Student.json");
        ss.saveStudentToFiles(s2);
        ss.openStudentFile("Student.json");
        ss.saveStudentToFiles(s3);
        ss.openStudentFile("Student.json");


    }
}
