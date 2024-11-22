package org.example.task2;

/**
 * Пельмени
 */
public class Dumplings implements SemifinishedFood{

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
        return "Пельмени";
    }
}
