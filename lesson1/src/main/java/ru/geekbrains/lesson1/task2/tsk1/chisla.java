package ru.geekbrains.lesson1.task2.tsk1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class chisla {
    static List<Integer> i = Arrays.asList(1,2,3,4,1,151,6);

    public static void main(String[] args) {

        System.out.println(i.stream().mapToInt(Integer::intValue).average());

    }

}
