/**
 * Property Class (Eiendom)
 * @author sunruh
 * @version 1.0
 */
public class Property {
    private final int municipalityNumber;
    private final String municipalityName;
    private final int lotNumber;
    private final int sectionNumber;
    private String name;
    private double area;
    private String ownersName;


    /**
     * Constructor function which allows user to define a New Property. Includes a name.
     * @param municipalityNumber
     * @param municipalityName
     * @param lotNumber
     * @param sectionNumber
     * @param area
     * @param ownersName
     * @param name
     */
    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, double area, String ownersName, String name) {
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.ownersName = ownersName;
    }

    /**
     * Constructor function which lets user define a new property. Does not include a name. Consider writing a set function and only one constructor instead of writing two constructors.
     * @param municipalityNumber
     * @param municipalityName
     * @param lotNumber
     * @param sectionNumber
     * @param area
     * @param ownersName
     */
    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, double area, String ownersName) {
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.area = area;
        this.ownersName = ownersName;
        this.name = null;
    }

    /**
     * Returns the Unique Property ID of the property, as a combination of municipality number, lot number and section number.
     * @return
     */
    public String getPropertyID(){
        return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
    }

    public String getName() {
        return name;
    }
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }
    public String getMunicipalityName() {
        return municipalityName;
    }
    public int getLotNumber() {
        return lotNumber;
    }
    public int getSectionNumber() {
        return sectionNumber;
    }
    public double getArea() {
        return area;
    }
    public String getOwnersName() {
        return ownersName;
    }
    public void setOwnersName(String newOwnersName) {
        this.ownersName = newOwnersName;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setArea(double newArea) {
        this.area = newArea;
    }

    @Override
    public String toString() {
        String uniqueID = municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
        if(this.name != null){
            return "Property Name: " + name + "\n" + "Property ID: " + uniqueID + "\n" + "Area: " + area + "m^2" + "\n" + "Owner: " + ownersName + "\n";
        }
        else{
            return "Property ID: " + uniqueID + "\n" + "Area: " + area + "m^2" + "\n" + "Owner: " + ownersName + "\n";
        }
    }

}
