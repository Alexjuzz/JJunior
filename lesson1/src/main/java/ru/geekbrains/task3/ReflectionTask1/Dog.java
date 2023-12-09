package ru.geekbrains.task3.ReflectionTask1;

public class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void toSing() {
        System.out.println(name + ": WOOF, WOOF!");
    }
}
