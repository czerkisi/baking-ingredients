/*
 * Course: CS1021
 * Winter 2021-2022
 * Lab 2 - Kitchen
 * Name: Ian Czerkis
 * Created: 8 Dec 2021
 */

package czerkisi;

import java.util.ArrayList;
import java.util.List;

/**
 * this class implements Ingredient by combining Ingredients to create a new Ingredient
 */
public class Mix implements Ingredient {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final String name;
    private static final int NUMBER_OF_EQUALS = 52;


    Mix(String name){
        this.name = name;
    }

    /**
     * this method adds an Ingredient to the mixed Ingredient
     * @param ingredient the Ingredient to be added to the mix
     */
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    /**
     * this method checks if there are any dry ingredients in the mix
     * @return returns true if any of the ingredients in the mix are dry
     */
    public boolean hasDryIngredient(){
        boolean ret = false;
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isDry()) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * this method checks if there are any wet ingredients in the mix
     * @return returns true if any of the ingredients in the mix are wet
     */
    public boolean hasWetIngredient(){
        boolean ret = false;
        for (Ingredient ingredient : ingredients) {
            if (!ingredient.isDry()) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * this method calculates the sum of the calories of all the Ingredients in the mix
     * @return total number of calories in the mix
     */
    public double getCalories(){
        int calories = 0;
        for (Ingredient ingredient : ingredients) {
            calories += ingredient.getCalories();
        }
        return calories;
    }

    /**
     * this method calculates the sum of the number of cups of all the Ingredients in the mix
     * @return total number of cups in the mix
     */
    public double getCups(){
        double cups = 0;
        for (Ingredient ingredient : ingredients) {
            double addCups = ingredient.getCups();
            cups += addCups;
        }
        return cups;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isDry(){
        return !hasWetIngredient();
    }

    /**
     * this method prints the name, Ingredients, total cups, total calories, and
     * recipes, cups, and calories of all the Ingredients in the list
     */
    public void printRecipe(){
        for (int i = 0; i < NUMBER_OF_EQUALS; i++) {
            System.out.print("=");
        }
        System.out.println("\n" + name);
        for (int i = 0; i < NUMBER_OF_EQUALS; i++) {
            System.out.print("=");
        }
        System.out.print("\n");

        //print dry ingredients
        System.out.println("Dry Ingredients: ");
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isDry()) {
                System.out.println("  " + ingredient.getName());
            }
        }
        System.out.print("\n");

        //print wet ingredients
        System.out.println("Wet Ingredients: ");
        for (Ingredient ingredient : ingredients) {
            if (!ingredient.isDry()) {
                System.out.println("  " + ingredient.getName());
            }
        }
        System.out.print("\n");

        //print total cups and calories
        System.out.println("Cups: "+ CUP_FORMAT.format(getCups()) + " Cups");
        System.out.println("Energy " + Math.round(getCalories()) + " Calories\n");

        for (Ingredient ingredient : ingredients) {
            ingredient.printRecipe();
            System.out.print("\n");
        }
    }

}

