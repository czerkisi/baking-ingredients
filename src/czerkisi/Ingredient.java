/*
 * Course: CS1021
 * Winter 2021-2022
 * Lab 2 - Kitchen
 * Name: Ian Czerkis
 * Created: 8 Dec 2021
 */

package czerkisi;

import java.text.DecimalFormat;

/**
 * this interface manages attributes of Ingredients
 */
public interface Ingredient {
    /**
     * this method formats a number to 2 decimal points
     */
    DecimalFormat CUP_FORMAT = new DecimalFormat("#.##");

    /**
     * this method calculates the number of calories in an Ingredient
     * @return the total number of calories in the Ingredient
     */
    double getCalories();

    /**
     * this method calculates the number of cups in an Ingredient
     * @return the total number of cups in the Ingredient
     */
    double getCups();

    /**
     * this method returns the name of the Ingredient
     * @return the name of the Ingredient
     */
    String getName();

    /**
     * this method determines if the Ingredient is dry
     * @return returns true if one or all of the
     * Ingredients in an Ingredient are dry
     */
    boolean isDry();

    /**
     * this method prints the recipe of the Ingredient and any mixed Ingredients
     */
    void printRecipe();
}