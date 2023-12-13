package ru.geekbrains.Serialize;

import java.io.*;

/*
Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и обсудите,
почему значение GPA не было сохранено/восстановлено.
 */
public class Student implements Externalizable {
    //region Поля
    public String name;
    public int age;
    public transient double GPA;
    //endregion

    // region Конструкторы
    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student() {

    }

    //endregion
    //region WriteExternal
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }
    //endregion

    //region readExternal
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }

    //endregion
    //region toString
    @Override
    public String toString() {
        return "Студент: " + name
                + "! "
                    + age + " лет. " +
                        "Cредний балл: " + GPA;
    }
}
