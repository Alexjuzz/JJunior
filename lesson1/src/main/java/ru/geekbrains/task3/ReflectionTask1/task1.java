package ru.geekbrains.task3.ReflectionTask1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Задача 1:
//        Создайте абстрактный класс "Animal" с полями "name" и "age".
//        Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
//        Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
//        Выведите на экран информацию о каждом объекте.
//        Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
public class task1 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Cat cat = new Cat("Barsik", 10);
        Dog dog = new Dog("Kac", 5);
        Animal[] animals = new Animal[]{new Cat("BARSIK", 5), new Dog("Kac", 5)};
        for (Animal a : animals
        ) {
            inforMationAboutAnimals(a);
        }
    }

    static void inforMationAboutAnimals(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Method methods = clazz.getDeclaredMethod("toSing");
        for (Field f : fields
             ) {
            System.out.print(f.get(obj)+ " ");

        }
        methods.invoke(obj);
    }
}
