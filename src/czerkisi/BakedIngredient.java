/*
 * Course: CS1021
 * Winter 2021-2022
 * Lab 2 - Kitchen
 * Name: Ian Czerkis
 * Created: 8 Dec 2021
 */
package czerkisi;

/**
 * this class implements Ingredient by baking an Ingredient
 */
public class BakedIngredient implements Ingredient {
    private static final int NUMBER_OF_EQUALS = 52;
    private final Ingredient baseIngredient;
    private final Ingredient bakedIngredient;

    BakedIngredient(Ingredient ingredient, double expansionFactor){
        this.bakedIngredient = new SimpleIngredient(ingredient.getCalories(),
                ingredient.getCups()*expansionFactor, true, "Baked "+ingredient.getName());
        this.baseIngredient = ingredient;
    }

    public double getCalories() {
        return bakedIngredient.getCalories();
    }

    public double getCups() {
        return bakedIngredient.getCups();
    }

    public boolean isDry() {
        return true;
    }

    public String getName() {
        return bakedIngredient.getName();
    }

    /**
     * this method prints the new name, new number of cups,
     * number of calories  of the baked Ingredient
     */
    public void printRecipe(){
        for (int i = 0; i < NUMBER_OF_EQUALS; i++) {
            System.out.print("=");
        }
        System.out.println("\n" + bakedIngredient.getName());
        for (int i = 0; i < NUMBER_OF_EQUALS; i++) {
            System.out.print("=");
        }
        System.out.print("\n");
        System.out.println("Ingredient to be baked: " + baseIngredient.getName());
        System.out.println("Cups: " + bakedIngredient.getCups() + " Cups");
        System.out.println("Energy: " + Math.round(baseIngredient.getCalories()) +" Calories");
        baseIngredient.printRecipe();
    }

}
