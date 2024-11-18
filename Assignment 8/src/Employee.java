public class Employee {
    private final Person person;
    private final int employeeNumber;
    private final int employmentYear;
    private float monthlySalary;
    private float taxPercent;

    public Employee(Person person, int employeeNumber, int employmentYear, float monthlySalary, float taxPercent) {
        this.person = person;
        this.employeeNumber = employeeNumber;
        this.employmentYear = employmentYear;
        this.monthlySalary = monthlySalary;
        this.taxPercent = taxPercent/100.0f;
    }

    // Get Methods
    public Person getPerson() {
        return person;
    }
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    public int getEmploymentYear() {
        return employmentYear;
    }
    public float getMonthlySalary() {
        return monthlySalary;
    }
    public float getTaxPercent() {
        return taxPercent;
    }

    public String getFullName() {
        return getPerson().getFirstName() + " " + getPerson().getLastName();
    }

    // Set Methods
    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    public void setTaxPercent(float taxPercent) {
        this.taxPercent = taxPercent/100.0f;
    }

    // Other
    public float calculateTaxDeductible(){
        return this.monthlySalary * this.taxPercent;
    }

    public float calculateGrossSalary(){
        return this.monthlySalary *12.0f;
    }

    public float calculateYearlyTax(){
        float result = 0;
        for (int i = 0; i < 12; i++) {
            if(i == 5){
                continue;
            }
            if(i == 11){
                result += this.monthlySalary* (this.taxPercent/2);
                continue;
            }
            result += this.monthlySalary * this.taxPercent;
        }

        return result;
    }
    public String findEmployeeName(){
        return this.person.getLastName() + ", " + this.person.getFirstName();
    }

    public int findEmployeeAge(int currentYear){
        return currentYear - this.person.getBirthYear();
    }

    public int findYearsEmployed(int currentYear){
        return currentYear - this.employmentYear;
    }

    public Boolean isEmployedForXYears(int xNumberOfYears){
        return this.employmentYear >= xNumberOfYears;
    }




}
