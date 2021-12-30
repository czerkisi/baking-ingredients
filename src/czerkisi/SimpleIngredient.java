/*
 * Course: CS1021
 * Winter 2021-2022
 * Lab 2 - Kitchen
 * Name: Ian Czerkis
 * Created: 8 Dec 2021
 */
package czerkisi;

/**
 * this class implements Ingredient by defining the basic methods and attributes of an Ingredient
 */
public class SimpleIngredient implements Ingredient {
    private final double calories;
    private final double cups;
    private final boolean isDry;
    private final String name;
    private static final int NUMBER_OF_EQUALS = 52;


    SimpleIngredient(double calories, double cups, boolean isDry, String name){
        this.calories = calories;
        this.cups = cups;
        this.isDry = isDry;
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public double getCups() {
        return Double.parseDouble(Ingredient.CUP_FORMAT.format(cups));
    }

    public boolean isDry() {
        return isDry;
    }

    public String getName() {
        return name;
    }

    /**
     * this method prints the name, number of cups, and calories of the Ingredient
     */
    public void printRecipe(){
        for (int i = 0; i < NUMBER_OF_EQUALS; i++) {
            System.out.print("=");
        }
        System.out.println("\n" + name);
        for (int i = 0; i < NUMBER_OF_EQUALS; i++) {
            System.out.print("=");
        }
        System.out.println("\nCups: " + CUP_FORMAT.format(cups) + " Cups");
        System.out.println("Energy: " + Math.round(calories) +" Calories");
    }
}
