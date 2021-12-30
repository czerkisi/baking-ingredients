/*
 * Course: CS1021
 * Winter 2021-2022
 * Lab 2 - Kitchen
 * Name: Ian Czerkis
 * Created: 8 Dec 2021
 */
package czerkisi;

/**
 * this class implements Ingredient by measuring quantities of the desired Ingredient
 */
public class Measure implements Ingredient {
    private final Ingredient baseIngredient;
    private final Ingredient measuredIngredient;
    private final int numerator;
    private final int denominator;
    private static final int NUMBER_OF_EQUALS = 52;


    Measure(int numerator, int denominator, Ingredient ingredient) {
        this.numerator = numerator;
        this.denominator = denominator;
        double calories = (((double)numerator/denominator) *
                (ingredient.getCalories()/ingredient.getCups()));
        boolean isDry = ingredient.isDry();
        double cups = (double)numerator/denominator;
        String name;

        if (denominator == 1 && numerator == 1) {
            name = numerator + " Cup " + ingredient.getName();
        } else if (denominator == 1){
            name = numerator + " Cups " + ingredient.getName();
        } else if ((double) numerator/denominator > 1){
            name = numerator+"/"+denominator+" Cups "+ingredient.getName();
        } else {
            name = numerator+"/"+denominator+" Cup "+ingredient.getName();
        }
        measuredIngredient = new SimpleIngredient(calories, cups, isDry, name);
        baseIngredient = ingredient;

    }
    Measure(int numerator, Ingredient ingredient){
        this(numerator, 1, ingredient);
    }

    public double getCalories() {
        return measuredIngredient.getCalories();
    }

    public double getCups() {
        return measuredIngredient.getCups();
    }

    public boolean isDry() {
        return measuredIngredient.isDry();
    }

    public String getName() {
        return measuredIngredient.getName();
    }

    /**
     * this method prints the name, quantity,
     */
    public void printRecipe(){
        for (int i = 0; i < NUMBER_OF_EQUALS; i++) {
            System.out.print("=");
        }
        System.out.println("\n" + measuredIngredient.getName());
        for (int i = 0; i < NUMBER_OF_EQUALS; i++) {
            System.out.print("=");
        }
        System.out.println("\nMeasured Ingredient: " + baseIngredient.getName());
        if (denominator == 1){
            System.out.println("Cups: " +
                    CUP_FORMAT.format(measuredIngredient.getCups()) + " Cups");
        } else {
            System.out.println("Cups: " + numerator + "/"+ denominator +
                    " Cups (" + CUP_FORMAT.format(measuredIngredient.getCups()) + ") Cups");

        }
        System.out.println("Energy: " + Math.round(measuredIngredient.getCalories()) +" Calories");
        baseIngredient.printRecipe();
    }

}
