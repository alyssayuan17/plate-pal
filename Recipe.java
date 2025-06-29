import java.util.ArrayList;

public class Recipe {
    //instance variables
    private String name; 
    private ArrayList <Ingredient> ingredients = new ArrayList<>();
    
    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Recipe(String name) {
        this.name = name; 
    }

    // method for printing recipe
    public static void printRecipe(Recipe recipe, String meal) {
        System.out.println("\n" + meal.toUpperCase() + ": " + recipe.getName());
        System.out.println("\nINGREDIENTS: \n");
        for (Ingredient i : recipe.getIngredients()) { // for each Ingredient object in the recipe's ingredient list 
            System.out.println("\t- " + i.getName() + ", " + i.getQty()); // print the ingredients
        }
    }

    // getters

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    } 

}