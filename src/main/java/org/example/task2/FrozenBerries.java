package org.example.task2;

/**
 * Замороженные ягоды
 */
public class FrozenBerries implements SemifinishedFood{
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
        return "Замороженные ягоды";
    }
}
