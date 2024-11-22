package org.example.task2;

/**
 * Фрукт
 */
public class Fruit implements HealthyFood{
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
        return "Фрукт";
    }
}
