package org.example.task2;

/**
 * Шоколадный батончик
 */
public class ChocolateBar implements Snack{

    @Override
    public boolean getProtein() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Шоколадный батончик";
    }
}
