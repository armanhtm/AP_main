/**
 * Acts on each Cargo
 *
 * @author Narges Salehi & Mohammadreza Ghaderi
 * @version 1.1
 * @since October 2020
 */

public class Cargo {
    private String name;
    //Total cost of each cargo transportation
    public double price;
    //Distance of origin and destination of cargo transportation
    public int distance;
    //check cargo insurance
    public boolean insurance;
    //keeps destination of cargo as a code
    public int destination;
    //keeps origin of cargo as a code
    public int origin;
    //keeps overload value
    public int overload;
    //keeps weight of cargo
    public double weight;


    /**
     * Create a new Cargo
     */
    public Cargo() {
        //Default value of insurance is false - should be checked
        insurance = false;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    /**
     * Get price of Cargo
     *
     * @return Price of cargo
     */
    public double getPrice() {
        return price;
    }

    /**
     * Calculate the Total cost of each cargo
     */
    public double calculatePrice() {
        double cost = 0;
        cost += calculateDistance() * 5000;
        cost += calculateWeightPrice() * 2500;
        if(this.weight > 20)
            cost += calculateOverload() * 3000;
        this.price = cost;
        return cost;
    }

    /**
     * Calculate the distance of origin and destination
     */
    public int calculateDistance() {
        return Math.abs(this.origin - this.destination);
    }

    /**
     * Calculate cost of cargo weight
     */
    public double calculateWeightPrice() {
        return Math.ceil(this.weight);
    }

    /**
     * Check if the cargo insured or not
     *
     * @return true or false
     */
    public boolean hasInsurance() {
        return insurance;
    }


    /**
     * Calculate overload of each Cargo
     */
    public double calculateOverload() {
        return this.weight - 20;
    }
   /**
    * show cargo information
    */
   public void showCargo(){
       System.out.print(this.price + " " +  this.InsurancetoString() + " " +  this.origin +
               " " + this.destination);
   }
    /**
     * convert result of insurance to string
     *
     * @return
     */
    public String InsurancetoString(){
        if(hasInsurance())
            return "insured";
        return "not insured";
    }

}

