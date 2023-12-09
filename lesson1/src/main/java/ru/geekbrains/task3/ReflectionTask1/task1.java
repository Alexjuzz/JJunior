package ru.geekbrains.task3.ReflectionTask1;
//Задача 1:
//        Создайте абстрактный класс "Animal" с полями "name" и "age".
//        Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
//        Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
//        Выведите на экран информацию о каждом объекте.
//        Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
public class task1 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik",10);
        Dog dog = new Dog("Kac", 5);
        cat.toSing();
        dog.toSing();

    }
}
