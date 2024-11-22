package org.example.task2;

/**
 * Еда
 */
public interface Food extends Thing{

    /**
     * Получить наличие протеина в еде
     * @return протеин
     */
    boolean getProtein();

    /**
     * Получить наличие жира в еде
     * @return жир
     */
    boolean getFats();

    /**
     * Получить наличие углеводов в еде
     * @return углеводы
     */
    boolean getCarbohydrates();
}
