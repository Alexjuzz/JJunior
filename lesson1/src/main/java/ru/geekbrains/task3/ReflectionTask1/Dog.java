package ru.geekbrains.task3.ReflectionTask1;

public class Dog extends Animal{

    public String name;
    public int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public void toSing() {
        System.out.println(name + ": WOOF, WOOF!");
    }
}
