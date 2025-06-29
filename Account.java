import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner; 

public class Account {

    //scanner 
    static Scanner in = new Scanner(System.in); 
    
    //instance variables for storage of days and recipes
    //todo: maybe change hashmap to arraylist 
    private HashMap <String, Day> days = new HashMap<>(); //they can add days. each day has a breakfast, lunch, dinner 
    private HashMap <String, Recipe> recipes = new HashMap <>(); //contains preset 9 recipes + any custom recipes user creates 
    private HashMap <String, String> ingredientUnits = new HashMap <>(); // key=ingredient name, value=unit 

    //instance variables for account info 
    private String firstName; 
    private String lastName;
    
    //more instance variables that store preferences from initial dietary needs survey 
    private boolean vegetarian; 
    private String preferMeat; //options: red || seafood || poultry || no preference
    private boolean preferCarbs;
    private boolean preferAltProtein; //beans, tofu, etc.
    private String preferVeg; //options: green || red + orange

    private String meal; // to determine breakfast, lunch, or dinner

    public static Account askForName(Scanner in) { // first account method to set up name
        System.out.print("Enter first name: ");
        String firstName = in.nextLine();
        System.out.print("Enter last name: ");
        String lastName = in.nextLine(); 
        System.out.println("\nHello " + firstName + " " + lastName + ", welcome to Plate Pal!\n" ); // message to user!
        return new Account(firstName, lastName); // return new account
    }

    public Account(String firstName, String lastName) { // account name constructor
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Account askForPrefs(Scanner in){ // second account method to set up user preferences, preference survey

        System.out.print("Do you prefer vegetarian dishes? (y/n): "); // ask if user prefers vegetarian options
        String input = "";
        boolean vegetarian = false; 

        do { // do-while loop to catch invalid inputs
            input = in.nextLine();
            if (input.equalsIgnoreCase("y")) {
                vegetarian = true; 
            } else if (input.equalsIgnoreCase("n")) {
                vegetarian = false; 
            } else {
                System.out.print("Invalid input. Please try again (y/n): ");
            }
        } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));

        String preferMeat = "no preference";
        input = "";
        if (vegetarian == false) { //ask for meat preferences ... if vegetarian == true, preferMeat is set to none initially 
            System.out.print("Meat preferences? \n\ta) red \n\tb) poultry \n\tc) seafood and fish \n\td) no preference for meat \n(a/b/c/d): ");
            do {
                input = in.nextLine();
                if (input.equalsIgnoreCase("a")) {
                    preferMeat = "red";
                } else if (input.equalsIgnoreCase("b")) {
                    preferMeat = "poultry"; 
                } else if (input.equalsIgnoreCase("c")) {
                    preferMeat = "seafood";
                } else if (input.equalsIgnoreCase("d")) {
                    // preferMeat = "no preference";
                    System.out.print("Would you prefer a dish with... \n\ta) carbs \n\tb) low carbs \n(a/b): ");
                    String prefCarbs = "";
                    do {
                        prefCarbs = in.nextLine().trim().toLowerCase();
                        if (prefCarbs.equals("a")) {
                            preferMeat = "carbs";
                        } else if (prefCarbs.equals("b")){
                            preferMeat = "low carbs";
                        } else {
                            System.out.print("Invalid input. Please try again (a/b): ");
                        }
                    } while (!prefCarbs.equals("a") && !prefCarbs.equals("b"));
                } else {
                    System.out.print("Invalid input. Please try again (a/b/c/d): ");
                }
            } while (!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("c") && !input.equalsIgnoreCase("d"));
        }

