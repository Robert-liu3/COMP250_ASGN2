
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FastFood extends FoodPlace {

    private List<Staff> staff = new ArrayList<>();

    public FastFood(String name, double fixedCosts, Owner owner, List<Staff> staff) {
        super(name,fixedCosts,owner);
        this.staff = new ArrayList<Staff>(staff); //"shallow" copy idk how to make one
    }

    public List<Staff> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name of FastFood: " + this.getName() +
                "\n" + "Owner: " + this.getOwner());
        int index = 1;
        for (Staff staff: staff) {
            builder.append("\n" + "Staff " + index++ + " : " + staff );
        }
        return builder.toString();
    }

    @Override
    public void workShift(int hours) {
        double salaryExpenses = 0;
        for (Staff a: staff){
            salaryExpenses += a.workHours(hours);
        }
        this.getOwner().setSalaryExpenses(this.getOwner().getSalaryExpenses()+salaryExpenses);
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        ArrayList<IncomeTaxPayer> incomeTaxPayerArrayList = new ArrayList<IncomeTaxPayer>();
        incomeTaxPayerArrayList.add(this.getOwner());
        for (Staff a: staff) {
            incomeTaxPayerArrayList.add(a);
        }
        ArrayList<IncomeTaxPayer> newIncomeTaxPayerArrayList = (ArrayList<IncomeTaxPayer>) incomeTaxPayerArrayList.clone();
        return newIncomeTaxPayerArrayList;
    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
        //variables
        double menuPrice = check.getMenuPrice();
        int numOfStaff = 0;
        double tip = check.getTip();

        //checks for the number of staff
        for (Staff a: staff) {
            numOfStaff++;
        }
        if (numOfStaff == 0) return;
        double tipPerStaff = tip/numOfStaff;

        //increasing income
        for (Staff b: staff) { //feels redundant
            b.setIncome(b.getIncome()+tipPerStaff);
        }
        this.getOwner().setIncome(this.getOwner().getIncome()+menuPrice);

        //increasing sales task
        this.setTotalSalesTax(this.getTotalSalesTax()+check.getSalesTax());
    }

    @Override
    public double getTipPercentage() {
        return 0;
    }
}
