import java.util.HashSet;
/**
 * Property Register Class
 * @author sunruh
 * @version 1.0
 */
public class PropertyRegister {
    private HashSet<Property> properties;


    public PropertyRegister() {
        properties = new HashSet<>();
    }

    public int findNumberOfProperties(){
        return properties.size();
    }

    public void addPropertyToRegister(Property property){
        properties.add(property);
    }

    public void removePropertyFromRegister(Property property){
        properties.remove(property);
    }

    public Property findPropertyByID(String propertyID){
        for(Property property : properties){
            if(property.getPropertyID().equals(propertyID)){
                return property;
            }
        }
        return null;
    }

    public void findPropertyByLotNumber(int lotNumber){
        int index = 0;
        System.out.println("\nProperties with lot number (" + lotNumber + "):");
        for(Property property : properties) {
            if (property.getLotNumber() == lotNumber) {
                index++;
                System.out.println(index + ". " + property.toString());
            }
        }
        if(index == 1){
            System.out.println("Found 1 Property");
        }
        else if (index > 1){
            System.out.println("Found " + index + " properties.");
        }
        else{
            System.out.println("Sorry, no property with lot number " + lotNumber + " exists");
        }
    }

    public void printProperties(){
        System.out.println("\n" + "List of Properties in the Registry: " + "\n");
        for(Property property : properties){
            System.out.println(property.toString());
        }
    }

    public double calculateTotalAverageArea(){
        double totalArea = 0;
        double index = 0;
        for(Property property : properties){
            totalArea += property.getArea();
            index++;
        }

        return totalArea / index;
    }
}
