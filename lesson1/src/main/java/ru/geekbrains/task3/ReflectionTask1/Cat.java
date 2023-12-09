package ru.geekbrains.task3.ReflectionTask1;

public class Cat extends Animal {
    String name;
    int age;
    @Override
    public void toSing() {
        System.out.println(name + ": muau, muay");
    }
    public  Cat(String name,int age){
        this.age = age;
        this.name = name;
    }
}
