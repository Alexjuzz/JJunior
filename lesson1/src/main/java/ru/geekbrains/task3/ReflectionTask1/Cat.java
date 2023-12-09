package ru.geekbrains.task3.ReflectionTask1;

public class Cat extends Animal {
    @Override
    public void toSing() {
        System.out.println(name + ": muau, muay");
    }
    public  Cat(String name,int age){
        super(name,age);
    }
}
