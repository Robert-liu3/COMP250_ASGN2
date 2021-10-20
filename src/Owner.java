
public class Owner extends IncomeTaxPayer {

	final private int incomeTaxPct = 10;
	private double salaryExpenses;

	private FoodPlace foodPlace;

	public Owner(String name) {
		super(name);
	}

	public int getIncomeTaxPct() {
		return incomeTaxPct;
	}

	public double getSalaryExpenses() {
		return salaryExpenses;
	}

	public void setSalaryExpenses(double salaryExpenses) {
		this.salaryExpenses = salaryExpenses;
	}

	public void setFoodPlace(FoodPlace foodPlace) {
		this.foodPlace = foodPlace;
	}

	public FoodPlace getFoodPlace() { return foodPlace; }

	@Override
	public double calculateIncomeTax() {
		double profit;
		double incomeTax;

		double salaryExpenses = this.getSalaryExpenses(); //salary expenses
		double fixedCosts = this.getFoodPlace().getFixedCosts(); //fixed costs
		double taxDecimal = incomeTaxPct*0.01;

		profit = this.getIncome() - salaryExpenses - fixedCosts;

		if (profit < 0.0) {
			incomeTax = 0.0;
		} else {
			incomeTax = profit*taxDecimal;
		}

		return incomeTax;
	}
}
