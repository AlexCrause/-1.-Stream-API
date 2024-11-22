package org.example.task2;

/**
 * Чипсы
 */
public class Crisps implements Snack{
    @Override
    public boolean getProtein() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Чипсы";
    }
}
