

public class Fraction {
    private int[] result;
    private int teller;
    private int nevner;

    public Fraction(int teller, int nevner){
        this.teller = teller;
        if(nevner == 0){
            throw new IllegalArgumentException("Nevner kan ikke være lik null");
        }
        this.nevner = nevner;
        this.result = new int[2];

    }
    public Fraction(int teller){
        this.teller = teller;
        this.nevner = 1;
        this.result = new int[2];
    }

    public int getTeller(){
        return teller;
    }
    public int getNevner(){
        return nevner;
    }
    public int[] getResult(){
        return this.result;
    }
    public void Add(Fraction other){
        int fellesnevner;
        int teller_1 = this.getTeller();
        int teller_2 = other.getTeller();
        
        if(this.getNevner() != other.getNevner()){
            fellesnevner = this.getNevner()*other.getNevner();
            teller_1 = (teller_1*other.getNevner());
            teller_2 = (teller_2*this.getNevner());
        }
        else{
            fellesnevner = this.getTeller();
        }
        this.result[0] = (teller_1+teller_2);
        this.result[1] = (fellesnevner);
    }
    public void Subtract(Fraction other){
        int teller_1 = this.getTeller();
        int teller_2 = other.getTeller();
        int felles_nevner;

        if(this.getNevner() != other.getNevner()){
            felles_nevner = this.getNevner()*other.getNevner();
            teller_1 = (teller_1*other.getNevner());
            teller_2 = (teller_2*this.getNevner());
        }
        else{
            felles_nevner = this.getNevner();
        }
        this.result[0] = (teller_1-teller_2);
        this.result[1] = felles_nevner;
        
    }
    public void Multiply(Fraction other){
        int teller_1 = this.getTeller();
        int teller_2 = other.getTeller();

        this.result[0] = teller_1*teller_2;
        this.result[1] = this.getNevner()*other.getNevner();
    }
    public void Divide(Fraction other){
        this.result[0] = this.getTeller() * other.getNevner();
        this.result[1] = this.getNevner() * other.getTeller();
    }
}
