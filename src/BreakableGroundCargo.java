/**
 * Acts on Breakable Ground Cargoes
 *
 * @author Narges Salehi & Mohammadreza Ghaderi
 * @version 1.1
 * @since October 2020
 */
public class BreakableGroundCargo extends GroundCargo {
    public BreakableGroundCargo() {
        super();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public double calculatePrice() {
        double cost;
        cost = super.calculatePrice();
        cost *= 3;
        this.price = cost;
        return cost;
    }

    @Override
    public int calculateDistance() {
        return super.calculateDistance();
    }


    @Override
    public double calculateWeightPrice() {
        return super.calculateWeightPrice();
    }


    @Override
    public boolean hasInsurance() {
        return super.hasInsurance();
    }

    @Override
    public double calculateOverload() {
        return super.calculateOverload();
    }

    public void showCargo() {
        super.showCargo();
        System.out.println(" Breakable");
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getName() {
        return super.getName();
    }

    public String InsurancetoString() {
        return super.InsurancetoString();
    }
}