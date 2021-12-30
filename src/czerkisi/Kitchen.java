/*
 * Course: CS1021
 * Winter 2021-2022
 * Lab 2 - Kitchen
 * Name: Ian Czerkis
 * Created: 8 Dec 2021
 */

package czerkisi;

import java.util.Scanner;

/**
 * Build recipes out of ingredients
 */
public class Kitchen {
    private static final Ingredient BUTTER =
            new SimpleIngredient(810, 0.5, false, "Butter");
    private static final Ingredient EGGS =
            new SimpleIngredient(85, 1, false, "Eggs");
    private static final Ingredient MILK =
            new SimpleIngredient(103, 1, false, "Milk");
    private static final Ingredient SUGAR =
            new SimpleIngredient(773, 1, true, "Sugar");
    private static final Ingredient FLOUR =
            new SimpleIngredient(455, 1, true, "Flour");
    private static final Ingredient COCOA_POWDER =
            new SimpleIngredient(49, 1/16., true, "Cocoa Powder");
    private static final Ingredient STRAWBERRIES =
            new SimpleIngredient(47, 1, true, "Strawberries");

    /**
     * The multiplier indicating how the cake's volume expands while baking
     */
    public static final double EXPANSION_FACTOR = 1.2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("What would you like to bake?");
            System.out.println("Enter Brownies, Pasta, Cupcakes, or Chocolate Covered Strawberries");
            switch (in.nextLine().toUpperCase()) {
                case "BROWNIES":
                    makeBrownies();
                    break;
                case "PASTA":
                    makePasta();
                    break;
                case "CUPCAKES":
                    makeCupcakes();
                    break;
                case "CHOCOLATE COVERED STRAWBERRIES":
                    makeChocolateCoveredStrawberries();
                    break;
                default:
                    System.out.println("Response not found");
            }
        } while (bakeAgain(in).equalsIgnoreCase("yes"));

    }

    private static String bakeAgain(Scanner in) {
        String response;
        boolean advance = false;
        System.out.println("Would you like to bake another item?");
        do {
            response = in.nextLine();
            if (response.equalsIgnoreCase("yes")||
                    response.equalsIgnoreCase("no")){
                advance = true;
            } else {
                System.out.println("Not a valid response, enter Yes or No: ");
            }
        } while (!advance);

        return response;
    }

    private static void makeBrownies() {
        //https://www.allrecipes.com/recipe/9599/quick-and-easy-brownies/
        //1 cup butter
        //2 cups sugar
        //1/2 cup cocoa powder
        //4 eggs
        //1.5 cups flour
        Mix brownieBatter = new Mix("Brownie Batter");
        brownieBatter.addIngredient(new Measure(1, BUTTER));
        brownieBatter.addIngredient(new Measure(2, SUGAR));
        brownieBatter.addIngredient(new Measure(1, 2, COCOA_POWDER));
        brownieBatter.addIngredient(new Measure(4, EGGS));
        brownieBatter.addIngredient(new Measure(3, 2, FLOUR));

        Ingredient bakedBrownies = new BakedIngredient(brownieBatter, EXPANSION_FACTOR);
        bakedBrownies.printRecipe();
    }

    private static void makePasta() {
        //https://rouxbe.com/recipes/1296-basic-egg-pasta-dough
        // 1 cup flour
        // 2 large eggs
        Mix dough = new Mix("Pasta");
        dough.addIngredient(new Measure(2, EGGS));
        dough.printRecipe();
    }

    private static void makeCupcakes() {
        //https://www.yellowblissroad.com/vanilla-cupcakes-vanilla-buttercream/
        //Batter:
        // 1/2 cup butter
        //1 cup sugar
        //1 egg
        //1 2/3 cups flour
        //3/4 cup milk
        //Frosting:
        //3/4 cup butter
        //3/16 cup milk
        //4 cups sugar
        Mix cupcakeBatter = new Mix("Cupcake Batter");
        cupcakeBatter.addIngredient(new Measure(1, 2, BUTTER));
        cupcakeBatter.addIngredient(new Measure(1, SUGAR));
        cupcakeBatter.addIngredient(new Measure(1, EGGS));
        cupcakeBatter.addIngredient(new Measure(5, 3, FLOUR));
        cupcakeBatter.addIngredient(new Measure(3, 4, MILK));
        Ingredient bakedCupcake = new BakedIngredient(cupcakeBatter, EXPANSION_FACTOR);

        Mix frosting = new Mix("Frosting");
        frosting.addIngredient(new Measure(3, 4, BUTTER));
        frosting.addIngredient(new Measure(3, 16, MILK));
        frosting.addIngredient(new Measure(4, SUGAR));

        Mix cupcakes = new Mix("Cupcakes");
        cupcakes.addIngredient(bakedCupcake);
        cupcakes.addIngredient(frosting);
        cupcakes.printRecipe();
    }

    private static void makeChocolateCoveredStrawberries() {
        // https://treatdreams.com/chocolate-ganache-with-cocoa-powder/
        //2 cups milk
        //1/2 cup sugar
        //1 1/2 cup cocoa powder
        //2 cups strawberries
        Mix ganache = new Mix("Chocolate Ganache");
        ganache.addIngredient(new Measure(2, MILK));
        ganache.addIngredient(new Measure(1, 2, SUGAR));
        ganache.addIngredient(new Measure(3, 2, COCOA_POWDER));

        Mix chocolateCoveredStrawberries = new Mix("Chocolate Covered Strawberries");
        chocolateCoveredStrawberries.addIngredient(new Measure(4, STRAWBERRIES));
        chocolateCoveredStrawberries.addIngredient(ganache);

        chocolateCoveredStrawberries.printRecipe();
    }
}
