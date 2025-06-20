import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // breakfast recipes
    static Recipe veggieBagelSandwich, beanVeggieScramble, greenEggScramble, redOrangeVeggieSalad, pancakes, crustlessQuiche, steakAndEggs, smokedSalmonBagel, turkeyBaconAndEggs;
    // lunch recipes
    static Recipe veggieWrap, edamameSpinachSalad, spinachAvocadoSalad, redOrangeLunchSalad, BLTSandwich, eggSaladLettuceWrap, beefBurger, tunaMeltSandwich, chickenCaesarSalad;
    // dinner recipes
    static Recipe vegetarianPizza, riceAndBeans, gardenSalad, moroccanBeetSalad, spaghettiBolognese, eggCasserole, steak, smokedSalmon, bakedChickenBreast;

    static Scanner in = new Scanner(System.in);
    static Account myAccount;
    static Recipe breakfast; 
    static Recipe lunch; 
    static Recipe dinner; 

    // class-level hashmaps to be accessed throughout Main.java
    static HashMap <String, String> unitsGuide =  new HashMap <>();
    static HashMap <String, Recipe> recipes = new HashMap<>(); // hashmap to store recipes

    public static void main(String[] args) {

        String[][] ingredientUnits = { // 2D array to store ingredient units --> hashmap
            {"all-purpose flour", "cup(s)"},
            {"arugula", "cup(s)"},
            {"avocado", ""},
            {"bacon slices", ""},
            {"bagel", ""},
            {"baking powder", "tsp"},
            {"beef patty", ""},
            {"bell pepper", ""},
            {"black beans", "can(s)"},
            {"black beans (cooked, rinsed)", "cup(s)"},
            {"black olives", "cup(s)"},
            {"black pepper", "tsp"},
            {"bread slices", ""},
            {"burger bun", ""},
            {"butter", "tbsp"},
            {"canned tuna (in water, drained)", "cup(s)"},
            {"carrot", ""},
            {"caesar dressing", "tbsp"},
            {"cheddar cheese", "cup(s)"},
            {"cherry tomatoes", "cup(s)"},
            {"chives", "tbsp"},
            {"cilantro", "tbsp"},
            {"cream cheese", "tbsp"},
            {"croutons", "cup(s)"},
            {"cucumber", "slice(s)"},
            {"cumin", "tbsp"},
            {"dijon mustard", "tsp"},
            {"egg whites", ""},
            {"eggs", ""},
            {"garlic", "clove(s)"},
            {"garlic powder", "tsp"},
            {"grilled chicken breast", "g"},
            {"green onion", "tbsp"},
            {"hard-boiled eggs", ""},
            {"hummus", "tbsp"},
            {"kale", "cup(s)"},
            {"ketchup", "tbsp"},
            {"lemon juice", "tbsp"},
            {"lemon juice/vinegar", "tbsp"},
            {"lemon wedge", ""},
            {"lemon wedges", ""},
            {"lettuce", ""},
            {"mayonnaise", "tbsp"},
            {"milk", "cup(s)"},
            {"mozzarella cheese", "cup(s)"},
            {"mushrooms", "cup(s)"},
            {"mustard", "tsp"},
            {"olive oil", "tsp"},
            {"onion", ""},
            {"orange bell pepper", ""},
            {"paprika", "tsp"},
            {"parmesan cheese (shaved)", "tbsp"},
            {"pizza dough", "g"},
            {"red bell pepper", ""},
            {"red onion", "tbsp"},
            {"red wine vinegar", "tbsp"},
            {"romaine lettuce", "cup(s)"},
            {"romaine/mixed greens", "cup(s)"},
            {"salt", "tsp"},
            {"smoked salmon", "g"},
            {"spaghetti", "g"},
            {"spinach", "cup(s)"},
            {"sugar", "tbsp"},
            {"tomato", "slice(s)"},
            {"tomato paste", "tbsp"},
            {"tomato sauce", "cup(s)"},
            {"tortilla wrap", ""},
            {"vegetable broth", "cup(s)"},
            {"white/brown rice", "cup(s)"}
        };
    
        for (int i = 0; i < ingredientUnits.length; i++) { // for loop to add into hashmap unitsGuide
            String name = ingredientUnits[i][0];
            String units = ingredientUnits[i][1];
            unitsGuide.put(name, units); 
        }

        // create ArrayList for recipe ingredients

        // breakfast
        ArrayList<Ingredient> arrVeggieBagelSandwich = new ArrayList<>(); // veg, carbs
        arrVeggieBagelSandwich.add(new Ingredient("Bagel", "1"));
        arrVeggieBagelSandwich.add(new Ingredient("Cream cheese", "2 tbsp"));
        arrVeggieBagelSandwich.add(new Ingredient("Tomato", "2 slice(s)"));
        arrVeggieBagelSandwich.add(new Ingredient("Cucumber", "3 slice(s)"));
        arrVeggieBagelSandwich.add(new Ingredient("Lettuce", "1"));
        arrVeggieBagelSandwich.add(new Ingredient("Olive oil", "1 tsp"));
        arrVeggieBagelSandwich.add(new Ingredient("Salt", "0.25 tsp"));
        arrVeggieBagelSandwich.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrBeanVeggieScramble = new ArrayList<>(); // veg, low carbs, beans
        arrBeanVeggieScramble.add(new Ingredient("Egg whites", "3"));  
        arrBeanVeggieScramble.add(new Ingredient("Black beans (cooked, rinsed)", "0.25 cup(s)"));  
        arrBeanVeggieScramble.add(new Ingredient("Spinach", "0.5 cup(s)"));  
        arrBeanVeggieScramble.add(new Ingredient("Bell pepper", "0.25"));  
        arrBeanVeggieScramble.add(new Ingredient("Onion", "0.25"));  
        arrBeanVeggieScramble.add(new Ingredient("Garlic", "1 clove(s)"));  
        arrBeanVeggieScramble.add(new Ingredient("Olive oil", "1 tsp"));  

        ArrayList<Ingredient> arrGreenEggScramble = new ArrayList<>(); // veg, low carbs, no beans, greens
        arrGreenEggScramble.add(new Ingredient("Eggs", "2"));
        arrGreenEggScramble.add(new Ingredient("Egg whites", "2"));
        arrGreenEggScramble.add(new Ingredient("Spinach", "1 cup(s)"));
        arrGreenEggScramble.add(new Ingredient("Kale", "0.5 cup(s)"));
        arrGreenEggScramble.add(new Ingredient("Mushrooms", "0.25 cup(s)"));
        arrGreenEggScramble.add(new Ingredient("Olive oil", "1 tsp"));
        arrGreenEggScramble.add(new Ingredient("Salt", "0.25 tsp"));
        arrGreenEggScramble.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrRedOrangeVeggieSalad = new ArrayList<>(); // veg, low carbs, no beans, red + orange
        arrRedOrangeVeggieSalad.add(new Ingredient("Red bell pepper", "1"));
        arrRedOrangeVeggieSalad.add(new Ingredient("Carrot", "1"));
        arrRedOrangeVeggieSalad.add(new Ingredient("Cherry tomatoes", "0.5 cup(s)"));
        arrRedOrangeVeggieSalad.add(new Ingredient("Orange bell pepper", "0.5"));
        arrRedOrangeVeggieSalad.add(new Ingredient("Olive oil", "1 tbsp"));
        arrRedOrangeVeggieSalad.add(new Ingredient("Red wine vinegar", "1 tbsp"));
        arrRedOrangeVeggieSalad.add(new Ingredient("Salt", "0.25 tsp"));
        arrRedOrangeVeggieSalad.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList <Ingredient> arrPancakes = new ArrayList<>(); // not veg, no meat pref, no veg pref, carbs
        arrPancakes.add(new Ingredient("All-purpose flour", "1 cup(s)"));
        arrPancakes.add(new Ingredient("Milk", "0.75 cup(s)"));
        arrPancakes.add(new Ingredient("Egg", "1"));
        arrPancakes.add(new Ingredient("Baking powder", "2 tsp"));
        arrPancakes.add(new Ingredient("Sugar", "2 tbsp"));
        arrPancakes.add(new Ingredient("Salt", "0.25 tsp"));

        ArrayList<Ingredient> arrCrustlessQuiche = new ArrayList<>(); // not veg, no meat pref, no veg pref, low carbs
        arrCrustlessQuiche.add(new Ingredient("Eggs", "3"));
        arrCrustlessQuiche.add(new Ingredient("Heavy cream", "0.25 cup(s)"));
        arrCrustlessQuiche.add(new Ingredient("Cheddar cheese", "0.5 cup(s)"));
        arrCrustlessQuiche.add(new Ingredient("Spinach", "0.5 cup(s)"));
        arrCrustlessQuiche.add(new Ingredient("Mushrooms", "0.25 cup(s)"));
        arrCrustlessQuiche.add(new Ingredient("Salt", "0.25 tsp"));
        arrCrustlessQuiche.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrSteakAndEggs = new ArrayList<>(); // not veg, pref meat, red meat
        arrSteakAndEggs.add(new Ingredient("Striploin steak", "1"));
        arrSteakAndEggs.add(new Ingredient("Eggs", "2"));
        arrSteakAndEggs.add(new Ingredient("Butter", "1 tbsp"));
        arrSteakAndEggs.add(new Ingredient("Salt", "0.5 tsp"));
        arrSteakAndEggs.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrSmokedSalmonBagel = new ArrayList<>(); // not veg, pref meat, seafood
        arrSmokedSalmonBagel.add(new Ingredient("Bagel", "1"));
        arrSmokedSalmonBagel.add(new Ingredient("Cream cheese", "2 tbsp"));
        arrSmokedSalmonBagel.add(new Ingredient("Smoked salmon", "75 g"));
        arrSmokedSalmonBagel.add(new Ingredient("Cucumber", "3 slice(s)"));
        arrSmokedSalmonBagel.add(new Ingredient("Red onion", "2 tbsp"));
        arrSmokedSalmonBagel.add(new Ingredient("Lemon wedge", "1"));

        ArrayList<Ingredient> arrTurkeyBaconAndEggs = new ArrayList<>(); // not veg, pref meat, poultry
        arrTurkeyBaconAndEggs.add(new Ingredient("Turkey bacon", "3 slice(s)"));
        arrTurkeyBaconAndEggs.add(new Ingredient("Eggs", "2"));
        arrTurkeyBaconAndEggs.add(new Ingredient("Butter", "1 tbsp"));
        arrTurkeyBaconAndEggs.add(new Ingredient("Salt", "0.25 tsp"));
        arrTurkeyBaconAndEggs.add(new Ingredient("Black pepper", "0.25 tsp"));

        // put all recipes into HashMap recipes
        recipes.put("veggie bagel sandwich", new Recipe("veggie bagel sandwich", arrVeggieBagelSandwich));
        recipes.put("bean veggie scramble", new Recipe("bean veggie scramble", arrBeanVeggieScramble));
        recipes.put("green egg scramble", new Recipe("green egg scramble", arrGreenEggScramble));
        recipes.put("red orange veggie salad", new Recipe("red orange veggie salad", arrRedOrangeVeggieSalad));
        recipes.put("pancakes", new Recipe("pancakes", arrPancakes));
        recipes.put("crustless quiche", new Recipe("crustless quiche", arrCrustlessQuiche));
        recipes.put("steak and eggs", new Recipe("steak and eggs", arrSteakAndEggs));
        recipes.put("smoked salmon bagel", new Recipe("smoked salmon bagel", arrSmokedSalmonBagel));
        recipes.put("turkey bacon and eggs", new Recipe("turkey bacon and eggs", arrTurkeyBaconAndEggs));

        // get all keys from recipes HashMap
        veggieBagelSandwich = recipes.get("veggie bagel sandwich");
        beanVeggieScramble = recipes.get("bean veggie scramble");
        greenEggScramble = recipes.get("green egg scramble");
        redOrangeVeggieSalad = recipes.get("red orange veggie salad");
        pancakes = recipes.get("pancakes");
        crustlessQuiche = recipes.get("crustless quiche");
        steakAndEggs = recipes.get("steak and eggs");
        smokedSalmonBagel = recipes.get("smoked salmon bagel");
        turkeyBaconAndEggs = recipes.get("turkey bacon and eggs");


        // lunch
        ArrayList<Ingredient> arrVeggieWrap = new ArrayList<>(); // veg, carbs
        arrVeggieWrap.add(new Ingredient("Tortilla wrap", "1"));
        arrVeggieWrap.add(new Ingredient("Hummus", "2 tbsp"));
        arrVeggieWrap.add(new Ingredient("Lettuce", "2"));
        arrVeggieWrap.add(new Ingredient("Tomato", "2 slice(s)"));
        arrVeggieWrap.add(new Ingredient("Cucumber", "4 slice(s)"));
        arrVeggieWrap.add(new Ingredient("Bell pepper", "0.25"));
        arrVeggieWrap.add(new Ingredient("Olive oil", "1 tsp"));
        arrVeggieWrap.add(new Ingredient("Salt", "0.25 tsp"));
        arrVeggieWrap.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrEdamameSpinachSalad = new ArrayList<>(); // veg, low carbs, beans
        arrEdamameSpinachSalad.add(new Ingredient("Shelled edamame", "0.5 cup(s)"));
        arrEdamameSpinachSalad.add(new Ingredient("Spinach", "2 cup(s)"));
        arrEdamameSpinachSalad.add(new Ingredient("Cucumber", "0.5"));
        arrEdamameSpinachSalad.add(new Ingredient("Red bell pepper", "0.25"));
        arrEdamameSpinachSalad.add(new Ingredient("Olive oil", "1 tbsp"));
        arrEdamameSpinachSalad.add(new Ingredient("Lemon juice", "1 tbsp"));
        arrEdamameSpinachSalad.add(new Ingredient("Salt", "0.25 tsp"));
        arrEdamameSpinachSalad.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrSpinachAvocadoSalad = new ArrayList<>(); // veg, low carbs, no beans, greens
        arrSpinachAvocadoSalad.add(new Ingredient("Spinach", "2 cup(s)"));
        arrSpinachAvocadoSalad.add(new Ingredient("Arugula", "1 cup(s)"));
        arrSpinachAvocadoSalad.add(new Ingredient("Avocado", "0.5"));
        arrSpinachAvocadoSalad.add(new Ingredient("Cucumber", "0.5"));
        arrSpinachAvocadoSalad.add(new Ingredient("Green onion", "2 tbsp"));
        arrSpinachAvocadoSalad.add(new Ingredient("Olive oil", "1 tbsp"));
        arrSpinachAvocadoSalad.add(new Ingredient("Lemon juice", "1 tbsp"));
        arrSpinachAvocadoSalad.add(new Ingredient("Salt", "0.25 tsp"));
        arrSpinachAvocadoSalad.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrRedOrangeLunchSalad = new ArrayList<>(); // veg, low carbs, no beans, red + orange
        arrRedOrangeLunchSalad.add(new Ingredient("Red bell pepper", "1"));
        arrRedOrangeLunchSalad.add(new Ingredient("Carrot", "1"));
        arrRedOrangeLunchSalad.add(new Ingredient("Cherry tomatoes", "0.5 cup(s)"));
        arrRedOrangeLunchSalad.add(new Ingredient("Red onion", "2 tbsp"));
        arrRedOrangeLunchSalad.add(new Ingredient("Olive oil", "1 tbsp"));
        arrRedOrangeLunchSalad.add(new Ingredient("Lemon juice", "1 tbsp"));
        arrRedOrangeLunchSalad.add(new Ingredient("Salt", "0.25 tsp"));
        arrRedOrangeLunchSalad.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrBLTSandwich = new ArrayList<>(); // not veg, no meat pref, no veg pref, carbs
        arrBLTSandwich.add(new Ingredient("Bread slices", "2"));
        arrBLTSandwich.add(new Ingredient("Bacon slices", "3"));
        arrBLTSandwich.add(new Ingredient("Lettuce leaves", "2"));
        arrBLTSandwich.add(new Ingredient("Tomato slices", "2"));
        arrBLTSandwich.add(new Ingredient("Mayonnaise", "1 tbsp"));

        ArrayList<Ingredient> arrEggSaladLettuceWrap = new ArrayList<>(); // not veg, no meat pref, no veg pref, low carbs
        arrEggSaladLettuceWrap.add(new Ingredient("Hard-boiled eggs", "2"));
        arrEggSaladLettuceWrap.add(new Ingredient("Mayonnaise", "2 tbsp"));
        arrEggSaladLettuceWrap.add(new Ingredient("Dijon mustard", "1 tsp"));
        arrEggSaladLettuceWrap.add(new Ingredient("Lettuce leaves", "4"));
        arrEggSaladLettuceWrap.add(new Ingredient("Chives", "1 tbsp"));
        arrEggSaladLettuceWrap.add(new Ingredient("Salt", "0.25 tsp"));
        arrEggSaladLettuceWrap.add(new Ingredient("Black pepper", "0.25 tsp"));

        ArrayList<Ingredient> arrBeefBurger = new ArrayList<>(); // not veg, pref meat, red meat
        arrBeefBurger.add(new Ingredient("Beef patty", "1"));
        arrBeefBurger.add(new Ingredient("Burger bun", "1"));
        arrBeefBurger.add(new Ingredient("Cheddar cheese", "1 slice(s)"));
        arrBeefBurger.add(new Ingredient("Lettuce", "1"));
        arrBeefBurger.add(new Ingredient("Tomato", "2 slice(s)"));
        arrBeefBurger.add(new Ingredient("Onion", "2"));
        arrBeefBurger.add(new Ingredient("Ketchup", "1 tbsp"));
        arrBeefBurger.add(new Ingredient("Mustard", "1 tsp"));

        ArrayList<Ingredient> arrTunaMeltSandwich = new ArrayList<>(); // not veg, pref meat, seafood
        arrTunaMeltSandwich.add(new Ingredient("Bread slices", "2"));
        arrTunaMeltSandwich.add(new Ingredient("Canned tuna (in water, drained)", "0.5 cup(s)"));
        arrTunaMeltSandwich.add(new Ingredient("Mayonnaise", "2 tbsp"));
        arrTunaMeltSandwich.add(new Ingredient("Cheddar cheese", "1 slice(s)"));
        arrTunaMeltSandwich.add(new Ingredient("Tomato", "2 slice(s)"));
        arrTunaMeltSandwich.add(new Ingredient("Butter", "1 tbsp"));

        ArrayList<Ingredient> arrChickenCaesarSalad = new ArrayList<>(); // not veg, pref meat, poultry
        arrChickenCaesarSalad.add(new Ingredient("Romaine lettuce", "2 cup(s)"));
        arrChickenCaesarSalad.add(new Ingredient("Grilled chicken breast", "100 g"));
        arrChickenCaesarSalad.add(new Ingredient("Parmesan cheese (shaved)", "2 tbsp"));
        arrChickenCaesarSalad.add(new Ingredient("Croutons", "0.25 cup(s)"));
        arrChickenCaesarSalad.add(new Ingredient("Caesar dressing", "2 tbsp"));
        arrChickenCaesarSalad.add(new Ingredient("Olive oil", "1 tsp"));
        arrChickenCaesarSalad.add(new Ingredient("Salt", "0.25 tsp"));
        arrChickenCaesarSalad.add(new Ingredient("Black pepper", "0.25 tsp"));

        // repeat for lunch recipes
        recipes.put("veggie wrap", new Recipe("veggie wrap", arrVeggieWrap));
        recipes.put("edamame spinach salad", new Recipe("edamame spinach salad", arrEdamameSpinachSalad));
        recipes.put("spinach avocado salad", new Recipe("spinach avocado salad", arrSpinachAvocadoSalad));
        recipes.put("red orange lunch salad", new Recipe("red orange lunch salad", arrRedOrangeLunchSalad));
        recipes.put("blt sandwich", new Recipe("blt sandwich", arrBLTSandwich));
        recipes.put("egg salad lettuce wrap", new Recipe("egg salad lettuce wrap", arrEggSaladLettuceWrap));
        recipes.put("beef burger", new Recipe("beef burger", arrBeefBurger));
        recipes.put("tuna melt sandwich", new Recipe("tuna melt sandwich", arrTunaMeltSandwich));
        recipes.put("chicken caesar salad", new Recipe("chicken caesar salad", arrChickenCaesarSalad));

        veggieWrap = recipes.get("veggie wrap");
        edamameSpinachSalad = recipes.get("edamame spinach salad");
        spinachAvocadoSalad = recipes.get("spinach avocado salad");
        redOrangeLunchSalad = recipes.get("red orange lunch salad");
        BLTSandwich = recipes.get("blt sandwich");
        eggSaladLettuceWrap = recipes.get("egg salad lettuce wrap");
        beefBurger = recipes.get("beef burger");
        tunaMeltSandwich = recipes.get("tuna melt sandwich");
        chickenCaesarSalad = recipes.get("chicken caesar salad");


        // dinner
        ArrayList <Ingredient> arrVegetarianPizza = new ArrayList<>(); // veg, carbs
        arrVegetarianPizza.add(new Ingredient("Pizza dough", "250 g"));
        arrVegetarianPizza.add(new Ingredient("Tomato sauce", "0.25 cup(s)"));
        arrVegetarianPizza.add(new Ingredient("Mozzarella cheese", "0.5 cup(s)"));
        arrVegetarianPizza.add(new Ingredient("Mushrooms", "0.75 cup(s)"));
        arrVegetarianPizza.add(new Ingredient("Black olives", "0.25 cup(s)"));
        arrVegetarianPizza.add(new Ingredient("Olive oil", "1 tbsp"));
        
        ArrayList <Ingredient> arrRiceAndBeans = new ArrayList<>(); // veg, low carbs, beans
        arrRiceAndBeans.add(new Ingredient("White/brown rice", "1 cup(s)"));
        arrRiceAndBeans.add(new Ingredient("Black beans", "1 can(s)"));
        arrRiceAndBeans.add(new Ingredient("Onion", "1"));
        arrRiceAndBeans.add(new Ingredient("Garlic", "2 clove(s)"));
        arrRiceAndBeans.add(new Ingredient("Olive oil", "1 tbsp"));
        arrRiceAndBeans.add(new Ingredient("Vegetable broth", "2 cup(s)"));
        
        ArrayList <Ingredient> arrGardenSalad = new ArrayList<>(); // veg, low carbs, no beans, greens
        arrGardenSalad.add(new Ingredient("Romaine/mixed greens", "4 cup(s)"));
        arrGardenSalad.add(new Ingredient("Tomato", "1"));
        arrGardenSalad.add(new Ingredient("Cucumber", "1"));
        arrGardenSalad.add(new Ingredient("Red onion", "0.25"));
        arrGardenSalad.add(new Ingredient("Olive oil", "2 tbsp"));
        arrGardenSalad.add(new Ingredient("Lemon juice/vinegar", "1 tbsp"));
        
        ArrayList <Ingredient> arrMoroccanBeetSalad = new ArrayList<>(); // veg, low carbs, no beans, red + orange
        arrMoroccanBeetSalad.add(new Ingredient("Beets", "2"));
        arrMoroccanBeetSalad.add(new Ingredient("Olive oil", "2 tbsp"));
        arrMoroccanBeetSalad.add(new Ingredient("Lemon juice/vinegar", "1 tbsp"));
        arrMoroccanBeetSalad.add(new Ingredient("Garlic", "1 clove(s)"));
        arrMoroccanBeetSalad.add(new Ingredient("Cumin", "0.5 tbsp"));
        arrMoroccanBeetSalad.add(new Ingredient("Cilantro", "2 tbsp"));
        
        ArrayList <Ingredient> arrSpaghettiBolognese = new ArrayList<>(); // not veg, no meat pref, no veg pref, carbs
        arrSpaghettiBolognese.add(new Ingredient("Spaghetti", "200 g"));
        arrSpaghettiBolognese.add(new Ingredient("Olive oil", "1 tbsp"));
        arrSpaghettiBolognese.add(new Ingredient("Onion", "1"));
        arrSpaghettiBolognese.add(new Ingredient("Garlic", "2 clove(s)"));
        arrSpaghettiBolognese.add(new Ingredient("Carrot", "1"));
        arrSpaghettiBolognese.add(new Ingredient("Celery", "1"));
        arrSpaghettiBolognese.add(new Ingredient("Crushed tomatoes", "1 can(s)"));
        arrSpaghettiBolognese.add(new Ingredient("Tomato paste", "1 tbsp"));
        
        ArrayList <Ingredient> arrEggCasserole = new ArrayList<>(); // not veg, no meat pref, no veg pref, low carbs
        arrEggCasserole.add(new Ingredient("Eggs", "4"));
        arrEggCasserole.add(new Ingredient("Milk", "0.25 cup(s)"));
        arrEggCasserole.add(new Ingredient("Cheddar cheese", "0.5 cup(s)"));
        arrEggCasserole.add(new Ingredient("Bell pepper", "0.5"));
        arrEggCasserole.add(new Ingredient("Spinach", "0.5"));
        arrEggCasserole.add(new Ingredient("Onion", "0.25"));
        
        ArrayList <Ingredient> arrSteak = new ArrayList<>(); // not veg, pref meat, red meat
        arrSteak.add(new Ingredient("Striploin steak","1"));
        arrSteak.add(new Ingredient("Salt","0.5 tbsp"));
        arrSteak.add(new Ingredient("Black pepper","0.5 tbsp"));
        arrSteak.add(new Ingredient("Olive oil","1 tbsp"));
        arrSteak.add(new Ingredient("Butter","1 tbsp"));
        arrSteak.add(new Ingredient("Garlic","2 clove(s)"));
        
        ArrayList <Ingredient> arrSmokedSalmon = new ArrayList<>(); // not veg, pref meat, seafood 
        arrSmokedSalmon.add(new Ingredient("Smoked salmon", "150 g"));
        arrSmokedSalmon.add(new Ingredient("Cream cheese", "2 tbsp"));
        arrSmokedSalmon.add(new Ingredient("Cucumber", "0.5"));
        arrSmokedSalmon.add(new Ingredient("Red onion", "0.25"));
        arrSmokedSalmon.add(new Ingredient("Lemon wedges", "2"));
        
        ArrayList <Ingredient> arrBakedChickenBreast = new ArrayList<>(); // not veg, pref meat, poultry
        arrBakedChickenBreast.add(new Ingredient("Chicken breasts", "2"));
        arrBakedChickenBreast.add(new Ingredient("Olive oil", "1 tbsp"));
        arrBakedChickenBreast.add(new Ingredient("Garlic powder", "0.5 tsp"));
        arrBakedChickenBreast.add(new Ingredient("Paprika", "0.5 tsp"));
        arrBakedChickenBreast.add(new Ingredient("Salt", "0.5 tsp"));
        arrBakedChickenBreast.add(new Ingredient("Black pepper", "0.25 tsp"));

        // repeat for dinner recipes
        recipes.put("vegetarian pizza" , new Recipe("vegetarian pizza", arrVegetarianPizza));
        recipes.put("rice and beans", new Recipe("rice and beans", arrRiceAndBeans));
        recipes.put("garden salad", new Recipe("garden salad", arrGardenSalad));
        recipes.put("moroccan beet salad", new Recipe("moroccan beet salad", arrMoroccanBeetSalad));
        recipes.put("spaghetti bolognese", new Recipe("spaghetti bolognese", arrSpaghettiBolognese));
        recipes.put("egg casserole", new Recipe("egg casserole", arrEggCasserole));
        recipes.put("steak", new Recipe("steak", arrSteak));
        recipes.put("smoked salmon", new Recipe("smoked salmon", arrSmokedSalmon));        
        recipes.put("baked chicken breast", new Recipe("baked chicken breast", arrBakedChickenBreast));

        vegetarianPizza = recipes.get("vegetarian pizza");
        riceAndBeans = recipes.get("rice and beans");
        gardenSalad = recipes.get("garden salad");
        moroccanBeetSalad = recipes.get("moroccan beet salad");
        spaghettiBolognese = recipes.get("spaghetti bolognese");
        eggCasserole = recipes.get("egg casserole");
        steak = recipes.get("steak");
        smokedSalmon = recipes.get("smoked salmon");
        bakedChickenBreast = recipes.get("baked chicken breast");

        // initiate program

        System.out.println("\n==================================================");
        System.out.println("               Welcome to Plate Pal               ");
        System.out.println("                  Meal Planner!                   ");
        System.out.println("==================================================");
        System.out.println("This program will:");
        System.out.println("  • Let you choose which meal to plan:");
        System.out.println("    breakfast, lunch, dinner, or all three at once");
        System.out.println("  • Ask for your dietary preferences (vegetarian");
        System.out.println("    or meat type, carb vs low-carb, preferred veggies)");
        System.out.println("  • Recommend recipes tailored to your preferences,");
        System.out.println("    and display the ingredients with quantities");
        System.out.println("    needed to make each dish");
        System.out.println("  • Allow you to re-plan/replace additional meals");
        System.out.println("    in your plan in the same session");
        System.out.println("  • Search for recipes by name or let you add your");
        System.out.println("    own custom creations at the end!");
        System.out.println("==================================================\n");

        myAccount = Account.askForName(in); // call method to ask for name, store into static field

        System.out.println("==================================================");

        myAccount.setRecipes(recipes); // call setter from Account.java

        String again = ""; // initialize variable

        // boolean variables for printing breakfast/lunch/dinner recipes
        boolean breakfastPrint = false; 
        boolean lunchPrint = false; 
        boolean dinnerPrint = false; 
    
        do { // do-while loop to produce recipes until user wishes to exit/stop adding recipes

            // ask user to pick which meal to plan before calling survey method
            if (breakfastPrint == false && lunchPrint == false && dinnerPrint == false) { // provide all four options given that no meal has been printed yet
                System.out.print("\nWhich meal would you like to plan? \n\ta) Breakfast \n\tb) Lunch \n\tc) Dinner \n\td) All three \nEnter: (a/b/c/d): ");
            } else { // otherwise, get rid of option d) All three
                System.out.print("\nWhich meal would you like to plan? \n\ta) Breakfast \n\tb) Lunch \n\tc) Dinner \nEnter: (a/b/c): ");
            }

            String choice = ""; // collect user's choice in variable
            choice = in.nextLine().trim().toLowerCase(); // trim, make it lowercase

            System.out.println();

            // boolean variables to check if user picks a/b/c or all three (but it must be when no other meal has already been printed)
            boolean isSingleMeal = choice.matches("[abc]"); 
            boolean isFirstAllThree = choice.equals("d") && !(breakfastPrint || lunchPrint || dinnerPrint); // only first time that all three is requested

            // ONLY call method from Account.java for the preference survey if BOTH boolean conditions are met
            if (isSingleMeal || isFirstAllThree) {
                myAccount = myAccount.askForPrefs(in);
            }

            if (choice.equals("a")) {
                setBreakfast(); // if user chooses to plan breakfast, call method to plan their breakfast
                breakfastPrint = true; 
            } else if (choice.equals("b")) {
                setLunch(); //same for lunch 
                lunchPrint = true;
            } else if (choice.equals("c")) {
                setDinner();
                dinnerPrint = true; 
            } else if (choice.equals("d") && !breakfastPrint && !lunchPrint && !dinnerPrint) { // run this is choice is d) AND no other meal ha printed yet
                // call all three methods to set meals
                setBreakfast(); 
                setLunch();
                setDinner();
                // print all three planned meals
                breakfastPrint = true; 
                lunchPrint = true;
                dinnerPrint = true;
            } else { // if user enters invalid inputs, loop until the input is accepted
                System.out.print("Invalid choice. Please enter one of the valid options listed: ");
            }

            System.out.println();

            // print only what user asked for
            if (isSingleMeal || isFirstAllThree) { // if either boolean conditions are met...
                
                //valid, proceed
                System.out.println("Current Meal Plan:\n");

                if (breakfastPrint == true) { // set boolean to true to indicate that meal has already been printed
                    System.out.println("Breakfast: " + breakfast.getName()); // print
                }

                if (lunchPrint == true) {
                    System.out.println("Lunch: " + lunch.getName());
                }

                if (dinnerPrint == true) {
                    System.out.println("Dinner: " + dinner.getName());
                }

                System.out.print("\nPlan another meal? (y/n): "); // prompt user again
                do { // do-while loop to trap error
                    again = in.nextLine().trim().toLowerCase();
                    if (!again.equals("n") && !again.equals("y")) {
                        System.out.print("Invalid input. Please try again (y/n) : ");
                    }
                } while (!again.equals("y") && !again.equals("n"));
            }

        } while (!again.equals("n")); // keep looping if y or invalid, stop if n

        System.out.println("\n----------\n\nHere are your meals for the day:");
        printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint); // call method to print all meals for the day

        System.out.print("\nWould you like to find another recipe by name? (y/n): "); // ask user if they would like to search for a recipe by key
        String searchRecipe;
        do { // do-while loop to error trap if user enters not y/n
            searchRecipe = in.nextLine().trim().toLowerCase();
            if (!searchRecipe.equals("y") && !searchRecipe.equals("n")) {
                System.out.print("Invalid input. Please try again (y/n) : ");
            }
        } while (!searchRecipe.equals("y") && !searchRecipe.equals("n"));

        if (searchRecipe.equalsIgnoreCase("y")) { // if user wants to search for recipe...
            Recipe foundRecipe = myAccount.findRecipeByName(); // call method to search for recipe 

            if (foundRecipe != null) { // if recipe is found...
                System.out.println("\nRecipe found: " + foundRecipe.getName()); // return the name of the found recipe 
                
                System.out.print("\nWould you like to add this to your meal plan for the day? (y/n): "); // ask user if they would like to add meal to the plan
                String addToPlan;
                do { // do-while loop to error trap if user enters not y/n
                    addToPlan = in.nextLine().trim().toLowerCase();
                    if (!addToPlan.equals("y") && !addToPlan.equals("n")) {
                        System.out.print("Invalid input. Please try again (y/n) : ");
                    }
                } while (!addToPlan.equals("y") && !addToPlan.equals("n"));
            
                if (addToPlan.equalsIgnoreCase("y")) { // if yes...
                    
                    System.out.println("\nWhat meal would you like to switch out? \n\ta) breakfast \n\tb) lunch \n\tc) dinner \nEnter (a/b/c): ");
                    String mealSwitch; // switch if user enters breakfast/lunch/dinner with an existing plan already, add if user enters a meal of the day that has yet to be planned
                    do {
                        mealSwitch = in.nextLine().trim().toLowerCase();
                        if (mealSwitch.equalsIgnoreCase("a")) {
                            breakfast = foundRecipe; // equate breakfast recipe to be the recipe stored in foundRecipe
                            breakfastPrint = true; // set boolean to equal true
                            System.out.println("\n----------\n\nHere are your updated meals for the day:"); // print updated meals
                            printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint);
                        } else if (mealSwitch.equalsIgnoreCase("b")) {
                            lunch = foundRecipe; // repeat
                            lunchPrint = true;
                            System.out.println("\n----------\n\nHere are your updated meals for the day:");
                            printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint);
                        } else if (mealSwitch.equalsIgnoreCase("c")) {
                            dinner = foundRecipe;
                            dinnerPrint = true; 
                            System.out.println("\n----------\n\nHere are your updated meals for the day:");
                            printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint);
                        } else { // else, catch the invalid input
                            System.out.println("\nPlease enter a valid input! (a/b/c) ");
                        }
                    } while(!mealSwitch.equals("a") && !mealSwitch.equals("b") && !mealSwitch.equals("c"));
                } else {
                    System.out.println("\nYour searched recipe was discarded.");
                    System.out.println("\n----------\n\nHere are your meals for the day:");
                    printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint);
                }

            } else { // if no recipe is found...
                
                System.out.print("\nRecipe not found. Would you like to add a custom recipe? (y/n): "); // ask user if they want to add their own custome recipe
                String addRecipe;
                do { // do-while loop to error trap if user enters not y/n
                    addRecipe = in.nextLine().trim().toLowerCase();
                    if (!addRecipe.equals("y") && !addRecipe.equals("n")) {
                        System.out.print("Invalid input. Please try again (y/n) : ");
                    }
                } while (!addRecipe.equals("y") && !addRecipe.equals("n"));

                if (addRecipe.equalsIgnoreCase("y")) {
                    Recipe custom = myAccount.createCustomRecipe(unitsGuide); // if yes, call method

                    String addToPlan;

                    System.out.print("\nWould you like to add this to your meal plan for the day? (y/n): "); // prompt user to add their custom recipe
                    
                    do { 
                        addToPlan = in.nextLine().trim().toLowerCase();
                        if (!addToPlan.equals("y") && !addToPlan.equals("n")){
                            System.out.println("Invalid input. Please try again (y/n) : ");
                        }
                    } while (!addToPlan.equals("y") && !addToPlan.equals("n"));

                    if (addToPlan.equalsIgnoreCase("y")) {
                        
                        System.out.print("\nWhat meal would you like to switch out? \n\ta) breakfast \n\tb) lunch \n\tc) dinner \nEnter (a/b/c): "); // ask user to switch with an existing planned meal
                        String mealSwitch;

                        do { 
                            mealSwitch = in.nextLine();
                            if (mealSwitch.equalsIgnoreCase("a")) { // if user picks breakfast
                                breakfast = custom; // equate their custome recipe to be the breakfast recipe
                                System.out.println("\nAdded your custom recipe: " + custom.getName());
                                System.out.println("\n----------\n\nHere are your updated meals for the day:");
                                printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint); // print all meals again
                            } else if (mealSwitch.equalsIgnoreCase("b")) { // repeat
                                lunch = custom;
                                System.out.println("\nAdded your custom recipe: " + custom.getName());
                                System.out.println("\n----------\n\nHere are your updated meals for the day:");
                                printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint);
                            } else if (mealSwitch.equalsIgnoreCase("c")) {
                                dinner = custom;
                                System.out.println("\nAdded your custom recipe: " + custom.getName());
                                System.out.println("\n----------\n\nHere are your updated meals for the day:");
                                printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint);
                            } else {
                                System.out.println("\nPlease enter a valid input! (a/b/c): "); // check for invalid input
                            }
                        } while (!mealSwitch.equals("a") && !mealSwitch.equals("b") && !mealSwitch.equals("c"));
                    } else {
                        System.out.println("\nYour custom recipe was discarded.");
                        System.out.println("\n----------\n\nHere are your meals for the day:");
                        printMealsForTheDay(breakfastPrint, lunchPrint, dinnerPrint);
                    }
                    
                } 
            }
        }
        System.out.println("\nThank you for using Plate Pal - Happy eating! :)\n"); // cute finishing note!!
    }
    
    // based on user survey results we equate one of the recipes to equal each: breakfast, lunch, dinner

    public static void setBreakfast() { // method for setting the breakfast recipe
        if (myAccount.isVegetarian()) { // if account is vegetarian...
            if (myAccount.isPreferCarbs()) { // prompt for if user prefers carbs
                breakfast = veggieBagelSandwich; // if yes, return this recipe
            } else if (myAccount.isPreferAltProtein()) { // if not, ask for if user prefers alternative protein
                breakfast = beanVeggieScramble; // return
            } else { // low carb, no alt protein --> pick veg by colour
                if (myAccount.getPreferVeg().equalsIgnoreCase("green")) { // green vegetables?
                    breakfast = greenEggScramble; // return
                } else { // if not...
                    breakfast = redOrangeVeggieSalad; // return
                }
            }
        } else { // if user doesn't want a vegetarian meal...
            String meat = myAccount.getPreferMeat().toLowerCase(); // get user's prefered meat dish category
            if (meat.equalsIgnoreCase("red")) { // if red meat...
                breakfast = steakAndEggs; // return
            } else if (meat.equalsIgnoreCase("seafood")) { // if seafood...
                breakfast = smokedSalmonBagel; // return
            } else if (meat.equalsIgnoreCase("poultry")) { // if poultry...
                breakfast = turkeyBaconAndEggs; // return
            } else { // if no meat prefered...
                if (meat.equalsIgnoreCase("carbs")) { // ask for carb preference
                    breakfast = pancakes; // return pancakes if prefer carbs
                } else {
                    breakfast = crustlessQuiche; // otherwise, return
                }
            }
        }
    }

    public static void setLunch() { // method for setting lunch recipe
        if (myAccount.isVegetarian()) { // similar logic to breakfast recipe selection...
            if (myAccount.isPreferCarbs()) {
                lunch = veggieWrap; // ... with different recipes for lunch
            } else if (myAccount.isPreferAltProtein()) {
                lunch = edamameSpinachSalad;
            } else { // low carb, no alt protein --> pick veg by colour
                if (myAccount.getPreferVeg().equalsIgnoreCase("green")) {
                    lunch = spinachAvocadoSalad;
                } else {
                    lunch = redOrangeLunchSalad;
                }
            }
        } else {
            String meat = myAccount.getPreferMeat().toLowerCase();
            if (meat.equalsIgnoreCase("red")) {
                lunch = beefBurger;
            } else if (meat.equalsIgnoreCase("seafood")) {
                lunch = tunaMeltSandwich;
            } else if (meat.equalsIgnoreCase("poultry")) {
                lunch = chickenCaesarSalad;
            } else {
                if (meat.equalsIgnoreCase("carbs")) {
                    lunch = BLTSandwich;
                } else {
                    lunch = eggSaladLettuceWrap;
                }
            }
        }
    }

    public static void setDinner() { // method for setting dinner recipe
        if (myAccount.isVegetarian()) { // similar logic to breakfast + lunch recipe selection...
            if (myAccount.isPreferCarbs()) {
                dinner = vegetarianPizza; // ... with a different menu for dinner!
            } else if (myAccount.isPreferAltProtein()) {
                dinner = riceAndBeans;
            } else { // low carb, no alt protein --> pick veg by colour
                if (myAccount.getPreferVeg().equalsIgnoreCase("green")) {
                    dinner = gardenSalad;
                } else {
                    dinner = moroccanBeetSalad;
                }
            }
        } else {
            String meat = myAccount.getPreferMeat().toLowerCase();
            if (meat.equalsIgnoreCase("red")) {
                dinner = steak;
            } else if (meat.equalsIgnoreCase("seafood")) {
                dinner = smokedSalmon;
            } else if (meat.equalsIgnoreCase("poultry")) {
                dinner = bakedChickenBreast;
            } else {
                if (meat.equalsIgnoreCase("carbs")) {
                    dinner = spaghettiBolognese;
                } else {
                    dinner = eggCasserole;
                }
            }
        }
    }

    // method for printing the meals for the day
    public static void printMealsForTheDay(boolean breakfastPrint, boolean lunchPrint, boolean dinnerPrint) {
        if (breakfastPrint == true) { // if the boolean is set to true...
            Recipe.printRecipe(breakfast, "breakfast"); // call method to print the recipe
        }
        if (lunchPrint == true) {
            Recipe.printRecipe(lunch, "lunch");
        }
        if (dinnerPrint == true) {
            Recipe.printRecipe(dinner, "dinner");
        }
    }
}