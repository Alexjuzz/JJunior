package ru.geekbrains.lesson1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     *
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    //endregion

    /**
     * Балансировка корзины
     */
    public void cardBalancing() {
        AtomicBoolean proteins = new AtomicBoolean(false);
        AtomicBoolean fats = new AtomicBoolean(false);
        AtomicBoolean carbohydrates = new AtomicBoolean(false);
        foodstuffs.stream()
                .filter(food -> !proteins.get() && food.getProteins())
                .findFirst()
                .ifPresent(food -> proteins.set(true));

        foodstuffs.stream()
                .filter(food -> !fats.get() && food.getFats())
                .findFirst()
                .ifPresent(food -> fats.set(true));

        foodstuffs.stream()
                .filter(food -> !carbohydrates.get() && food.getCarbohydrates())
                .findFirst()
                .ifPresent(food -> carbohydrates.set(true));

        market.getThings(clazz).stream()
                        .filter(food -> (!proteins.get()) && food.getProteins()).findFirst().ifPresent(foodstuffs::add);

        market.getThings(clazz).stream()
                .filter(food -> (!fats.get()) && food.getFats()).findFirst().ifPresent(foodstuffs::add);

        market.getThings(clazz).stream()
                .filter(food -> (!carbohydrates.get()) && food.getCarbohydrates()).findFirst().ifPresent(foodstuffs::add);


        if (proteins.get() && fats.get() && carbohydrates.get())
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }


    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));
    }

}
