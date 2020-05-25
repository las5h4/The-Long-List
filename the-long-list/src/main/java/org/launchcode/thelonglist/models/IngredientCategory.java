package org.launchcode.thelonglist.models;

public enum IngredientCategory {

    FRESH_PRODUCE("Fresh Produce", "freshProduceList"),
    DELI("Deli", "deliList"),
    BAKERY("Bakery", "bakeryList"),
    CHEESE("Cheese", "cheeseList"),
    SPICES("Spices", "spicesList"),
    DRY_BAKING("Dry/Baking", "dryBakingList"),
    CANNED_JARRED("Canned/Jarred Goods", "cannedJarredList"),
    CONDIMENTS("Condiments", "condimentsList"),
    MEAT_SEAFOOD("Meat/Seafood", "meatSeafoodList"),
    DAIRY("Dairy", "dairyList"),
    FROZEN("Frozen", "frozenList"),
    SNACKS("Snacks", "snacksList"),
    BEVERAGES_NON_ALC("Beverages (Non-Alcoholic)", "beveragesList"),
    ALCOHOL("Alcohol", "alcoholList"),
    OTHER("Other", "otherList");

    private final String displayName;

    private final String listName;

    IngredientCategory(String displayName, String listName) {
        this.displayName = displayName;
        this.listName = listName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getListName() {
        return listName;
    }
}
