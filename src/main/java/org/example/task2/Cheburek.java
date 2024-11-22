package org.example.task2;

/**
 * Чебурек
 */
public class Cheburek implements SemifinishedFood{

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
        return "Чебурек";
    }
}
