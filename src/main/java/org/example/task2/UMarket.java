package org.example.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * U-Market
 */
public class UMarket {

    //region Методы

    public <T extends Thing> T getThingsByIndex(Class<T> clazz, int index){

        /*int counter = 1;
        for (var thing : things) {
            if (clazz.isAssignableFrom(thing.getClass())) {
                if (index == counter++){
                    return (T) thing;
                }
            }
        }
        return null;*/
        AtomicInteger counter = new AtomicInteger(1);
        return things.stream()
                .filter(clazz::isInstance)
                .filter(thing -> index == counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);

    }


    public <T extends Thing> Collection<T> getThings(Class<T> clazz){

        /*Collection<T> list = new ArrayList<>();
        for (var thing : things) {
            if (clazz.isAssignableFrom(thing.getClass())) {
                list.add((T) thing);
            }
        }
        return list;*/

        return things.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    /**
     * Распечатать список товаров по типу
     *
     * @param <T>
     */
    public <T extends Thing> void printThings(Class<T> clazz) {

        /*int index = 1;
        for (var thing : things) {
            if (clazz.isInstance(thing)) {
                if (Food.class.isAssignableFrom(thing.getClass())) {
                    System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                            index++, thing.getName(),
                            ((Food) thing).getProtein() ? "Да" : "Нет",
                            ((Food) thing).getFats() ? "Да" : "Нет",
                            ((Food) thing).getCarbohydrates() ? "Да" : "Нет");
                } else {
                    System.out.printf("[%d] %s\n", index++, thing.getName());
                }
            }
        }*/

        int[] counter = {1};
        things.stream()
                .filter(clazz::isInstance)
                .forEach(thing -> {

                    //работает только с Food
                    /*System.out.printf(
                            Food.class.isAssignableFrom(thing.getClass()) ?
                                    "[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n" :
                            "[%d] %s\n", counter[0]++, thing.getName(),
                            ((Food) thing).getProtein() ? "Да" : "Нет",
                            ((Food) thing).getFats() ? "Да" : "Нет",
                            ((Food) thing).getCarbohydrates() ? "Да" : "Нет");*/

                    if (Food.class.isAssignableFrom(thing.getClass())) {
                        Food foodThing = (Food) thing;
                        System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                                counter[0]++, thing.getName(),
                                foodThing.getProtein() ? "Да" : "Нет",
                                foodThing.getFats() ? "Да" : "Нет",
                                foodThing.getCarbohydrates() ? "Да" : "Нет");
                    } else {
                        System.out.printf("[%d] %s\n", counter[0]++, thing.getName());
                    }
                });
    }

    private void initializingThings() {
        things.add(new Pen());
        things.add(new Notebook());

        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new BalykCheese());
        things.add(new Crisps());
        things.add(new ChocolateBar());

        things.add(new Dumplings());
        things.add(new FrozenBerries());
        things.add(new Cheburek());
    }
    //endregion

    //region Конструкторы

    public UMarket() {
        things = new ArrayList<>();
        initializingThings();
    }

    //endregion


    //region Поля
    /**
     * Товары в магазине
     */
    private final Collection<Thing> things;
    //endregion
}
