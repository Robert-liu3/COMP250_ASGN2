
import java.util.ArrayList;
import java.util.List;

public class FoodStand extends FoodPlace {

    public FoodStand(String name, double fixedCosts, WorkingOwner owner) {
        super(name,fixedCosts,owner);
    }

    @Override
    public String toString() {
        return "Name of FoodStand: " + this.getName() +
                "\n" + "Owner: " + this.getOwner();
    }

    @Override
    public void workShift(int hours) {
        // no salaried workers so do nothing
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        ArrayList<IncomeTaxPayer> incomeTaxPayerArrayList = new ArrayList<IncomeTaxPayer>();
        incomeTaxPayerArrayList.add(this.getOwner());
        return incomeTaxPayerArrayList;

    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
        double tip = check.getTip();
        double menuPrice = check.getMenuPrice();
        double salesTax = check.getSalesTax();

        this.getOwner().setIncome(this.getOwner().getIncome()+tip+menuPrice);
        this.setTotalSalesTax(this.getTotalSalesTax()+salesTax);
    }

    @Override
    public double getTipPercentage() {
        WorkingOwner owner = (WorkingOwner) this.getOwner();
        double targetTipPct =owner.getTargetTipPct();
        return targetTipPct;
    }
}
