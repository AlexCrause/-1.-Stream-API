package org.example.task2;

/**
 * Курица
 */
public class Chicken implements HealthyFood{

    @Override
    public boolean getProtein() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Курица";
    }
}
