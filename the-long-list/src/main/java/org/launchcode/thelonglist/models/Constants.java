package org.launchcode.thelonglist.models;

import java.util.List;

public class Constants {

    public static final List<String> INGREDIENT_CATEGORIES = List.of("Fresh Produce", "Deli", "Bakery", "Cheese", "Spices", "Dry/Baking", "Canned/Jarred Goods", "Condiments", "Meat/Seafood", "Dairy", "Frozen", "Snacks", "Beverages (Non-Alcoholic)", "Alcohol", "Other");

    public static List<String> getIngredientCategories() {
        return INGREDIENT_CATEGORIES;
    }

}
