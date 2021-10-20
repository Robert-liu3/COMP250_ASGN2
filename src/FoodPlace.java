
import java.util.List;

public abstract class FoodPlace {

    private static int currentMaxFoodPlaceID;
    private int foodPlaceID;
    private String name;
    private double fixedCosts;
    private double totalSalesTax;
    private Owner owner;

    //FoodPlace foodPlace;

    public FoodPlace(String name, double fixedCosts, Owner owner){
        this.name = name;
        this.fixedCosts = fixedCosts;
        this.owner = owner;
        owner.setFoodPlace(this); //if this doesnt work, try this.owner.getFoodPlace
    }

    public static int getCurrentMaxFoodPlaceID() {
        return currentMaxFoodPlaceID;
    }

    public int getFoodPlaceID() {
        return foodPlaceID;
    }

    public String getName() {
        return this.name;
    }

    public double getFixedCosts() {
        return this.fixedCosts;
    }

    public double getTotalSalesTax() {
        return this.totalSalesTax;
    }

    public void setTotalSalesTax(double totalSalesTax) {
        this.totalSalesTax = totalSalesTax;
    }

    public Owner getOwner() {
        return this.owner;
    }

    @Override
    public boolean equals(Object obj) {
        boolean theyEqual = false;
        if (obj instanceof FoodPlace) {
            if (this.getFoodPlaceID() == ((FoodPlace) obj).getFoodPlaceID()) {
                theyEqual = true;
            }
        }
        return theyEqual;
    }

    abstract void workShift(int hours);

    abstract List<IncomeTaxPayer> getIncomeTaxPayers();

    abstract void distributeIncomeAndSalesTax(Check check);

    abstract double getTipPercentage();
}