        boolean preferCarbs = false; //for meat lovers, set preferCarbs to false 
        input = "";
        if (vegetarian == true || preferMeat.equalsIgnoreCase("none")) { //run if statement for people who don't prefer meat 
            System.out.print("Do you prefer a low-carb diet? (y/n): ");
            do {
                input = in.nextLine();
                if (input.equalsIgnoreCase("y")) { //if they want low-carb, set preferCarbs to false 
                    preferCarbs = false; 
                } else if (input.equalsIgnoreCase("n")) { //if they don't want a low-carb diet, set preferCarbs to true 
                    preferCarbs = true; 
                } else {
                    System.out.print("Invalid input. Please try again (y/n): ");
                }
            } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));
        }

        boolean preferAltProtein = false; //this preference will be set to false in the cases where the if statement does not run, as those cases already have a preference selected 
        input = "";
        if (vegetarian == true && preferCarbs == false) { //no preference selected yet - refer to tree in work log if confused 
            System.out.print("Do you prefer alternative proteins such as beans and tofu? (y/n): ");
            do {
                input = in.nextLine();
                if (input.equalsIgnoreCase("y")) { //if they like altProtein, set to true 
                    preferAltProtein = true; 
                } else if (input.equalsIgnoreCase("n")) { //if they don't like, set to false 
                    preferAltProtein = false; 
                } else {
                    System.out.print("Invalid input. Please try again (y/n):");
                }
            } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));
        }

        String preferVeg = "green"; //default unless indicated otherwise 
        input = "";
        if (vegetarian == true && preferCarbs == false && preferAltProtein == false) {
            System.out.print("Do you prefer: \n\ta) green vegetables \n\tb) red + orange vegetables \n(a/b): ");
            do {
                input = in.nextLine();
                if (input.equalsIgnoreCase("a")) { //if they like altProtein, set to true 
                    preferVeg = "green";
                } else if (input.equalsIgnoreCase("b")) { //if they don't like, set to false 
                    preferVeg = "red + orange";
                } else {
                    System.out.print("Invalid input. Please try again (a/b): ");
                }
            } while (!input.equalsIgnoreCase("a") && !input.equalsIgnoreCase("b"));
        }

        this.vegetarian = vegetarian;
        this.preferMeat = preferMeat;
        this.preferCarbs = preferCarbs;
        this.preferAltProtein = preferAltProtein;
        this.preferVeg = preferVeg;
        return this; // return current instance of the class from within the method
    }

    // account preference survey constructor
    public Account(HashMap<String, Day> days, HashMap<String, Recipe> recipes, HashMap<String, String> ingredientUnits,
            boolean vegetarian, String preferMeat, boolean preferCarbs, boolean preferAltProtein, String preferVeg,
            String meal) {
        this.days = days;
        this.recipes = recipes;
        this.ingredientUnits = ingredientUnits;
        this.vegetarian = vegetarian;
        this.preferMeat = preferMeat;
        this.preferCarbs = preferCarbs;
        this.preferAltProtein = preferAltProtein;
        this.preferVeg = preferVeg;
        this.meal = meal;
    }

    public Recipe findRecipeByName() { // linear search method for user recipe search
        System.out.println("\nWhat is the name of the recipe you wish to search for? ");
        String searchKey = in.nextLine().trim().toLowerCase();

        // loop keys only
        for (String key : recipes.keySet()) {
            if (key.toLowerCase().equals(searchKey)) {
                return recipes.get(key);
            }
        }
        return null; // return null if recipe not found
    }

    public Recipe createCustomRecipe(HashMap <String, String> unitsGuide) {
        System.out.print("What is the name of your recipe? ");
        String recipeName = in.nextLine();
        Recipe customRecipe = new Recipe(recipeName); //create new recipe object by the name of recipeName

        String input; 
        int count = 1; 
        ArrayList <Ingredient> ingredients = new ArrayList<>();
        do {
            System.out.print("Enter done to stop. \nEnter name of ingredient " + count + ": ");
            input = in.nextLine();
            if (!input.trim().equalsIgnoreCase("done")) {
                Ingredient temp = addCustomIngredient(input, unitsGuide); 
                ingredients.add(temp);
            }
            count++;
        } while (!input.trim().equalsIgnoreCase("done"));
        
        customRecipe.setIngredients(ingredients); //once ingredient list is completed, add ingredient list under the user's custom recipe 
        recipes.put(recipeName.toLowerCase(), customRecipe); //put new recipe in hashmap list of recipes in account 

        System.out.println("\nRecipe completed!");
    
        Recipe.printRecipe(customRecipe, "custom recipe");

        return customRecipe;
    }

    public Ingredient addCustomIngredient (String name, HashMap <String, String> unitsGuide) {
        if (!unitsGuide.containsKey(name.toLowerCase())) { //must add to unitsGuide
            System.out.print("Enter the unit you would like to use for <" + name + ">: ");
            String unit = in.nextLine();
            unitsGuide.put(name.toLowerCase(), unit.toLowerCase());
        }
        System.out.print("How many <" + unitsGuide.get(name.toLowerCase()) + "> of <" + name + "> to add? ");
        double qtyNum = doubleInput();
        String qty = qtyNum + " " + unitsGuide.get(name.toLowerCase());// amt and unit 
        return new Ingredient (name, qty);
    }

    public static double doubleInput() {
        double num = 0; 
        int done = 0; 
        do { 
            try {
                num = Double.parseDouble(in.nextLine());
                done = 1; // exit loop on valid input
            } catch (Exception e) {
                System.out.print("Incorrect input. Please enter a number value: ");
            }
        } while (done == 0);
        return num; 
    }

    // constructor
    public Account(String firstName, String lastName,
        boolean vegetarian, String preferMeat, boolean preferAltProtein, boolean preferCarbs,
            String preferVeg) {
        this.vegetarian = vegetarian;
        this.preferMeat = preferMeat;
        this.preferAltProtein = preferAltProtein;
        this.preferCarbs = preferCarbs;
        this.preferVeg = preferVeg;
    }

    //another constructor with all instance variables?
    public Account(String firstName, String lastName, boolean vegetarian, String preferMeat, boolean preferAltProtein, boolean preferCarbs, String preferVeg, HashMap <String, Day> days, HashMap <String, Recipe> recipes) {
        this.vegetarian = vegetarian;
        this.preferMeat = preferMeat;
        this.preferAltProtein = preferAltProtein;
        this.preferCarbs = preferCarbs;
        this.preferVeg = preferVeg;
        this.days = days; 
        this.recipes = recipes; 
    }

    // getters

    public static Scanner getIn() {
        return in;
    }

    public HashMap<String, Day> getDays() {
        return days;
    }

    public HashMap<String, Recipe> getRecipes() {
        return recipes;
    }

    public HashMap<String, String> getIngredientUnits() {
        return ingredientUnits;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public String getPreferMeat() {
        return preferMeat;
    }

    public boolean isPreferCarbs() {
        return preferCarbs;
    }

    public boolean isPreferAltProtein() {
        return preferAltProtein;
    }

    public String getPreferVeg() {
        return preferVeg;
    }

    public String getMeal() {
        return meal;
    }

    // setters

    public static void setIn(Scanner in) {
        Account.in = in;
    }

    public void setDays(HashMap<String, Day> days) {
        this.days = days;
    }

    public void setRecipes(HashMap<String, Recipe> recipes) {
        this.recipes = recipes;
    }

    public void setIngredientUnits(HashMap<String, String> ingredientUnits) {
        this.ingredientUnits = ingredientUnits;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setPreferMeat(String preferMeat) {
        this.preferMeat = preferMeat;
    }

    public void setPreferCarbs(boolean preferCarbs) {
        this.preferCarbs = preferCarbs;
    }

    public void setPreferAltProtein(boolean preferAltProtein) {
        this.preferAltProtein = preferAltProtein;
    }

    public void setPreferVeg(String preferVeg) {
        this.preferVeg = preferVeg;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    

}