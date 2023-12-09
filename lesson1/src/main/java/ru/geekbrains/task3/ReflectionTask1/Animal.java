package ru.geekbrains.task3.ReflectionTask1;
//        Создайте абстрактный класс "Animal" с полями "name" и "age".
//        Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
//        Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:

public abstract class Animal implements toSing {
    String name;
    int age;
    Animal(String name,int age){
        this.age = age;
        this.name = name;
    }
}
