package org.example.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food>{

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodStuffs;

    private final UMarket market;

    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market){
        this.clazz = clazz;
        this.market = market;
        foodStuffs = new ArrayList<>();
    }

    public Collection<T> getFoodStuffs(){
        return foodStuffs;
    }

    /**
     * Расспечатать список товаров в корзине
     */
    public void printFoodStuffs(){
        AtomicInteger index = new AtomicInteger(1);
        foodStuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProtein() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancing(){

        /*boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food : foodStuffs) {
            if (!proteins && food.getProtein()) {
                proteins = true;
            } else if (!fats && food.getFats()) {
                fats = true;
            } else if (!carbohydrates && food.getCarbohydrates()) {
                carbohydrates = true;
            } if (proteins && fats && carbohydrates) {
                break;
            }
        }

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        for (var thing: market.getThings(Food.class)) {

            if (!proteins && thing.getProtein()) {
                proteins = true;
                foodStuffs.add((T) thing);
            } else if (!fats && thing.getFats()) {
                fats = true;
                foodStuffs.add((T) thing);
            } else if (!carbohydrates && thing.getCarbohydrates()) {
                carbohydrates = true;
                foodStuffs.add((T) thing);
            } if (proteins && fats && carbohydrates) {
                break;
            }
        }

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина сбалансирована по БЖУ.");
        } else {
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
        }*/





        boolean[] nutrients = {false, false, false};

        foodStuffs.forEach(food -> {
            if (food.getProtein()) nutrients[0] = true;
            if (food.getFats()) nutrients[1] = true;
            if (food.getCarbohydrates()) nutrients[2] = true;
        });

        if (nutrients[0] && nutrients[1] && nutrients[2]) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        market.getThings(Food.class).stream()
                .filter(thing -> {

                    if (!nutrients[0] && thing.getProtein()) {
                        nutrients[0] = true;
                        foodStuffs.add((T) thing);
                        return false;
                    }

                    if (!nutrients[1] && thing.getFats()) {
                        nutrients[1] = true;
                        foodStuffs.add((T) thing);
                        return false;
                    }

                    if (!nutrients[2] && thing.getCarbohydrates()) {
                        nutrients[2] = true;
                        foodStuffs.add((T) thing);
                        return false;
                    }
                    return false;
                })
                .collect(Collectors.toList());


        System.out.println(nutrients[0] && nutrients[1] && nutrients[2]
                ? "Корзина сбалансирована по БЖУ."
                : "Невозможно сбалансировать корзину по БЖУ.");
    }
}
