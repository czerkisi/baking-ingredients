/*
 * Course: CS1021
 * Winter 2021-2022
 * Lab 2 - Kitchen
 * Name: Ian Czerkis
 * Created: 8 Dec 2021
 */
package czerkisi;

/**
 * Driver class that illustrates making evaporated milk by baking milk.
 */
public class EvaporatedMilk {
    /** The milk to be baked */
    private static final Ingredient MILK =
            new SimpleIngredient(103.0, 1.0, false, "Milk");

    /** Ratio of volume after evaporating to before */
    public static final double DEHYDRATION_FACTOR = 0.2;

    public static void main(String[] args) {
        Ingredient milk = MILK;
        Ingredient evaporatedMilk = new BakedIngredient(milk, DEHYDRATION_FACTOR);
        evaporatedMilk.printRecipe();
    }
}
