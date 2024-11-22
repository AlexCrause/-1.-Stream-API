package org.example.task2;

/**
 * Сыр балыковый (Балык)
 */
public class BalykCheese implements Snack{

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
        return "Сыр (Балык)";
    }
}
