import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class MenuRegister {
    private ArrayList<Menu> menus;
    private ArrayList<Dish> dishes;
    public MenuRegister() {
        menus = new ArrayList<>();
        dishes = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    /**
     * @param name Name given as a string, (Throws exception over 100 characters)
     * @param type Choose from Appetizer, Main, Dessert
     * @param Price Input a reasonable price (negative prices will throw exception)
     * @param recipe Define recipe
     */
    public void createNewDish(String name, String type, double Price,String recipe){
        if(!isValidName(name)){
            throw new IllegalArgumentException("Invalid name!");
        }
        if(!isValidName(type)){
            throw new IllegalArgumentException("Invalid type!");
        }
        if(!isValidPrice(Price)){
            throw new IllegalArgumentException("Invalid price!");
        }

        dishes.add(new Dish(name, type, Price, recipe));
    }

    public Menu getMenu(String name){
        for(Menu menu : menus){
            if(menu.getName().equals(name)){
                return menu;
            }
        }
        return null;
    }
    public void getMenus(){
        String printMenus = IntStream.range(0,menus.size())
                .mapToObj(i -> menus.get(i).getName())
                .collect(Collectors.joining("\n"));
        System.out.println(printMenus);
    }

    public int getNumberOfMenus(){
        return menus.size();
    }

    public Dish findDish(String name){
        for(Dish dish : dishes){
            if(dish.getName().equals(name)){
                return dish;
            }
        }
        return null;
    }

    public void printDishes(){
        String printDishes = IntStream.range(0, dishes.size())
                .mapToObj(i -> (i+1) + "." + dishes.get(i).toString())
                .collect(Collectors.joining("\n"));
        System.out.println(printDishes);
    }

    public int getNumberOfDishes(){
        return dishes.size();
    }

    public void createNewMenu(String name, ArrayList<Dish> dishes){
        if(!isValidName(name)){
            throw new IllegalArgumentException("Invalid name!");
        }
        menus.add(new Menu(name));
        Menu createdMenu = getMenu(name);
        for(Dish dish : dishes){
            createdMenu.addDish(dish);
        }
    }

    public void findDishByType(String type){
        ArrayList<Dish> foundDishes = new ArrayList<>();
        for(Dish dish : dishes){
            if(dish.getType().equals(type)){
                foundDishes.add(dish);
            }
        }
        for(Dish dish : foundDishes){
            System.out.println(dish.toString());
        }
    }
    public Dish getDish(int index){
        return dishes.get(index);
    }

    public void displayMenus(ArrayList<Menu> menus){
        for(Menu menu : menus){
            System.out.println(menu.getName());
        }
    }

    public ArrayList<Menu> findMenusWithinPriceRange(double lowerValue, double upperValue){
        ArrayList<Menu> foundMenus = new ArrayList<>();
        for(Menu menu : menus){
            if(menu.getTotalPrice() >= lowerValue && menu.getTotalPrice() <= upperValue){
                foundMenus.add(menu);
            }
        }
        return foundMenus;
    }

    private boolean isValidName(String name) {
        return (name != null && !name.isEmpty() && name.length() < 100);
    }
    private boolean isValidPrice(double price) {
        return(price > 0);
    }

}
