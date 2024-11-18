public class Dish {
    private final String name;
    private final String type;
    private final double price;
    private final String recipe;

    public Dish(String name, String type, double price, String recipe) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public String getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "Dish: " + name + ", Type: " + type + ", Price: " + price + "kr";
    }



}
