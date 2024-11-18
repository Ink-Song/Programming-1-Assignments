import java.util.ArrayList;

public class Menu {
    private String name;
    private ArrayList<Dish> dishes;
    private int totalPrice;

    public Menu(String name) {
        this.name = name;
        dishes = new ArrayList<>();
        totalPrice = 0;
    }
    public String getName() {
        return name;
    }

    private void resetTotalPrice() {
        totalPrice = 0;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public int getTotalPrice() {
        resetTotalPrice();
        for(Dish dish : dishes) {
            totalPrice += dish.getPrice();
        }
        return totalPrice;
    }

    public void displayMenu() {
        System.out.println("\n" + getName() + " Menu");
        for(Dish dish : dishes) {
            System.out.println(dish.toString());
        }
    }

}
